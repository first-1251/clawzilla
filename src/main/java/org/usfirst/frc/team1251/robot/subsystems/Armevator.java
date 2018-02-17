package org.usfirst.frc.team1251.robot.subsystems;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1251.robot.mechanisms.Arm;
import org.usfirst.frc.team1251.robot.mechanisms.Elevator;
import org.usfirst.frc.team1251.robot.commands.DeferredCmdSupplier;
import org.usfirst.frc.team1251.robot.Arm;
import org.usfirst.frc.team1251.robot.Elevator;

public class Armevator extends Subsystem{

    // Properties for establishing Elevator and Arm :)
    private Elevator elevator;
    private Arm arm;
    private DeferredCmdSupplier<Command> defaultCommand;

    public Armevator(Elevator elevator, Arm arm, DeferredCmdSupplier<Command> defaultCommand) {
        this.elevator = elevator;
        this.arm = arm;
        this.defaultCommand = defaultCommand;
    }

    public Elevator getElevator() {
        return elevator;
    }

    public Arm getArm() {
        return arm;
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(this.defaultCommand.get());
    }


}
