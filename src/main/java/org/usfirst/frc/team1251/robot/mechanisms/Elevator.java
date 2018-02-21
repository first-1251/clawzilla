package org.usfirst.frc.team1251.robot.mechanisms;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import org.usfirst.frc.team1251.robot.RobotMap;
import org.usfirst.frc.team1251.robot.virtualSensors.ElevatorPosition;

/**
 * Created by nick2 on 1/18/18
 */
public class Elevator {

    // Polarity for   J U S T   I N   C A S E
    private static final int POLARITY = 1;

    // Motor(s) for elevators (move it up and down)
    private Victor elevatorMotor1;

    // Limit Switches that prevent the elevator from overextending
    // TODO: MOVE this to `ElevatorPosition` -- read as part of `Elevator.isAtBottom()`
    private DigitalInput elevatorLimitSwitch;

    private ElevatorPosition elevatorPosition;

    public Elevator(ElevatorPosition elevatorPosition) {
        this.elevatorPosition = elevatorPosition;
        elevatorMotor1 = new Victor(RobotMap.ELEVATOR_VICTOR);
        //elevatorLimitSwitch = new DigitalInput(RobotMap.ELEVATOR_LIMIT_SWITCH);
    }

    // goUp() and goDown() methods will use a speed variable until control type is determined

    // Have the elevator go upwards

    /**
     * This Method moves the elevator up at a specified speed until the limit switch is activated.  If it is, the speed is nixed.
     *
     * @param speed A value between 0 and 1, inclusive, such that any value less than 0 shall be rounded to 0 and any value greater than 1 shall be rounded to 1.
     */
    public void goUp(double speed) {
        // This will protect us;  Bounds speed to between 0 and 1
        speed = Math.max(speed, 0);
        speed = Math.min(speed, 1);
        speed *= POLARITY;
        if (!elevatorLimitSwitch.get()){
            elevatorMotor1.set(speed);
        } else {
            elevatorMotor1.set(0);
        }
    }

    /**
     * This Method moves the elevator downward at a specified speed.
     *
     * @param speed A value between 0 and 1, inclusive, such that any value less than 0 shall be rounded to 0 and any value greater than 1 shall be rounded to 1.  This value is to be negated.
     */
    public void goDown(double speed) {
        // This will protect us;  Bounds speed to between 0 and 1
        speed = Math.max(speed, 0);
        speed = Math.min(speed, 1);
        speed *= -POLARITY;
        elevatorMotor1.set(speed);
    }

    /**
     * This Method politely stops the elevator :)
     */
    public void stopPlease(){
        elevatorMotor1.set(0);
    }
}

// Water game confirmed.

// Potatoes are delicious!