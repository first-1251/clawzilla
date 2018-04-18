package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import org.usfirst.frc.team1251.robot.subsystems.Collector;

/**
 * This TimedCommand collects forever and ends when it is interrupted by another command
 * The timeout is enough to get the motor running.
 */

public class CollectForever extends TimedCommand {

    private Collector collector;

    public CollectForever(Collector collector) {
        super(.25);
        this.collector = collector;
    }

    protected void execute(){
        collector.pullIn();
    }

}
