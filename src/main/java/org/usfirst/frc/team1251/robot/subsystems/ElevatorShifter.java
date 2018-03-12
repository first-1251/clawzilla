package org.usfirst.frc.team1251.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.RobotMap;
import org.usfirst.frc.team1251.robot.commands.DeferredCmdSupplier;

public class ElevatorShifter extends DoubleSolenoidGearShifter {

    ElevatorShifter(DeferredCmdSupplier<Command> defaultCommand) {
        super(defaultCommand);
        this.isInverted = false;
        this.solenoid = new DoubleSolenoid(RobotMap.ELEVATOR_SHIFTER_FORWARD, RobotMap.ELEVATOR_SHIFTER_REVERSE);
    }

}
