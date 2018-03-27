package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;

public class DoNothingDriveTrain extends TimedCommand {
    public DoNothingDriveTrain(double timeout, DriveTrain driveTrain) {
        super(timeout);

        requires(driveTrain);
    }

    @Override
    protected boolean isFinished() {
        return super.isFinished();
    }
}
