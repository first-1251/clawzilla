package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrainShifter;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;

public class TestAuto extends CommandGroup {
    public TestAuto(DriveTrain driveTrain, DriveFeedback driveFeedback, DriveTrainShifter driveTrainShifter) {
        //addSequential(new AutoForwards(driveFeedback, driveTrain, driveTrainShifter, 215.71));

        // Face the 90 degree heading
        //addSequential(new AutoTurn(driveTrain, 90, driveFeedback, driveTrainShifter));

        //addSequential(new DoNothingDriveTrain(1.5, driveTrain));

        // Move forward 175.00 inches
        ///addSequential(new AutoForwards(driveFeedback, driveTrain, driveTrainShifter, 175.00));

        // Face the 180 degree heading
        addSequential(new AutoTurn(driveTrain, 45, driveFeedback, driveTrainShifter));

        //addSequential(new DoNothingDriveTrain(1.5, driveTrain));

        //addSequential(new AutoTurn(driveTrain, 135, driveFeedback, driveTrainShifter));

        //addSequential(new DoNothingDriveTrain(0.5, driveTrain));

        // Move forward 9.44 inches
        //addSequential(new AutoForwards(driveFeedback, driveTrain, driveTrainShifter, 9.44));
    }
}
