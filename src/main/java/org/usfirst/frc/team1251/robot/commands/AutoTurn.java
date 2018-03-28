package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;

public class AutoTurn extends Command {

    private final DriveFeedback driveFeedback;
    private DriveTrain driveTrain;
    private double desiredAngle;
    private double angleDelta;
    private boolean done = false;
    private double finishedThreshold;
    private double finishedThresholdRight;

    public AutoTurn(DriveTrain driveTrain, double desiredAngle, DriveFeedback driveFeedback) {
        this.driveFeedback = driveFeedback;
        this.driveTrain = driveTrain;
        this.desiredAngle = desiredAngle;
        requires(this.driveTrain);
    }

    @Override
    protected void initialize() {
        // TODO-tweak: Adjust to flavor. // 8.0 for speed of 0.5  30.0 for speed 0.7
        this.finishedThreshold = 30.0;
        this.finishedThresholdRight = 25.0;
        done = false;
    }

    @Override
    protected void execute() {
        done = isFinishedTurning();
        if (!done) {
            if (desiredAngle < 0) {
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
        driveFeedback.updateSensorData();
        if (desiredAngle < 0) {
            return Math.abs(Math.abs(driveFeedback.getAngle()) - Math.abs(desiredAngle)) < this.finishedThreshold;
        } else {
            return Math.abs(Math.abs(driveFeedback.getAngle()) - Math.abs(desiredAngle)) < this.finishedThresholdRight;
        }
    }
}
