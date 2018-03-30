package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1251.robot.subsystems.Arm;
import org.usfirst.frc.team1251.robot.subsystems.Elevator;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;

public class ArmevatorFromStartingToSwitch extends CommandGroup {

    public ArmevatorFromStartingToSwitch(Elevator elevator, Arm arm, ArmPosition armPosition) {
        addSequential(new TimedElevatorUpAndHold(elevator, 2));
        addSequential(new ArmDownTo90AndHold(arm, armPosition));
    }
}
