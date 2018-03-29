package org.usfirst.frc.team1251.robot.commands.AutoPathPermutations;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1251.robot.commands.*;
import org.usfirst.frc.team1251.robot.subsystems.*;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;
import org.usfirst.frc.team1251.robot.virtualSensors.ElevatorPosition;

public class CSwitchLeft extends CommandGroup{
    public CSwitchLeft(Arm arm, ArmPosition armPosition, Claw claw, Collector collector, DriveFeedback driveFeedback, DriveTrain driveTrain, DriveTrainShifter driveTrainShifter, Elevator elevator, ElevatorPosition elevatorPosition){

        // Move forward 24 inches
        addSequential(new AutoForwards(driveFeedback, driveTrain, driveTrainShifter, 24.00));

        // Face the 229 degree heading
        addSequential(new AutoTurn(driveTrain, 229, driveFeedback));

        // Move forward 78.89 inches
        addSequential(new AutoForwards(driveFeedback, driveTrain, driveTrainShifter, 78.89));

        // Face the 0 degree heading
        addSequential(new AutoTurn(driveTrain, 0, driveFeedback));

        // Move forward 24.00 inches
        addSequential(new AutoForwards(driveFeedback, driveTrain, driveTrainShifter, 24.00));

        // Raise elevator?

        // Bring arm down to 90 degrees
        addSequential(new AutoArmTo90(arm, armPosition));

        // Eject cube
        addSequential(new TimedEject(collector));

        // Lower elevator, Bring arm to minimum, AND Move Backwards 36.82 inches
        addSequential(new AutoElevatorToBottom(elevator, elevatorPosition));
        addParallel(new AutoArmDownToMinimum(arm, armPosition));
        addParallel(new AutoForwards(driveFeedback, driveTrain, driveTrainShifter, -36.82));

        // Face the 290 degree heading
        addSequential(new AutoTurn(driveTrain, 290, driveFeedback));

        // Move forward 32.76
        addSequential(new AutoForwards(driveFeedback, driveTrain, driveTrainShifter, 32.76));

        // Grab cube
        addSequential(new AutoGrabCube(claw, collector, driveTrain, driveTrainShifter, driveFeedback));

        // Move backward 32.76
        addSequential(new AutoForwards(driveFeedback, driveTrain, driveTrainShifter, -32.76));

        // Face the 0 degree heading
        addSequential(new AutoTurn(driveTrain, 0, driveFeedback));

        // Move forward 36.82, Raise Elevator, and Bring arm to 90
        addSequential(new AutoForwards(driveFeedback, driveTrain, driveTrainShifter, 36.82));
        addParallel(new AutoArmTo90(arm, armPosition));
        //TODO: Determine ticks per inch so we can use accurate heights
        addParallel(new AutoElevator(elevator, elevatorPosition, 1));

        // Eject cube
        addSequential(new TimedEject(collector));
    }
}



