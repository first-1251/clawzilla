package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.Arm;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;

public class AutoArmTo90 extends Command {

    private Arm arm;
    private ArmPosition armPosition;

    private double speed = 1;
    private double sustainSpeed = 0.15;
    private boolean isAtPosition;

    public AutoArmTo90(Arm arm, ArmPosition armPosition){
        this.arm = arm;
        this.armPosition = armPosition;
    }

    protected void execute(){
        arm.pivotUp(speed);
        isAtPosition = true;
    }

    @Override
    protected void end() {
        arm.pivotUp(0.15);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}
