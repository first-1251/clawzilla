package org.usfirst.frc.team1251.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import org.usfirst.frc.team1251.robot.teleopInput.gamepad.GamePad;
import org.usfirst.frc.team1251.robot.teleopInput.triggers.GamePadButtonTrigger;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    // TODO: stop using this.
    public static final Joystick stick = new Joystick(0);

    public final GamePad driverPad;
    public final GamePad operatorPad;
    public final Button xListener;
    public final Button yListener;
    public final Button aListener;
    public final Button bListener;
    public final Button ltListener;
    public final Button rtListener;
    public final Button lbListener;
    public final Button rbListener;
    public final Button rsClickListener;
    public final Button lsClickListener;
    public final Button startListener;
    public final Button selectListener;

    public OI(GamePad driverPad, GamePad operatorPad) {
        this.driverPad = driverPad;
        this.operatorPad = operatorPad;

        this.xListener = new GamePadButtonTrigger(driverPad.x());
        this.yListener = new GamePadButtonTrigger(driverPad.y());
        this.aListener = new GamePadButtonTrigger(driverPad.a());
        this.bListener = new GamePadButtonTrigger(driverPad.b());
        this.ltListener = new GamePadButtonTrigger(driverPad.lt());
        this.rtListener = new GamePadButtonTrigger(driverPad.rt());
        this.lbListener = new GamePadButtonTrigger(driverPad.lb());
        this.rbListener = new GamePadButtonTrigger(driverPad.rb());
        this.rsClickListener = new GamePadButtonTrigger(driverPad.rsClick());
        this.lsClickListener = new GamePadButtonTrigger(driverPad.lsClick());
        this.startListener = new GamePadButtonTrigger(driverPad.start());
        this.selectListener = new GamePadButtonTrigger(driverPad.select());
    }

    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new MoveElevator());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new MoveElevator());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new MoveElevator());
}
