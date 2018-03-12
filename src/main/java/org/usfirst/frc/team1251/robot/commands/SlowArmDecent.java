package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import org.usfirst.frc.team1251.robot.subsystems.Armevator;

public class SlowArmDecent extends TimedCommand {
    private final Armevator armevator;
    private static final double DURATION = .5;
    private static final double SPEED = .1;


    public SlowArmDecent(Armevator armevator) {
        super(DURATION);
        this.armevator = armevator;
        requires(armevator);
    }

    @Override
    protected void execute() {
        this.armevator.getArm().pivotUp(SPEED);
    }

    @Override
    protected void end() {
        this.armevator.getArm().stopPivot();
    }
}
