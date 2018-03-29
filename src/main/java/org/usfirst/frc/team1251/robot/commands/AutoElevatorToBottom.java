package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.Elevator;
import org.usfirst.frc.team1251.robot.virtualSensors.ElevatorPosition;

public class AutoElevatorToBottom extends Command{

    private Elevator elevator;
    private ElevatorPosition elevatorPosition;

    private double speed = 0.5;

    public AutoElevatorToBottom(Elevator elevator, ElevatorPosition elevatorPosition){
        this.elevator = elevator;
        this.elevatorPosition = elevatorPosition;

        requires(elevator);
    }

    @Override
    protected void execute(){
        if(elevatorPosition.isAtMinHeight()){
            elevator.goDown(speed);
        } else {
            elevator.stop();
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
