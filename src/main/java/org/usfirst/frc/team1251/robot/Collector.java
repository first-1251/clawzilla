package org.usfirst.frc.team1251.robot;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

public class Collector {

    private static final int MOTOR_LEFT_FORWARD = 1; //Gas Gas Gas
    private static final int MOTOR_RIGHT_FORWARD = 1; //Gotta step on the gas
    private static final int MOTOR_LEFT_BACKWARD = -1;
    private static final int MOTOR_RIGHT_BACKWARD = -1;
    private static final int MOTOR_STOP = 0; //Drift Button

    //The left bag motor, when looking from the rear perspective.
    private SpeedController leftMotor;

    //The right bag motor, when looking from the rear perspective.
    private SpeedController rightMotor;

    public Collector() {
        this.leftMotor = new Victor(RobotMap.COLLECTOR_LEFT_VICTOR);
        this.rightMotor = new Victor(RobotMap.COLLECTOR_RIGHT_VICTOR);
    }

    //Below includes Motor commands for collector victor's
    public void stop()
    {
        rightMotor.set(MOTOR_STOP);
        leftMotor.set(MOTOR_STOP);
        return;
    }
    public void pullInLeft()
    {
        rightMotor.set(MOTOR_RIGHT_BACKWARD);
        leftMotor.set(MOTOR_LEFT_FORWARD);
        return;
    }
    public void pullIn()
    {
        rightMotor.set(MOTOR_RIGHT_FORWARD);
        leftMotor.set(MOTOR_LEFT_FORWARD);
    }
    public void pullInRight()
    {
        rightMotor.set(MOTOR_RIGHT_BACKWARD);
        leftMotor.set(MOTOR_LEFT_BACKWARD);
        return;
    }



}