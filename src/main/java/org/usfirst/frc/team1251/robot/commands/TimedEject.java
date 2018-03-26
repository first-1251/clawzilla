package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import org.usfirst.frc.team1251.robot.subsystems.Collector;


public class TimedEject extends TimedCommand {

    private static final double EJECT_SPEED = .25;
    private static final double EJECT_DURATION = .25;
    private final Collector collector;

    public TimedEject(Collector collector) {
        super(EJECT_DURATION);
        this.collector = collector;
        this.requires(collector);
    }

    @Override
    protected void execute() {
        this.collector.eject(EJECT_SPEED);
    }

    @Override
    protected void end() {
        this.collector.stop();
    }
}
