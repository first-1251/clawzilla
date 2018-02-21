package org.usfirst.frc.team1251.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1251.robot.mechanisms.Claw;
import org.usfirst.frc.team1251.robot.mechanisms.Collector;

/**
 * Is it a Claw? Is it a Collector? No! It's a Clawlector!
 *
 * This subsystem is the block collector, but it also has a claw mechanism.  As a result of a
 * a mechanical design change announced on 2/7/2018, the Arm and the Claw subsystem have been
 * combined into a single subsystem.
 */
public class Clawlector extends Subsystem {

    private Claw claw;
    private Collector collector;

    public Clawlector (Claw claw, Collector collector) {
        this.claw = claw;
        this.collector = collector;
    }

    public Claw getClaw() {
        return claw;
    }

    public Collector getCollector() {
        return collector;
    }

    //This just needs to be here
    @Override
    public void initDefaultCommand() {
        // No default command
    }
}
