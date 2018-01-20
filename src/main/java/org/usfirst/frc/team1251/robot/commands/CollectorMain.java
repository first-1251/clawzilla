package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.OI;
import org.usfirst.frc.team1251.robot.Robot;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;

import java.util.stream.Collector;

public class CollectorMain extends Command
{
    private final Joystick joystick;

    public CollectorMain()
    {
        this.joystick = OI.stick;
        this.requires(Robot.Collector);
    }

    @Override
    protected boolean isFinished()
    {
        return false;
    }

    @Override
    protected void execute()
    {
        super.execute();
    }

}
