package org.usfirst.frc.team1251.robot.commands.autoMotions;

import edu.wpi.first.wpilibj.command.CommandGroup;
import jaci.pathfinder.followers.EncoderFollower;
import org.usfirst.frc.team1251.robot.commands.MotionProfiling.FollowPath;
import org.usfirst.frc.team1251.robot.subsystems.Arm;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1251.robot.subsystems.Elevator;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;

public class CLeftSwitchCollectSecondCube extends CommandGroup {


    public CLeftSwitchCollectSecondCube(DriveFeedback driveFeedback, DriveTrain driveTrain,
                                         Arm arm, ArmPosition armPosition,
                                         Elevator elevator) {

        // After .5 second delay, start moving armevator into position for floor collection
        // TODO: Implement as parallel

        // Move away from switch
        addSequential(new ReverseFromSwitch(driveTrain, driveFeedback));

        // Move up to cube
        addSequential(new ApproachCube(driveTrain, driveFeedback));

        // Collect Cube - Trust that the armevator has had time to get into position!
        // TODO: Implement as sequential

    }

    private class ReverseFromSwitch extends FollowPath {

        ReverseFromSwitch(DriveTrain driveTrain, DriveFeedback driveFeedback) {
            super("CLeftSwitch_CubeAll_LeaveSwitch", driveTrain, driveFeedback);
        }
    }

    private class ApproachCube extends FollowPath {

        ApproachCube(DriveTrain driveTrain, DriveFeedback driveFeedback) {
            super("CBothSwitch_Cube2_ApproachStack", driveTrain, driveFeedback);
        }

        @Override
        protected void configureFollowerPIDVA(EncoderFollower follower) {
            // Reduce dampening for this motion
            follower.configurePIDVA(KP, KI, 0, KV, KA);
        }
    }
}
