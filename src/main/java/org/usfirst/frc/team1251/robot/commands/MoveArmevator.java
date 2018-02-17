package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.MoveElevator;
import org.usfirst.frc.team1251.robot.MoveArm;

public class MoveArmevator extends Command {
    private MoveArm moveArm = new MoveArm();
    private MoveElevator moveElevator = new MoveElevator();

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
