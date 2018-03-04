package org.usfirst.frc.team1251.robot.mechanisms;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import org.usfirst.frc.team1251.robot.RobotMap;

public class Claw {

    private DoubleSolenoid clawSolenoid;

    public Claw(){
        clawSolenoid = new DoubleSolenoid(RobotMap.CLAW_SOLENOID_FORWARD, RobotMap.CLAW_SOLENOID_REVERSE);
    }

    //Pistons set to default state and opens
    public void openClaw (){
        clawSolenoid.set(DoubleSolenoid.Value.kReverse);
    }

    //Pistons extend to close claw
    public void closeClaw () {
        clawSolenoid.set(DoubleSolenoid.Value.kForward);
    }


}
