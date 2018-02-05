package org.usfirst.frc.team1251.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1251.robot.commands.ExampleCommand;
import org.usfirst.frc.team1251.robot.commands.TestCommand;
import org.usfirst.frc.team1251.robot.commands.TestTimedCommand;
import org.usfirst.frc.team1251.robot.subsystems.ControllerTestBed;
import org.usfirst.frc.team1251.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team1251.robot.teleopInput.gamepad.ModernGamePad;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    public static final ControllerTestBed testSubsystem = new ControllerTestBed("Test Subsystem");

    public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
    public static OI oi;

    Command autonomousCommand;
    SendableChooser chooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        oi = new OI(new ModernGamePad(new Joystick(0)));

        // Use this for checking controller mappings.
        // this.addListenersForButtonTests();

        // Use this for checking behavior of various controller event combinations.
        // this.addListenersForEventTests();

        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", new ExampleCommand());
//        chooser.addObject("My Auto", new MyAutoCommand());
        SmartDashboard.putData("Auto mode", chooser);

    }

    private void addListenersForButtonTests() {
        oi.xListener.whileHeld(new TestCommand(testSubsystem, "X", true));
        oi.yListener.whileHeld(new TestCommand(testSubsystem, "Y", true));
        oi.aListener.whileHeld(new TestCommand(testSubsystem, "A", true));
        oi.bListener.whileHeld(new TestCommand(testSubsystem, "B", true));
        oi.rtListener.whileHeld(new TestCommand(testSubsystem, "RT", true));
        oi.ltListener.whileHeld(new TestCommand(testSubsystem, "LT", true));
        oi.rbListener.whileHeld(new TestCommand(testSubsystem, "RB", true));
        oi.lbListener.whileHeld(new TestCommand(testSubsystem, "LB", true));
        oi.rsClickListener.whileHeld(new TestCommand(testSubsystem, "RS-Click", true));
        oi.lsClickListener.whileHeld(new TestCommand(testSubsystem, "LS-Click", true));
        oi.startListener.whileHeld(new TestCommand(testSubsystem, "Start", true));
        oi.selectListener.whileHeld(new TestCommand(testSubsystem, "Select", true));
    }

    private void addListenersForEventTests() {

        // A command that runs forever, but yields to other commands that want to use its subsystem.
        Command politeCommand = new TestCommand(testSubsystem, "politeCommand", true);

        // A command that runs for only 5 seconds, but refuses to yield to other commands.
        Command stubbornCommand = new TestTimedCommand(testSubsystem, "stubbornCommand", 5, false);

        // A command that runs for 60 seconds but can be interrupted.
        Command longCommand = new TestTimedCommand(testSubsystem, "timedCommand", 60, true);


        // Test 1: Start/stop with buttons.
        //   Press X (See that politeCommand is running)
        //   Press Y (See that politeCommand has stopped)
        oi.xListener.whenPressed(politeCommand);
        oi.yListener.cancelWhenPressed(politeCommand);

        // Test 2: Timed run
        //   Press A (See that "stubbornCommand" runs for 5 seconds, then stops)
        oi.aListener.whenPressed(stubbornCommand);


        // Test 3: Interrupt
        //   Press X (See that politeCommand is running)
        //   Press A (See that politeCommand is interrupted, stubbornCommand takes over)

        // Test 3: No Interrupt
        // TODO-discover: Will "politeCommand" run after stubborn finishes? (Hypothesis: no)
        //    Press A (See that "stubbornCommand" runs)
        //    Press X (See that "stubbornCommand" continues to run)

        // Test 4: Toggle
        // TODO-discover: Does cancel supersede timeout (Hypothesis: yes)
        //    Press B (See that longCommand runs)
        //    Press B (See that longCommand stops)
        oi.bListener.toggleWhenPressed(longCommand);

        // Test 5: While Held
        //    Hold RB (See that "politeCommand" runs)
        //    Release RB (See that "politeCommand" stops)
        oi.rbListener.whileHeld(politeCommand);

        // Test 6: When Released
        //   Hold LB (See that nothing happens)
        //   Release LB (See that "stubbornCommand" runs)
        oi.lbListener.whenReleased(politeCommand);
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    public void disabledInit(){

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
     * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
     * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
     * below the Gyro
     *
     * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
     * or additional comparisons to the switch structure below with additional strings & commands.
     */
    public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();

		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */

        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
