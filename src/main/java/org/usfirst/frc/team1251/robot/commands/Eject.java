package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.Clawlector;
import org.usfirst.frc.team1251.robot.teleopInput.driverInput.HumanInput;


public class Eject extends Command {

    private static final double EJECT_SPEED = 1.0;
    private final Clawlector clawlector;
    private final HumanInput humanInput;

    public Eject(Clawlector clawlector, HumanInput humanInput) {
        this.clawlector = clawlector;
        this.humanInput = humanInput;
        this.requires(clawlector);
        this.setInterruptible(false);
    }

    @Override
    protected void initialize() {
        this._manageClaw();
    }

    private void _manageClaw() {
        if (humanInput.operatorGamePad.rt().isPressed()) {
            this.clawlector.getClaw().openClaw();
        }
    }

    @Override
    protected void execute() {
        this._manageClaw();
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
