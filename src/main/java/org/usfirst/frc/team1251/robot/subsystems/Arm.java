package org.usfirst.frc.team1251.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import org.usfirst.frc.team1251.robot.Robot;
import org.usfirst.frc.team1251.robot.RobotMap;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;

/**
 * Potentiometer(port #, degree range, offset)
 *
 */
public class Arm extends Subsystem {

    //Declare variables
    private DigitalInput armLimitSwitch;

    private VictorSPX armMotor;

    private ArmPosition armPosition;

    public Arm() {

        //Button
        armLimitSwitch = new DigitalInput(RobotMap.armLimitSwitch);

        //Arm pivot motor
        armMotor = new VictorSPX(RobotMap.armMotor);

        this.armPosition = Robot.armPosition;


    }

    //This just needs to be here
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }


    //Arm tilts up
    //Arm should pivot up. If button pressed, motor must stop immediately
    public void pivotUp(double speed){

        if (this.armPosition.isArmUp()){
            armMotor.set(ControlMode.PercentOutput, 0);
        } else {
            armMotor.set(ControlMode.PercentOutput, speed);
    }

           }

    //Arm tilts down
    //Arm should pivot down, no button pressed
    public void pivotDown(double speed){
        armMotor.set(ControlMode.PercentOutput, speed);

        if (this.armPosition.isArmDown()){
            armMotor.set(ControlMode.PercentOutput, 0);
        } else {
            armMotor.set(ControlMode.PercentOutput, speed);
        }
    }

}