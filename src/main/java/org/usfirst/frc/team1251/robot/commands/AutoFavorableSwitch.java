package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1251.robot.subsystems.*;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;

public class AutoFavorableSwitch extends CommandGroup {
    public AutoFavorableSwitch(Claw claw, Collector collector, DriveTrain driveTrain, DriveFeedback driveFeedback, DriveTrainShifter shifter) {

        // Travel far enough to be at middle of switch plate
        addSequential(new AutoForwards(driveFeedback, driveTrain, shifter, 168)); // 14'

        // Turn to face the switch plate
        addSequential(new AutoTurn(driveTrain, -90, driveFeedback)); // 90 degrees counter-clockwise

        // Put the cube on the switch.
        addSequential(new TimedEject(collector));
    }
}
