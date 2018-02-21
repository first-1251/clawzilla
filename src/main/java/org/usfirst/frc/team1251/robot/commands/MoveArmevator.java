package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.Armevator;
import org.usfirst.frc.team1251.robot.teleopInput.gamepad.GamePad;

public class MoveArmevator extends Command {
    private GamePad gamePad;
    private final Armevator armevator;

    public MoveArmevator(GamePad gamePad, Armevator armevator) {
        this.gamePad = gamePad;
        this.armevator = armevator;
        requires(this.armevator);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void execute() {
        double elevatorStick = this.gamePad.rs().getVertical();
        if(elevatorStick > 0) {
            this.armevator.getElevator().goUp(elevatorStick);
        } else if(elevatorStick < 0) {
            this.armevator.getElevator().goDown(elevatorStick);
        } else {
            this.armevator.getElevator().stopPlease();
        }


        double armStick = this.gamePad.ls().getVertical();

        if (armStick > 0){
            //System.out.println("moving up");
            this.armevator.getArm().pivotUp(armStick);

        } else if (armStick < 0){
            //System.out.println("moving down");
            this.armevator.getArm().pivotDown(armStick);

        } else if (armStick == 0){
            //System.out.println("not moving");
            this.armevator.getArm().stopPivot();
        }

    }

    @Override
    public void end() {
        this.armevator.getElevator().stopPlease();
        this.armevator.getArm().stopPivot();
    }

}
