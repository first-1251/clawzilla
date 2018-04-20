package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1251.robot.commands.MotionProfiling.FollowPath;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrainShifter;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;

public class CrossLineAuto extends CommandGroup {

    public CrossLineAuto(DriveTrain driveTrain, DriveFeedback driveFeedback, DriveTrainShifter shifter) {
        addSequential(new CrossLine(driveTrain, driveFeedback));
    }

    private class CrossLine extends FollowPath {
        private CrossLine(DriveTrain driveTrain, DriveFeedback driveFeedback) {
            super("CrossLine", driveTrain, driveFeedback);
        }
    }
}
