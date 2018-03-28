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
        this.collector.pullIn();

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

