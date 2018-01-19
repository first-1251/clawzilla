package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.OI;
import org.usfirst.frc.team1251.robot.Robot;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;

/**
 * Created by nick2 on 1/13/2018.
 */
public class DanzaRobotica extends Command {

    // Nova variavel para o tren de conduzir
    private final DriveTrain driveTrain;

    private final Joystick joystick;


    // Construtor do metodo
    public DanzaRobotica(){
        this.requires(Robot.driveTrain);
        this.driveTrain = Robot.driveTrain;
        this.joystick = OI.stick;
    }

    @Override
    protected void execute() {
        this.driveTrain.setLeftSpeed(joystick.getRawAxis(1));
        this.driveTrain.setRightSpeed(joystick.getRawAxis(3));
        if (this.joystick.getRawAxis(1) > 0) {
            System.out.println("お前わもう死んでる。何？！竜が我が敵を喰らう！");
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
