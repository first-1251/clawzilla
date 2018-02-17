package org.usfirst.frc.team1251.robot.mechanisms;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import org.usfirst.frc.team1251.robot.RobotMap;
import org.usfirst.frc.team1251.robot.virtualSensors.ElevatorPosition;

/**
 * Created by nick2 on 1/18/18
 */
public class Elevator {

    // Motor(s) for elevators (move it up and down)
    private Victor elevatorMotor1;

    // Limit Switches that prevent the elevator from overextending
    // TODO: MOVE this to `ElevatorPosition` -- read as part of `Elevator.isAtBottom()`
    private DigitalInput elevatorLimitSwitch;

    private ElevatorPosition elevatorPosition;

    public Elevator(ElevatorPosition elevatorPosition) {
        this.elevatorPosition = elevatorPosition;
        elevatorMotor1 = new Victor(RobotMap.ELEVATOR_VICTOR);
        elevatorLimitSwitch = new DigitalInput(RobotMap.ELEVATOR_LIMIT_SWITCH);
    }

    // goUp() and goDown() methods will use a speed variable until control type is determined

    // Have the elevator go upwards
    public void goUp(double speed) {
        if (!elevatorLimitSwitch.get()){
            elevatorMotor1.set(speed);
        } else {
            elevatorMotor1.set(0);
        }
    }

    // Have the elevator go downwards (will go down over time?)
    public void goDown(double speed) {
        elevatorMotor1.set(-speed);
    }

    // Prevents the elevator from overreaching by checking limit switch state
    public void stopPlease(){
        elevatorMotor1.set(0);
    }
}

// Water game confirmed.
