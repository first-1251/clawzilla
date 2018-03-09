package org.usfirst.frc.team1251.robot.mechanisms;

import edu.wpi.first.wpilibj.Victor;
import org.usfirst.frc.team1251.robot.RobotMap;
import org.usfirst.frc.team1251.robot.virtualSensors.ElevatorPosition;

/**
 * Created by nick2 on 1/18/18
 */
public class Elevator {

    // If the motors are inverted
    private static final boolean isMotor1Inverted = false;
    private static final boolean isMotor2Inverted = false;

    // Motor(s) for elevators (move it up and down)
    private Victor elevatorMotor1;
    private Victor elevatorMotor2;

    private ElevatorPosition elevatorPosition;

    public Elevator(ElevatorPosition elevatorPosition) {
        this.elevatorPosition = elevatorPosition;

        elevatorMotor1 = new Victor(RobotMap.ELEVATOR_MOTOR_1);
        elevatorMotor2 = new Victor(RobotMap.ELEVATOR_MOTOR_2);

        elevatorMotor1.setInverted(isMotor1Inverted);
        elevatorMotor2.setInverted(isMotor2Inverted);
    }


    /**
     * This method moves the elevator up at the speed given unless we are at the maximum
     *
     * @param speed A value bounded by 0 and 1 that isn't outside those values
     */
    public void goUp(double speed) {
        if (elevatorPosition.isAtMaxHeight()) {
            elevatorMotor1.set(0);
            elevatorMotor2.set(0);
        }

        // bounds speed to between 0 and 1
        speed = Math.max(speed, 0);
        speed = Math.min(speed, 1);

        speed = 0;

        elevatorMotor1.set(speed);
        elevatorMotor2.set(speed);
    }

    /**
     * This method moves the elevator downward at the speed given
     *
     * @param speed A value bounded by 0 and 0.05 that isn't outside those values
     */
    public void goDown(double speed) {
        // bounds speed to between 0 and 0.5
        speed = Math.max(speed, 0);
        speed = Math.min(speed, 0.05);
        speed *= -1;

        speed = 0;

        elevatorMotor1.set(speed);
        elevatorMotor2.set(speed);
    }

    /**
     * This method stops the elevator
     */
    public void stop() {
        elevatorMotor1.set(0);
        elevatorMotor2.set(0);
    }
}
