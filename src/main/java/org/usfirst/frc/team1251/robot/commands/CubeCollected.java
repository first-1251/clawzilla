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
        input.operatorGamePad.rumbleLeft(0.5);
        input.operatorGamePad.rumbleRight(0.5);

        input.driverGamePad.rumbleLeft(0.5);
        input.driverGamePad.rumbleRight(0.5);
    }

    @Override
    protected void end() {
        super.end();
        input.operatorGamePad.rumbleLeft(0);
        input.operatorGamePad.rumbleRight(0);

        input.driverGamePad.rumbleLeft(0);
        input.driverGamePad.rumbleRight(0);
    }
}
