package org.usfirst.frc.team1251.robot.sensors;

/**
 * A sensor which outputs information derived from raw output from one or (often) more than one sensor.
 *
 * The work of deriving information is done by the `calculate()` method. Because this work tends to involve some sort
 * of non-trivial logical or mathematical operations, the `calculate()` method is usually called only once, during the
 * `*Periodic()` method of the `Robot'.
 */
public interface DerivedSensor {
    /**
     * Tells the sensor to calculate a new position based on any information obtained since the last calculation.
     */
    void calculate();
}
