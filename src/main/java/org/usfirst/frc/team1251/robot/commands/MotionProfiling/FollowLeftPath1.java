package org.usfirst.frc.team1251.robot.commands.MotionProfiling;

import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;

import java.io.File;

public class FollowLeftPath1 extends Command {

    private DriveFeedback driveFeedback;
    private DriveTrain driveTrain;
    private Trajectory left;
    private Trajectory right;
    private EncoderFollower leftFollower;
    private EncoderFollower rightFollower;
    private int index = 0;

    public FollowLeftPath1(DriveTrain driveTrain, DriveFeedback driveFeedback) {
        this.driveFeedback = driveFeedback;
        driveFeedback.reset();
        this.driveTrain = driveTrain;
        requires(driveTrain);
        left = Pathfinder.readFromCSV(new File("/home/lvuser/CenterLeft1_left_detailed.csv"));
        right = Pathfinder.readFromCSV(new File("/home/lvuser/CenterLeft1_right_detailed.csv"));
        leftFollower = new EncoderFollower(left);
        leftFollower.configurePIDVA(1.2, 0.0, 0.15, 1.0/12.0, 1/15.0);
        leftFollower.configureEncoder(0, (int) DriveFeedback.TICKS_PER_TURN, DriveFeedback.WHEEL_DIAMETER / 12.0);
        rightFollower = new EncoderFollower(right);
        rightFollower.configurePIDVA(1.2, 0.0, 0.15, 1.0/12.0, 1/15.0);
        rightFollower.configureEncoder(0, (int) DriveFeedback.TICKS_PER_TURN, DriveFeedback.WHEEL_DIAMETER / 12.0);
    }

    @Override
    protected void initialize() {
        super.initialize();
        index = 0;
    }

    @Override
    protected void execute() {
        System.out.println("RUNN");
        System.out.println(rightFollower.isFinished());
        super.execute();
        driveFeedback.updateSensorData();
        driveTrain.setSpeed(leftFollower.calculate(driveFeedback.getLeftPosition()) - (0.0000 * Math.abs(Pathfinder.r2d(leftFollower.getHeading()) - driveFeedback.getHeading())),
                rightFollower.calculate(driveFeedback.getRightPosition()) + (0.0000 * Math.abs(Pathfinder.r2d(rightFollower.getHeading()) - driveFeedback.getHeading())));
    }

    @Override
    protected void end() {
        super.end();
        driveTrain.setSpeed(0, 0);
        driveFeedback.reset();
    }

    @Override
    protected boolean isFinished() {
        return leftFollower.isFinished() && rightFollower.isFinished();
    }
}
