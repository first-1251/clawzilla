package org.usfirst.frc.team1251.robot.commands.AutoPathPermutations;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1251.robot.commands.DropCube;
import org.usfirst.frc.team1251.robot.commands.autoMotions.CRightSwitchCollectSecondCube;
import org.usfirst.frc.team1251.robot.commands.autoMotions.CRightSwitchCollectThirdCube;
import org.usfirst.frc.team1251.robot.commands.autoMotions.CRightSwitchInitialApproach;
import org.usfirst.frc.team1251.robot.commands.autoMotions.CRightSwitchSecondApproach;
import org.usfirst.frc.team1251.robot.subsystems.*;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;
import org.usfirst.frc.team1251.robot.virtualSensors.ElevatorPosition;

public class CSwitchRightFancy extends CommandGroup {

    @Override
    protected void initialize() {
        System.out.println("This is " + this.getClass().getName());
    }


    public CSwitchRightFancy(DriveFeedback driveFeedback, DriveTrainShifter driveShifter, DriveTrain driveTrain,
                             Arm arm, ArmPosition armPosition,
                             Elevator elevator, ElevatorPosition elevatorPosition,
                             Claw claw, Collector collector) {

        // Make our initial approach
        addSequential(new CRightSwitchInitialApproach(driveFeedback, driveTrain, arm, armPosition, elevator));

        // Drop the cube
        addSequential(new DropCube(claw, collector));

        // Get the 2nd cube.
        addSequential(new CRightSwitchCollectSecondCube(driveFeedback, driveTrain, arm, armPosition, elevator, elevatorPosition, claw, collector));

        // Make 2nd approach
        addSequential(new CRightSwitchSecondApproach(driveFeedback, driveTrain, arm, armPosition, elevator));

        addSequential(new DropCube(claw, collector));

        addSequential(new CRightSwitchCollectThirdCube(driveFeedback, driveTrain, arm, armPosition, elevator));
    }

}
