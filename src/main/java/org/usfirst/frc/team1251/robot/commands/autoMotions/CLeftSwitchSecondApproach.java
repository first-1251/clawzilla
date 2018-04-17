package org.usfirst.frc.team1251.robot.commands.autoMotions;

import edu.wpi.first.wpilibj.command.CommandGroup;
import jaci.pathfinder.followers.EncoderFollower;
import org.usfirst.frc.team1251.robot.commands.MotionProfiling.FollowPath;
import org.usfirst.frc.team1251.robot.subsystems.Arm;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1251.robot.subsystems.Elevator;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;

public class CLeftSwitchSecondApproach extends CommandGroup {


    public CLeftSwitchSecondApproach(DriveFeedback driveFeedback, DriveTrain driveTrain,
                                     Arm arm, ArmPosition armPosition,
                                     Elevator elevator) {

        // Clear the stack
        addSequential(new ClearStack(driveTrain, driveFeedback));

        // Back up and adjust angle for approach;
        // TODO: sequential

        // Position armevator for delivery
        // TODO: Parallel

        // Make approach
        // TODO: Sequential
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
}
