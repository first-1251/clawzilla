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

    public AutoTurn(DriveTrain driveTrain, double angleDelta, DriveFeedback driveFeedback) {
        this.driveFeedback = driveFeedback;
        this.driveTrain = driveTrain;
        this.angleDelta = angleDelta;
    }

    @Override
    protected void initialize() {
        driveTrain.setGearShifter(DriveTrain.HIGH_GEAR);
        desiredAngle = angleDelta + driveFeedback.getAngle();

        // TODO-tweak: Adjust to flavor.
        this.finishedThreshold = 1.0/3.0 * Math.abs(desiredAngle);
        done = false;
    }

    @Override
    protected void execute() {
        done = isFinishedTurning();
        if (!done) {
            driveTrain.setSpeed(-.5, 0.5);
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
        return Math.abs(Math.abs(driveFeedback.getAngle()) - Math.abs(desiredAngle)) >= this.finishedThreshold;
    }
}
