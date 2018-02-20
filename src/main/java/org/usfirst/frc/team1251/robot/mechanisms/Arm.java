package org.usfirst.frc.team1251.robot.mechanisms;

import edu.wpi.first.wpilibj.Victor;
import org.usfirst.frc.team1251.robot.RobotMap;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;

/**
 * Potentiometer(port #, degree range, offset)
 *
 */
public class Arm {

    private Victor armMotor;

    private ArmPosition armPosition;

    public Arm(ArmPosition armPosition) {

        //Arm pivot motor
        armMotor = new Victor(RobotMap.armMotor);

        this.armPosition = armPosition;
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