package org.usfirst.frc.team1251.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1251.robot.RobotMap;
import org.usfirst.frc.team1251.robot.commands.DanzaRobotica;

/**
 * Created by nick2 on 1/13/2018.
 */
public class DriveTrain extends Subsystem {

    private RobotDrive driveBase;
    private Encoder leftEnc;
    private Encoder rightEnc;
    private Talon leftMotor1;
    private Talon leftMotor2;
    private Talon rightMotor1;
    private Talon rightMotor2;

    //Constructor
    public DriveTrain(){
        leftMotor1 = new Talon(RobotMap.LEFT_TALON_1);
        leftMotor2 = new Talon(RobotMap.LEFT_TALON_2);
        rightMotor1 = new Talon(RobotMap.RIGHT_TALON_1);
        rightMotor2 = new Talon(RobotMap.RIGHT_TALON_2);
    }

    //Method from ABSTRACT Subsystem
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DanzaRobotica());
    }

    // Sample method
    public void setLeftSpeed(double speed){
        leftMotor1.setSpeed(speed);
        leftMotor2.setSpeed(speed);
    }

    // Sample method
    public void setRightSpeed(double speed){
        rightMotor1.setSpeed(speed);
        rightMotor2.setSpeed(speed);
    }
}


