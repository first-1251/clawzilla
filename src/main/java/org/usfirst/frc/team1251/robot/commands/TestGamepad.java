package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.Robot;
import org.usfirst.frc.team1251.robot.teleopInput.gamepad.GamePad;
import org.usfirst.frc.team1251.robot.teleopInput.gamepad.ModernGamePad;

public class TestGamepad extends Command
{
    private final GamePad gamePad;

    public TestGamepad()
    {
        this.gamePad = new ModernGamePad(new Joystick(5));
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void execute()
    {
        //System.out.println("IM RUNNING BOYZ");

        if (this.gamePad.a().isPressed())
        {
            System.out.println("A is Pressed");
        }
        if (this.gamePad.b().isPressed())
        {
            System.out.println("B is Pressed");
        }
        if (this.gamePad.x().isPressed())
        {
            System.out.println("X is Pressed");
        }
        if (this.gamePad.y().isPressed())
        {
            System.out.println("Y is Pressed");
        }
        if (this.gamePad.rb().isPressed())
        {
            System.out.println("RB is Pressed");
        }
        if (this.gamePad.lb().isPressed())
        {
            System.out.println("LB is Pressed");
        }
        if (this.gamePad.rsClick().isPressed())
        {
            System.out.println("RS is Pressed");
        }
        if (this.gamePad.lsClick().isPressed())
        {
            System.out.println("LS is Pressed");
        }
        if (this.gamePad.start().isPressed())
        {
            System.out.println("START is Pressed");
        }
        if (this.gamePad.select().isPressed())
        {
            System.out.println("SELECT is Pressed");
        }
        if (this.gamePad.lt().isPressed())
        {
            System.out.println("LT is Pressed " + this.gamePad.lt().getValue());
            System.out.println("LT Deadzone .75 " + this.gamePad.lt().getValue(.75) );
        }
        if (this.gamePad.rt().isPressed())
        {
            System.out.println("RT is Pressed " + this.gamePad.rt().getValue());
            System.out.println("RT Deadzone .75 " + this.gamePad.rt().getValue(.75));
        }
        /**
        if (this.gamePad.ls().getVertical() < 0.0 || this.gamePad.ls().getHorizontal() > 0.0)
        {
            System.out.println("LS Vertical Value " + this.gamePad.ls().getVertical());
            System.out.println("LS Vertical Deadzone .25 " + this.gamePad.ls().getVertical(.25));
        }

        if (this.gamePad.ls().getHorizontal() != 0)
        {
            System.out.println("LS Vertical Value " + this.gamePad.ls().getVertical());
            System.out.println("LS Vertical Deadzone .25 " + this.gamePad.ls().getVertical(.25));
        }
        if (this.gamePad.rs().getVertical() != 0)
        {
            System.out.println("RS Vertical Value " + this.gamePad.rs().getHorizontal());
            System.out.println("RS Vertical Deadzone .25 " + this.gamePad.ls().getHorizontal(.25));
        }
        if (this.gamePad.rs().getHorizontal() != 0)
        {
            System.out.println("RS Horizontal Value " + this.gamePad.rs().getHorizontal());
            System.out.println("RS Horizontal Deadzone .25 " + this.gamePad.rs().getHorizontal(.25));
         }
         **/

    }


}
