package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.TimedCommand;
import org.usfirst.frc.team1251.robot.subsystems.Collector;

public class TimedIntake extends TimedCommand {

    private static final double INTAKE_SPEED = 0.25;
    private static final double INTAKE_DURATION = 1;

    private Collector collector;

    public TimedIntake(Collector collector){
        super(INTAKE_DURATION);
        this.collector = collector;

        requires(collector);
    }

    @Override
    protected void execute(){
        this.collector.eject(-INTAKE_SPEED);
    }

    @Override
    protected void end(){
        this.collector.stop();
    }
}
