package org.usfirst.frc.team1251.robot.virtualSensors;

import edu.wpi.first.wpilibj.DigitalInput;
import org.usfirst.frc.team1251.robot.Robot;
import org.usfirst.frc.team1251.robot.RobotMap;

public class CrateDetector
{
    //Honorary Name: collector Crate Detector

    //collector Button Limits

    //One of the 3 switches used to align the crate. On left side when looking from the rear perspective.
    private DigitalInput leftSwitch;

    //One of the 3 switches used to align the crate. In the middle.
    private DigitalInput middleSwitch;

    //One of the 3 switches used to align the crate. On right side when looking from the rear perspective.
    private DigitalInput rightSwitch;


    public enum CrateState {
        SKEWED_LEFT, DIAGONAL, SKEWED_RIGHT, CRATE_COLLECTED, NONE
    }

    public CrateDetector()
    {
        leftSwitch = new DigitalInput(RobotMap.COLLECTOR_LEFT_SWITCH);
        middleSwitch = new DigitalInput(RobotMap.COLLECTOR_MIDDLE_SWITCH);
        rightSwitch = new DigitalInput(RobotMap.COLLECTOR_RIGHT_SWITCH);
    }
    public CrateState getCrateState()
    {
        if (isLeftOnly()) {
            return CrateState.SKEWED_LEFT;
        }
        if (isLeftMiddle()) {
            return CrateState.SKEWED_LEFT;
        }
        if (isRightOnly()) {
            return CrateState.SKEWED_RIGHT;
        }
        if (isMiddleOnly()) {
            return CrateState.DIAGONAL;
        }
        if (isRightMiddle()) {
            return CrateState.SKEWED_RIGHT;
        }
        if (isAllPressed()) {
            return CrateState.CRATE_COLLECTED;
        }

        return CrateState.NONE;
    }

    private boolean isLeftOnly() //Only left button is pressed
    {
        return isLeftPressed() && !isMiddlePressed() && !isRightPressed();
    }
    private boolean isMiddleOnly() //Only middle button is pressed
    {
        return isMiddlePressed() && !isLeftPressed() && !isRightPressed();
    }
    private boolean isRightOnly() //Only right button is pressed
    {
        return isRightPressed() && !isMiddlePressed() && !isLeftPressed();
    }
    private boolean isLeftMiddle() //Left and Middle is pressed
    {
        return isLeftPressed() && isMiddlePressed() && !isRightPressed();
    }
    private boolean isRightMiddle() //Right and Middle is pressed
    {
        return isRightPressed() && isMiddlePressed() && !isLeftPressed();
    }
    private boolean isAllPressed() //Right and Middle is pressed
    {
        return isRightPressed() && isMiddlePressed() && isLeftPressed();
    }


    private boolean isRightPressed() {
        return rightSwitch.get();
    }

    private boolean isLeftPressed() {
        return leftSwitch.get();
    }

    private boolean isMiddlePressed() {
        return middleSwitch.get();
    }


}
