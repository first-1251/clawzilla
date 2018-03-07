package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;

public class AutoForwards extends Command {

    private DriveTrain driveTrain;

    private final double GEAR_RATIO = 3.21428571428;
    private final double ALLOWABLE_ERROR = 250.0; // in encoder ticks, 1/10 of an encoder turn, 1/30 of a wheel turn
    private final double WHEEL_DIAMETER = 4.25;
    private final double INCHES_TO_WHEEL_TURNS = 1.0 / (WHEEL_DIAMETER * Math.PI);
    private final double WHEELS_TURNS_TO_ENCODER_TICKS = 500 * GEAR_RATIO;  // 1 wheel
    private final double RIGHT_IS_SPECIAL = 900; // ticks per rev on right practice

static int counter = 0;

    private double totalDistance;

    private double leftDistance;
    private double rightDistance;
    public AutoForwards(DriveTrain driveTrain, double inches) {
        this.driveTrain = driveTrain;
        requires(driveTrain);

        totalDistance = inches * INCHES_TO_WHEEL_TURNS;// * WHEELS_TURNS_TO_ENCODER_TICKS;
        //System.out.println(totalDistance);
    }

    @Override
    protected void initialize() {
        driveTrain.updateSensorData();
        leftDistance = totalDistance * WHEELS_TURNS_TO_ENCODER_TICKS + driveTrain.getLeftDistance();
        rightDistance = totalDistance * RIGHT_IS_SPECIAL + driveTrain.getRightDistance();
        driveTrain.enablePIDMode();
        driveTrain.setGearShifter(DriveTrain.HIGH_GEAR);
        driveTrain.set(leftDistance, rightDistance);
        System.out.println("hello");
    }

    @Override
    protected void execute() {

        driveTrain.updateSensorData();
        System.out.println("LE: " + driveTrain.getLeftDistance());
        System.out.println("RI: " + driveTrain.getRightDistance());
    }

    @Override
    protected boolean isFinished() {
        System.out.println(driveTrain.isPidComplete(ALLOWABLE_ERROR));
        return driveTrain.isPidComplete(ALLOWABLE_ERROR);
    }
}
