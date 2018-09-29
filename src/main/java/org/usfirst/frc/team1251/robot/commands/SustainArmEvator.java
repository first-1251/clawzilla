package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.Arm;
import org.usfirst.frc.team1251.robot.subsystems.Elevator;

public class SustainArmEvator extends Command {

    private final double SUSTAIN_ARM = 0.20;
    private final double SUSTAIN_ELEVATOR = 0.13;
    private Arm arm;
    private final Elevator elevator;

    public SustainArmEvator(Arm arm, Elevator elevator) {
        this.arm = arm;
        this.elevator = elevator;
        requires(this.arm);
        requires(this.elevator);
    }

    @Override
    protected void execute() {
        elevator.goUp(SUSTAIN_ELEVATOR);
        arm.pivotUp(SUSTAIN_ARM);
    }

    @Override
    protected void end() {
        elevator.stop();
        arm.stopPivot();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
