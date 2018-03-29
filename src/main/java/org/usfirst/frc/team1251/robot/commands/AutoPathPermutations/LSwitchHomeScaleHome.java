package org.usfirst.frc.team1251.robot.commands.AutoPathPermutations;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1251.robot.commands.*;
import org.usfirst.frc.team1251.robot.subsystems.*;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;

public class LSwitchHomeScaleHome extends CommandGroup {
    // Go forward 147.36 inches

    // Face the 90 degree heading

    // Move forward 17.29 inches

    // Bring arm down to 90 degrees

    // Eject the cube into switch

    public LSwitchHomeScaleHome(Arm arm, ArmPosition armPosition, Claw claw, Collector collector, DriveFeedback driveFeedback, DriveTrain driveTrain, DriveTrainShifter driveTrainShifter){

        // Go forward 147.36 inches
        addSequential(new AutoForwards(driveFeedback, driveTrain, driveTrainShifter, 147.36));

        // Face the 90 degree heading
        addSequential(new AutoTurn(driveTrain, 90, driveFeedback));

        // Move forward 17.29 inches
        addSequential(new AutoForwards(driveFeedback, driveTrain, driveTrainShifter, 17.29));

//        // Bring arm down to 90 degrees
//        addSequential(new AutoArmTo90(arm, armPosition));
//
//        // Eject the cube into switch
//        addSequential(new TimedEject(collector));
//
//        // Bring arm down to minimum to pick up the cube
//        addSequential(new AutoArmDownToMinimum(arm, armPosition));

        // Face the 180 degree heading
        addSequential(new AutoTurn(driveTrain, 180, driveFeedback));

        // Move backwards 65.25 inches
        addSequential(new AutoForwards(driveFeedback,driveTrain,driveTrainShifter, -65.25));

        // Face the 132.4 degree heading
        addSequential(new AutoTurn(driveTrain, 132.4, driveFeedback));

        // Move forward 17.00 inches
        addSequential(new AutoForwards(driveFeedback,driveTrain,driveTrainShifter, 17.00));

//        // Pick up cube
//        addSequential(new AutoGrabCube(claw, collector, driveTrain, driveTrainShifter, driveFeedback));

        // Move back 26 inches
        addSequential(new AutoForwards(driveFeedback,driveTrain,driveTrainShifter, -26.00));

        // Turn to face the 19.4 degree heading 19.4
        addSequential(new AutoTurn(driveTrain, 19.4, driveFeedback));

        // Move forward 42.67 and bring arm back up to 90
        addSequential(new AutoForwards(driveFeedback,driveTrain,driveTrainShifter, 42.67));

//        addParallel(new AutoArmTo90(arm, armPosition));

        // Raise elevator

    }

}
