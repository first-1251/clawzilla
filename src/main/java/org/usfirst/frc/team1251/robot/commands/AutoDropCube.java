package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1251.robot.subsystems.Claw;
import org.usfirst.frc.team1251.robot.subsystems.Collector;

public class AutoDropCube extends CommandGroup {

    public AutoDropCube(Claw claw, Collector collector) {
        addParallel(new TimedOpenClaw(claw, 1));
        addParallel(new DelayedTimedEject(collector, .25, .75));
    }
}
