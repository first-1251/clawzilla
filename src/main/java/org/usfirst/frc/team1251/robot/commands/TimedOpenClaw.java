package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import org.usfirst.frc.team1251.robot.subsystems.Claw;

public class TimedOpenClaw extends TimedCommand {

    private final Claw claw;

    public TimedOpenClaw(Claw claw, double timeout) {
        super(timeout);

        this.claw = claw;
        requires(claw);
    }

    @Override
    protected void execute() {
        this.claw.openClaw();
    }

    @Override
    protected void end() {
        this.claw.closeClaw();
    }
}
