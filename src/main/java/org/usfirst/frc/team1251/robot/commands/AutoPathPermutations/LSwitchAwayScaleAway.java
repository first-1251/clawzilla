package org.usfirst.frc.team1251.robot.commands.AutoPathPermutations;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1251.robot.commands.*;
import org.usfirst.frc.team1251.robot.subsystems.*;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;
import org.usfirst.frc.team1251.robot.virtualSensors.ElevatorPosition;

public class LSwitchAwayScaleAway extends CommandGroup {
    public LSwitchAwayScaleAway(Elevator elevator, ElevatorPosition elevatorPosition, Arm arm, ArmPosition armPosition, Claw claw, Collector collector, DriveFeedback driveFeedback, DriveTrain driveTrain, DriveTrainShifter driveTrainShifter){

        // Go forward 215.71 inches
        addSequential(new AutoForwards(driveFeedback, driveTrain, driveTrainShifter, 228));

                // Face the 90 degree heading
        addSequential(new PIDTurn(driveTrain, driveFeedback, 90), 1.0);

        // Move forward 175.00 inches
        addSequential(new AutoForwards(driveFeedback, driveTrain, driveTrainShifter, 187.00));

        // Face the 180 degree heading
        addSequential(new PIDTurn(driveTrain, driveFeedback, 180), 1.0);

                // Move forward 9.44 inches
        addSequential(new AutoForwards(driveFeedback, driveTrain, driveTrainShifter, 24), 1.5);

        addSequential(new ArmevatorFromStartingToSwitch(elevator, arm, armPosition));

        addSequential(new DropCube(claw, collector));

        addSequential(new ArmevatorToStarting(elevator, elevatorPosition, arm, armPosition));
        // Bring arm down to 90 degrees
//        addSequential(new AutoArmTo90(arm, armPosition));

        // Eject the cube into switch
//        addSequential(new TimedEject(collector));

        // Bring arm down to minimum to pick up the cube
//        addSequential(new AutoArmDownToMinimum(arm, armPosition));

        // Face the 150 degree heading
//        addSequential(new AutoTurn(driveTrain, 150, driveFeedback));
//
//        // Grab cube
////        addSequential(new AutoGrabCube(claw, collector, driveTrain, driveTrainShifter, driveFeedback));
//
//        // Bring arm back up to 90
////        addSequential(new AutoArmTo90(arm, armPosition));
//
//        // Face the 90 degree heading
//        addSequential(new AutoTurn(driveTrain, 90, driveFeedback));
//
//        // Go forward 30 inches
//        addSequential(new AutoForwards(driveFeedback, driveTrain, driveTrainShifter, 30.00));
//
//        // Face the 0 degree heading
//        addSequential(new AutoTurn(driveTrain, 0, driveFeedback));
//
//        // Move forward 60
//        //TODO: Determine the exact length of this travel distance (not shown in diagram; must guesstimate)
//        addSequential(new AutoForwards(driveFeedback, driveTrain, driveTrainShifter, 60.00));
//
//        // Raise arm
////        addSequential(new AutoArmUpToTop(arm, armPosition));
//
//        // Eject Cube
////        addSequential(new TimedEject(collector));

    }

}
