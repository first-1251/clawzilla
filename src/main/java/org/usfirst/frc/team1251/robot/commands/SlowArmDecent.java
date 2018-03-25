package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import org.usfirst.frc.team1251.robot.subsystems.Arm;

public class SlowArmDecent extends TimedCommand {
    private final Arm arm;
    private static final double DURATION = .5;
    private static final double SPEED = .1;


    public SlowArmDecent(Arm arm) {
        super(DURATION);
        this.arm = arm;
        requires(arm);
    }

    @Override
    protected void execute() {
        this.arm.pivotUp(SPEED);
    }

    @Override
    protected void end() {
        this.arm.stopPivot();
    }
}
