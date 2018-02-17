package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import org.usfirst.frc.team1251.robot.Robot;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;

public class AutoTest extends TimedCommand{

    private DriveTrain driveTrain;

    public AutoTest() {
        super(5);
        requires(Robot.DRIVE_TRAIN);
        this.driveTrain = Robot.DRIVE_TRAIN;
    }

    @Override
    protected void initialize() {
        driveTrain.enablePIDMode();
    }

    @Override
    protected void execute() {
        //100 wheel rotations
        driveTrain.set(100 * DriveTrain.WHEEL_TO_ENCODER);
    }

    @Override
    protected void end() {
        driveTrain.enableRegularMode();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
