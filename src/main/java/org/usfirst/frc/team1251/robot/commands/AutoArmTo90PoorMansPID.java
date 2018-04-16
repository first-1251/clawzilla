package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.Arm;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;

// This class is a combination of AutoArmTo90 and ArmDownTo90AndHold.  WARNING: EXPERIMENTAL!  MUST BE TESTED!

public class AutoArmTo90PoorMansPID extends Command {

    // Assumption: 0 degrees is vertical, 90 is straight out

    private Arm arm;
    private ArmPosition armPosition;

    //TODO: Tweak thresholds as needed
    private final double THRESHOLD = 0.5;

    private double topSpeed = 0.25; // Get things started.
    private double lowSpeed = 0.1; // Gravity will help us move down.


    private double sustainSpeed = 0.20;
    private boolean isAtPosition;

    public AutoArmTo90PoorMansPID(Arm arm, ArmPosition armPosition){
        this.arm = arm;
        this.armPosition = armPosition;
        requires(arm);
    }

    @Override
    protected void initialize() {
        isAtPosition = false;
    }

    protected void execute(){
        if (armPosition.getPotentiometer() < 90 - THRESHOLD) {
            // If we have reached 30 degrees, go slower, as we are aided by gravity
            if (armPosition.getPotentiometer() > 30) {
                arm.pivotDown(lowSpeed);
            } else {
                arm.pivotDown(topSpeed);
            }
        } else if (armPosition.getPotentiometer() > 90 + THRESHOLD) {
            // If we are past 100 degrees, go fast, as we are fighting gravity
            if (armPosition.getPotentiometer() < 100) {
                arm.pivotDown(lowSpeed);
            } else {
                arm.pivotDown(topSpeed);
            }
        } else {
            arm.pivotUp(sustainSpeed);
            isAtPosition = true;
        }

    }

    @Override
    protected void end() {
        // Nothing yet
    }

    @Override
    protected boolean isFinished() {
        return isAtPosition;
    }

}
