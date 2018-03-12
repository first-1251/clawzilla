package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1251.robot.teleopInput.driverInput.HumanInput;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;

public class TeleopDrive extends Command {

    private final DriveFeedback driveFeedback;

    private HumanInput humanInput;

    private DriveTrain driveTrain;


    public TeleopDrive(HumanInput humanInput, DriveTrain driveTrain, DriveFeedback driveFeedback) {
        this.humanInput = humanInput;
        this.driveTrain = driveTrain;
        this.driveFeedback = driveFeedback;

        requires(this.driveTrain);
    }

    @Override
    protected void initialize() { }

    @Override
    protected void execute() {

        // Update sensor data, just to force data to the driver station shuffleboard
        driveFeedback.updateSensorData();

        // Cube the human input to make movement at the extremes more dramatic.
        double leftCubed = humanInput.getLeftWheelSpeed();
        double rightCubed = humanInput.getRightWheelSpeed();
        leftCubed *= leftCubed * leftCubed;
        rightCubed *= rightCubed * rightCubed;

        // setSpeed motors
        driveTrain.setSpeed(leftCubed, rightCubed);
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
