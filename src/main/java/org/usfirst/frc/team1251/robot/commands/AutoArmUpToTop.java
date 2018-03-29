package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.Arm;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;

public class AutoArmUpToTop extends Command {

    private Arm arm;
    private ArmPosition armPosition;

    private double speed = 0.5;

    public AutoArmUpToTop(Arm arm, ArmPosition armPosition){
        this.arm = arm;
        this.armPosition = armPosition;

        requires(arm);
    }

    @Override
    protected void execute() {
        if(!armPosition.isArmUp()){
            arm.pivotUp(speed);
        } else {
            arm.stopPivot();
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
