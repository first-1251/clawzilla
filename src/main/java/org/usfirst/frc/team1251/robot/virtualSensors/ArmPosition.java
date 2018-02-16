package org.usfirst.frc.team1251.robot.virtualSensors;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

public class ArmPosition {
    private Potentiometer armPotentiometer;
    private static final int ARM_UP_DEGREES = 120;
    private static final int ARM_DOWN_DEGREES = 70;

    public ArmPosition(){

        //Arm potentiometer
        //Calculates range of motion for arm
        armPotentiometer = new AnalogPotentiometer(0,360,30);


    }


    public boolean isArmUp(){
        double potDegrees = armPotentiometer.get();
        if (potDegrees >= ARM_UP_DEGREES ){
            System.out.println("Arm up");
            return true;

        } else {
            return false;

        }


    }

    public boolean isArmDown(){
        double potDegrees = armPotentiometer.get();
        if (potDegrees <= ARM_DOWN_DEGREES){
            System.out.println("Arm down");
            return true;

        } else {
            return false;

        }

    }




}
