package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1251.robot.OI;
import org.usfirst.frc.team1251.robot.Robot;
import org.usfirst.frc.team1251.robot.subsystems.Elevator;

/**
 * Created by nick2 on 1/18/18
 */
public class MoveElevator extends Command {

    private final Elevator elevator;
    private final Joystick joystick;

    // Declares Subsystem dependencies
    public MoveElevator() {
        this.requires(Robot.elevator);
        this.elevator = Robot.elevator;
        this.joystick = OI.stick;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(joystick.getRawAxis(1) > 0) {
            this.elevator.goUp(joystick.getRawAxis(1));
        } else if(joystick.getRawAxis(1) < 0) {
            this.elevator.goDown(joystick.getRawAxis(1));
        } else {
            this.elevator.stopPlease();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }


    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        // this.elevator.stopPlease();
        // Must figure out whether we use joystick or button
    }
}