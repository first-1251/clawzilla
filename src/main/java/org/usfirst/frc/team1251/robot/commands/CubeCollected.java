package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import org.usfirst.frc.team1251.robot.teleopInput.driverInput.HumanInput;

public class CubeCollected extends TimedCommand{

    private HumanInput input;

    public CubeCollected(HumanInput humanInput) {
        super(0.5);
        this.input = humanInput;
    }

    @Override
    protected void execute() {
        super.execute();
        input.rumbleOperator(0.5);
        input.rumbleDriver(0.5);
    }

    @Override
    protected void end() {
        super.end();
        input.rumbleOperator(0);
        input.rumbleDriver(0);
    }
}
