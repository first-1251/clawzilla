package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrainShifter;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;

public class TestAuto extends CommandGroup {
    public TestAuto(DriveTrain driveTrain, DriveFeedback driveFeedback, DriveTrainShifter driveTrainShifter) {
        addSequential(new AutoTurn(driveTrain, 180, driveFeedback));
        addSequential(new DoNothingDriveTrain(0.5, driveTrain));
        addSequential(new AutoTurn(driveTrain, 90, driveFeedback));
    }
}
