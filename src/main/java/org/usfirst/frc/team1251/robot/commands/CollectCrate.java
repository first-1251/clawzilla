package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.Collector;
import org.usfirst.frc.team1251.robot.Robot;
import org.usfirst.frc.team1251.robot.subsystems.Clawlector;
import org.usfirst.frc.team1251.robot.teleopInput.gamepad.GamePad;
import org.usfirst.frc.team1251.robot.virtualSensors.CrateDetector;

public class CollectCrate extends Command {

    private final GamePad gamePad;
    private final CrateDetector crateDetector;
    private final Collector collector;


    public CollectCrate()
    {
        this.gamePad = Robot.oi.driverPad;
        this.crateDetector = Robot.crateDetector;
        this.collector = Robot.COLLECTOR;
        //this.requires(this.collector);
    }

    protected void execute() {
        //todo when press enable command
        if (this.crateDetector.getCrateState() == CrateDetector.CrateState.CRATE_COLLECTED)
        {
            System.out.println("Crate Collected");
            this.collector.stop();
            return;
        }
        if (this.crateDetector.getCrateState() == CrateDetector.CrateState.SKEWED_LEFT)
        {
            System.out.println("Skewed Left");
            this.collector.pullInLeft();
            return;
        }
        if (this.crateDetector.getCrateState() == CrateDetector.CrateState.DIAGONAL)
        {
            System.out.println("Diagonal");
            this.collector.pullInLeft();
            return;
        }
        if (this.crateDetector.getCrateState() == CrateDetector.CrateState.SKEWED_RIGHT)
        {
            System.out.println("Skewed Right");
            this.collector.pullInRight();
            return;
        }
        if (this.crateDetector.getCrateState() == CrateDetector.CrateState.NONE)
        {
            System.out.println("None");
            this.collector.pullIn();
            return;
        }

    }
    protected void end()
    {
        this.collector.stop();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
    //
}

