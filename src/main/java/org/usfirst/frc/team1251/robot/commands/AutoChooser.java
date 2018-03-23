package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import openrio.powerup.MatchData;
import org.usfirst.frc.team1251.robot.subsystems.Clawlector;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrainShifter;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;

public class AutoChooser extends CommandGroup {

    public AutoChooser(Clawlector clawlector, DriveTrain driveTrain, DriveFeedback driveFeedback, DriveTrainShifter shifter) {
        MatchData.OwnedSide ourSwitch = MatchData.getOwnedSide(MatchData.GameFeature.SWITCH_NEAR);

        if (ourSwitch == MatchData.OwnedSide.RIGHT) {
            addSequential(new AutoFavorableSwitch(clawlector, driveTrain, driveFeedback, shifter));
        } else if (ourSwitch == MatchData.OwnedSide.LEFT) {
            addSequential(new AutoUnfavorableSwitch(clawlector, driveTrain, driveFeedback, shifter));
        } else {
            System.out.println("Unknown switch side, just crossing line.");
            addSequential(new CrossLineAuto(driveTrain, driveFeedback, shifter));
        }
    }
}