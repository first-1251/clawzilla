package org.usfirst.frc.team1251.robot.commands.AutoPathPermutations;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1251.robot.commands.DropCube;
import org.usfirst.frc.team1251.robot.commands.autoMotions.CLeftSwitchCollectSecondCube;
import org.usfirst.frc.team1251.robot.commands.autoMotions.CLeftSwitchCollectThirdCube;
import org.usfirst.frc.team1251.robot.commands.autoMotions.CLeftSwitchInitialApproach;
import org.usfirst.frc.team1251.robot.commands.autoMotions.CLeftSwitchSecondApproach;
import org.usfirst.frc.team1251.robot.subsystems.*;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;
import org.usfirst.frc.team1251.robot.virtualSensors.ElevatorPosition;

public class CSwitchLeftFancy extends CommandGroup{

    @Override
    protected void initialize() {
        System.out.println("This is " + this.getClass().getName());
    }

    public CSwitchLeftFancy(DriveFeedback driveFeedback, DriveTrainShifter driveShifter, DriveTrain driveTrain,
                            Arm arm, ArmPosition armPosition,
                            Elevator elevator, ElevatorPosition elevatorPosition,
                            Claw claw, Collector collector) {

        // Make our initial approach
        addSequential(new CLeftSwitchInitialApproach(driveFeedback, driveTrain, arm, armPosition, elevator));

        // Drop the cube
        addSequential(new DropCube(claw, collector));

        // Get the 2nd cube.
        addSequential(new CLeftSwitchCollectSecondCube(driveFeedback, driveTrain, arm, armPosition, elevator, elevatorPosition, claw, collector));

        // Make 2nd approach
        addSequential(new CLeftSwitchSecondApproach(driveFeedback, driveTrain, arm, armPosition, elevator));

        //addSequential(new DropCube(claw, collector));

        //addSequential(new CLeftSwitchCollectThirdCube(driveFeedback, driveTrain, arm, armPosition, elevator, elevatorPosition));

    }

}
