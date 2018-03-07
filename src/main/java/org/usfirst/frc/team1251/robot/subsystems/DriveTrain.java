package org.usfirst.frc.team1251.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1251.robot.MotorFactory;
import org.usfirst.frc.team1251.robot.RobotMap;
import org.usfirst.frc.team1251.robot.commands.DeferredCmdSupplier;

// Talon SRX software manual:
// https://docs.google.com/viewerng/viewer?url=https://link.vex.com/vexpro/pdf/217-8080-Talon-SRX-Software-Reference-Manual
// Victor SPX is mostly the same as that
public class DriveTrain extends Subsystem {

    //PID Values for Drivetrain
    // low gear
    //private final double K_P_LEFT = 0.38;
    //private final double K_P_RIGHT = 0.3975;
    // high gear
    private final double K_P_LEFT = 0.1105;
    private final double K_P_RIGHT = 0.1005;
    private final double K_I = 0;
    private final double K_D = 0.5;
    private final double K_F = 0;
    //private final double K_F_RIGHT = -.011;
    private final int K_INTERCEPT = 0;

    public static final DoubleSolenoid.Value LOW_GEAR = DoubleSolenoid.Value.kReverse;
    public static final DoubleSolenoid.Value HIGH_GEAR = DoubleSolenoid.Value.kForward;

    // Encoder ratio constants
    public static final double WHEEL_TO_ENCODER = 4.0 * 125.0; //gear ratio 4 to 1, 125 encoders ticks per wheel turn
    private final DeferredCmdSupplier<Command> defaultCommand;

    private TalonSRX leftMasterMotor;

    private TalonSRX rightMasterMotor;

    private ADXRS450_Gyro gyro;

    private DoubleSolenoid gearShifter;

    private int leftDistance;
    private int rightDistance;

    private int leftVelocity;
    private int rightVelocity;

    private ControlMode mode;

    public DriveTrain(DeferredCmdSupplier<Command> defaultCommand) {
        this.defaultCommand = defaultCommand;
        //setup solenoid
        gearShifter = new DoubleSolenoid(RobotMap.DRIVE_GEAR_SHIFT_PORT1, RobotMap.DRIVE_GEAR_SHIFT_PORT2);

        //create left motors
        leftMasterMotor = MotorFactory.initLeftDriveMotors();

        //create right motors
        rightMasterMotor = MotorFactory.initRightDriveMotors();

        //Setup encoders
        leftMasterMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0, 0);
        rightMasterMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0, 0);

        //Setup PIDF
        leftMasterMotor.config_kP(0, K_P_LEFT, 0);
        leftMasterMotor.config_kI(0, K_I, 0);
        leftMasterMotor.config_kD(0, K_D, 0);
        leftMasterMotor.config_kF(0, K_F, 0);

        rightMasterMotor.config_kP(0, K_P_LEFT, 0);
        rightMasterMotor.config_kI(0, K_I, 0);
        rightMasterMotor.config_kD(0, K_D, 0);
        rightMasterMotor.config_kF(0, K_F, 0);

        gyro = new ADXRS450_Gyro();

        SmartDashboard.putBoolean("Reset Encoders", false);
    }

    @Override
    public void periodic() {
        updateSensorData();
        SmartDashboard.putNumber("Left Encoder", leftDistance);
        SmartDashboard.putNumber("Right Encoder", rightDistance);
        SmartDashboard.putNumber("Gyro", gyro.getAngle());

        if (SmartDashboard.getBoolean("Reset Encoders", false)) {
            resetEncoders();
        }
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(this.defaultCommand.get());
    }

    public void enablePIDMode() {
        this.mode = ControlMode.Position;
    }

    public void enableMotionProfileMode() {
        this.mode = ControlMode.MotionMagic;
    }

    public void enableRegularMode() {
        this.mode = ControlMode.PercentOutput;
    }

    public ControlMode getMode() {
        return this.mode;
    }

    public void limitVoltage(double voltage) {
        rightMasterMotor.configVoltageCompSaturation(voltage, 0);
        leftMasterMotor.configVoltageCompSaturation(voltage, 0);
    }
    public void set(double value) {
        leftMasterMotor.set(mode, value);
        rightMasterMotor.set(mode, value);
    }

    public void set(double left, double right) {
        leftMasterMotor.set(mode, left);
        rightMasterMotor.set(mode, right);
    }

    public int getLeftDistance() {
        return this.leftDistance;
    }

    public int getRightDistance() {
        return this.rightDistance;
    }

    public int getLeftVelocity() {
        return this.leftVelocity;
    }

    public int getRightVelocity() {
        return this.rightVelocity;
    }

    public void updateSensorData() {
        this.leftDistance = leftMasterMotor.getSelectedSensorPosition(0);
        this.rightDistance = rightMasterMotor.getSelectedSensorPosition(0);

        this.leftVelocity = leftMasterMotor.getSelectedSensorVelocity(0);
        this.rightVelocity = rightMasterMotor.getSelectedSensorVelocity(0);
    }

    public DoubleSolenoid.Value getShiftState() {
        return gearShifter.get();
    }

    public void setGearShifter(DoubleSolenoid.Value shifting) {
        gearShifter.set(shifting);
    }

    public void resetEncoders() {
        System.out.println("E:" + leftMasterMotor.setSelectedSensorPosition(0, 0, 5).value);
        rightMasterMotor.setSelectedSensorPosition(0, 0, 5);
    }

    public boolean isPidComplete(double allowableError) {

        updateSensorData();
        if (leftDistance != 0) {
            System.out.println("Enc:" + leftDistance);
        }
        int left = leftDistance - leftMasterMotor.getClosedLoopTarget(0);
        int right = rightDistance - rightMasterMotor.getClosedLoopTarget(0);

        //if (((left + right) / 2.0) < allowableError) {
            System.out.println(left);
            System.out.println(right);
        System.out.println("LT: " + leftMasterMotor.getClosedLoopTarget(0));
        System.out.println("RT: " + rightMasterMotor.getClosedLoopTarget(0));
        //}

        left = Math.abs(left);
        right = Math.abs(right);

        //System.out.println((left + right) / 2.0);
        //return false;
        return ((left + right) / 2.0) < allowableError;
    }

    public double getAngle() {
        return gyro.getAngle();
    }
}
