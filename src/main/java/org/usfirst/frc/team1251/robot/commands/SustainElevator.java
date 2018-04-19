package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.Elevator;

public class SustainElevator extends Command {

    private final double SUSTAIN = 0.13;
    private Elevator elevator;

    public SustainElevator(Elevator elevator) {
        this.elevator = elevator;
        requires(elevator);
    }

    @Override
    protected void execute() {
        elevator.goUp(SUSTAIN);
    }

    @Override
    protected void end() {
        elevator.stop();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
