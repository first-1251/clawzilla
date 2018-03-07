package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;

public class SwitchAuto  extends CommandGroup{

    public SwitchAuto(DriveTrain driveTrain) {
        addSequential(new AutoTurn(driveTrain, -30));
        //addSequential(new AutoForwards(driveTrain, 60));
    }
}
