package org.usfirst.frc.team1251.robot.teleopInput.gamepad;

import edu.wpi.first.wpilibj.GenericHID;

public class ModernGamePad extends GamePad {

    private final GenericHID rawDevice;

    public ModernGamePad(GenericHID rawDevice) {

        this.rawDevice = rawDevice;

        this.A = new DigitalButton(0, rawDevice);
        this.B = new DigitalButton(1, rawDevice);
        this.X = new DigitalButton(2, rawDevice);
        this.Y = new DigitalButton(3, rawDevice);
        this.LB = new DigitalButton(4, rawDevice);
        this.RB = new DigitalButton(5, rawDevice);
        this.Select = new DigitalButton(6, rawDevice);
        this.Start = new DigitalButton(7, rawDevice);
        this.RSClick = new DigitalButton(8, rawDevice);
        this.LSClick = new DigitalButton(9, rawDevice);

        this.LT = new AnalogTriggerButton(2, rawDevice);
        this.RT = new AnalogTriggerButton(3,rawDevice);

        this.LS = new Stick(0, 1, rawDevice);
        this.RS = new Stick(2, 3, rawDevice);
    }

    @Override
    public void rumbleLeft(double value) {
        this.rawDevice.setRumble(GenericHID.RumbleType.kLeftRumble, value);
    }

    @Override
    public void rumbleRight(double value) {
        this.rawDevice.setRumble(GenericHID.RumbleType.kRightRumble, value);
    }
}
