package org.usfirst.frc.team1251.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 * Potentiometer(port #, degree range, offset)
 *
 */
public class Arm extends Subsystem {

    //Declare variables
    private DigitalInput armLimitSwitch;
    private Potentiometer armPotentiometer;
    private SpeedController armMotor;


    public Arm() {

        //Button
        armLimitSwitch = new DigitalInput(0);

        //Arm pivot motor
        armMotor = new Victor(0);

        //Arm potentiometer
        //Calculates range of motion for arm
        armPotentiometer = new Potentiometer(){
            @Override
            public double get() {
                return 0;
            }

            @Override
            public void setPIDSourceType(PIDSourceType pidSource) {

            }

            @Override
            public PIDSourceType getPIDSourceType() {
                return null;
            }

            @Override
            public double pidGet() {
                return 0;
            }

        };

    }

    //This just needs to be here
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }



    //Arm tilts up
    //Arm should pivot up. If button pressed, motor must stop immediately
    public void pivotUp(double speed){

        if (!armLimitSwitch.get()){
            armMotor.set(speed);
        } else {
            armMotor.set(0);
        }

    }

    //Arm tilts down
    //Arm should pivot down, no button pressed
    public void pivotDown(double speed){
        armMotor.set(speed);

    }


}