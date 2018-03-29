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
    private Timer releaseTimer = new Timer();
    //private boolean isReleaseTimerRunning = false;
    private boolean isTimerRunning = false;


    public CrateDetector() {
        collectorSwitch = new DigitalInput(RobotMap.COLLECTOR_SWITCH);
    }

    public boolean isCrateCollected()
    {
        if (!collectorSwitch.get())
        {
            if (isTimerRunning)
            {
                if (buttonTimer.get() >= 0.05)
                {


                    releaseTimer.start();

                    if (releaseTimer.get() >= 1)
                    {
                        releaseTimer.stop();
                        releaseTimer.reset();
                        return true;
                    } else {
                        return false;
                    }

                    //return true;


                } else {
                    return false;
                }

            } else {
                buttonTimer.start();
                isTimerRunning = true;
                //isReleaseTimerRunning = true;
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
