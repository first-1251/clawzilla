package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.Armevator;
import org.usfirst.frc.team1251.robot.teleopInput.driverInput.DriverInput;
import org.usfirst.frc.team1251.robot.teleopInput.gamepad.GamePad;

public class MoveArmevator extends Command {
    private DriverInput driverInput;
    private final Armevator armevator;

    public MoveArmevator(DriverInput driverInput, Armevator armevator) {
        this.driverInput = driverInput;
        this.armevator = armevator;
        requires(this.armevator);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void execute() {
        double armUpSpeed = this.driverInput.getArmUpSpeed();
        double armDownSpeed = this.driverInput.getArmDownSpeed();

        if (armUpSpeed > 0) {
            this.armevator.getArm().pivotUp(armUpSpeed);
        } else if (armDownSpeed > 0) {
            this.armevator.getArm().pivotDown(armDownSpeed);
        } else {
            this.armevator.getArm().stopPivot();
        }

        double elevatorUpSpeed = this.driverInput.getElevatorUpSpeed();
        double elevatorDownSpeed = this.driverInput.getElevatorDownSpeed();

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
