package org.usfirst.frc.team1251.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Created by nick2 on 1/18/18
 */
public class Elevator extends Subsystem {

    // CIM Motor(s) for elevators (move it up and down)
    private SpeedController elevatorMotor1;

    // private SpeedController elevatorMotor2; May only use one control for both motors

    // private Encoder elevatorEncoder; Maybe?

    // Limit Switches that prevent the elevator from overextending
    private DigitalInput elevatorLimitSwitch;

    public Elevator(){
        elevatorMotor1 = null;
        elevatorLimitSwitch = null;
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    // Have the elevator go upwards
    public void goUpPlease(double speed) {
        if (!elevatorLimitSwitch.get()){
            elevatorMotor1.set(speed);
        } else { //
            elevatorMotor1.set(0);
        }
    }

    // Have the elevator go downwards (will go down over time?)
    public void goDownPlease(double speed) {
        elevatorMotor1.set(-speed);
    }

    // Method which prevents the arm from overreaching by checking limit switch state
    public void stopPlease(){
        if (elevatorLimitSwitch.get()){
            elevatorMotor1.set(0);
        }
    }
}
