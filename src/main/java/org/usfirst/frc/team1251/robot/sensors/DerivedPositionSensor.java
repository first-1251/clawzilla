package org.usfirst.frc.team1251.robot.sensors;

import org.usfirst.frc.team1251.robot.RobotPosition;

/**
 * Uses raw sensor data to derive the position of the Robot on the field.
 */
public interface DerivedPositionSensor extends DerivedSensor {
    /**
     * Reports the current position of the Robot.
     *
     * @return The Robot's current, calculated position on the field.
     */
    RobotPosition getPosition();
}
