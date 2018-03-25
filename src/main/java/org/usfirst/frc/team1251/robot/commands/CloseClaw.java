package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.Claw;

public class CloseClaw extends Command {

    private final Claw claw;

    public CloseClaw(Claw claw) {

        this.claw = claw;
        requires(claw);
    }

    @Override
    protected void execute() {
        this.claw.getClaw().closeClaw();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
