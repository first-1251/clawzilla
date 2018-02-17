package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.Robot;
import org.usfirst.frc.team1251.robot.subsystems.Clawlector;
import org.usfirst.frc.team1251.robot.teleopInput.gamepad.GamePad;
import org.usfirst.frc.team1251.robot.virtualSensors.CrateDetector;

public class CollectCrate extends Command {

    private final GamePad gamePad;
    private final CrateDetector crateDetector;
    private final Clawlector clawLector;

    public CollectCrate()
    {
        this.gamePad = Robot.oi.gamePad;
        this.crateDetector = Robot.crateDetector;
        this.clawLector = Robot.CLAWLECTOR;
        this.requires(this.clawLector);
    }

    protected void execute() {
        //todo when press enable command
        if (this.crateDetector.getCrateState() == CrateDetector.CrateState.CRATE_COLLECTED)
        {
            System.out.println("Crate Collected");
            this.clawLector.stop();
            return;
        }
        if (this.crateDetector.getCrateState() == CrateDetector.CrateState.SKEWED_LEFT)
        {
            System.out.println("Skewed Left");
            this.clawLector.pullInLeft();
            return;
        }
        if (this.crateDetector.getCrateState() == CrateDetector.CrateState.DIAGONAL)
        {
            System.out.println("Diagonal");
            this.clawLector.pullInLeft();
            return;
        }
        if (this.crateDetector.getCrateState() == CrateDetector.CrateState.SKEWED_RIGHT)
        {
            System.out.println("Skewed Right");
            this.clawLector.pullInRight();
            return;
        }
        if (this.crateDetector.getCrateState() == CrateDetector.CrateState.NONE)
        {
            System.out.println("None");
            this.clawLector.pullIn();
            return;
        }

    }
    protected void end()
    {
        this.clawLector.stop();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
    //
}

