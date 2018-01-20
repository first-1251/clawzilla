package org.usfirst.frc.team1251.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Claw extends Subsystem {

    private Solenoid clawSolenoidLeft, clawSolenoidRight;

    public Claw(){
        clawSolenoidLeft = new solenoid();
        clawSolenoidRight = new solenoid();

    }

    //This just needs to be here
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    //Left claw solenoid movement
    public void leftSolenoid () {

    }

    //Right claw solenoid movement
    public void rightSolenoid () {

    }

}
