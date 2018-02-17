package org.usfirst.frc.team1251.robot.virtualSensors;

import org.usfirst.frc.team1251.robot.Robot;

public class ArmPosition {
   // private Potentiometer armPotentiometer;
    private static final int ARM_UP_DEGREES = 120;
    private static final int ARM_DOWN_DEGREES = 70;

    public ArmPosition(){

        //Arm potentiometer
        //Calculates range of motion for arm
      //  armPotentiometer = new AnalogPotentiometer(0,360,30);


    }


    public boolean isArmUp(){
        return Robot.oi.driverPad.y().isPressed();



       /* double potDegrees = armPotentiometer.get();
        if (potDegrees >= ARM_UP_DEGREES ){
            System.out.println("Arm up");
            return true;

        } else {
            return false;

        }
*/

    }

    public boolean isArmDown(){
        return Robot.oi.driverPad.a().isPressed();

        /*
        double potDegrees = armPotentiometer.get();
        if (potDegrees <= ARM_DOWN_DEGREES){
            System.out.println("Arm down");
            return true;

        } else {
            return false;

        }*/

    }




}
