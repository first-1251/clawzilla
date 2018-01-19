package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1251.robot.OI;
import org.usfirst.frc.team1251.robot.Robot;
import org.usfirst.frc.team1251.robot.subsystems.Elevator;

/**
 *
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
        this.elevator.goUpPlease(joystick.getRawAxis(1));
        this.elevator.goDownPlease(joystick.getRawAxis(1));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }


    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        this.elevator.stopPlease();
    }
}