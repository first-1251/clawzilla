package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.Arm;
import org.usfirst.frc.team1251.robot.subsystems.Elevator;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;
import org.usfirst.frc.team1251.robot.virtualSensors.ElevatorPosition;

public class PositionToScale extends Command {

    private Elevator elevator;
    private ElevatorPosition elevatorPosition;
    private Arm arm;
    private ArmPosition armPosition;

    public PositionToScale(Elevator elevator, Arm arm){
        this.elevator = elevator;
        this.arm = arm;
        requires(elevator);
        requires(arm);
    }

    protected void execute(){
        if(timeSinceInitialized() < 1){
            this.arm.pivotUp(0);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
