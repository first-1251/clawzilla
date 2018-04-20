package org.usfirst.frc.team1251.robot.commands.AutoPathPermutations;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1251.robot.commands.DropCube;
import org.usfirst.frc.team1251.robot.commands.autoMotions.RSwitchHomeInitialApproach;
import org.usfirst.frc.team1251.robot.subsystems.*;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;
import org.usfirst.frc.team1251.robot.virtualSensors.ElevatorPosition;

public class RSwitchHomeScaleHomeFancy extends CommandGroup {


    public RSwitchHomeScaleHomeFancy(Elevator elevator, ElevatorPosition elevatorPosition, Arm arm, ArmPosition armPosition, Claw claw, Collector collector, DriveFeedback driveFeedback, DriveTrain driveTrain, DriveTrainShifter driveTrainShifter){

        addSequential(new RSwitchHomeInitialApproach(driveFeedback, driveTrain, arm, armPosition, elevator));
        // Drop the cube
        addSequential(new DropCube(claw, collector));

    }

}
