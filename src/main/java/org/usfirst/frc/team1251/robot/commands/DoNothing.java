package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.teleopInput.gamepad.GamePad;

public class DoNothing extends Command {

    private GamePad controller;

    public DoNothing(GamePad controller) {
        this.controller = controller;
    }

    @Override
    protected boolean isFinished() {
        return controller.a().isPressed();
    }
}
