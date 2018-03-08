package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.DoubleSolenoidGearShifter;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrainShifter;

public class ShiftDriveTrain extends Command {
    private final DriveTrainShifter shifter;
    private final DoubleSolenoidGearShifter.Gear goal;

    public ShiftDriveTrain(DriveTrainShifter shifter, DriveTrainShifter.Gear goal) {
        this.shifter = shifter;
        this.goal = goal;
        this.setInterruptible(false);
    }

    @Override
    protected void execute() {
        shifter.setGear(goal);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
