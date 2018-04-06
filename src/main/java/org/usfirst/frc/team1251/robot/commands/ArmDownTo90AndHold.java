package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.Arm;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;

public class ArmDownTo90AndHold extends Command {

    private Arm arm;
    private ArmPosition armPosition;

    private double topSpeed = 0.5; // Get things started.
    private double lowSpeed = 0.5; // Gravity will help us move down.
    private double sustainSpeed = 0.20;
    private boolean isAtPosition;

    public ArmDownTo90AndHold(Arm arm, ArmPosition armPosition){
        this.arm = arm;
        this.armPosition = armPosition;
        requires(arm);
    }

    @Override
    protected void initialize() {
        isAtPosition = false;
    }

    protected void execute(){

        // If we've made it to 90 (or overshot it), use the sustaining speed.
        // TODO: May need to cut it off early to account for inertia.
        if (armPosition.getPotentiometer() >= 90) {
            isAtPosition = true;
            arm.pivotUp(sustainSpeed);
            return;
        }

        // If we've made it at least 30, slow the motor -- gravity will be helping at this point.
        if (armPosition.getPotentiometer() > 30) {
            arm.pivotDown(lowSpeed);
        } else {
            arm.pivotDown(topSpeed);
        }
    }

    @Override
    protected void end() {
        // If we hit the mark, we will have triggered a sustaining speed. We want that speed to be
        // maintained until something else takes over.
    }

    @Override
    protected boolean isFinished() {
        return isAtPosition;
    }

}
