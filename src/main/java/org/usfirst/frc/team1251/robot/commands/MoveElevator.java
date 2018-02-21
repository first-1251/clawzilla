package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.Armevator;

/**
 * Created by nick2 on 1/18/18
 */
public class MoveElevator extends Command {

    private final Joystick joystick;
    private final Armevator armevator;

    // Declares Subsystem dependencies
    public MoveElevator(Armevator armevator, Joystick joystick) {
        this.requires(armevator);
        this.armevator = armevator;
        this.joystick = joystick;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(joystick.getRawAxis(1) > 0) {
            this.armevator.getElevator().goUp(joystick.getRawAxis(1));
        } else if(joystick.getRawAxis(1) < 0) {
            this.armevator.getElevator().goDown(joystick.getRawAxis(1));
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