package org.usfirst.frc.team1251.robot.teleopInput.gamepad;

import edu.wpi.first.wpilibj.GenericHID;

public class LegacyGamePad extends GamePad {

    public LegacyGamePad(GenericHID rawDevice) {
        this.A = new DigitalButton(1, rawDevice);
        this.B = new DigitalButton(2, rawDevice);
        this.X = new DigitalButton(0, rawDevice);
        this.Y = new DigitalButton(3, rawDevice);
        this.LB = new DigitalButton(4, rawDevice);
        this.RB = new DigitalButton(5, rawDevice);
        this.Select = new DigitalButton(8, rawDevice);
        this.Start = new DigitalButton(9, rawDevice);
        this.RSClick = new DigitalButton(10, rawDevice);
        this.LSClick = new DigitalButton(11, rawDevice);
        this.LT = new DigitalTriggerButton(6, rawDevice);
        this.RT = new DigitalTriggerButton(7, rawDevice);

        this.LS = new Stick(0, 1, rawDevice);
        this.RS = new Stick(2, 3, rawDevice);
    }

    @Override
    public void rumbleLeft(double value) {
        // No rumble support.
    }

    @Override
    public void rumbleRight(double value) {
        // No rumble support.
    }
}
