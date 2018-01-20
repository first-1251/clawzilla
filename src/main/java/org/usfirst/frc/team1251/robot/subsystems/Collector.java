package org.usfirst.frc.team1251.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1251.robot.RobotMap;
import org.usfirst.frc.team1251.robot.commands.CollectorMain;

public class Collector extends Subsystem
{
    //Bag Motors

    //The left bag motor, when looking from the rear perspective.
    private SpeedController leftMotor;

    //The right bag motor, when looking from the rear perspective.
    private SpeedController rightMotor;

    //Collector Button Limits

    //One of the 3 switches used to align the crate. On left side when looking from the rear perspective.
    private DigitalInput leftSwitch;

    //One of the 3 switches used to align the crate. In the middle.
    private DigitalInput middleSwitch;

    //One of the 3 switches used to align the crate. On right side when looking from the rear perspective.
    private DigitalInput rightSwtich;

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


    public boolean isLeftOnly() //Only left button is pressed
    {
        return leftSwitch.get() && !middleSwitch.get() && !rightSwtich.get();
    }
    public boolean isMiddleOnly() //Only middle button is pressed
    {
        return middleSwitch.get() && !leftSwitch.get() && !rightSwtich.get();
    }
    public boolean isRightOnly() //Only right button is pressed
    {
        return rightSwtich.get() && !middleSwitch.get() && !leftSwitch.get();
    }
    public boolean isLeftMiddle() //Left and Middle is pressed
    {
        return leftSwitch.get() && middleSwitch.get() && !leftSwitch.get();
    }
    public boolean isRightMiddle() //Right and Middle is pressed
    {
        return rightSwtich.get() && middleSwitch.get() && !leftSwitch.get();
    }
    public boolean isAllPressed() //Right and Middle is pressed
    {
        return rightSwtich.get() && middleSwitch.get() && leftSwitch.get();
    }


    public void buttonPressed()
    {
        if (isLeftOnly()) {
            rightMotor.set(1);
            leftMotor.set(1);
            return;
        }
        if (isLeftMiddle()) {
            rightMotor.set(1);
            leftMotor.set(1);
            return;
        }
        if (isMiddleOnly()) {
            rightMotor.set(1);
            leftMotor.set(1);
            return;
        }
        if (isRightOnly()) {
            rightMotor.set(-1);
            leftMotor.set(-1);
            return;
        }
        if (isRightMiddle()) {
            rightMotor.set(-1);
            leftMotor.set(-1);
            return;
        }
        if (isAllPressed()) {
            rightMotor.set(0);
            leftMotor.set(0);
            return;
        }

    }
}
