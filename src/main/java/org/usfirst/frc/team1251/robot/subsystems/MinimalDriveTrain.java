package org.usfirst.frc.team1251.robot.subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.CANSpeedController;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class MinimalDriveTrain extends Subsystem{

    private CANSpeedController leftMotor1;
    private CANSpeedController leftMotor2;
    private CANSpeedController leftMotor3;
    private CANSpeedController leftMotor4;

    private CANSpeedController rightMotor1;
    private CANSpeedController rightMotor2;
    private CANSpeedController rightMotor3;
    private CANSpeedController rightMotor4;

    private Encoder leftDistance;
    private Encoder rightDistance;

    public static final double SPEEDCONTROLLER_MAX_VOLTAGE = 12.0;

    public MinimalDriveTrain(CANSpeedController[] leftMotors, CANSpeedController[] rightMotors, Encoder leftDistance, Encoder rightDistance) {
        this.leftMotor1 = leftMotors[0];
        this.leftMotor2 = leftMotors[1];
        this.leftMotor3 = leftMotors[2];
        this.leftMotor4 = leftMotors[3];

        this.rightMotor1 = rightMotors[0];
        this.rightMotor2 = rightMotors[1];
        this.rightMotor3 = rightMotors[2];
        this.rightMotor4 = rightMotors[3];

        this.leftDistance  = leftDistance;
        this.rightDistance = rightDistance;

        this.leftMotor1.setControlMode(CANTalon.TalonControlMode.Voltage.value);
        this.leftMotor2.setControlMode(CANTalon.TalonControlMode.Voltage.value);
        this.leftMotor3.setControlMode(CANTalon.TalonControlMode.Voltage.value);
        this.leftMotor4.setControlMode(CANTalon.TalonControlMode.Voltage.value);

        this.rightMotor1.setControlMode(CANTalon.TalonControlMode.Voltage.value);
        this.rightMotor2.setControlMode(CANTalon.TalonControlMode.Voltage.value);
        this.rightMotor3.setControlMode(CANTalon.TalonControlMode.Voltage.value);
        this.rightMotor4.setControlMode(CANTalon.TalonControlMode.Voltage.value);
    }

    @Override
    protected void initDefaultCommand() {

    }
    
    public void setLeftVoltage(double voltage) {
        leftMotor1.set(voltage / SPEEDCONTROLLER_MAX_VOLTAGE);
        leftMotor2.set(voltage / SPEEDCONTROLLER_MAX_VOLTAGE);
        leftMotor3.set(voltage / SPEEDCONTROLLER_MAX_VOLTAGE);
        leftMotor4.set(voltage / SPEEDCONTROLLER_MAX_VOLTAGE);
    }

    public void setRightVoltage(double voltage) {
        rightMotor1.set(voltage / SPEEDCONTROLLER_MAX_VOLTAGE);
        rightMotor2.set(voltage / SPEEDCONTROLLER_MAX_VOLTAGE);
        rightMotor3.set(voltage / SPEEDCONTROLLER_MAX_VOLTAGE);
        rightMotor4.set(voltage / SPEEDCONTROLLER_MAX_VOLTAGE);
    }

    public double getLeftSpeed() {
        return leftDistance.get();
    }

    public double getRightSpeed() {
        return rightDistance.get();
    }
}
