package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.DoubleSolenoidGearShifter;
import org.usfirst.frc.team1251.robot.subsystems.ElevatorShifter;

public class ShiftElevator extends Command {
    private final ElevatorShifter shifter;
    private final DoubleSolenoidGearShifter.Gear goal;

    public ShiftElevator(ElevatorShifter shifter, ElevatorShifter.Gear goal) {
        this.shifter = shifter;
        this.goal = goal;
        this.setInterruptible(false);
        requires(this.shifter);
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
