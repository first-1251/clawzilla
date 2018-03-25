package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.Collector;
import org.usfirst.frc.team1251.robot.virtualSensors.CrateDetector;

public class CollectCrate extends Command {

    private final CrateDetector crateDetector;
    private final Collector collector;


    public CollectCrate(CrateDetector crateDetector, Collector collector)
    {
        this.crateDetector = crateDetector;
        this.collector = collector;
        this.requires(this.collector);
    }

    protected void execute() {
        // For now, always just pull the crate in.
        this.collector.getCollector().pullIn();



//        //todo when press enable command
//        if (this.crateDetector.getCrateState() == CrateDetector.CrateState.CRATE_COLLECTED)
//        {
//            this.clawlector.getCollector().stop();
//            return;
//        }
//        if (this.crateDetector.getCrateState() == CrateDetector.CrateState.SKEWED_LEFT)
//        {
//            this.clawlector.getCollector().pullInLeft();
//            return;
//        }
//        if (this.crateDetector.getCrateState() == CrateDetector.CrateState.SKEWED_RIGHT)
//        {
//            this.clawlector.getCollector().pullInRight();
//            return;
//        }
//        if (this.crateDetector.getCrateState() == CrateDetector.CrateState.NONE)
//        {
//            this.clawlector.getCollector().pullIn();
//        }

    }
    protected void end()
    {
        this.collector.getCollector().stop();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
    //
}

