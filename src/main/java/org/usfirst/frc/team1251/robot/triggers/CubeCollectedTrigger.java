package org.usfirst.frc.team1251.robot.triggers;

import edu.wpi.first.wpilibj.buttons.Trigger;
import org.usfirst.frc.team1251.robot.virtualSensors.CrateDetector;

public class CubeCollectedTrigger extends Trigger {
    private final CrateDetector crateDetector;

    public CubeCollectedTrigger(CrateDetector crateDetector) {
        this.crateDetector = crateDetector;
    }

    @Override
    public boolean get() {
        return crateDetector.isCrateCollected();
    }
}
