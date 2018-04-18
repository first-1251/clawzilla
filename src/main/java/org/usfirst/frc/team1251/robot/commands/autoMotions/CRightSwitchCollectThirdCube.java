package org.usfirst.frc.team1251.robot.commands.autoMotions;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1251.robot.commands.ArmevatorToGroundCollect;
import org.usfirst.frc.team1251.robot.commands.MotionProfiling.FollowPath;
import org.usfirst.frc.team1251.robot.subsystems.Arm;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1251.robot.subsystems.Elevator;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;
import org.usfirst.frc.team1251.robot.virtualSensors.ElevatorPosition;

public class CRightSwitchCollectThirdCube extends CommandGroup {


    public CRightSwitchCollectThirdCube(DriveFeedback driveFeedback, DriveTrain driveTrain,
                                        Arm arm, ArmPosition armPosition, ElevatorPosition elevatorPosition,
                                        Elevator elevator) {

        // After .5 second delay, start moving armevator into position for floor collection

        addParallel(new ArmevatorToGroundCollect(.5, elevator, elevatorPosition, arm, armPosition));
        // Move away from switch
        addSequential(new ReverseFromSwitch(driveTrain, driveFeedback));

    }

    private class ReverseFromSwitch extends FollowPath {

        ReverseFromSwitch(DriveTrain driveTrain, DriveFeedback driveFeedback) {
            super("CRightSwitch_CubeAll_LeaveSwitch", driveTrain, driveFeedback);
        }
    }
}
