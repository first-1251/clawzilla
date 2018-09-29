package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.Claw;
import org.usfirst.frc.team1251.robot.subsystems.Collector;


public class TeleopDropCube extends Command {

    private static final double EJECT_SPEED = 0.75;
    private static final double EJECT_DELAY = .25;
    private final Collector collector;
    private final Claw claw;
    private final double delay;
    private final Timer delayTimer = new Timer();

    public TeleopDropCube(Collector collector, Claw claw) {
        this.collector = collector;
        this.claw = claw;
        this.delay = EJECT_DELAY;
        requires(collector);
        requires(claw);
    }

    @Override
    protected void initialize() {
        delayTimer.stop();
        delayTimer.reset();
        delayTimer.start();
    }

    @Override
    protected void execute() {
        // Open the claw and keep it open.
        claw.openClaw();

        // Only run ejection once the delay has passed.
        if (delayTimer.get() >= delay) {
            this.collector.eject(EJECT_SPEED);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        delayTimer.stop();
        this.claw.closeClaw();
        this.collector.stop();
    }
}
