package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import org.usfirst.frc.team1251.robot.teleopInput.driverInput.HumanInput;

public class CubeCollected extends TimedCommand{

    private HumanInput input;

    public CubeCollected(HumanInput humanInput) {
        super(1);
        this.input = humanInput;
    }

    @Override
    protected void execute() {
        super.execute();
        input.rumbleOperator(1);
        input.rumbleDriver(1);
    }

    @Override
    protected void end() {
        super.end();
        input.rumbleOperator(0);
        input.rumbleDriver(0);
    }
}
