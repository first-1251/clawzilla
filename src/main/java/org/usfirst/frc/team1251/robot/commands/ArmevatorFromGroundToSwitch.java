package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1251.robot.subsystems.Arm;
import org.usfirst.frc.team1251.robot.subsystems.Elevator;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;

public class ArmevatorFromGroundToSwitch extends CommandGroup {

    public ArmevatorFromGroundToSwitch(Elevator elevator, Arm arm, ArmPosition armPosition) {
        addParallel(new TimedElevatorUpAndHold(elevator, .3, .85));
        addParallel(new ArmUpTo90AndHold(arm, armPosition));
    }
}
