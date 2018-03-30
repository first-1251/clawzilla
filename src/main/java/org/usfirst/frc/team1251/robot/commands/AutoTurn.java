package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.DoubleSolenoidGearShifter;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrainShifter;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;

public class AutoTurn extends Command {

    private final DriveFeedback driveFeedback;
    private DriveTrain driveTrain;
    private DriveTrainShifter driveShifter;
    private double desiredAngle;
    private boolean done = false;

    private final double CLOCKWISE_THRESHOLD_FACTOR = 0.29;
    private final double COUNTER_CLOCKWISE_THRESHOLD_FACTOR = 0.29;

    private Direction direction;
    private double finishedThreshold;

    enum Direction {
        CLOCKWISE, COUNTER_CLOCKWISE
    }

    public AutoTurn(DriveTrain driveTrain, double desiredAngle, DriveFeedback driveFeedback, DriveTrainShifter driveShifter) {
        this.driveFeedback = driveFeedback;
        this.driveTrain = driveTrain;
        this.desiredAngle = desiredAngle;
        this.driveShifter = driveShifter;
        requires(this.driveTrain);
        requires(driveShifter);
    }

    @Override
    protected void initialize() {

        System.out.println("Turning: " + desiredAngle);
        driveShifter.setGear(DoubleSolenoidGearShifter.Gear.LOW);
        // Figure out how far we have to go and what way to turn
        double distanceToTarget = distanceToTarget();

        if (distanceToTarget < 0) {
            direction = Direction.COUNTER_CLOCKWISE;
            finishedThreshold = Math.max(-distanceToTarget * COUNTER_CLOCKWISE_THRESHOLD_FACTOR, 30.0);
        } else {
            direction = Direction.CLOCKWISE;
            finishedThreshold = Math.min(distanceToTarget * CLOCKWISE_THRESHOLD_FACTOR, 30.0);
        }

        done = false;
    }

    @Override
    protected void execute() {
        done = isFinishedTurning();
        if (!done) {
            if (direction == Direction.COUNTER_CLOCKWISE) {
                driveTrain.setSpeed(-0.7, 0.7);
            } else {
                driveTrain.setSpeed(0.7, -0.7);
            }
        } else {
            driveTrain.setSpeed(0, 0);
        }
    }

    @Override
    protected void end() {
        driveTrain.setSpeed(0, 0);
    }

    @Override
    protected boolean isFinished() {
        return done;
    }

    private boolean isFinishedTurning() {
        return (Math.abs(distanceToTarget()) <= finishedThreshold);
    }

    private double distanceToTarget() {
        driveFeedback.updateSensorData();
        double heading = driveFeedback.getHeading();
        if (heading < desiredAngle) {
            heading += 360;
        }

        double left = heading - desiredAngle;

        if (left < 180)
            return -left;
        else {
            return 360 - left;
        }
    }
}
