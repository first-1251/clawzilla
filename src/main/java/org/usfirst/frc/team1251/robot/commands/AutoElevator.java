package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.Elevator;
import org.usfirst.frc.team1251.robot.subsystems.ElevatorShifter;
import org.usfirst.frc.team1251.robot.virtualSensors.ElevatorPosition;

public class AutoElevator extends Command {

    private Elevator elevator;
    private ElevatorPosition elevatorPosition;

    // Desired height in inches
    private int height;

    private int tolerance = 1;

    private double speed = 0.8;
    private double sustainSpeed = 0.10;
    private boolean isAtPosition;

    public AutoElevator(Elevator elevator, ElevatorPosition elevatorPosition, int height) {
        this.elevator = elevator;
        this.elevatorPosition = elevatorPosition;
        this.height = height;

        requires(elevator);
    }

    protected void initialize(){
        isAtPosition = false;
    }

    protected void execute(){
        if(elevatorPosition.getHeight() < height - 1){
            elevator.goUp(speed);
        } else if (elevatorPosition.getHeight() > height + 1) {
            elevator.goDown(speed);
        } else {
            elevator.goUp(sustainSpeed);
        }
    }

    @Override
    protected boolean isFinished() {
        return isAtPosition;
    }
}
