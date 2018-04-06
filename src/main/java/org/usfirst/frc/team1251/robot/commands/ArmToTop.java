package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.Arm;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;

public class ArmToTop extends Command {

    private Arm arm;
    private ArmPosition armPosition;

    private double speed = 1.0;
    private boolean done = false;

    public ArmToTop(Arm arm, ArmPosition armPosition){
        this.arm = arm;
        this.armPosition = armPosition;

        requires(arm);
    }

    @Override
    protected void initialize() {
        done = false;
    }

    @Override
    protected void execute() {
        done = armPosition.isArmUp();
        if (!done) {
            arm.pivotUp(speed);
        } else {
            arm.stopPivot();
        }
    }

    @Override
    protected boolean isFinished() {
        return done;
    }
}
