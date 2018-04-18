package org.usfirst.frc.team1251.robot.commands.autoMotions;

import edu.wpi.first.wpilibj.command.CommandGroup;
import jaci.pathfinder.followers.EncoderFollower;
import org.usfirst.frc.team1251.robot.commands.ArmevatorFromGroundToSwitch;
import org.usfirst.frc.team1251.robot.commands.MotionProfiling.FollowPath;
import org.usfirst.frc.team1251.robot.subsystems.Arm;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1251.robot.subsystems.Elevator;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;

public class CRightSwitchSecondApproach extends CommandGroup {


    public CRightSwitchSecondApproach(DriveFeedback driveFeedback, DriveTrain driveTrain,
                                      Arm arm, ArmPosition armPosition,
                                      Elevator elevator) {

        // Clear the stack
        addSequential(new ClearStack(driveTrain, driveFeedback));

        // Position armevator for delivery
        addParallel(new ArmevatorFromGroundToSwitch(elevator, arm, armPosition));

        // Make approach
        addSequential(new ApproachSwitch(driveTrain, driveFeedback));
    }

    private class ClearStack extends FollowPath {
        private ClearStack(DriveTrain driveTrain, DriveFeedback driveFeedback) {
            super("Back2ishFeet", driveTrain, driveFeedback);
        }


        @Override
        protected void configureFollowerPIDVA(EncoderFollower follower) {
            follower.configurePIDVA(KP, KI, KD, KV, KA);
        }
    }

    private class ApproachSwitch extends FollowPath {
        private ApproachSwitch (DriveTrain driveTrain, DriveFeedback driveFeedback) {
            super("CRightSwitch_Cube2_ApproachSwitch", driveTrain, driveFeedback);
        }


        @Override
        protected void configureFollowerPIDVA(EncoderFollower follower) {
            follower.configurePIDVA(KP, KI, KD, KV, KA);
        }
    }
}
