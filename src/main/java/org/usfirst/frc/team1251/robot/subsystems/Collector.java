package org.usfirst.frc.team1251.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1251.robot.CrateDetector;
import org.usfirst.frc.team1251.robot.commands.CollectorMain;

public class Collector extends Subsystem
{
    //Bag Motors For Things

    //The left bag motor, when looking from the rear perspective.
    private SpeedController leftMotor;

    //The right bag motor, when looking from the rear perspective.
    private SpeedController rightMotor;

    private CrateDetector crateDetector;

    public Collector()
    {

    }

    @Override
    protected void initDefaultCommand()
    {
        this.getDefaultCommand(new CollectorMain());
    }

    private void getDefaultCommand(CollectorMain collectorMain) {
    }


    public void runCollectorWheels()
    {
        CrateDetector.CrateState crateState = this.crateDetector.getCrateState();

        if (crateState == CrateDetector.CrateState.SKEWED_LEFT)
        {
            rightMotor.set(1);
            leftMotor.set(1);
            return;
        }

        if (crateState == CrateDetector.CrateState.DIAGONAL)
        {
            rightMotor.set(1);
            leftMotor.set(1);
            return;
        }

        if (crateState == CrateDetector.CrateState.SKEWED_RIGHT)
        {
            rightMotor.set(-1);
            leftMotor.set(-1);
            return;
        }

        if (crateState == CrateDetector.CrateState.CRATE_COLLECTED)
        {
            rightMotor.set(0);
            leftMotor.set(0);
            return;
        }
        if (crateState == CrateDetector.CrateState.NONE)
        {
            //Sucks in crate
            rightMotor.set(1);
            leftMotor.set(-1);
            return;
        }

    }
}
