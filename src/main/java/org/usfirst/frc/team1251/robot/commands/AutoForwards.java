package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrainShifter;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;

public class AutoForwards extends Command {

    private DriveTrain driveTrain;
    private final DriveTrainShifter shifter;

    private final double GEAR_RATIO = 3.21428571428;
    private final double ALLOWABLE_ERROR = 250.0; // in encoder ticks, 1/10 of an encoder turn, 1/30 of a wheel turn
    private final double WHEEL_DIAMETER = 4.25;

    private final double TICKS_PER_TURN = 500 * GEAR_RATIO; // total apples
    private final double WHEEL_CIRCUMFERENCE = (WHEEL_DIAMETER * Math.PI); // Inches per turn | # of buckets
    private final double TICKS_PER_INCH = TICKS_PER_TURN / WHEEL_CIRCUMFERENCE;



    private final double INCHES_TO_WHEEL_TURNS = 1.0 / (WHEEL_DIAMETER * Math.PI);
    private final double WHEELS_TURNS_TO_ENCODER_TICKS = 500 * GEAR_RATIO;  // 1 wheel


    private double targetTicks;
    private DriveFeedback driveFeedback;

    private int targetLeftPosition;
    private int targetRightPosition;
    private boolean done = false;

    // Number of inches to adjust the target distance.
    private double targetTweak = 0;

    public AutoForwards(DriveFeedback driveFeedback, DriveTrain driveTrain, DriveTrainShifter shifter, double inches) {
        this.driveFeedback = driveFeedback;
        this.driveTrain = driveTrain;
        this.shifter = shifter;
        requires(driveTrain);

        targetTicks = (inches + targetTweak) * TICKS_PER_INCH;
    }

    @Override
    protected void initialize() {
        // Always run in high gear.
        shifter.setGear(DriveTrainShifter.Gear.HIGH);

        // Calculate the new target position and capture them as integers.
        driveFeedback.updateSensorData();
        Double targetLeftPosition = targetTicks + driveFeedback.getLeftPosition();
        Double targetRightPosition = targetTicks + driveFeedback.getRightPosition();
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
