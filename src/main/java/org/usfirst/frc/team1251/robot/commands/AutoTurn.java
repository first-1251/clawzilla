package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;

public class AutoTurn extends Command {

    private DriveTrain driveTrain;
    private double desiredAngle;
    private boolean done = false;

    public AutoTurn(DriveTrain driveTrain, double angleDelta) {
        this.driveTrain = driveTrain;
        desiredAngle = angleDelta + driveTrain.getAngle();
    }

    @Override
    protected void initialize() {
        driveTrain.enableRegularMode();
        driveTrain.setGearShifter(DriveTrain.HIGH_GEAR);
        done = false;
    }

    @Override
    protected void execute() {
        if (Math.abs(Math.abs(driveTrain.getAngle()) - Math.abs(desiredAngle)) > (1.0/3.0 * Math.abs(desiredAngle))) {
            driveTrain.set(-.5, 0.5);
        } else {
            driveTrain.set(0, 0);
            done = true;
        }
    }

    @Override
    protected void end() {
        //driveTrain.set(0, 0);
    }

    @Override
    protected boolean isFinished() {
        return done;
//        System.out.println("finished?");
//        System.out.println(done);
//        return done;
    }
}
