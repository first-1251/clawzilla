package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.PIDCommand;
import org.usfirst.frc.team1251.robot.subsystems.Elevator;
import org.usfirst.frc.team1251.robot.virtualSensors.ElevatorPosition;

public class PositionElevator extends PIDCommand {

    private static final double K_P = 0;
    private static final double K_I = 0;
    private static final double K_D = 0;
    private static final double K_F = 0;

    private static final double PERIOD = 0.01;

    private Elevator elevator;
    private ElevatorPosition elevatorPosition;

    public PositionElevator(Elevator elevator, ElevatorPosition elevatorPosition) {
        super(K_P, K_I, K_D, PERIOD);

        this.elevator = elevator;
        this.elevatorPosition = elevatorPosition;

        requires(elevator);

    }

    @Override
    protected void initialize() {
        this.getPIDController().setPercentTolerance(5);
        this.getPIDController().setF(K_F);
    }

    @Override
    protected double returnPIDInput() {
        return elevatorPosition.getHeight();
    }

    @Override
    protected void usePIDOutput(double output) {
        elevator.move(output);
    }

    @Override
    protected boolean isFinished() {
        // get interrupted by the driver, instead of letting the elevator fall once it reaches the desired height.
        return false;
    }
}
