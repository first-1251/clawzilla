package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.Elevator;
import org.usfirst.frc.team1251.robot.virtualSensors.ElevatorPosition;

public class ElevatorToBottom extends Command {

    private final static double SPEED = .5;

    private final Elevator elevator;
    private final ElevatorPosition elevatorPosition;

    public ElevatorToBottom(Elevator elevator, ElevatorPosition elevatorPosition) {
        this.elevator = elevator;
        this.elevatorPosition = elevatorPosition;
    }

    @Override
    protected void execute() {
        elevator.goDown(SPEED);
    }

    @Override
    protected void end() {
        elevator.stop();
    }

    @Override
    protected boolean isFinished() {
        return elevatorPosition.isAtMinHeight();
    }
}
