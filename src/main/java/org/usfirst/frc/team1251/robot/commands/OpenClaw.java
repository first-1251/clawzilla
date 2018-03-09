package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.Clawlector;

public class OpenClaw extends Command {

    private final Clawlector clawlector;

    public OpenClaw(Clawlector clawlector) {

        this.clawlector = clawlector;
        requires(clawlector);
    }

    @Override
    protected void execute() {
        this.clawlector.getClaw().openClaw();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
