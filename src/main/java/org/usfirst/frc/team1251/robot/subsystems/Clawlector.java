package org.usfirst.frc.team1251.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1251.robot.Robot;
import org.usfirst.frc.team1251.robot.RobotMap;
import org.usfirst.frc.team1251.robot.virtualSensors.CrateDetector;

/**
 * Is it a Claw? Is it a Collector? No! It's a Clawlector!
 *
 * This subsystem is the block collector, but it also has a claw mechanism.  As a result of a
 * a mechanical design change announced on 2/7/2018, the Arm and the Claw subsystem have been
 * combined into a single subsystem.
 */
public class Clawlector extends Subsystem {

    private Solenoid clawSolenoidLeft, clawSolenoidRight;

    //The left bag motor, when looking from the rear perspective.
    private SpeedController leftMotor;

    //The right bag motor, when looking from the rear perspective.
    private SpeedController rightMotor;

    private CrateDetector crateDetector;

    public Clawlector(){
        clawSolenoidLeft = new Solenoid(RobotMap.clawSolenoidLeft);
        clawSolenoidRight = new Solenoid(RobotMap.clawSolenoidRight);

        this.crateDetector = Robot.crateDetector;
        this.leftMotor = new Victor(RobotMap.COLLECTOR_LEFT_VICTOR);
        this.rightMotor = new Victor(RobotMap.COLLECTOR_RIGHT_VICTOR);

    }

    //This just needs to be here
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    //Pistons set to default state and opens
    public void openClaw (){
        clawSolenoidLeft.set(false);
        clawSolenoidRight.set(false);
    }

    //Pistons extend to close claw
    public void closeClaw () {
        clawSolenoidLeft.set(true);
        clawSolenoidRight.set(true);

    }

    public void stop()
    {
        rightMotor.set(0);
        leftMotor.set(0);
        return;
    }
    public void pullInLeft()
    {
        rightMotor.set(-1);
        leftMotor.set(1);
        return;
    }
    public void pullIn()
    {
        rightMotor.set(1);
        leftMotor.set(1);
        return;
    }
    public void pullInRight()
    {
        rightMotor.set(-1);
        leftMotor.set(-1);
        return;
    }
}
