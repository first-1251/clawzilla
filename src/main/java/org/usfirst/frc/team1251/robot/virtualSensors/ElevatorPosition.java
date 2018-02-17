package org.usfirst.frc.team1251.robot.virtualSensors;

import edu.wpi.first.wpilibj.Encoder;

public class ElevatorPosition {
    private Encoder elevatorEncoder;
    private final double CIRCUMFERENCE = 0.75 * Math.PI; // Diameter is 0.75 I N C H E S

    // Constructor
    public ElevatorPosition(){
        elevatorEncoder = new Encoder(1, 0);
    }

    // Gets height in inches through conversion of Encoder Ticks to inches [(E / 360) * C]
    public double getHeight(){
        double encoderTicks = (double) elevatorEncoder.get();
        double distance = (encoderTicks / 360) * CIRCUMFERENCE;
        return distance;
    }

    // Resets encoder
    public void reset(){
        elevatorEncoder.reset();
    }
}
