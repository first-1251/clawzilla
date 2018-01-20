package org.usfirst.frc.team1251.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1251.robot.RobotMap;

public class Claw extends Subsystem {

    private Solenoid clawSolenoidLeft, clawSolenoidRight;

    public Claw(){
       clawSolenoidLeft = new Solenoid(RobotMap.clawSolenoidLeft);
       clawSolenoidRight = new Solenoid(RobotMap.clawSolenoidRight);

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

    //Pistons fire and extend to close
    public void closeClaw () {
        clawSolenoidLeft.set(true);
        clawSolenoidRight.set(true);

    }

}
