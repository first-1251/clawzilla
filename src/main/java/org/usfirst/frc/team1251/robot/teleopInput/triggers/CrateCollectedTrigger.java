package org.usfirst.frc.team1251.robot.teleopInput.triggers;

import edu.wpi.first.wpilibj.buttons.Trigger;
import org.usfirst.frc.team1251.robot.virtualSensors.CrateDetector;

public class CrateCollectedTrigger extends Trigger {

    private CrateDetector crateDetector;

    public CrateCollectedTrigger(CrateDetector crateDetector)
    {
        this.crateDetector = crateDetector;
    }

    @Override
    public boolean get() {
        return crateDetector.isCrateCollected();
    }

}
