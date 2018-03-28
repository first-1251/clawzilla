package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1251.robot.subsystems.Claw;
import org.usfirst.frc.team1251.robot.subsystems.Collector;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrainShifter;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;

public class AutoUnfavorableSwitch extends CommandGroup {
    public AutoUnfavorableSwitch(Claw claw, Collector collector, DriveTrain driveTrain, DriveFeedback driveFeedback, DriveTrainShifter shifter) {

        // Drive far enough to pass the switch and clear the line of cubes

        addSequential(new AutoForwards(driveFeedback, driveTrain, shifter, 248 - 49)); // 20' 3" 248

        // Turn to approach the opposing switch.
        addSequential(new AutoTurn(driveTrain, -90, driveFeedback)); // 90 degrees counter-clockwise

        addSequential(new DoNothingDriveTrain(0.3, driveTrain));
        // Travel along back side of switch (between switch and scale)to the middle of the opposing switch.
        addSequential(new AutoForwards(driveFeedback, driveTrain, shifter, 159 - 64)); // 13' 3"

        // Turn to face the switch.
        addSequential(new AutoTurn(driveTrain, -180, driveFeedback)); // 90 degrees counter-clockwise

        addSequential(new DoNothingDriveTrain(0.3, driveTrain));
        addSequential(new AutoForwards(driveFeedback, driveTrain, shifter, 14));
        // Put the block in the switch
        addSequential(new TimedEject(collector));

    }
}
