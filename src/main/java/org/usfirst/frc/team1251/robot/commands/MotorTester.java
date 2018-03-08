package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1251.robot.Robot;
import org.usfirst.frc.team1251.robot.teleopInput.gamepad.GamePad;

public class MotorTester extends CommandGroup {

    private GamePad gamePad;

    public MotorTester(GamePad gamePad) {
        this.gamePad = gamePad;

        requires(Robot.MOTORS);

        setupCanCommands();
       // setupPwmCommands();
    }

    private void setupCanCommands() {
        for (int i = 0; i < Robot.MOTORS.speedControllersCan.length; i++) {
            addSequential(new MoveMotor(Robot.MOTORS.speedControllersCan[i], gamePad));
            addSequential(new DoNothing(gamePad));
        }
    }

    private void setupPwmCommands() {
        for (int i = 0; i < Robot.MOTORS.speedControllers.length; i++) {
            addSequential(new MoveMotor(Robot.MOTORS.speedControllers[i], gamePad));
            addSequential(new DoNothing(gamePad));
        }
    }

    @Override
    protected void execute() {
        SmartDashboard.putNumber("RIGHT: ", Robot.MOTORS.speedControllersCan[0].getSelectedSensorPosition(0));
        SmartDashboard.putNumber("LEFT: ", Robot.MOTORS.speedControllersCan[1].getSelectedSensorPosition(0));
    }
}
