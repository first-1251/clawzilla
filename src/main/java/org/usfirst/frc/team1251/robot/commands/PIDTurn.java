package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;

public class PIDTurn extends PIDCommand {

    private static final double P = 0.01;
    private static final double I = 0.000015;
    private static final double D = 0.0;

    private final double timeAllowance;
    private final Timer timeAllowanceTimer = new Timer();

    private final static double TIMED_OUT_THRESHOLD = 3;
    private final static double TIME_ALLOWANCE = 2;

    enum Direction {
        CLOCKWISE, COUNTER_CLOCKWISE
    }

    private static final double PERIOD = 0.01;

    private DriveTrain driveTrain;
    private DriveFeedback driveFeedback;
    private double desiredAngle;
    private Direction direction;


    public PIDTurn(DriveTrain driveTrain, DriveFeedback driveFeedback, double desiredAngle) {
        super(P, I, D, PERIOD);

        this.timeAllowance = TIME_ALLOWANCE;
        this.desiredAngle = desiredAngle;
        this.driveTrain = driveTrain;
        this.driveFeedback = driveFeedback;
        this.setInputRange(0.0, 360.0);
        this.getPIDController().setAbsoluteTolerance(1.0);
        this.getPIDController().setContinuous();
    }


    @Override
    protected void initialize() {
        this.timeAllowanceTimer.stop();
        this.timeAllowanceTimer.reset();
        if (this.timeAllowance > 0) {
            this.timeAllowanceTimer.start();
        }

        double distanceToTarget = distanceToTarget();
        this.getPIDController().setSetpoint(desiredAngle);

        if (distanceToTarget < 0) {
            direction = Direction.COUNTER_CLOCKWISE;
        } else {
            direction = Direction.CLOCKWISE;
        }
    }

    @Override
    protected double returnPIDInput() {
        driveFeedback.updateSensorData();
        return driveFeedback.getHeading();
    }

    @Override
    protected void usePIDOutput(double output) {

        if (direction == Direction.COUNTER_CLOCKWISE) {
            driveTrain.setSpeed(-output, output);
        } else {
            driveTrain.setSpeed(output, -output);
        }
    }

    private double distanceToTarget() {
        driveFeedback.updateSensorData();
        double heading = driveFeedback.getHeading();
        if (heading < desiredAngle) {
            heading += 360;
        }

        double left = heading - desiredAngle;

        if (left < 180)
            return -left;
        else {
            return 360 - left;
        }
    }

    @Override
    protected boolean isFinished() {

        if (timeAllowance > 0 && timeAllowanceTimer.get() >= timeAllowance) {
            // Times up! See how we did.
            if (Math.abs(this.desiredAngle - this.distanceToTarget()) <= TIMED_OUT_THRESHOLD) {
                // Close enough! Short circuit the command.
                return true;
            }
        }

        return getPIDController().onTarget();
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        super.initSendable(builder);
    }

    @Override
    protected void end() {
        super.end();
        this.timeAllowanceTimer.stop();
        this.timeAllowanceTimer.reset();
        this.driveTrain.setSpeed(0, 0);
    }
}
