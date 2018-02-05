package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import org.usfirst.frc.team1251.robot.subsystems.ControllerTestBed;

/**
 *
 */
public class TestTimedCommand extends TimedCommand {

    private final ControllerTestBed subSystem;
    private final String name;

    public TestTimedCommand(ControllerTestBed subSystem, String name, double timeout, boolean isInterruptible) {
        super(timeout);
        this.setInterruptible(isInterruptible);
        this.subSystem = subSystem;
        this.name = name;
        requires(this.subSystem);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("TimedCommand: " + name + " execute()");
        subSystem.go();
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("TimedCommand: " + name + " end()");
        subSystem.cleanup();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        System.out.println("TimedCommand: " + name + " interrupted()");
        this.end();
    }


    @Override
    public synchronized void start() {
        // Intercept calls to start() just so we can witness that it happened.
        System.out.println("Command: " + name + " start()");
        super.start();
    }

    @Override
    public synchronized void cancel() {
        // Intercept calls to cancel() just so we can witness that it happened.
        System.out.println("Command: " + name + " cancel()");
        super.cancel();
    }
}
