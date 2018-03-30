package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.Arm;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;

/**
 * @deprecated Not really deprecated, but needs testing and maybe PID - see ArmTo90AndHold for auto movements
 */
public class AutoArmTo90 extends Command {

    private Arm arm;
    private ArmPosition armPosition;

    private double speed = 0.8;
    private double sustainSpeed = 0.15;
    private boolean isAtPosition;

    public AutoArmTo90(Arm arm, ArmPosition armPosition){
        this.arm = arm;
        this.armPosition = armPosition;
    }

    @Override
    protected void initialize() {
        isAtPosition = false;
    }

    protected void execute(){
        if (armPosition.lessThan90()) {
            arm.pivotUp(speed);
        } else if (armPosition.atLeast90()) {
            arm.pivotDown(speed);
        } else {
            arm.pivotUp(sustainSpeed);
            isAtPosition = true;
        }

    }

    @Override
    protected void end() {
        arm.pivotUp(0.15);
    }

    @Override
    protected boolean isFinished() {
        return isAtPosition;
    }

}
