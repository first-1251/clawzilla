package org.usfirst.frc.team1251.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1251.robot.RobotMap;
import org.usfirst.frc.team1251.robot.commands.DeferredCmdSupplier;

public class Claw extends Subsystem{

    private final DeferredCmdSupplier<Command> defaultCmdSupplier;
    private DoubleSolenoid clawSolenoid;

    public Claw(DeferredCmdSupplier<Command> defaultCmdSupplier){
        this.defaultCmdSupplier = defaultCmdSupplier;
        clawSolenoid = new DoubleSolenoid(RobotMap.CLAW_SOLENOID_FORWARD, RobotMap.CLAW_SOLENOID_REVERSE);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(this.defaultCmdSupplier.get());
    }

    //Pistons set to default state and opens
    public void openClaw (){
        clawSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    //Pistons extend to close claw
    public void closeClaw () {
        clawSolenoid.set(DoubleSolenoid.Value.kReverse);
    }

}
