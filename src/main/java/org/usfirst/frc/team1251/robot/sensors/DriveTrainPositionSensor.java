package org.usfirst.frc.team1251.robot.sensors;

import edu.wpi.first.wpilibj.Encoder;

/**
 * Derives and reports the Robot's position on the field using sensors related directly to the DriveTrain.
 */
public class DriveTrainPositionSensor implements DerivedPositionSensor {

    /**
     * The encoder which is reading movement of the left wheel(s)
     */
    private final Encoder leftWheelEncoder;

    /**
     * The encoder which is reading movement of the right wheel(s)
     */
    private final Encoder rightWheelEncoder;

    /**
     * The last known position of the robot.
     */
    private final RobotPosition lastKnownPosition;

    /**
     * The last distance read from the encoder. This is compared against live reads of the controller to detect how
     * far the the robot's left wheels have traveled since the previous read.
     */
    private double lastLeftEncoderDistance;

    /**
     * The last distance read from the encoder. This is compared against live reads of the controller to detect how
     * far the robot's right wheels have traveled since the previous read.
     */
    private double lastRightEncoderDistance;

    /**
     * @param leftWheelEncoder  The wheel encoder which detects movement on the left side of the drive train.
     * @param rightWheelEncoder The wheel encoder which detects movement on the right side of the drive train.
     * @param currentPosition   The current position of the robot.
     */
    DriveTrainPositionSensor(Encoder leftWheelEncoder, Encoder rightWheelEncoder, RobotPosition currentPosition) {

        this.leftWheelEncoder = leftWheelEncoder;
        this.lastLeftEncoderDistance = leftWheelEncoder.getDistance();

        this.rightWheelEncoder = rightWheelEncoder;
        this.lastRightEncoderDistance = rightWheelEncoder.getDistance();

        this.lastKnownPosition = currentPosition;
    }

    @Override
    public RobotPosition getPosition() {
        return lastKnownPosition;
    }

    @Override
    public void calculate() {
        // Capture the current distances from the encoders.
        double currentLeftDistance = this.leftWheelEncoder.getDistance();
        double currentRightDistance = this.rightWheelEncoder.getDistance();

        // TODO: Use the delta between the current and last known encoder distances to adjust the last known position.

        // Now that we are done calculating, capture the current distances as the last-known distances so that they
        // can be used in the next calculation.
        this.lastLeftEncoderDistance = currentLeftDistance;
        this.lastRightEncoderDistance = currentRightDistance;
    }
}
