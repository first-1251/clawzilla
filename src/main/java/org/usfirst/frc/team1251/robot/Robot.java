package org.usfirst.frc.team1251.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import org.usfirst.frc.team1251.robot.commands.*;
import org.usfirst.frc.team1251.robot.mechanisms.Arm;
import org.usfirst.frc.team1251.robot.mechanisms.Claw;
import org.usfirst.frc.team1251.robot.mechanisms.Collector;
import org.usfirst.frc.team1251.robot.mechanisms.Elevator;
import org.usfirst.frc.team1251.robot.subsystems.Armevator;
import org.usfirst.frc.team1251.robot.subsystems.Clawlector;
import org.usfirst.frc.team1251.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1251.robot.teleopInput.driverInput.DriverInput;
import org.usfirst.frc.team1251.robot.teleopInput.gamepad.GamePad;
import org.usfirst.frc.team1251.robot.teleopInput.gamepad.ModernGamePad;
import org.usfirst.frc.team1251.robot.teleopInput.triggers.Always;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;
import org.usfirst.frc.team1251.robot.virtualSensors.CrateDetector;
import org.usfirst.frc.team1251.robot.virtualSensors.ElevatorPosition;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    /**
     * @deprecated Use driverInput property instead (todo: add `driverInput` property)
     */
    public static OI oi;



    //public static final DriveTrain driveTrain = new DriveTrain();

    private Command autonomousCommand;
    private SendableChooser chooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {

        // Set up driver input
        GamePad driverGamePad =  new ModernGamePad(new Joystick(0));
        GamePad crateGamePad =  new ModernGamePad(new Joystick(1));

        DriverInput driverInput = new DriverInput(driverGamePad, crateGamePad);

        // TODO: Remove after all references are cleaned up.
        oi = new OI(driverGamePad, crateGamePad);


        // Create virtual sensors (used by mechanisms, subsystems and commands)
        ArmPosition armPosition = new ArmPosition();
        ElevatorPosition elevatorPosition = new ElevatorPosition();
        CrateDetector crateDetector = new CrateDetector();

        // Create mechanisms (used by subsystems)
        Arm arm = new Arm(armPosition);
        Elevator elevator = new Elevator(elevatorPosition);
        Collector collector = new Collector();
        Claw claw = new Claw();

        // Create subsystems (used by commands)
        // Use `DeferredCmdSupplier` to handle the chicken/egg problem with default commands
        DeferredCmdSupplier<Command> armevatorDefaultCmdSupplier = new DeferredCmdSupplier<>();
        Armevator armevator = new Armevator(elevator, arm, armevatorDefaultCmdSupplier);

        DeferredCmdSupplier<Command> driveTrainDefaultCmdSupplier = new DeferredCmdSupplier<>();
        DriveTrain driveTrain = new DriveTrain(driveTrainDefaultCmdSupplier);

        Clawlector clawlector = new Clawlector(claw, collector);

        // Create commands
        CollectCrate collectCrate = new CollectCrate(crateDetector, clawlector);
        MoveArm moveArm = new MoveArm(oi.operatorPad, armevator);
        MoveElevator moveElevator = new MoveElevator(armevator, OI.stick);
        TeleopDrive teleopDrive = new TeleopDrive(oi.driverPad, driveTrain);

        // Assign default commands
        armevatorDefaultCmdSupplier.set(moveArm);
        driveTrainDefaultCmdSupplier.set(teleopDrive);

        // assign driver-initiated command triggers.
        driverInput.attachCommandTriggers(collectCrate);


        // Uncomment to test a controller on port 5
        //initGamepadTest();

        // TODO: Do we need a chooser?
        // chooser = new SendableChooser();
        // chooser.addDefault("Default Auto", new MoveElevator());
//        chooser.addObject("My Auto", new MyAutoCommand());
        // SmartDashboard.putData("Auto mode", chooser);
    }

    private void initGamepadTest()
    {
        Trigger trigger = new Always();
        trigger.whileActive(new TestGamepad());
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
			autonomousCommand = new MoveElevator();
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
