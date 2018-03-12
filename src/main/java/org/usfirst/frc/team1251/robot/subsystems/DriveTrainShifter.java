package org.usfirst.frc.team1251.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.RobotMap;
import org.usfirst.frc.team1251.robot.commands.DeferredCmdSupplier;

public class DriveTrainShifter extends DoubleSolenoidGearShifter {

    public DriveTrainShifter(DeferredCmdSupplier<Command> defaultCommand) {
        super(defaultCommand);
        this.isInverted = false;
        this.solenoid = new DoubleSolenoid(RobotMap.DRIVE_SHIFTER_FORWARD, RobotMap.DRIVE_SHIFTER_REVERSE);
    }


}
