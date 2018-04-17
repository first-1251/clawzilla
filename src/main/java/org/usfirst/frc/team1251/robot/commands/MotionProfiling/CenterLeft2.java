package org.usfirst.frc.team1251.robot.commands.MotionProfiling;

import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;

public class CenterLeft2 extends FollowPath {

    public CenterLeft2(DriveTrain driveTrain, DriveFeedback driveFeedback) {
        super("CenterLeft2", driveTrain, driveFeedback);
    }
}
