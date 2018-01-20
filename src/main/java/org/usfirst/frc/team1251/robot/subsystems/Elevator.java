package org.usfirst.frc.team1251.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1251.robot.RobotMap;

/**
 * Created by nick2 on 1/18/18
 */
public class Elevator extends Subsystem {

    // Motor(s) for elevators (move it up and down)
    private Victor elevatorMotor1;
    //Maintains position (counteracts gravity) while holding crate at limit switch
    //TODO: FIND CORRECT LS IDLING SPEED
    private final static double LIMIT_SWITCH_IDLE_SPEED = 0;
    // Encoder for elevator
    private Encoder elevatorEncoder;
    // Limit Switches that prevent the elevator from overextending
    private DigitalInput elevatorLimitSwitch;

    public Elevator(){
        //TODO: FIX ENCODER INITIALIZATION
        elevatorEncoder = new Encoder(RobotMap.ELEVATOR_ENCODER, RobotMap.ELEVATOR_ENCODER);
        elevatorMotor1 = new Victor(RobotMap.ELEVATOR_VICTOR);
        elevatorLimitSwitch = new DigitalInput(RobotMap.ELEVATOR_LIMIT_SWITCH);
    }

    public void initDefaultCommand() {
        // Initial action will be to stay still :)
    }

    // goUp() and goDown() methods will use a speed variable until control type is determined
    // Defaulted to joystick
    //TODO: DETERMINE CONTROL TYPE FOR ELEV. (BUTTON, JOYSTICK, ETC.)

    // Have the elevator go upwards
    public void goUp(double speed) {
        if (!elevatorLimitSwitch.get()){
            elevatorMotor1.set(speed);
        } else {
            elevatorMotor1.set(LIMIT_SWITCH_IDLE_SPEED);
        }
    }

    // Have the elevator go downwards (will go down over time?)
    public void goDown(double speed) {
        elevatorMotor1.set(-speed);
    }

    // Prevents the elevator from overreaching by checking limit switch state
    public void stopPlease(){
        if (elevatorLimitSwitch.get()){
            elevatorMotor1.set(LIMIT_SWITCH_IDLE_SPEED);
            //TODO: EDIT TO 0
        }
    }
}

// Water game confirmed.
