package org.usfirst.frc.team1251.robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import robotDance.RobotDance;


public class DriveTrain extends Subsystem{

    private Talon leftMotor1;
    private Talon leftMotor2;

    private Talon rightMotor1;
    private Talon rightMotor2;


    public DriveTrain(){
        leftMotor1 = new Talon(RobotMap.LEFT_TALON_1_PORT);
        leftMotor2 = new Talon(RobotMap.LEFT_TALON_2_PORT);

        rightMotor1 = new Talon(RobotMap.RIGHT_TALON_1_PORT);
        rightMotor2 = new Talon(RobotMap.RIGHT_TALON_2_PORT);
    }

    @Override
    public void initDefaultCommand() {
        this.setDefaultCommand(new RobotDance());
    }


    public void setRight(double speed){
        System.out.println("xd");
        rightMotor1.set(speed);
        rightMotor2.set(speed);
    }

    public void setLeft(double speed){
        System.out.println("whoa");
        leftMotor1.set(speed);
        leftMotor2.set(speed);
    }


}
