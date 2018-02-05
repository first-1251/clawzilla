package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.ControllerTestBed;

public class TestCommand extends Command {
    private final ControllerTestBed subSystem;
    private final String name;

    public TestCommand(ControllerTestBed subSystem, String name, boolean isInterruptible) {
        super();
        this.setInterruptible(isInterruptible);
        this.subSystem = subSystem;
        this.name = name;
        requires(this.subSystem);
    }

    /**
     * The initialize method is called the first time this Command is run after being started.
     */
    @Override
    protected void initialize() {
        System.out.println("Command: " + name + " initialize()");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("Command: " + name + " execute()");
        subSystem.go();
    }

    @Override
    protected boolean isFinished() {
        // Run until cancelled.
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("Command: " + name + " end()");
        subSystem.cleanup();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        System.out.println("Command: " + name + " interrupted()");
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
