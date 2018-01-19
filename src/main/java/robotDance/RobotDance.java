package robotDance;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.OI;
import org.usfirst.frc.team1251.robot.Robot;
import org.usfirst.frc.team1251.robot.DriveTrain;

public class RobotDance extends Command{

    private final DriveTrain driveTrain;
    private final Joystick stick;

    public RobotDance(){
        this.stick = OI.stick;

        this.requires(Robot.DriveTrain);
        this.driveTrain = Robot.DriveTrain;
    }

    @Override
    protected boolean isFinished() {
        return false;

    }

    @Override
    protected void execute() {
        super.execute();
        this.driveTrain.setLeft(stick.getRawAxis(1));
        this.driveTrain.setRight(stick.getRawAxis(3));

        if (this.stick.getRawAxis(1)>0) {
            System.out.println("wOwOw");
        }
    }
}
