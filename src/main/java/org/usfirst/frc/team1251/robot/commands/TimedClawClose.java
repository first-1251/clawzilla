package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.TimedCommand;
import org.usfirst.frc.team1251.robot.subsystems.Claw;

public class TimedClawClose extends TimedCommand {

    private final Claw claw;

    public TimedClawClose(Claw claw) {
        super(0.1);
        this.claw = claw;
        requires(claw);
    }

    @Override
    protected void execute() {
        this.claw.closeClaw();
    }
}
