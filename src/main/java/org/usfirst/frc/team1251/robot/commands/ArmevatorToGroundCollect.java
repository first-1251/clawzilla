package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1251.robot.commands.util.TimedNothing;
import org.usfirst.frc.team1251.robot.subsystems.Arm;
import org.usfirst.frc.team1251.robot.subsystems.Elevator;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;
import org.usfirst.frc.team1251.robot.virtualSensors.ElevatorPosition;

public class ArmevatorToGroundCollect extends CommandGroup {
    public ArmevatorToGroundCollect(double delay, Elevator elevator, ElevatorPosition elevatorPosition, Arm arm, ArmPosition armPosition) {
        addSequential(new TimedNothing(delay));
        addSequential(new ElevatorToBottom(elevator, elevatorPosition));
        addSequential(new AutoArmDownToMinimum(arm, armPosition));
        addSequential(new SlowArmDecent(arm));
    }
}
