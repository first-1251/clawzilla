package org.usfirst.frc.team1251.robot.commands.autoMotions;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1251.robot.commands.ArmevatorFromStartingToSwitch;
import org.usfirst.frc.team1251.robot.commands.MotionProfiling.FollowPath;
import org.usfirst.frc.team1251.robot.subsystems.Arm;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1251.robot.subsystems.Elevator;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;

public class LSwitchHomeInitialApproach extends CommandGroup {


    public LSwitchHomeInitialApproach(DriveFeedback driveFeedback, DriveTrain driveTrain,
                                      Arm arm, ArmPosition armPosition,
                                      Elevator elevator) {

        // Immediately start positioning the arm. Allow other things to run at the same time.
        addParallel(new ArmevatorFromStartingToSwitch(elevator, arm, armPosition));

        // Move to switch
        addParallel(new ToSwitch(driveTrain, driveFeedback));
    }

    private class ToSwitch extends FollowPath {
        private ToSwitch(DriveTrain driveTrain, DriveFeedback driveFeedback) {
            super("LSwitchHome_Cube1_StartToSwitch", driveTrain, driveFeedback);
        }
    }
}
