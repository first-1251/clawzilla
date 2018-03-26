package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.Claw;
import org.usfirst.frc.team1251.robot.subsystems.Collector;
import org.usfirst.frc.team1251.robot.teleopInput.driverInput.HumanInput;


public class Eject extends Command {

    private static final double EJECT_SPEED = 1.0;
    private final Claw claw;
    private final Collector collector;
    private final HumanInput humanInput;

    public Eject(Claw claw, Collector collector, HumanInput humanInput) {
        this.claw = claw;
        this.collector = collector;
        this.humanInput = humanInput;
        this.requires(claw);
        this.requires(collector);
        this.setInterruptible(false);
    }

    @Override
    protected void initialize() {
        this._manageClaw();
    }

    private void _manageClaw() {
        if (humanInput.operatorGamePad.rt().isPressed()) {
            this.claw.openClaw();
        }
    }

    @Override
    protected void execute() {
        this._manageClaw();
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
