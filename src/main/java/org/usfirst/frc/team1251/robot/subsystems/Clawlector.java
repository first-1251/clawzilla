package org.usfirst.frc.team1251.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1251.robot.Claw;
import org.usfirst.frc.team1251.robot.Collector;
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

    private Claw claw = new Claw();
    private Collector collector = new Collector();

    public Claw getClaw() {
        return claw;
    }

    public Collector getCollector() {
        return collector;
    }

    //This just needs to be here
    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
