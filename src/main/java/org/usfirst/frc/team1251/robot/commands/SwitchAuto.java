package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrainShifter;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;

public class SwitchAuto  extends CommandGroup{

    public SwitchAuto(DriveTrain driveTrain, DriveFeedback driveFeedback, DriveTrainShifter shifter) {
        addSequential(new AutoForwards(driveFeedback, driveTrain, shifter, 138));
    }
}
