package org.usfirst.frc.team1251.robot.subsystems;

import com.ctre.phoenix.motorcontrol.IMotorController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1251.robot.MotorFactory;
import org.usfirst.frc.team1251.robot.RobotMap;
import org.usfirst.frc.team1251.robot.commands.MotorTester;
import org.usfirst.frc.team1251.robot.teleopInput.gamepad.ModernGamePad;

public class Motors extends Subsystem {

    public IMotorController[] speedControllersCan = new IMotorController[8];
    public SpeedController[] speedControllers = new SpeedController[5];

    public Motors() {
        speedControllersCan[0] = MotorFactory.createTalon(RobotMap.DRIVE_RIGHT_LEAD_MOTOR, MotorFactory.kDefaultConfiguration);
        speedControllersCan[1] = MotorFactory.createTalon(RobotMap.DRIVE_LEFT_LEAD_MOTOR, MotorFactory.kDefaultConfiguration);

        speedControllersCan[2] = MotorFactory.createVictor(RobotMap.DRIVE_RIGHT_FOLLOW_MOTOR_1, MotorFactory.kDefaultConfiguration);
        speedControllersCan[3] = MotorFactory.createVictor(RobotMap.DRIVE_RIGHT_FOLLOW_MOTOR_2, MotorFactory.kDefaultConfiguration);
        speedControllersCan[4] = MotorFactory.createVictor(RobotMap.DRIVE_RIGHT_FOLLOW_MOTOR_3, MotorFactory.kDefaultConfiguration);
        speedControllersCan[5] = MotorFactory.createVictor(RobotMap.DRIVE_LEFT_FOLLOW_MOTOR_1, MotorFactory.kDefaultConfiguration);
        speedControllersCan[6] = MotorFactory.createVictor(RobotMap.DRIVE_LEFT_FOLLOW_MOTOR_2, MotorFactory.kDefaultConfiguration);
        speedControllersCan[7] = MotorFactory.createVictor(RobotMap.DRIVE_LEFT_FOLLOW_MOTOR_3, MotorFactory.kDefaultConfiguration);

        speedControllers[0] = new Victor(RobotMap.ARM_MOTOR);

        speedControllers[1] = new Victor(RobotMap.ELEVATOR_MOTOR_1);
        speedControllers[2] = new Victor(RobotMap.ELEVATOR_MOTOR_2);

        speedControllers[3] = new Victor(RobotMap.COLLECTOR_LEFT_MOTOR);
        speedControllers[4] = new Victor(RobotMap.COLLECTOR_RIGHT_MOTOR);
    }

    @Override
    protected void initDefaultCommand() {
        //setDefaultCommand(new MotorTester(new ModernGamePad(new Joystick(0))));
    }
}
