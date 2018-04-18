package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1251.robot.subsystems.Arm;
import org.usfirst.frc.team1251.robot.subsystems.Elevator;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;
import org.usfirst.frc.team1251.robot.virtualSensors.ElevatorPosition;

public class ArmevatorToGroundCollect extends CommandGroup {
    public ArmevatorToGroundCollect(Elevator elevator, ElevatorPosition elevatorPosition, Arm arm, ArmPosition armPosition) {
        addParallel(new ElevatorToBottom(elevator, elevatorPosition));
        addParallel(new AutoArmDownToMinimum(arm, armPosition));
    }
}
