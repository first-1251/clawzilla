package org.usfirst.frc.team1251.robot.triggers;

import edu.wpi.first.wpilibj.buttons.Trigger;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;

public class ArmDownJustNowTrigger extends Trigger{

    private final ArmPosition armPosition;

    public ArmDownJustNowTrigger(ArmPosition armPosition) {
        this.armPosition = armPosition;
    }

    @Override
    public boolean get() {
        return this.armPosition.isArmDown();
    }
}
