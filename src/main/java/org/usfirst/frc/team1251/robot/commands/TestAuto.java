package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1251.robot.commands.AutoPathPermutations.CSwitchLeftFancy;
import org.usfirst.frc.team1251.robot.subsystems.*;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;
import org.usfirst.frc.team1251.robot.virtualSensors.ElevatorPosition;

public class TestAuto extends CommandGroup {
    public TestAuto(DriveTrain driveTrain, DriveFeedback driveFeedback, DriveTrainShifter driveTrainShifter,
                    Elevator elevator, Arm arm, ArmPosition armPosition, Claw claw, Collector collector, ElevatorPosition elevatorPosition) {

        addSequential(new CSwitchLeftFancy(
                driveFeedback, driveTrainShifter, driveTrain,
                arm, armPosition,
                elevator, elevatorPosition,
                claw, collector
        ));

    }
}
