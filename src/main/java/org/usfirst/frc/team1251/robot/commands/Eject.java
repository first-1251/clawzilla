package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.Collector;


public class Eject extends Command {

    private static final double EJECT_SPEED = 1.0;
    private final Collector collector;

    public Eject(Collector collector) {
        this.collector = collector;
        this.requires(collector);
        this.setInterruptible(false);
    }

    @Override
    protected void execute() {
        this.collector.eject(EJECT_SPEED);
    }

    @Override
    protected void end() {
        this.collector.stop();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
