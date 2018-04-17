package org.usfirst.frc.team1251.robot.commands.MotionProfiling;

import jaci.pathfinder.followers.EncoderFollower;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;

public class CenterLeft3 extends FollowPath {

    public CenterLeft3(DriveTrain driveTrain, DriveFeedback driveFeedback) {
        super("CenterLeft3", driveTrain, driveFeedback);
    }

    @Override
    protected void configureFollowerPIDVA(EncoderFollower follower) {
        // Reduce dampening for this motion
        follower.configurePIDVA(KP, KI, .1, KV, KA);
    }
}
