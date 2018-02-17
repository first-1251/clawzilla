package org.usfirst.frc.team1251.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1251.robot.Arm;
import org.usfirst.frc.team1251.robot.Elevator;

public class Armevator extends Subsystem{

    // Properties for establishing Elevator and Arm :)
    private Elevator elevator = new Elevator();
    private Arm arm = new Arm();

    public Elevator getElevator() {
        return elevator;
    }

    public Arm getArm() {
        return arm;
    }

    @Override
    protected void initDefaultCommand() {

    }


}
