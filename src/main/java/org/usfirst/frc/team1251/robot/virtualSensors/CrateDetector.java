package org.usfirst.frc.team1251.robot.virtualSensors;

import edu.wpi.first.wpilibj.DigitalInput;

public class CrateDetector
{
    //Honorary Name: collector Crate Detector

    //collector Button Limits

    //the switch used to align the crate.
    private DigitalInput crateSwitch;

    public CrateDetector() {
        //crateSwitch = new DigitalInput(RobotMap.COLLECTOR_SWITCH);
    }

    public boolean get() {
        return true;
        //return crateSwitch.get();
    }


}
