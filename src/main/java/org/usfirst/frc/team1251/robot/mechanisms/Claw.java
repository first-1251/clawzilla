package org.usfirst.frc.team1251.robot.mechanisms;

import edu.wpi.first.wpilibj.Solenoid;
import org.usfirst.frc.team1251.robot.RobotMap;

public class Claw {

    private Solenoid clawSolenoidLeft, clawSolenoidRight;

    public Claw(){
        clawSolenoidLeft = new Solenoid(RobotMap.clawSolenoidLeft);
        clawSolenoidRight = new Solenoid(RobotMap.clawSolenoidRight);

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


}
