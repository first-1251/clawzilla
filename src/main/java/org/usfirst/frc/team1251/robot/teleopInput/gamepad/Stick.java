package org.usfirst.frc.team1251.robot.teleopInput.gamepad;


import edu.wpi.first.wpilibj.GenericHID;

/**
 * Represents a stick on the controller. Each stick can report its horizontal and vertical values which each range
 * from -1 to 1.
 */
public class Stick {

    private final int verticalAxisID;
    private final int horizontalAxisID;
    private final GenericHID rawDevice;

    /**
     * @param horizontalAxisID The raw axis to inspect to get the horizontal position of the stick.
     * @param verticalAxisID The raw axis to inspect to get the vertical position of the stick.
     * @param rawDevice The raw HID that contains this stick.
     */
    Stick(int horizontalAxisID, int verticalAxisID, GenericHID rawDevice) {
        this.verticalAxisID = verticalAxisID;
        this.horizontalAxisID = horizontalAxisID;
        this.rawDevice = rawDevice;
    }

    /**
     * Provides the current vertical position of the stick.
     *
     * @return A value between -1 and 1 where < 0 represents a downward position and +1 represents an
     *         upward position.
     */
    public double getVertical() {
        return rawDevice.getRawAxis(this.verticalAxisID);
    }

    /**
     * Provides the current vertical position of the stick ignoring values within the given deadZone.
     *
     * The deadZone extends out in all directions. Therefore, if the deadZone is given as 0.20 and the stick is at
     * 0.19 or -0.19, the return value would be 0.
     *
     * @param deadZone The distance from the center which should be ignored.
     *
     * @return A value between -1 and 1 where < 0 represents a downward position and > 0 represents an
     *     upward position.
     */
    public double getVertical(double deadZone) {
        return this.applyDeadZone(deadZone, this.getVertical());
    }

    /**
     * Provides the current horizontal position of the stick.
     **
     * @return A value between -1 and 1 where < 0 represents a leftward position and > 0 represents an
     *     rightward position.
     */
    public double getHorizontal() {
        return rawDevice.getRawAxis(this.horizontalAxisID);
    }

    /**
     * Provides the current horizontal position of the stick ignoring values within the given deadZone.
     *
     * The deadZone extends out in all directions. Therefore, if the deadZone is given as 0.20 and the stick is at
     * 0.19 or -0.19, the return value would be 0.
     *
     * @param deadZone The distance from the center which should be ignored.
     *
     * @return A value between -1 and 1 where < 0 represents a leftward position and > 0 represents an
     *     rightward position.
     */
    public double getHorizontal(double deadZone) {
        return this.applyDeadZone(deadZone, this.getHorizontal());
    }

    /**
     * A helper which will apply a deadZone against a given axis value.
     *
     * @param deadZone The deadZone to apply. Dead zones apply in all directions, so the absolute value of this
     *                 parameter will be used.
     * @param axisValue The axis value to apply the deadZone to.
     *
     * @return The adjusted axis value. The original value is always adjusted towards 0 but will never be adjusted
     *         beyond 0. If the original value is positive, the return value will be positive or zero; similarly, if
     *         the original value is negative, the return value will be negative or zero.
     */
    private double applyDeadZone(double deadZone, double axisValue) {
        // Simplest case first... if axis is at zero, then the deadZone is a non-factor.
        if (axisValue == 0) {
            return 0;
        }

        // deadZone extends in all directions, so use its absolute value.
        deadZone = Math.abs(deadZone);

        // Check to see if the axis value is negative
        if (axisValue < 0) {
            // Add the deadZone to adjust towards zero, but don't let it exceed 0.
            return Math.min(axisValue + deadZone, 0);
        }

        // Not zero and not negative... It is safe to assume that the axis value is positive.
        // Subtract the deadZone from the axis value to adjust towards zero, but don't let it fall below 0.
        return Math.max(axisValue - deadZone, 0);
    }
}
