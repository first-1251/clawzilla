package org.usfirst.frc.team1251.robot.mechanisms;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import org.usfirst.frc.team1251.robot.RobotMap;

public class Collector {

    private static final int MOTOR_LEFT_FORWARD = -1; //Gas Gas Gas
    private static final int MOTOR_RIGHT_FORWARD = 1; //Gotta step on the gas
    private static final int MOTOR_LEFT_BACKWARD = 1;
    private static final int MOTOR_RIGHT_BACKWARD = -1;
    private static final int MOTOR_STOP = 0; //Drift Button


    // SAFETY!
    private static final double EJECTION_MAX_SPEED = .5;

    //The left bag motor, when looking from the rear perspective.
    private SpeedController leftMotor;

    //The right bag motor, when looking from the rear perspective.
    private SpeedController rightMotor;

    public Collector() {
        this.leftMotor = new Victor(RobotMap.COLLECTOR_LEFT_MOTOR);
        this.rightMotor = new Victor(RobotMap.COLLECTOR_RIGHT_MOTOR);

        this.leftMotor.setInverted(true);
        this.rightMotor.setInverted(true);
    }

    //Below includes Motor commands for collector victor's
    public void stop() {
        rightMotor.set(MOTOR_STOP);
        leftMotor.set(MOTOR_STOP);
    }

    public void pullInLeft() {
        rightMotor.set(MOTOR_RIGHT_BACKWARD);
        leftMotor.set(MOTOR_LEFT_FORWARD);
    }

    public void pullIn() {
        rightMotor.set(-MOTOR_RIGHT_FORWARD);
        leftMotor.set(-MOTOR_LEFT_FORWARD);
    }

    public void pullInRight() {
        rightMotor.set(MOTOR_RIGHT_BACKWARD);
        leftMotor.set(MOTOR_LEFT_BACKWARD);
    }

    public void eject(double speed) {
        speed = Math.max(speed, 0);
        speed = Math.min(speed, EJECTION_MAX_SPEED);
        rightMotor.set(speed);
        leftMotor.set(-speed);
    }


}