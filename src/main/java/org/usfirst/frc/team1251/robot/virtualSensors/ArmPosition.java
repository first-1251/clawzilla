package org.usfirst.frc.team1251.robot.virtualSensors;

import edu.wpi.first.wpilibj.DigitalInput;
import org.usfirst.frc.team1251.robot.RobotMap;

public class ArmPosition {

    // limit switches
    private DigitalInput topSwitch;
    private DigitalInput bottomSwitch;

    // a constant to check the input against, allowing us to change this constant IF the switches are inverted
    private boolean TOP_PRESSED = true;
    private boolean BOTTOM_PRESSED = true;

    public ArmPosition() {
        topSwitch = new DigitalInput(RobotMap.ARM_UPPER_LIMIT_SWITCH);
        bottomSwitch = new DigitalInput(RobotMap.ARM_LOWER_LIMIT_SWITCH);
    }

    public boolean isArmUp() {
        return topSwitch.get() == TOP_PRESSED;
    }

    public boolean isArmDown() {
        return bottomSwitch.get() == BOTTOM_PRESSED;
    }

}
