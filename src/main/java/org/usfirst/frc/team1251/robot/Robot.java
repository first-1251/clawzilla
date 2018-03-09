package org.usfirst.frc.team1251.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1251.robot.commands.*;
import org.usfirst.frc.team1251.robot.mechanisms.Arm;
import org.usfirst.frc.team1251.robot.mechanisms.Claw;
import org.usfirst.frc.team1251.robot.mechanisms.Collector;
import org.usfirst.frc.team1251.robot.mechanisms.Elevator;
import org.usfirst.frc.team1251.robot.subsystems.*;
import org.usfirst.frc.team1251.robot.teleopInput.driverInput.HumanInput;
import org.usfirst.frc.team1251.robot.teleopInput.gamepad.GamePad;
import org.usfirst.frc.team1251.robot.teleopInput.gamepad.ModernGamePad;
import org.usfirst.frc.team1251.robot.teleopInput.triggers.Always;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;
import org.usfirst.frc.team1251.robot.virtualSensors.CrateDetector;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;
import org.usfirst.frc.team1251.robot.virtualSensors.ElevatorPosition;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    //private PowerDistributionPanel pdp;
    private DriveTrain driveTrain;


    //public static final DriveTrain driveTrain = new DriveTrain();

    private Command autonomousCommand;
    private SendableChooser chooser;
    private DriveFeedback driveFeedback;
    private TeleopDrive teleopDriveCmd;
    private DriveTrainAutoShift driveTrainAutoShift;
    private DriveTrainShifter driveTrainShifter;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {

        // Set up driver input
        GamePad driverGamePad = new ModernGamePad(new Joystick(0));
        GamePad crateGamePad = new ModernGamePad(new Joystick(1));

        HumanInput humanInput = new HumanInput(driverGamePad, crateGamePad);

        SmartDashboard.putBoolean("Reset Encoders", false);

        // Create virtual sensors (used by mechanisms, subsystems and commands)
        ArmPosition armPosition = new ArmPosition();
        ElevatorPosition elevatorPosition = new ElevatorPosition();
        CrateDetector crateDetector = new CrateDetector();
        DriveFeedback driveFeedback = new DriveFeedback();

        // Create mechanisms (used by subsystems)
        Arm arm = new Arm(armPosition);
        Elevator elevator = new Elevator(elevatorPosition);
        Collector collector = new Collector();
        Claw claw = new Claw();

        // Create subsystems (used by commands)
        // Use `DeferredCmdSupplier` to handle the chicken/egg problem with default commands
        DeferredCmdSupplier<Command> armevatorDefaultCmdSupplier = new DeferredCmdSupplier<>();
        Armevator armevator = new Armevator(elevator, arm, armevatorDefaultCmdSupplier);

        // We will never provide a default command to be used during initialization for the DriveTrain or the
        // DriveTrainShifter -- we will set it manually when tele-op initializes. Feed in an empty command supplier.
        DriveTrain driveTrain = new DriveTrain(new DeferredCmdSupplier<>());

        // We will never provide a default command to be used during initialization for the DriveTrainShifter -- we will
        // set it manually when tele-op initializes. Feed in an empty command supplier.
        DriveTrainShifter driveTrainShifter = new DriveTrainShifter(new DeferredCmdSupplier<>());

        Clawlector clawlector = new Clawlector(claw, collector);

        // Create commands
        CollectCrate collectCrate = new CollectCrate(crateDetector, clawlector);
        MoveArmevator moveArmevator = new MoveArmevator(humanInput, armevator);
        TeleopDrive teleopDrive = new TeleopDrive(humanInput, driveTrain, driveFeedback);
        DriveTrainAutoShift driveTrainAutoShift = new DriveTrainAutoShift(driveFeedback, driveTrainShifter);
        ShiftDriveTrain shiftDriveTrainUp = new ShiftDriveTrain(driveTrainShifter, DriveTrainShifter.Gear.HIGH);
        ShiftDriveTrain shiftDriveTrainDown = new ShiftDriveTrain(driveTrainShifter, DriveTrainShifter.Gear.LOW);

        // Assign default commands
        armevatorDefaultCmdSupplier.set(moveArmevator);

        // assign driver-initiated command triggers.
        humanInput.attachCommandTriggers(collectCrate, shiftDriveTrainUp, shiftDriveTrainDown);


        // Uncomment to test a controller on port 5
        //initGamepadTest();

        // TODO: Do we need a chooser?
        // chooser = new SendableChooser();
        // chooser.addDefault("Default Auto", new MoveElevator());
//        chooser.addObject("My Auto", new MyAutoCommand());
        // SmartDashboard.putData("Auto mode", chooser);

        this.driveFeedback = driveFeedback;

        this.driveTrain = driveTrain;
        this.driveTrainShifter = driveTrainShifter;

        this.teleopDriveCmd = teleopDrive;
        this.driveTrainAutoShift = driveTrainAutoShift;

    }

    private void initGamepadTest() {
        Trigger trigger = new Always();
        trigger.whileActive(new TestGamepad());
    }


    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    public void disabledInit() {

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
     * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
     * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
     * below the Gyro
     * <p>
     * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
     * or additional comparisons to the switch structure below with additional strings & commands.
     */
    public void autonomousInit() {
        this.driveTrain.setDefaultCommand(null);
        this.driveTrainShifter.setDefaultCommand(null);
        CrossLineAuto crossLineAuto = new CrossLineAuto(driveTrain, driveFeedback, this.driveTrainShifter);
        crossLineAuto.start();
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
        this.driveTrain.setDefaultCommand(this.teleopDriveCmd);
        //this.driveTrainShifter.setDefaultCommand(this.driveTrainAutoShift);
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