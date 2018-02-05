package org.usfirst.frc.team1251.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ControllerTestBed extends Subsystem {

    private final String name;
    private int count = 0;

    public ControllerTestBed(String name) {
        this.name = name;
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void go() {
        System.out.println("Called go() on " + name + ", " + (count++) + "times");
    }

    public void cleanup() {
        System.out.println("Called cleanup() on " + name + "; resetting counter to 0");
        count = 0;
    }
}
