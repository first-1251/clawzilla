package org.usfirst.frc.team1251.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1251.robot.MotorFactory;
import org.usfirst.frc.team1251.robot.commands.DeferredCmdSupplier;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;

// Talon SRX software manual:
// https://docs.google.com/viewerng/viewer?url=https://link.vex.com/vexpro/pdf/217-8080-Talon-SRX-Software-Reference-Manual
// Victor SPX is mostly the same as that
public class DriveTrain extends Subsystem {

    //PID Values for Drivetrain
    private final double K_P_LEFT = 0.25;
    private final double K_P_RIGHT = 0.25;
    private final double K_I = 0;
    private final double K_D = 100;
    private final double K_F = 0;

    public static final DoubleSolenoid.Value LOW_GEAR = DoubleSolenoid.Value.kReverse;
    public static final DoubleSolenoid.Value HIGH_GEAR = DoubleSolenoid.Value.kForward;

    private final DeferredCmdSupplier<Command> defaultCommand;

    private TalonSRX leftMasterMotor;

    private TalonSRX rightMasterMotor;

    private DoubleSolenoid gearShifter;

    private DriveFeedback driveFeedback;

    private int rightTargetPosition;
    private int leftTargetPosition;

    public DriveTrain(DeferredCmdSupplier<Command> defaultCommand, DriveFeedback driveFeedback) {
        this.driveFeedback = driveFeedback;
        this.defaultCommand = defaultCommand;

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

        rightMasterMotor.config_kP(0, K_P_RIGHT, 0);
        rightMasterMotor.config_kI(0, K_I, 0);
        rightMasterMotor.config_kD(0, K_D, 0);
        rightMasterMotor.config_kF(0, K_F, 0);

        SmartDashboard.putBoolean("Reset Encoders", false);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(this.defaultCommand.get());
    }

    public void setTargetPosition(int left, int right) {

        // Store positions in local properties so we don't have to dig them out of the controllers later.
        leftTargetPosition = left;
        rightTargetPosition = right;

        leftMasterMotor.set(ControlMode.Position, left);
        rightMasterMotor.set(ControlMode.Position, right);
    }

    public int getLeftTargetPosition() {
        return leftTargetPosition;
    }

    public int getRightTargetPosition() {
        return rightTargetPosition;
    }

    public void setSpeed(double left, double right) {
        leftMasterMotor.set(ControlMode.PercentOutput, left);
        rightMasterMotor.set(ControlMode.PercentOutput, right);
    }

    public void setGearShifter(DoubleSolenoid.Value shifting) {
        gearShifter.set(shifting);
    }

    @Override
    public void periodic() {
        driveFeedback.updateSensorData();
    }
}
