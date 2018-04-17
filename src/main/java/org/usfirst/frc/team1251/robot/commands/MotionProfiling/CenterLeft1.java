package org.usfirst.frc.team1251.robot.commands.MotionProfiling;

import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;

public class CenterLeft1 extends FollowPath {
    public CenterLeft1(DriveTrain driveTrain, DriveFeedback driveFeedback) {
        super("CenterLeft1", driveTrain, driveFeedback);
    }
}
