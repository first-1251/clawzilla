package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.Collector;
import org.usfirst.frc.team1251.robot.teleopInput.driverInput.HumanInput;


public class Eject extends Command {

    private static final double EJECT_SPEED = 0.75;
    private final Collector collector;
    private HumanInput input;

    public Eject(Collector collector, HumanInput humanInput) {
        this.collector = collector;
        this.input = humanInput;
        this.requires(collector);
        this.setInterruptible(false);
    }

    @Override
    protected void execute() {
        this.collector.eject(EJECT_SPEED);
        input.rumbleOperator(0.75);
        input.rumbleDriver(0.75);
    }

    @Override
    protected void end() {
        this.collector.stop();
        input.rumbleOperator(0);
        input.rumbleDriver(0);

    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
