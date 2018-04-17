package org.usfirst.frc.team1251.robot.commands.MotionProfiling;

import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;

import java.io.File;

public class FollowPath extends Command {
    private static final String BASE_PATH = "/home/lvuser/";
    private static final double WHEEL_DIAMETER = DriveFeedback.WHEEL_DIAMETER / 12;
    private static final int TICKS_PER_TURN = (int)DriveFeedback.TICKS_PER_TURN;

    static final double KP = 1.2;
    static final double KI = 0.0;
    private static final double KD = 0.15;
    static final double KV = 1.0 / 12.0;
    static final double KA = 1 / 15.0;

    private final DriveTrain driveTrain;
    private final DriveFeedback driveFeedback;

    private EncoderFollower leftFollower;
    private EncoderFollower rightFollower;

    FollowPath(String fileBase, DriveTrain driveTrain, DriveFeedback driveFeedback) {

        requires(driveTrain);

        leftFollower = buildFollower(Pathfinder.readFromCSV(new File(BASE_PATH + fileBase + "_left_detailed.csv")));
        rightFollower = buildFollower(Pathfinder.readFromCSV(new File(BASE_PATH + fileBase + "_right_detailed.csv")));

        this.driveTrain = driveTrain;
        this.driveFeedback = driveFeedback;
    }

    private EncoderFollower buildFollower(Trajectory trajectory) {
        EncoderFollower follower = new EncoderFollower(trajectory);
        follower.configureEncoder(0, TICKS_PER_TURN, WHEEL_DIAMETER);
        this.configureFollowerPIDVA(follower);

        return follower;
    }

    protected void configureFollowerPIDVA(EncoderFollower follower) {
        follower.configurePIDVA(KP, KI, KD, KV, KA);
    }

    @Override
    protected void initialize() {
        super.initialize();
        driveFeedback.reset();
    }

    @Override
    protected void execute() {
        System.out.println("RUNN");
        System.out.println(rightFollower.isFinished());
        super.execute();
        driveFeedback.updateSensorData();
        driveTrain.setSpeed(
                leftFollower.calculate(driveFeedback.getLeftPosition()),
                rightFollower.calculate(driveFeedback.getRightPosition())
        );
    }

    @Override
    protected boolean isFinished() {
        return leftFollower.isFinished() && rightFollower.isFinished();
    }

    @Override
    protected void end() {
        super.end();
        driveTrain.setSpeed(0, 0);
        driveFeedback.reset();
    }



}
