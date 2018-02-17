package org.usfirst.frc.team1251.robot;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.Armevator;
import org.usfirst.frc.team1251.robot.teleopInput.gamepad.GamePad;


public class MoveArm {
    private final GamePad gamePad;
    private final Armevator armevator;


    public MoveArm(GamePad gamePad, Armevator armevator) {
        this.gamePad = gamePad;
        this.armevator = armevator;
        this.requires(this.armevator);

    }


    protected boolean isFinished() {
        return false;
    }


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


    protected void end() {
       this.armevator.getArm().stopPivot();

    }



}


