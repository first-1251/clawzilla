package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.OI;
import org.usfirst.frc.team1251.robot.Robot;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;

public class RobotDance extends Command
{
    private final Joystick joystick;
    private final DriveTrain driveTrain;


    public RobotDance()
    {
        this.joystick = OI.stick;
        this.requires(Robot.DriveTrain);
        this.driveTrain = Robot.DriveTrain;
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void execute()
    {
        super.execute();
        this.driveTrain.setLeftSpeed(joystick.getRawAxis(1));
        this.driveTrain.setRightSpeed(joystick.getRawAxis(3));

        if (OI.stick.getRawAxis(1) > 0)
        {
            System.out.println("Raw Access");
        }
    }

}
