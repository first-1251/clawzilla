package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.Armevator;
import org.usfirst.frc.team1251.robot.teleopInput.driverInput.HumanInput;

public class MoveArmevator extends Command {
    private HumanInput humanInput;
    private final Armevator armevator;

    public MoveArmevator(HumanInput humanInput, Armevator armevator) {
        this.humanInput = humanInput;
        this.armevator = armevator;
        requires(this.armevator);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void execute() {
        double armUpSpeed = this.humanInput.getArmUpSpeed();
        double armDownSpeed = this.humanInput.getArmDownSpeed();

        if (armUpSpeed > 0) {
            this.armevator.getArm().pivotUp(armUpSpeed);
        } else if (armDownSpeed > 0) {
            this.armevator.getArm().pivotDown(armDownSpeed);
        } else {
            this.armevator.getArm().stopPivot();
        }

        double elevatorUpSpeed = this.humanInput.getElevatorUpSpeed();
        double elevatorDownSpeed = this.humanInput.getElevatorDownSpeed();

        if (elevatorUpSpeed > 0) {
            this.armevator.getElevator().goUp(elevatorUpSpeed);
        } else if (elevatorDownSpeed > 0) {
            this.armevator.getElevator().goDown(elevatorDownSpeed);
        } else {
            this.armevator.getElevator().stopPlease();
        }
    }

    @Override
    public void end() {
        this.armevator.getElevator().stopPlease();
        this.armevator.getArm().stopPivot();
    }

}
