package org.usfirst.frc.team1251.robot.virtualSensors;

import com.ctre.phoenix.motorcontrol.IMotorController;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1251.robot.MotorFactory;

public class DriveFeedback {

    public static final double WHEEL_DIAMETER = 4.25;
    public static final double GEAR_RATIO = 3.21428571428;

    public static final double TICKS_PER_TURN = 500 * GEAR_RATIO; // total apples
    private final double WHEEL_CIRCUMFERENCE = (WHEEL_DIAMETER * Math.PI); // Inches per turn | # of buckets
    private final double TICKS_PER_INCH = TICKS_PER_TURN / WHEEL_CIRCUMFERENCE;
    private final double TICKS_PER_FOOT = TICKS_PER_INCH * 12;


    /**
     * The main motor controller for the left side of the drive train.
     *
     * IMPORTANT: This is a sensor class -- it should ONLY be reading sensor data from this motor controller; it
     * should **NEVER** change the state of the motor controller!
     */
    private final IMotorController leftMasterMotor;

    /**
     * The main motor controller for the right side of the drive train.
     *
     * IMPORTANT: This is a sensor class -- it should ONLY be reading sensor data from this motor controller; it
     * should **NEVER** change the state of the motor controller!
     */
    private final IMotorController rightMasterMotor;

    /**
     * The main gyro for the bot.
     */
    private Gyro gyro;

    /**
     * The current sensor position of the left side of drive train.
     */
    private int leftPosition;

    /**
     * The current sensor position of the right side of drive train.
     */
    private int rightPosition;

    /**
     * The current velocity of the left drive train.
     */
    private int leftVelocity;

    /**
     * The current velocity of the right drive train.
     */
    private int rightVelocity;

    /**
     * Current heading of the bot.
     */
    private double angle;

    /**
     * Degrees/second turn rate.
     */
    private double turnRate;


    public DriveFeedback() {
        this.leftMasterMotor = MotorFactory.initLeftDriveMotors();
        this.rightMasterMotor = MotorFactory.initRightDriveMotors();

        this.gyro = new ADXRS450_Gyro();
    }



    /**
     * Ideally, this should be called exactly once per tick to get a representation of
     */
    public void updateSensorData() {

        SmartDashboard.putNumber("Left Encoder", leftPosition);
        SmartDashboard.putNumber("Right Encoder", rightPosition);
        SmartDashboard.putData("Gyro", (Sendable) gyro); // this gyro also implements Sendable

        this.leftPosition = leftMasterMotor.getSelectedSensorPosition(0);
        this.rightPosition = rightMasterMotor.getSelectedSensorPosition(0);

        this.leftVelocity = leftMasterMotor.getSelectedSensorVelocity(0);
        this.rightVelocity = rightMasterMotor.getSelectedSensorVelocity(0);

        this.angle = gyro.getAngle();
        this.turnRate = gyro.getRate();
    }

    public double getTurnRate() {
        return turnRate;
    }

    /**
     *
     * @return The raw angle reported by the gyro.
     */
    public double getAngle() {
        return angle;
    }

    /**
     *        0
     *
     *        |
     * 270  - + -  90
     *        |
     *
     *       180
     *
     * @return The current heading of the robot in degrees where 0 (or 360) is its starting position and 90 is due
     *    right of its starting position.
     *
     */
    public double getHeading() {
        double heading = angle;

        // Use remainder operator to resolve multiple revolutions
        heading = (heading % 360) + 0.0; // 0.0 to change -0.0 to 0.0

        // Normalize negative headings by adding 360. (-270 becomes 90; -179 becomes 181; -1 becomes 359)
        return heading < 0 ? heading + 360 : heading;
    }

    public int getRightVelocity() {
        return rightVelocity;
    }

    public int getLeftVelocity() {
        return leftVelocity;
    }

    public int getRightPosition() {
        return rightPosition;
    }

    public int getLeftPosition() {
        return leftPosition;
    }

    // in feet
    public double getRightDistance() {
        return rightPosition / TICKS_PER_FOOT;
    }

    public double getLeftDistance() {
        return leftPosition / TICKS_PER_FOOT;
    }

    public void reset() {
        leftMasterMotor.setSelectedSensorPosition(0, 0, 5);
        rightMasterMotor.setSelectedSensorPosition(0, 0, 5);
    }
}
