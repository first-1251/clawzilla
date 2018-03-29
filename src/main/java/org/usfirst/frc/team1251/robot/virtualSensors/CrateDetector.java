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

    private Timer recentlyCollectedTimer = new Timer();
    private boolean isRecentlyCollectedTimerRunning = false;

    public CrateDetector() {
        collectorSwitch = new DigitalInput(RobotMap.COLLECTOR_SWITCH);
    }

    private void markAsRecentlyCollected() {
        if (isRecentlyCollectedTimerRunning) {
            recentlyCollectedTimer.stop();
        }

        recentlyCollectedTimer.reset();
        recentlyCollectedTimer.start();
        isRecentlyCollectedTimerRunning = true;
    }

    private boolean isRecentlyCollected() {
        if (!isRecentlyCollectedTimerRunning) {
            return false;
        }

        // Timer expires after a second.
        if (recentlyCollectedTimer.get() >= 1.0) {
            // Timer has expired, stop and reset it then return false. Crate was detected but not recently *enough*.
            recentlyCollectedTimer.stop();
            recentlyCollectedTimer.reset();
            isRecentlyCollectedTimerRunning = false;
            return false;
        }

        // Recently collected timer is running and has not expired.
        return true;
    }

    private boolean isButtonPressed() {
        return !collectorSwitch.get();
    }

    public boolean isCrateCollected()
    {
        // If the crate was recently collected, there is no reason to check the button state.
        if (isRecentlyCollected()) {
            return true;
        }

        if (isButtonPressed())
        {
            if (isTimerRunning)
            {
                // Timer is running... see if the button has been held long enough.
                if (buttonTimer.get() >= .10) {
                    // Button has been held long enough. Mark the crate as recently collected and return true.
                    markAsRecentlyCollected();
                    return true;
                } else {
                    return false;
                }

            } else {
                buttonTimer.start();
                isTimerRunning = true;
                return false;
            }

        } else {
            // Button is not pressed...

            // stop and reset the timer if it is running.
            if (isTimerRunning) {
                buttonTimer.stop();
                buttonTimer.reset();
                isTimerRunning = false;
            }

            // Indicate that the crate is not collected.
            return false;

        }
    }
}
