package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1251.robot.commands.MotionProfiling.FollowPath;
import org.usfirst.frc.team1251.robot.commands.MotionProfiling.FollowPathBackwards;
import org.usfirst.frc.team1251.robot.subsystems.*;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;
import org.usfirst.frc.team1251.robot.virtualSensors.ElevatorPosition;

public class TestAuto extends CommandGroup {
    public TestAuto(DriveTrain driveTrain, DriveFeedback driveFeedback, DriveTrainShifter driveTrainShifter,
                    Elevator elevator, Arm arm, ArmPosition armPosition, Claw claw, Collector collector, ElevatorPosition elevatorPosition) {
        //addSequential(new AutoForwards(driveFeedback, driveTrain, driveTrainShifter, 215.71));

        // Face the 90 degree heading
        //addSequential(new AutoTurn(driveTrain, 90, driveFeedback, driveTrainShifter));

        //addSequential(new DoNothingDriveTrain(1.5, driveTrain));

        // Move forward 175.00 inches
        ///addSequential(new AutoForwards(driveFeedback, driveTrain, driveTrainShifter, 175.00));

        // Face the 180 degree heading
        //addSequential(new AutoForwards(driveFeedback, driveTrain, driveTrainShifter));

        //addSequential(new PIDTurn(driveTrain, driveFeedback, 90));
        //addSequential(new DoNothingDriveTrain(1.0, driveTrain));
        //addSequential(new PIDTurn(driveTrain, driveFeedback, 180));

        //addSequential(new ArmevatorFromStartingToSwitch(elevator, arm, armPosition));

        //addSequential(new DoNothingDriveTrain(1.0, driveTrain));
        //addSequential(new DropCube(claw, collector));

        addSequential(new FollowPath(driveTrain, driveFeedback));
        addSequential(new FollowPathBackwards(driveTrain, driveFeedback));

        //addSequential(new ArmevatorToStarting(elevator, elevatorPosition, arm, armPosition));
        //addSequential(new DoNothingDriveTrain(1.5, driveTrain));

        //addSequential(new AutoTurn(driveTrain, 90, driveFeedback, driveTrainShifter));

        //addSequential(new DoNothingDriveTrain(0.5, driveTrain));

        // Move forward 9.44 inches
        //addSequential(new AutoForwards(driveFeedback, driveTrain, driveTrainShifter, 9.44));

        //addSequential(new ArmevatorFromStartingToSwitch(elevator, arm, armPosition));
        //addSequential(new DropCube(claw, collector));
    }
}
