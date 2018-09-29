package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.DoubleSolenoidGearShifter;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrainShifter;

public class Turn extends Command {

    private final DriveTrain driveTrain;
    private final Direction direction;
    private final DriveTrainShifter readOnlyShifter;

    private final static double LOW_GEAR_ROTATION_SPEED = 0.20;
    private final static double HIGH_GEAR_ROTATION_SPEED = 0.25;

    public enum Direction { RIGHT, LEFT }

    public Turn(DriveTrain driveTrain, Direction direction, DriveTrainShifter readOnlyShifter) {

        this.driveTrain = driveTrain;
        this.direction = direction;
        this.readOnlyShifter = readOnlyShifter;

        // Deliberately do not require the shifter -- we are only inspecting it, not manipulating it!
        requires(driveTrain);
    }

    @Override
    protected void initialize() {
        driveTrain.setSpeed(0, 0);
    }

    @Override
    protected void execute() {
        double rotationSpeed = readOnlyShifter.getGear() == DoubleSolenoidGearShifter.Gear.HIGH ?
                HIGH_GEAR_ROTATION_SPEED : LOW_GEAR_ROTATION_SPEED;

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
