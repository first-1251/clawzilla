package org.usfirst.frc.team1251.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.Armevator;
import org.usfirst.frc.team1251.robot.teleopInput.gamepad.GamePad;

/**
 * Created by nick2 on 1/18/18
 */
public class MoveElevator {

    private final GamePad gamePad;
    private final Armevator armevator;

    // Declares Subsystem dependencies
    public MoveElevator(Armevator armevator, Joystick joystick) {
        this.requires(armevator);
        this.armevator = armevator;
        this.joystick = joystick;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double stickValue = this.gamePad.rs().getVertical();
        if(stickValue > 0) {
            this.armevator.getElevator().goUp(stickValue);
        } else if(stickValue < 0) {
            this.armevator.getElevator().goDown(stickValue);
        } else {
            this.armevator.getElevator().stopPlease();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }


    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}