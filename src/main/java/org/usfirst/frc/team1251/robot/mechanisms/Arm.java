package org.usfirst.frc.team1251.robot.mechanisms;

import edu.wpi.first.wpilibj.*;
import org.usfirst.frc.team1251.robot.RobotMap;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;

/**
 * Potentiometer(port #, degree range, offset)
 *
 */
public class Arm {

    private Victor armMotor;

    private ArmPosition armPosition;

    private static final int POLARITY = 1;

    public Arm(ArmPosition armPosition) {

        //Arm pivot motor
        armMotor = new Victor(RobotMap.armMotor);

        this.armPosition = armPosition;


    }


    //Arm tilts up
    //Arm should pivot up. If button pressed, motor must stop immediately

    /**
     * Pivots arm up
     *
     * @param speed takes in # value between 0-1 where 1 is faster
     *              If # < 0, will be treated as 0
     *              If # > 1, will be treated as 1
     */

    public void pivotUp(double speed){

        //Clamping value
        speed = Math.min(speed, 1);
        speed = Math.max(speed, 0);

        speed = speed * POLARITY;

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

        //Clamping value
       speed = Math.min(speed, 1);
       speed = Math.max(speed, 0);

       //Speed multiplied by -1 so motor goes in reverse
       speed = speed * -POLARITY;

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