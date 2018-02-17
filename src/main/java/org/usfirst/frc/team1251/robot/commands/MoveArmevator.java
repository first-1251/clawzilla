package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.MoveElevator;
import org.usfirst.frc.team1251.robot.MoveArm;
import org.usfirst.frc.team1251.robot.Robot;
import org.usfirst.frc.team1251.robot.subsystems.Armevator;

public class MoveArmevator extends Command {
    private MoveArm moveArm;
    private MoveElevator moveElevator;
    private final Armevator armevator;

    public MoveArmevator() {
        this.armevator = Robot.ARMEVATOR;
        this.moveArm = new MoveArm(this.armevator);
        this.moveElevator = new MoveElevator(this.armevator);
        requires(this.armevator);
    }

    public MoveArm getMoveArm() {
        return moveArm;
    }

    public MoveElevator getMoveElevator() {
        return moveElevator;
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
