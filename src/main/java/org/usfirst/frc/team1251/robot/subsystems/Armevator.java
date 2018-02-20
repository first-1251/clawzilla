package org.usfirst.frc.team1251.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1251.robot.Arm;
import org.usfirst.frc.team1251.robot.Elevator;
import org.usfirst.frc.team1251.robot.commands.MoveArm;

public class Armevator extends Subsystem{

    // Properties for establishing Elevator and Arm :)
    private Elevator elevator;
    private Arm arm;
    private MoveArm defaultCommand;

    public Armevator(Elevator elevator, Arm arm, MoveArm defaultCommand) {
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
        setDefaultCommand(this.defaultCommand);
    }


}
