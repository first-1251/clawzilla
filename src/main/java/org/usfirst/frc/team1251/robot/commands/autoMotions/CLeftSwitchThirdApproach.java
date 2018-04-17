package org.usfirst.frc.team1251.robot.commands.autoMotions;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1251.robot.subsystems.Arm;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1251.robot.subsystems.Elevator;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;

public class CLeftSwitchThirdApproach extends CommandGroup {


    public CLeftSwitchThirdApproach(DriveFeedback driveFeedback, DriveTrain driveTrain,
                                    Arm arm, ArmPosition armPosition,
                                    Elevator elevator) {

        // Back up and adjust angle for approach;
        // TODO: sequential

        // Position elevator for delivery -- leave arm alone!
        // TODO: Parallel

        // Make approach
        // TODO: Sequential
    }
}
