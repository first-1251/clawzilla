package org.usfirst.frc.team1251.robot.commands.AutoPathPermutations;

import edu.wpi.first.wpilibj.command.CommandGroup;
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

        // TODO: Implement!
    }

}
