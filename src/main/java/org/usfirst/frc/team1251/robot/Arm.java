package org.usfirst.frc.team1251.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import org.usfirst.frc.team1251.robot.Robot;
import org.usfirst.frc.team1251.robot.RobotMap;
import org.usfirst.frc.team1251.robot.commands.MoveArm;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;

/**
 * Potentiometer(port #, degree range, offset)
 *
 */
public class Arm {

    //Declare variables
    private DigitalInput armLimitSwitch;

    private Victor armMotor;

    private ArmPosition armPosition;

    public Arm() {

        //Button
        armLimitSwitch = new DigitalInput(RobotMap.armLimitSwitch);


        //Arm pivot motor
        armMotor = new Victor(RobotMap.armMotor);

        this.armPosition = Robot.armPosition;


    }




    //Arm tilts up
    //Arm should pivot up. If button pressed, motor must stop immediately
    public void pivotUp(double speed){
       // armMotor.set(speed);

        //System.out.println(this.armPosition);
        if (this.armPosition.isArmUp()){
            armMotor.set(0);
        } else {
            armMotor.set(speed);
    }

           }




    //Arm tilts down
    //Arm should pivot down, no button pressed
    public void pivotDown(double speed){
       // armMotor.set(speed);

        if (this.armPosition.isArmDown()){
            armMotor.set(0);
        } else {
            armMotor.set(speed);
        }

    }


    public void stopPivot() {
        armMotor.set(0);

    }



}