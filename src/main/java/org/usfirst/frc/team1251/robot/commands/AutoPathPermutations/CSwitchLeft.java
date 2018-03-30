package org.usfirst.frc.team1251.robot.commands.AutoPathPermutations;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1251.robot.commands.*;
import org.usfirst.frc.team1251.robot.subsystems.*;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;
import org.usfirst.frc.team1251.robot.virtualSensors.ElevatorPosition;

public class CSwitchLeft extends CommandGroup{

    @Override
    protected void initialize() {
        System.out.println("This is CSwitchLeft");
    }

    public CSwitchLeft(DriveFeedback driveFeedback, DriveTrainShifter driveShifter, DriveTrain driveTrain,
                       Arm arm, ArmPosition armPosition,
                       Elevator elevator, ElevatorPosition elevatorPosition,
                       Claw claw, Collector collector) {
        addSequential(new AutoForwards(driveFeedback, driveTrain, driveShifter, 24));

        addSequential(new AutoTurn(driveTrain, 270, driveFeedback, driveShifter));
        addSequential(new DoNothingDriveTrain(.5, driveTrain));

        addSequential(new AutoForwards(driveFeedback, driveTrain, driveShifter, 59.93));

        addSequential(new AutoTurn(driveTrain, 0, driveFeedback, driveShifter));
        addSequential(new DoNothingDriveTrain(.5, driveTrain));

        // TODO: Candidate for overrun + timeout
        addSequential(new AutoForwards(driveFeedback, driveTrain, driveShifter, 75.32));

        addSequential(new ArmevatorFromStartingToSwitch(elevator, arm, armPosition));

        addSequential(new DropCube(claw, collector));

        addSequential(new ArmevatorToStarting(elevator, elevatorPosition, arm, armPosition));
    }

    // Move forward 24 inches

    // Face the 229 degree heading

    // Move forward 78.89 inches

    // Face the 360 degree heading

    // Move forward 24.00 inches

    // Raise elevator?

    // Bring arm down to 90 degrees

    // Eject cube


}
