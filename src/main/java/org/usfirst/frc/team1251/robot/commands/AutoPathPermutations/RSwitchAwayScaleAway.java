package org.usfirst.frc.team1251.robot.commands.AutoPathPermutations;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1251.robot.commands.*;
import org.usfirst.frc.team1251.robot.subsystems.*;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;
import org.usfirst.frc.team1251.robot.virtualSensors.ElevatorPosition;

public class RSwitchAwayScaleAway extends CommandGroup {
    public RSwitchAwayScaleAway(Arm arm, ArmPosition armPosition,Claw claw, Collector collector, DriveTrain driveTrain, DriveFeedback driveFeedback, DriveTrainShifter shifter, Elevator elevator, ElevatorPosition elevatorPosition) {
        // Go forward 215.71 inches
        addSequential(new AutoForwards(driveFeedback, driveTrain, shifter, 215.71));

        // Face the 270 degree heading
        addSequential(new AutoTurn(driveTrain, 270, driveFeedback));

        // Move forward 175.00 inches
        addSequential(new AutoForwards(driveFeedback, driveTrain, shifter, 175));

        // Face the 180 degree heading
        addSequential(new AutoTurn(driveTrain, 180, driveFeedback));

        // Move forward 9.44 inches
        addSequential(new AutoForwards(driveFeedback, driveTrain, shifter, 9.44));

        // Bring arm down to 90 degrees
        addSequential(new AutoArmTo90(arm, armPosition));

        // Eject the cube into switch
        addSequential(new TimedEject(collector));

        // Bring arm down to minimum to pick up the cube
        addSequential(new AutoArmDownToMinimum(arm, armPosition));

        // Face the 210 degree heading
        addSequential(new AutoTurn(driveTrain, 210, driveFeedback));

        // Grab cube
        addSequential(new AutoGrabCube(claw, collector, driveTrain, shifter, driveFeedback));

        // Bring arm back up to 90
        addSequential(new AutoArmTo90(arm, armPosition));

        // Face the 270 degree heading
        addSequential(new AutoTurn(driveTrain, 270, driveFeedback));

        // Go forward 30 inches
        addSequential(new AutoForwards(driveFeedback, driveTrain, shifter, 30.00));

        // Face the 0 degree heading
        addSequential(new AutoTurn(driveTrain, 0, driveFeedback));

        // Move forward 60
        //TODO: Determine the exact length of this travel distance (not shown in diagram; must guesstimate)
        addSequential(new AutoForwards(driveFeedback, driveTrain, shifter, 60.00));

        // Raise arm
        addSequential(new AutoArmUpToTop(arm, armPosition));

        // Eject Cube
        addSequential(new TimedEject(collector));

    }
}
