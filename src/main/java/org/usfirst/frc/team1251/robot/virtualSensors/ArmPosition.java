package org.usfirst.frc.team1251.robot.virtualSensors;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import org.usfirst.frc.team1251.robot.RobotMap;

/**
 * Arm position is measured in degrees from full-up (starting) position. The lower the arm, the higher the
 * degree. This is counter-intuitive to humans but is how the sensors are hooked up.
 */
public class ArmPosition {

    // limit switches
    private DigitalInput topSwitch;
    private DigitalInput bottomSwitch;

    private AnalogPotentiometer potentiometer;

    // a constant to check the input against, allowing us to change this constant IF the switches are inverted
    private boolean TOP_PRESSED = false;
    private boolean BOTTOM_PRESSED = false;

    private final double GEAR_RATIO = 130.0 / 14.0;

    public ArmPosition() {
        topSwitch = new DigitalInput(RobotMap.ARM_UPPER_LIMIT_SWITCH);
        bottomSwitch = new DigitalInput(RobotMap.ARM_LOWER_LIMIT_SWITCH);

        potentiometer = new AnalogPotentiometer(RobotMap.ARM_POTENTIOMETER, 3600 / GEAR_RATIO, -6.45);
    }

    public boolean isArmUp() {
        return topSwitch.get() == TOP_PRESSED;
    }

    public boolean isArmDown() {
        return bottomSwitch.get() == BOTTOM_PRESSED;
    }

    public double getPotentiometer() {
        return potentiometer.get();
    }

    /**
     * @deprecated - Seems inverted -- do not use without a closer look!
     */
    public boolean atLeast90() { return potentiometer.get() < 87.0; }

    /**
     * @deprecated - Seems inverted -- do not use without a closer look!
     */
    public boolean lessThan90() { return potentiometer.get() > 93.0; }
}
