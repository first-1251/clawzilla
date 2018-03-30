package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.TimedCommand;
import org.usfirst.frc.team1251.robot.subsystems.Collector;


public class DelayedTimedEject extends TimedCommand {

    private static final double EJECT_SPEED = 0.5;
    private final Collector collector;
    private final double delay;
    private final Timer delayTimer = new Timer();

    public DelayedTimedEject(Collector collector, double delay, double ejectTime) {
        super(delay + ejectTime);
        this.collector = collector;
        this.delay = delay;
    }

    @Override
    protected void initialize() {
        delayTimer.stop();
        delayTimer.reset();
        delayTimer.start();
    }

    @Override
    protected void execute() {
        // Only start the ejection once the delay has passed.
        if (delayTimer.get() >= delay) {
            this.collector.eject(EJECT_SPEED);
        }
    }

    @Override
    protected void end() {
        delayTimer.stop();
        this.collector.stop();
    }
}
