package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.Clawlector;

public class CloseClaw extends Command {

    private final Clawlector clawlector;

    public CloseClaw(Clawlector clawlector) {

        this.clawlector = clawlector;
        requires(clawlector);
    }

    @Override
    protected void execute() {
        this.clawlector.getClaw().closeClaw();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
