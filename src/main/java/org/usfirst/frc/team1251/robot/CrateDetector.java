package org.usfirst.frc.team1251.robot;

import edu.wpi.first.wpilibj.DigitalInput;

public class CrateDetector
{
    //Honorary Name: collector Crate Detector

    //collector Button Limits

    //One of the 3 switches used to align the crate. On left side when looking from the rear perspective.
    private DigitalInput leftSwitch;

    //One of the 3 switches used to align the crate. In the middle.
    private DigitalInput middleSwitch;

    //One of the 3 switches used to align the crate. On right side when looking from the rear perspective.
    private DigitalInput rightSwtich;

    public enum CrateState {
        SKEWED_LEFT, DIAGONAL, SKEWED_RIGHT, CRATE_COLLECTED, NONE
    }

    public CrateState getCrateState()
    {
        if (isLeftOnly()) {
            return CrateState.SKEWED_LEFT;
        }
        if (isMiddleOnly()) {
            return CrateState.DIAGONAL;
        }
        if (isLeftMiddle()) {
            return CrateState.SKEWED_LEFT;
        }
        if (isRightOnly()) {
            return CrateState.SKEWED_RIGHT;
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
        return leftSwitch.get() && !middleSwitch.get() && !rightSwtich.get();
    }
    private boolean isMiddleOnly() //Only middle button is pressed
    {
        return middleSwitch.get() && !leftSwitch.get() && !rightSwtich.get();
    }
    private boolean isRightOnly() //Only right button is pressed
    {
        return rightSwtich.get() && !middleSwitch.get() && !leftSwitch.get();
    }
    private boolean isLeftMiddle() //Left and Middle is pressed
    {
        return leftSwitch.get() && middleSwitch.get() && !leftSwitch.get();
    }
    private boolean isRightMiddle() //Right and Middle is pressed
    {
        return rightSwtich.get() && middleSwitch.get() && !leftSwitch.get();
    }
    private boolean isAllPressed() //Right and Middle is pressed
    {
        return rightSwtich.get() && middleSwitch.get() && leftSwitch.get();
    }


}
