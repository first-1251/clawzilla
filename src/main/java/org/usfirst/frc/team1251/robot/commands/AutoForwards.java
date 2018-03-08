package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;

public class AutoForwards extends Command {

    private DriveTrain driveTrain;

    private final double GEAR_RATIO = 3.21428571428;
    private final double ALLOWABLE_ERROR = 250.0; // in encoder ticks, 1/10 of an encoder turn, 1/30 of a wheel turn
    private final double WHEEL_DIAMETER = 4.25;
    private final double INCHES_TO_WHEEL_TURNS = 1.0 / (WHEEL_DIAMETER * Math.PI);
    private final double WHEELS_TURNS_TO_ENCODER_TICKS = 500 * GEAR_RATIO;  // 1 wheel

    private double totalDistance;
    private DriveFeedback driveFeedback;

    private int targetLeftPosition;
    private int targetRightPosition;
    private boolean done = false;

    public AutoForwards(DriveFeedback driveFeedback, DriveTrain driveTrain, double inches) {
        this.driveFeedback = driveFeedback;
        this.driveTrain = driveTrain;
        requires(driveTrain);

        totalDistance = inches * INCHES_TO_WHEEL_TURNS;
    }

    @Override
    protected void initialize() {
        // Always run in high gear.
        driveTrain.setGearShifter(DriveTrain.HIGH_GEAR);

        // Calculate the new target position and capture them as integers.
        driveFeedback.updateSensorData();
        Double targetLeftPosition = totalDistance * WHEELS_TURNS_TO_ENCODER_TICKS + driveFeedback.getLeftPosition();
        Double targetRightPosition = totalDistance * WHEELS_TURNS_TO_ENCODER_TICKS + driveFeedback.getRightPosition();
        this.targetLeftPosition = targetLeftPosition.intValue();
        this.targetRightPosition = targetRightPosition.intValue();

        // Set the new target positions to the drive train.
        driveTrain.setTargetPosition(this.targetLeftPosition, this.targetRightPosition);
    }

    @Override
    protected void execute() {
        // Check to see if we are done -- if we are, actively shut down.
        done = hasReachedTargetPosition(ALLOWABLE_ERROR);
        if (done) {
            driveTrain.setSpeed(0.0, 0.0);
        }
    }

    @Override
    protected boolean isFinished() {
        // Check to see if we are done.
        done = done || hasReachedTargetPosition(ALLOWABLE_ERROR);

        // We may have just become "done". Don't wait for next execution cycle to shut down the
        // motors.
        if (done) {
            driveTrain.setSpeed(0.0, 0.0);
        }

        return done;
    }

    @Override
    protected void end() {
        driveTrain.setSpeed(0.0, 0.0);
    }

    private boolean hasReachedTargetPosition(double allowableError) {

        driveFeedback.updateSensorData();

        int left = driveFeedback.getLeftPosition() - driveTrain.getLeftTargetPosition();
        int right = driveFeedback.getRightPosition() - driveTrain.getRightTargetPosition();

        left = Math.abs(left);
        right = Math.abs(right);

        return ((left + right) / 2.0) < allowableError;
    }
}
