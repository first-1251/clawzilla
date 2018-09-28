package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;

public class Turn extends Command {

    private final DriveTrain driveTrain;
    private final Direction direction;
    private final double rotationSpeed;

    public enum Direction { RIGHT, LEFT }

    public Turn(DriveTrain driveTrain, Direction direction, double rotationSpeed) {

        this.driveTrain = driveTrain;
        this.direction = direction;
        this.rotationSpeed = rotationSpeed;

        requires(driveTrain);
    }

    @Override
    protected void initialize() {
        driveTrain.setSpeed(0, 0);
    }

    @Override
    protected void execute() {
        if (direction == Direction.RIGHT) {
            driveTrain.setSpeed(rotationSpeed, -rotationSpeed);
        } else {
            driveTrain.setSpeed(-rotationSpeed, rotationSpeed);
        }
    }

    @Override
    protected void end() {
        driveTrain.setSpeed(0, 0);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
