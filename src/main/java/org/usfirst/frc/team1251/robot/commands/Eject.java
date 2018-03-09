package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.Clawlector;


public class Eject extends Command {

    private static final double EJECT_SPEED = .40;
    private final Clawlector clawlector;

    public Eject(Clawlector clawlector) {
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

    @Override
    protected boolean isFinished() {
        return false;
    }
}
