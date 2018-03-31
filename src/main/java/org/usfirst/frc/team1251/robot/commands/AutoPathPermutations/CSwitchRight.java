package org.usfirst.frc.team1251.robot.commands.AutoPathPermutations;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1251.robot.commands.*;
import org.usfirst.frc.team1251.robot.subsystems.*;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;
import org.usfirst.frc.team1251.robot.virtualSensors.ElevatorPosition;

public class CSwitchRight extends CommandGroup {

    @Override
    protected void initialize() {
        System.out.println("This is CSwitchRight");
    }


    public CSwitchRight(DriveFeedback driveFeedback, DriveTrainShifter driveShifter, DriveTrain driveTrain,
                        Arm arm, ArmPosition armPosition,
                        Elevator elevator, ElevatorPosition elevatorPosition,
                        Claw claw, Collector collector) {

        addSequential(new AutoForwards(driveFeedback, driveTrain, driveShifter, 24));

        addSequential(new PIDTurn(driveTrain, driveFeedback, 90), 1.0);

        addSequential(new AutoForwards(driveFeedback, driveTrain, driveShifter, 48.21));

        addSequential(new PIDTurn(driveTrain, driveFeedback, 0), 1.0);

        // TODO: Candidate for overrun + timeout
        addSequential(new AutoForwards(driveFeedback, driveTrain, driveShifter, 82.32));

        addSequential(new ArmevatorFromStartingToSwitch(elevator, arm, armPosition));

        addSequential(new DropCube(claw, collector));

        addSequential(new ArmevatorToStarting(elevator, elevatorPosition, arm, armPosition));
    }

    // Move forward 24 inches

    // Face the 137 degree heading

    // Move forward 70.69 inches

    // Face the 0 degree heading

    // Move forward 24.00 inches

    // Raise elevator?

    // Bring arm down to 90 degrees

    // Eject cube
}
