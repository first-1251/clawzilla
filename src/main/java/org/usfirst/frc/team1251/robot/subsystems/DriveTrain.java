package org.usfirst.frc.team1251.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1251.robot.commands.RobotDance;

public class DriveTrain extends Subsystem
{



    @Override
    protected void initDefaultCommand()
    {
        this.setDefaultCommand(new RobotDance());
    }

    public void setRightSpeed()
    {
        System.out.println("Right Speed Set");
    }

    public void setLeftSpeed()
    {
        System.out.println("Left Speed Set");

    }

}
