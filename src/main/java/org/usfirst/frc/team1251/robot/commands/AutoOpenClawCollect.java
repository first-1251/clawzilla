package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1251.robot.subsystems.Claw;
import org.usfirst.frc.team1251.robot.subsystems.Collector;

public class AutoOpenClawCollect extends CommandGroup {
    public AutoOpenClawCollect(Claw claw, Collector collector){
        addParallel(new OpenClaw(claw));
        addParallel(new CollectForever(collector));
    }
}
