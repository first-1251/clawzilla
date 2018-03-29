package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1251.robot.subsystems.Claw;
import org.usfirst.frc.team1251.robot.subsystems.Collector;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrainShifter;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;

public class AutoGrabCube extends CommandGroup {
    public AutoGrabCube(Claw claw, Collector collector, DriveTrain driveTrain, DriveTrainShifter driveTrainShifter, DriveFeedback driveFeedback){
        // Open claw to allow intake
        addSequential(new OpenClaw(claw));

        // Intake cube
        addSequential(new TimedIntake(collector));

        // Move ClawZilla forward
        addParallel(new AutoForwards(driveFeedback, driveTrain, driveTrainShifter, 5));

        // Open claw to allow intake
        addSequential(new CloseClaw(claw));

        // Move ClawZilla to original position
        addParallel(new AutoForwards(driveFeedback, driveTrain, driveTrainShifter, -5));
    }
}
