package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.DoubleSolenoidGearShifter;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrainShifter;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;

public class DriveTrainAutoShift extends Command {

    private final DriveFeedback driveFeedback;
    private final DriveTrainShifter shifter;

    private static final double SHIFTING_TIME = 2.0; // seconds
    private static final double SHIFTING_SPEED = 150.0 * 4 * 1; // encoder ticks / second

    private boolean timerStarted;
    private double time = 0.0;

    public DriveTrainAutoShift(DriveFeedback driveFeedback, DriveTrainShifter shifter) {
        this.shifter = shifter;
        this.driveFeedback = driveFeedback;
    }

    @Override
    protected void execute() {

        driveFeedback.updateSensorData();
        double averageSpeed = (driveFeedback.getLeftVelocity() + driveFeedback.getRightVelocity()) / 2.0;
        averageSpeed = Math.abs(averageSpeed);

        if (shifter.getGear() == DoubleSolenoidGearShifter.Gear.LOW) {
            considerHighGear(averageSpeed);
        } else {
            considerLowGear(averageSpeed);
        }

    }

    private void considerHighGear(double averageSpeed) {
        if (averageSpeed > SHIFTING_SPEED) {
            timerCountdown(DoubleSolenoidGearShifter.Gear.HIGH);
        } else {
            if (timerStarted) {
                timerStarted = false;
            }
        }
    }

    private void considerLowGear(double averageSpeed) {
        if (averageSpeed < SHIFTING_SPEED) {
            timerCountdown(DoubleSolenoidGearShifter.Gear.LOW);
        } else {
            if (timerStarted) {
                timerStarted = false;
            }
        }
    }

    private void timerCountdown(DoubleSolenoidGearShifter.Gear gear) {
        if (!timerStarted) {
            timerStarted = true;
            time = Timer.getFPGATimestamp();
        } else {
            if (time + SHIFTING_TIME > Timer.getFPGATimestamp()) {
                shifter.setGear(gear);
                timerStarted = false;
            }
        }
    }


    @Override
    protected void initialize() { }


    @Override
    protected void end() {
        super.end();
    }

    @Override
    protected void interrupted() {
        this.end();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}
