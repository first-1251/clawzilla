package org.usfirst.frc.team1251.robot.commands.AutoPathPermutations;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1251.robot.commands.*;
import org.usfirst.frc.team1251.robot.subsystems.*;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;
import org.usfirst.frc.team1251.robot.virtualSensors.ElevatorPosition;

public class CSwitchRight extends CommandGroup {
    public CSwitchRight(Arm arm, ArmPosition armPosition, Claw claw, Collector collector, DriveFeedback driveFeedback, DriveTrain driveTrain, DriveTrainShifter driveTrainShifter, Elevator elevator, ElevatorPosition elevatorPosition) {

        // Move forward 24 inches
        addSequential(new AutoForwards(driveFeedback, driveTrain, driveTrainShifter, 24));

        // Face the 137 degree heading
        addSequential(new AutoTurn(driveTrain, 137, driveFeedback));

        // Move forward 70.69 inches
        addSequential(new AutoForwards(driveFeedback, driveTrain, driveTrainShifter, 70.69));

        // Face the 0 degree heading
        addSequential(new AutoTurn(driveTrain, 0, driveFeedback));

        // Move forward 24.00 inches
        addSequential(new AutoForwards(driveFeedback, driveTrain, driveTrainShifter, 24));

        // Raise elevator?


        // Bring arm down to 90 degrees
        addSequential(new AutoArmTo90(arm, armPosition));

        // Eject cube
        addSequential(new TimedEject(collector));

    }
}
