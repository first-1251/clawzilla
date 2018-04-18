package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.Arm;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;

public class ArmUpTo90AndHold extends Command{
    private Arm arm;
    private ArmPosition armPosition;

    private double speed = 1;
    private double sustainSpeed = 0.20;
    private boolean isAtPosition;

    public ArmUpTo90AndHold(Arm arm, ArmPosition armPosition){
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
        if (armPosition.getPotentiometer() <= 90) {
            isAtPosition = true;
            arm.pivotUp(sustainSpeed);
            return;
        }

        // Not there yet, keep pivoting.
        arm.pivotUp(speed);
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
