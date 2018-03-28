package org.usfirst.frc.team1251.robot.virtualSensors;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team1251.robot.RobotMap;

public class CrateDetector {
    //Honorary Name: collector Crate Detector

    //Collector Limit Switch
    private DigitalInput collectorSwitch;

    //Values
    private Timer buttonTimer = new Timer();
    private boolean isTimerRunning = false;

    public CrateDetector() {
        collectorSwitch = new DigitalInput(RobotMap.COLLECTOR_SWITCH);
    }

    public boolean isCrateCollected()
    {
        if (collectorSwitch.get())
        {
            if (isTimerRunning)
            {
                return buttonTimer.get() >= 1;

            } else {
                buttonTimer.start();
                isTimerRunning = true;
                return false;
            }

        } else {

            if (isTimerRunning) {
                buttonTimer.stop();
                buttonTimer.reset();
                isTimerRunning = false;
            }
            return false;

        }
    }
}
