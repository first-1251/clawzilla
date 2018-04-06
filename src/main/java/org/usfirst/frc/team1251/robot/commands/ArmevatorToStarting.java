package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1251.robot.subsystems.Arm;
import org.usfirst.frc.team1251.robot.subsystems.Elevator;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;
import org.usfirst.frc.team1251.robot.virtualSensors.ElevatorPosition;

public class ArmevatorToStarting extends CommandGroup {
    public ArmevatorToStarting(Elevator elevator, ElevatorPosition elevatorPosition, Arm arm, ArmPosition armPosition) {
        addSequential(new ArmToTop(arm, armPosition), 1.0);
        addSequential(new ElevatorToBottom(elevator, elevatorPosition), 0.5);
    }
}
