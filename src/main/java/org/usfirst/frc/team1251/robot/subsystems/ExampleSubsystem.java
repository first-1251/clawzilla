package org.usfirst.frc.team1251.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1251.robot.commands.ExampleCommand;

/**
 *
 */
public class ExampleSubsystem extends Subsystem {

    private DigitalInput newLimitSwitch = new DigitalInput(0);
    private Victor bagMotor = new Victor(0);
    //private double bagMotorSpeed = bagMotor.get();

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ExampleCommand());
    }

    public boolean isSwitchOn()
    {
        return !newLimitSwitch.get();
    }

    public void setMotorSpeed(double speed) {
        bagMotor.set(speed);
    }

    public double getMotorSpeed()
    {
        return bagMotor.get();
    }
}
