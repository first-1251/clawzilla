package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1251.robot.OI;
import org.usfirst.frc.team1251.robot.Robot;
import org.usfirst.frc.team1251.robot.subsystems.ExampleDriveTrain;

import static org.usfirst.frc.team1251.robot.OI.stick;

/**
 *
 */
public class ExampleCommand extends Command {

    private final ExampleDriveTrain drive;
    private final Joystick joystick;

    public ExampleCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.EXAMPLE_DRIVE_TRAIN);
        this.drive = Robot.EXAMPLE_DRIVE_TRAIN;
        this.joystick = OI.stick;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        /*if (joystick.getRawAxis(1) > 0.0) {
            System.out.println("*Dejected Trombone Intensifies*");
            this.drive.moveMotorForward();
        } else if (joystick.getRawAxis(1) < 0.0) {
            this.drive.moveMotorBackward();
        }*/
        this.drive.setFreddie(joystick.getRawAxis(1));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}