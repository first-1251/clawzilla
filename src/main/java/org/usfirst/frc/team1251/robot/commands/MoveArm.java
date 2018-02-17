package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.Robot;
import org.usfirst.frc.team1251.robot.subsystems.Armevator;
import org.usfirst.frc.team1251.robot.teleopInput.gamepad.GamePad;


public class MoveArm extends Command {

    private final GamePad gamePad;
    private final Armevator armevator;


    public MoveArm() {
        this.gamePad = Robot.oi.driverPad;
        this.armevator = Robot.ARMEVATOR;
        this.requires(this.armevator);

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void execute() {
        double stickValue = this.gamePad.ls().getVertical();
        this.armevator.getArm().pivotUp(0);

        if (stickValue > 0){
            //System.out.println("moving up");
            this.armevator.getArm().pivotUp(stickValue);

        } else if (stickValue < 0){
            //System.out.println("moving down");
            this.armevator.getArm().pivotDown(stickValue);

        } else if (stickValue == 0){
            //System.out.println("not moving");
            this.armevator.getArm().stopPivot();
        }

    }

    @Override
    protected void end() {
       this.armevator.getArm().stopPivot();

    }



}


