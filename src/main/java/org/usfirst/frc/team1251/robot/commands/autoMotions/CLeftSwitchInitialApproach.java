package org.usfirst.frc.team1251.robot.commands.autoMotions;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1251.robot.commands.ArmevatorFromStartingToSwitch;
import org.usfirst.frc.team1251.robot.commands.MotionProfiling.FollowPath;
import org.usfirst.frc.team1251.robot.subsystems.*;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;

public class CLeftSwitchInitialApproach extends CommandGroup {


    public CLeftSwitchInitialApproach(DriveFeedback driveFeedback, DriveTrain driveTrain,
                                      Arm arm, ArmPosition armPosition,
                                      Elevator elevator) {

        // Immediately start positioning the arm. Allow other things to run at the same time.
        addParallel(new ArmevatorFromStartingToSwitch(elevator, arm, armPosition));

        // Move to switch
        addParallel(new ToSwitch(driveTrain, driveFeedback));
    }

    private class ToSwitch extends FollowPath {
        private ToSwitch(DriveTrain driveTrain, DriveFeedback driveFeedback) {
            super("CenterLeft1", driveTrain, driveFeedback);
        }
    }
}
