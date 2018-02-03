package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1251.robot.Robot;
import org.usfirst.frc.team1251.robot.subsystems.ExampleSubsystem;

/**
 *
 */
public class ExampleCommand extends Command {

    private final ExampleSubsystem exampleSubsystem;
    private static int count = 0;
    private static int donut = 0;

    public ExampleCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.exampleSubsystem);
        this.exampleSubsystem = Robot.exampleSubsystem;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
        if (this.exampleSubsystem.isSwitchOn())
        {
            this.exampleSubsystem.setMotorSpeed(1.0);

            double motorSpeed = exampleSubsystem.getMotorSpeed();
            System.out.println(motorSpeed);

                //todo auto stop motor.
        } else {

            this.exampleSubsystem.setMotorSpeed(0.0);

        }

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