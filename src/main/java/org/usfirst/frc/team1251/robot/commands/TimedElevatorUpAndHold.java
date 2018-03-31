package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import org.usfirst.frc.team1251.robot.subsystems.Elevator;

public class TimedElevatorUpAndHold extends TimedCommand {

    private Elevator elevator;
    private final double speed;

    private static double SUSTAIN_SPEED = .15;

    public TimedElevatorUpAndHold(Elevator elevator, double duration, double speed) {
        super(duration);
        this.elevator = elevator;
        this.speed = speed;

        requires(elevator);
    }


    protected void execute(){
        elevator.goUp(speed);
    }

    @Override
    protected void end() {
        elevator.goUp(SUSTAIN_SPEED);
    }
}
