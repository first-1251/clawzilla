package org.usfirst.frc.team1251.robot.commands.AutoPathPermutations;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1251.robot.commands.*;
import org.usfirst.frc.team1251.robot.subsystems.*;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;
import org.usfirst.frc.team1251.robot.virtualSensors.ElevatorPosition;

public class RSwitchHomeScaleHome extends CommandGroup {
    public RSwitchHomeScaleHome (Arm arm, ArmPosition armPosition,Claw claw, Collector collector, DriveTrain driveTrain, DriveFeedback driveFeedback, DriveTrainShifter shifter, Elevator elevator, ElevatorPosition elevatorPosition) {
        // Go forward 147.36 inches
        addSequential(new AutoForwards(driveFeedback, driveTrain, shifter, 147.36));

        // Face the 270 degree heading
        addSequential(new AutoTurn(driveTrain, 270, driveFeedback));

        // Move forward 17.29 inches
        addSequential(new AutoForwards(driveFeedback, driveTrain, shifter, 17.29));

        // Bring arm down to 90 degrees
        addSequential(new AutoArmTo90(arm, armPosition));

        // Eject the cube into switch
        addSequential(new TimedEject(collector));

        // Bring arm down to minimum to pick up the cube
        addSequential(new AutoArmDownToMinimum(arm, armPosition));

        // Face the 180 degree heading
        addSequential(new AutoTurn(driveTrain, 180, driveFeedback));

        // Move backwards 65.25 inches
        addSequential(new AutoForwards(driveFeedback,driveTrain,shifter, -65.25));

        // Face the 227.6 degree heading
        addSequential(new AutoTurn(driveTrain, 227.6, driveFeedback));

        // Move forward 17.00 inches
        addSequential(new AutoForwards(driveFeedback,driveTrain,shifter, 17.00));

        // Pick up cube
        addSequential(new AutoGrabCube(claw, collector, driveTrain, shifter, driveFeedback));

        // Move back 26 inches
        addSequential(new AutoForwards(driveFeedback,driveTrain,shifter, -26.00));

        // Turn to face the 340.6 degree heading
        addSequential(new AutoTurn(driveTrain, 340.6, driveFeedback));

        // Move forward 42.67 and bring arm back up to 90
        addSequential(new AutoForwards(driveFeedback,driveTrain,shifter, 42.67));
        addParallel(new AutoArmTo90(arm, armPosition));

        // Raise elevator

        //Drop cube into scale

    }
}
