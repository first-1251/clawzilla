package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import org.usfirst.frc.team1251.robot.subsystems.Elevator;

public class TimedElevatorUpAndHold extends TimedCommand {

    private Elevator elevator;

    private static double SPEED = .50;
    private static double SUSTAIN_SPEED = .1;

    public TimedElevatorUpAndHold(Elevator elevator, double timeout) {
        super(timeout);
        this.elevator = elevator;

        requires(elevator);
    }


    protected void execute(){
        elevator.goUp(SPEED);
    }

    @Override
    protected void end() {
        elevator.goUp(SUSTAIN_SPEED);
    }
}
