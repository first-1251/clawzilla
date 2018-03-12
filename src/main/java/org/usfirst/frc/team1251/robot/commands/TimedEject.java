package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import org.usfirst.frc.team1251.robot.subsystems.Clawlector;


public class TimedEject extends TimedCommand {

    private static final double EJECT_SPEED = .25;
    private static final double EJECT_DURATION = .25;
    private final Clawlector clawlector;

    public TimedEject(Clawlector clawlector) {
        super(EJECT_DURATION);
        this.clawlector = clawlector;
        this.requires(clawlector);
    }

    @Override
    protected void execute() {
        this.clawlector.getCollector().eject(EJECT_SPEED);
    }

    @Override
    protected void end() {
        this.clawlector.getCollector().stop();
    }
}
