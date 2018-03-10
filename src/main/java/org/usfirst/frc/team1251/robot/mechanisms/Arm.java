package org.usfirst.frc.team1251.robot.mechanisms;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1251.robot.RobotMap;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;

/**
 * Potentiometer(port #, degree range, offset)
 *
 */
public class Arm {

    private Victor armMotor;

    private ArmPosition armPosition;

    private static final boolean isInverted = true;

    public Arm(ArmPosition armPosition) {

        //Arm pivot motor
        armMotor = new Victor(RobotMap.ARM_MOTOR);
        armMotor.setInverted(isInverted);

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

    public void pivotUp(double speed) {

        // Stop moving if the arm is already fully up.
        if (this.armPosition.isArmUp()) {
            stopPivot();
            return;
        }

        //Clamping value
        speed = Math.min(speed, 0.8);
        speed = Math.max(speed, 0);

        armMotor.set(speed);
    }


    //Arm tilts down
    //Arm should pivot down, no button pressed
    public void pivotDown(double speed) {

        // Stop moving if the arm is already fully down.
        if (this.armPosition.isArmDown()) {
            stopPivot();
            return;
        }

        //Clamping value
        speed = Math.min(speed, 0.25);
        speed = Math.max(speed, 0);

        armMotor.set(speed * -1);
    }

    public void showSwitches() {
        SmartDashboard.putBoolean("TOP", armPosition.isArmUp());
        SmartDashboard.putBoolean("BOTTOM", armPosition.isArmDown());

    }

    public void stopPivot() {
        armMotor.set(0);
    }

}