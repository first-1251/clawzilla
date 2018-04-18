package org.usfirst.frc.team1251.robot.commands.autoMotions;

import edu.wpi.first.wpilibj.command.CommandGroup;
import jaci.pathfinder.followers.EncoderFollower;
import org.usfirst.frc.team1251.robot.commands.ArmevatorToGroundCollect;
import org.usfirst.frc.team1251.robot.commands.AutoOpenClawCollect;
import org.usfirst.frc.team1251.robot.commands.CloseClaw;
import org.usfirst.frc.team1251.robot.commands.MotionProfiling.FollowPath;
import org.usfirst.frc.team1251.robot.subsystems.*;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;
import org.usfirst.frc.team1251.robot.virtualSensors.ElevatorPosition;

public class CLeftSwitchCollectSecondCube extends CommandGroup {


    public CLeftSwitchCollectSecondCube(DriveFeedback driveFeedback, DriveTrain driveTrain,
                                        Arm arm, ArmPosition armPosition,
                                        Elevator elevator, ElevatorPosition elevatorPosition,
                                        Claw claw, Collector collector) {

        // After .5 second delay, start moving armevator into position for floor collection
        // TODO: Implement as parallel
        addParallel(new ArmevatorToGroundCollect(.5, elevator, elevatorPosition, arm, armPosition));

        // Move away from switch
        addSequential(new ReverseFromSwitch(driveTrain, driveFeedback));

        // Collect Cube - Trust that the armevator has had time to get into position!
        // TODO: Implement as sequential
        addParallel(new AutoOpenClawCollect(claw, collector));

        // Move up to cube
        addSequential(new ApproachCube(driveTrain, driveFeedback));

        addSequential(new CloseClaw(claw));
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
            follower.configurePIDVA(KP, KI, KD, KV, KA);
        }
    }
}
