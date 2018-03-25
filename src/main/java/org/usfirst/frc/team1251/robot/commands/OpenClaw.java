package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.Claw;

public class OpenClaw extends Command {

    private final Claw claw;

    public OpenClaw(Claw claw) {

        this.claw = claw;
        requires(claw);
    }

    @Override
    protected void execute() {
        this.claw.getClaw().openClaw();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
