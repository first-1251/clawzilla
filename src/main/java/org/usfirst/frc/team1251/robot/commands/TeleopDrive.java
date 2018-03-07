package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1251.robot.teleopInput.gamepad.GamePad;

public class TeleopDrive extends Command {

    private static final int JOYSTICK_SMOOTHING_SAMPLES = 4;

    private static final double SHIFTING_TIME = 2.0; // seconds
    private static final double SHIFTING_SPEED = 150.0 * 4 * 1; // encoder ticks / second


    private int leftHigh;
    private int rightHigh;
    private boolean timerStarted = false;
    private double time = 0.0;

    private GamePad driveStick;

    private DriveTrain driveTrain;

    private double[] leftSmoothing;
    private double[] rightSmoothing;
    PowerDistributionPanel pdp;

    public TeleopDrive(GamePad gamePad, DriveTrain driveTrain) {
        this.driveStick = gamePad;
        this.driveTrain = driveTrain;

        requires(this.driveTrain);

        leftSmoothing = new double[JOYSTICK_SMOOTHING_SAMPLES];
        rightSmoothing = new double[JOYSTICK_SMOOTHING_SAMPLES];
    }

    @Override
    protected void initialize() {
        // enable percentage output
        driveTrain.enableRegularMode();
        driveTrain.setGearShifter(DriveTrain.HIGH_GEAR);
    }

    @Override
    protected void execute() {

        driveTrain.updateSensorData();

        if (driveTrain.getLeftVelocity() > leftHigh) {
            leftHigh = driveTrain.getLeftVelocity();
        }

        if (driveTrain.getRightVelocity() > rightHigh) {
            rightHigh = driveTrain.getRightVelocity();
        }
        //if (driveStick.a().isPressed()) {
            //driveTrain.setGearShifter(DriveTrain.LOW_GEAR);
        //}

        //if (driveStick.b().isPressed()) {
            //driveTrain.setGearShifter(DriveTrain.HIGH_GEAR);
        //}
        // smooth inputs
        double leftSmoothed = calculateLeftSmoothed(driveStick.ls().getVertical());
        double rightSmoothed = calculateRightSmoothed(driveStick.rs().getVertical());

        // cube smoothed inputs
        leftSmoothed *= leftSmoothed * leftSmoothed;
        rightSmoothed *= rightSmoothed * rightSmoothed;

        if (driveStick.b().isPressed()) {
            leftSmoothed = 1.0;
        }

        if (driveStick.a().isPressed()) {
            rightSmoothed = 1.0;
        }

        // set motors
        driveTrain.set(leftSmoothed, rightSmoothed);

        // do shifting stuff
        //driveShifting();

        //System.out.println(pdp.getCurrent(0) + "|" + pdp.getCurrent(1) + "|"
               // + pdp.getCurrent(2) + "|" + pdp.getCurrent(3) + "|" + pdp.getCurrent(15) + "|"
               // + pdp.getCurrent(14) + "|" + pdp.getCurrent(13) + "|" + pdp.getCurrent(12) + "|"
               // + pdp.getTotalCurrent() + "|" + pdp.getCurrent(0) + pdp.getCurrent(1)
               // + pdp.getCurrent(2) + pdp.getCurrent(3)
               // + pdp.getCurrent(15) + pdp.getCurrent(14)
               // + pdp.getCurrent(13) + pdp.getCurrent(12));

        //System.out.println(driveTrain.getLeftVelocity() + "|" + driveTrain.getRightVelocity());
        //System.out.println();

        System.out.println(leftHigh);
        System.out.println(rightHigh);
    }

    /**
     * @param left the joystick left value
     * @return the speed the left drivetrain should go, smoothed over JOYSTICK_SMOOTHING_SAMPLES
     */
    private double calculateLeftSmoothed(double left) {
        double sum = 0.0;
        for (int i = 0; i < JOYSTICK_SMOOTHING_SAMPLES; i++) {
            if (i < JOYSTICK_SMOOTHING_SAMPLES - 1) {
                leftSmoothing[i] = leftSmoothing[i + 1];
                sum += leftSmoothing[i];
            } else {
                leftSmoothing[i] = left;
                sum += left;
            }
        }

        return sum / JOYSTICK_SMOOTHING_SAMPLES;
    }

    private double calculateRightSmoothed(double right) {
        double sum = 0.0;
        for (int i = 0; i < JOYSTICK_SMOOTHING_SAMPLES; i++) {
            if (i < JOYSTICK_SMOOTHING_SAMPLES - 1) {
                rightSmoothing[i] = rightSmoothing[i + 1];
                sum += rightSmoothing[i];
            } else {
                rightSmoothing[i] = right;
                sum += right;
            }
        }

        return sum / JOYSTICK_SMOOTHING_SAMPLES;
    }

    private void driveShifting() {
        driveTrain.updateSensorData();
        double averageSpeed = (driveTrain.getLeftVelocity() + driveTrain.getRightVelocity()) / 2.0;
        averageSpeed = Math.abs(averageSpeed);
        if (driveTrain.getShiftState() == DriveTrain.LOW_GEAR) {
            considerLowGear(averageSpeed);
        } else {
            considerHighGear(averageSpeed);
        }
    }

    private void considerLowGear(double averageSpeed) {
        if (averageSpeed > SHIFTING_SPEED) {
            timerCountdown(DriveTrain.HIGH_GEAR);
        } else {
            if (timerStarted) {
                timerStarted = false;
            }
        }
    }

    private void considerHighGear(double averageSpeed) {
        if (averageSpeed < SHIFTING_SPEED) {
            timerCountdown(DriveTrain.LOW_GEAR);
        } else {
            if (timerStarted) {
                timerStarted = false;
            }
        }
    }

    private void timerCountdown(DoubleSolenoid.Value gear) {
        if (!timerStarted) {
            timerStarted = true;
            time = Timer.getFPGATimestamp();
        } else {
            if (time + SHIFTING_TIME > Timer.getFPGATimestamp()) {
                driveTrain.setGearShifter(gear);
                timerStarted = false;
            }
        }
    }

    @Override
    protected void end() {
        super.end();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }


}
