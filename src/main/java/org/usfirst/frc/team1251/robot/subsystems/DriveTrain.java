package org.usfirst.frc.team1251.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1251.robot.RobotMap;
import org.usfirst.frc.team1251.robot.commands.RobotDance;

public class DriveTrain extends Subsystem
{
    private Talon leftMotor1;
    private Talon leftMotor2;

    private Talon rightMotor1;
    private Talon rightMotor2;

    public DriveTrain()
    {
        leftMotor1 = new Talon(RobotMap.LEFT_TALON_1);
        leftMotor2 = new Talon(RobotMap.LEFT_TALON_2);

        rightMotor1 = new Talon(RobotMap.RIGHT_TALON_1);
        rightMotor2 = new Talon(RobotMap.RIGHT_TALON_2);

    }

    @Override
    protected void initDefaultCommand()
    {
        this.setDefaultCommand(new RobotDance());
    }

    public void setRightSpeed(double speed)
    {
        leftMotor1.set(speed);
        leftMotor2.set(speed);
        System.out.println("Right Speed Set To: " + speed);
    }

    public void setLeftSpeed(double speed)
    {
        rightMotor1.set(speed);
        rightMotor2.set(speed);
        System.out.println("Left Speed Set To: " + speed);

    }



}
