package org.usfirst.frc.team1251.robot.commands.autoMotions;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1251.robot.subsystems.Arm;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1251.robot.subsystems.Elevator;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;

public class CLeftSwitchCollectThirdCube extends CommandGroup {


    public CLeftSwitchCollectThirdCube(DriveFeedback driveFeedback, DriveTrain driveTrain,
                                       Arm arm, ArmPosition armPosition,
                                       Elevator elevator) {

        // After .5 second delay, start moving elevator into position for 2nd layer collection. Leave arm extended!
        // TODO: Implement as parallel

        // Move away from switch
        // TODO: sequential

        // Move up to the cube
        // TODO: sequential

        // Collect Cube - Trust that the armevator has had time to get into position!
        // TODO: Implement as sequential

    }
}
