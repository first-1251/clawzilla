package org.usfirst.frc.team1251.robot.virtualSensors;

import edu.wpi.first.wpilibj.Encoder;

public class ElevatorPosition {
    private Encoder elevatorEncoder;
    private final double CIRCUMFERENCE = 0.75 * Math.PI; // Diameter is 0.75"
    private final static double MAX_HEIGHT = 72; // in inches

    // Constructor
    public ElevatorPosition(){
        elevatorEncoder = new Encoder(1, 0);
        elevatorEncoder.reset();
    }

    // Gets height in inches through conversion of Encoder Ticks to inches [(E / 360) * C]
    public double getHeight(){
        double encoderTicks = (double) elevatorEncoder.get();
        double distance = (encoderTicks / 360) * CIRCUMFERENCE;
        return distance;
    }

    public boolean isAtMaxHeight() {
        return getHeight() >= MAX_HEIGHT;
    }

    public boolean isAtMinHeight() {
        return getHeight() <= 0;
    }
}
