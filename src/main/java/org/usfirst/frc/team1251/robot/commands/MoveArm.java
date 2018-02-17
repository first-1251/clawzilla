package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.Robot;
import org.usfirst.frc.team1251.robot.subsystems.Arm;
import org.usfirst.frc.team1251.robot.teleopInput.gamepad.GamePad;


public class MoveArm extends Command {

    private final GamePad gamePad;
    private final Arm arm;


    public MoveArm() {
        this.gamePad = Robot.oi.gamePad;
        this.arm = Robot.arm;
        this.requires(this.arm);

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void execute() {
        double stickValue = this.gamePad.ls().getVertical();
        this.arm.pivotUp(0);

        if (stickValue > 0){
            System.out.println("moving up");
            this.arm.pivotUp(stickValue);

        } else if (stickValue < 0){
            System.out.println("moving down");
            this.arm.pivotDown(stickValue);

        } else if (stickValue == 0){
            System.out.println("not moving");
            this.arm.stopPivot();
        }

    }

    @Override
    protected void end() {
       this.arm.stopPivot();

    }



}


