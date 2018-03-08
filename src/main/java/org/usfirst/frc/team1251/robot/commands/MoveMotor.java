package org.usfirst.frc.team1251.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.IMotorController;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.teleopInput.gamepad.GamePad;

public class MoveMotor extends Command{

    private IMotorController motorController;

    private SpeedController speedController;

    private GamePad gamePad;

    public MoveMotor(IMotorController controller, GamePad gamePad) {
        this.motorController = controller;
        this.gamePad = gamePad;
    }

    public MoveMotor(SpeedController speedController, GamePad gamePad) {
        this.speedController = speedController;
        this.gamePad = gamePad;
    }

    @Override
    protected void execute() {
        if (motorController != null) {
            motorController.set(ControlMode.PercentOutput, 0.1);
        } else {
            speedController.set(0.1);
        }
    }

    @Override
    protected boolean isFinished() {
        return gamePad.b().isPressed();
    }
}
