package org.usfirst.frc.team1251.robot;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.MotorSafety;

/**
 * This class uses mostly Team254's code from their factory in their 2017 code.
 * This class is updated for the 2018 libraries, and allows VictorSPXs to be constructed as well as TalonSRXs
 */
public class MotorFactory {

    //private static final double SPEED_COMPENSATION_MULTIPLER = 0.66;
    public static class Configuration {
        public boolean LIMIT_SWITCH_NORMALLY_OPEN = true;
        public boolean ENABLE_VOLTAGE_LIMIT = true;
        public double MAX_OUTPUT_VOLTAGE = 9;
        public double NOMINAL_VOLTAGE = 0;
        public double PEAK_VOLTAGE = 9;
        public NeutralMode ENABLE_BRAKE = NeutralMode.Coast;
        public boolean ENABLE_CURRENT_LIMIT = false;
        public boolean ENABLE_SOFT_LIMIT = false;
        public boolean ENABLE_LIMIT_SWITCH = false;
        public int CURRENT_LIMIT = 0;
        public double EXPIRATION_TIMEOUT_SECONDS = MotorSafety.DEFAULT_SAFETY_EXPIRATION;
        public int FORWARD_SOFT_LIMIT = 0;
        public boolean INVERTED = false;
        public double NOMINAL_CLOSED_LOOP_VOLTAGE = 9;
        public int REVERSE_SOFT_LIMIT = 0;
        public boolean SAFETY_ENABLED = false;

        public int CONTROL_FRAME_PERIOD_MS = 5;
        public int MOTION_CONTROL_FRAME_PERIOD_MS = 5;
        public int GENERAL_STATUS_FRAME_RATE_MS = 5;
        public int FEEDBACK_STATUS_FRAME_RATE_MS = 5;
        public int QUAD_ENCODER_STATUS_FRAME_RATE_MS = 5;
        public int ANALOG_TEMP_VBAT_STATUS_FRAME_RATE_MS = 5;
        public int PULSE_WIDTH_STATUS_FRAME_RATE_MS = 5;

        public VelocityMeasPeriod VELOCITY_MEASUREMENT_PERIOD = VelocityMeasPeriod.Period_100Ms;
        public int VELOCITY_MEASUREMENT_ROLLING_AVERAGE_WINDOW = 64;

        //public double VOLTAGE_COMPENSATION_RAMP_RATE = 0;
        public double RAMP_TIME = 0.5;
    }

    public static final Configuration kDefaultConfiguration = new Configuration();
    public static final Configuration kSlaveConfiguration = new Configuration();

    static {
        kSlaveConfiguration.CONTROL_FRAME_PERIOD_MS = 1000;
        kSlaveConfiguration.MOTION_CONTROL_FRAME_PERIOD_MS = 1000;
        kSlaveConfiguration.GENERAL_STATUS_FRAME_RATE_MS = 1000;
        kSlaveConfiguration.FEEDBACK_STATUS_FRAME_RATE_MS = 1000;
        kSlaveConfiguration.QUAD_ENCODER_STATUS_FRAME_RATE_MS = 1000;
        kSlaveConfiguration.ANALOG_TEMP_VBAT_STATUS_FRAME_RATE_MS = 1000;
        kSlaveConfiguration.PULSE_WIDTH_STATUS_FRAME_RATE_MS = 1000;
    }

    public static TalonSRX createTalon(int id, Configuration config) {
        TalonSRX talonSRX = new TalonSRX(id);
        talonSRX.set(ControlMode.Current, 0);
        talonSRX.changeMotionControlFramePeriod(config.MOTION_CONTROL_FRAME_PERIOD_MS);
        talonSRX.setIntegralAccumulator(0, 0, 0);
        talonSRX.clearMotionProfileHasUnderrun(0);
        talonSRX.clearMotionProfileTrajectories();
        talonSRX.clearStickyFaults(0);
        talonSRX.enableVoltageCompensation(config.ENABLE_VOLTAGE_LIMIT);
        talonSRX.configVoltageCompSaturation(config.MAX_OUTPUT_VOLTAGE, 0);
        talonSRX.setNeutralMode(config.ENABLE_BRAKE);
        talonSRX.enableCurrentLimit(config.ENABLE_CURRENT_LIMIT);
        talonSRX.configForwardSoftLimitEnable(config.ENABLE_SOFT_LIMIT, 0);
        talonSRX.configReverseSoftLimitEnable(config.ENABLE_SOFT_LIMIT, 0);
        talonSRX.setSensorPhase(false);
        talonSRX.configContinuousCurrentLimit(config.CURRENT_LIMIT, 0);
        talonSRX.configForwardSoftLimitThreshold(config.FORWARD_SOFT_LIMIT, 0);
        talonSRX.setInverted(config.INVERTED);
        talonSRX.selectProfileSlot(0, 0);
        talonSRX.configReverseSoftLimitThreshold(config.REVERSE_SOFT_LIMIT, 0);
        talonSRX.configVelocityMeasurementPeriod(config.VELOCITY_MEASUREMENT_PERIOD, 0);
        talonSRX.configVelocityMeasurementWindow(config.VELOCITY_MEASUREMENT_ROLLING_AVERAGE_WINDOW, 0);
        talonSRX.configOpenloopRamp(config.RAMP_TIME, 0);
        talonSRX.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);

        talonSRX.setStatusFramePeriod(StatusFrameEnhanced.Status_1_General, config.GENERAL_STATUS_FRAME_RATE_MS, 0);
        talonSRX.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, config.FEEDBACK_STATUS_FRAME_RATE_MS, 0);
        talonSRX.setStatusFramePeriod(StatusFrameEnhanced.Status_3_Quadrature, config.QUAD_ENCODER_STATUS_FRAME_RATE_MS, 0);
        talonSRX.setStatusFramePeriod(StatusFrameEnhanced.Status_4_AinTempVbat,
                config.ANALOG_TEMP_VBAT_STATUS_FRAME_RATE_MS, 0);
        talonSRX.setStatusFramePeriod(StatusFrameEnhanced.Status_8_PulseWidth, config.PULSE_WIDTH_STATUS_FRAME_RATE_MS, 0);

        return talonSRX;
    }

    public static TalonSRX initLeftDriveMotors() {
        TalonSRX master = createTalon(RobotMap.LEFT_MASTER_MOTOR_ID, kDefaultConfiguration);
        master.setInverted(true); // backwards

        //master.configVoltageCompSaturation(kDefaultConfiguration.MAX_OUTPUT_VOLTAGE * SPEED_COMPENSATION_MULTIPLER, 0);

        VictorSPX leftMotor1 = createVictor(RobotMap.LEFT_SLAVE_MOTOR1_ID, kSlaveConfiguration);
        VictorSPX leftMotor2 = createVictor(RobotMap.LEFT_SLAVE_MOTOR2_ID, kSlaveConfiguration);
        VictorSPX leftMotor3 = createVictor(RobotMap.LEFT_SLAVE_MOTOR3_ID, kSlaveConfiguration);

        leftMotor1.setInverted(true);
        leftMotor2.setInverted(true);
        leftMotor3.setInverted(true);

        leftMotor1.follow(master);
        leftMotor2.follow(master);
        leftMotor3.follow(master);



        return master;
    }

    public static TalonSRX initRightDriveMotors() {
        TalonSRX master = createTalon(RobotMap.RIGHT_MASTER_MOTOR_ID, kDefaultConfiguration);

        VictorSPX rightMotor1 = createVictor(RobotMap.RIGHT_SLAVE_MOTOR1_ID, kSlaveConfiguration);
        VictorSPX rightMotor2 = createVictor(RobotMap.RIGHT_SLAVE_MOTOR2_ID, kSlaveConfiguration);
        VictorSPX rightMotor3 = createVictor(RobotMap.RIGHT_SLAVE_MOTOR3_ID, kSlaveConfiguration);

        rightMotor1.follow(master);
        rightMotor2.follow(master);
        rightMotor3.follow(master);

        return master;
    }

    public static VictorSPX createVictor(int id, Configuration config) {
        VictorSPX victorSPX = new VictorSPX(id);
        victorSPX.set(ControlMode.Current, 0);
        victorSPX.changeMotionControlFramePeriod(config.MOTION_CONTROL_FRAME_PERIOD_MS);
        victorSPX.setIntegralAccumulator(0, 0, 0);
        victorSPX.clearMotionProfileHasUnderrun(0);
        victorSPX.clearMotionProfileTrajectories();
        victorSPX.clearStickyFaults(0);
        victorSPX.configVoltageCompSaturation(config.MAX_OUTPUT_VOLTAGE, 0);
        victorSPX.setNeutralMode(config.ENABLE_BRAKE);

        // Victor SPX can't do this
        //victorSPX.enableCurrentLimit(config.ENABLE_CURRENT_LIMIT);

        victorSPX.configForwardSoftLimitEnable(config.ENABLE_SOFT_LIMIT, 0);
        victorSPX.configReverseSoftLimitEnable(config.ENABLE_SOFT_LIMIT, 0);
        victorSPX.setSensorPhase(false);

        // Victor SPX can't do this
        //victorSPX.configContinuousCurrentLimit(config.CURRENT_LIMIT, 0);

        victorSPX.configForwardSoftLimitThreshold(config.FORWARD_SOFT_LIMIT, 0);
//        victorSPX.setInverted(config.INVERTED);
        victorSPX.selectProfileSlot(0, 0);
        victorSPX.configReverseSoftLimitThreshold(config.REVERSE_SOFT_LIMIT, 0);
        victorSPX.configVelocityMeasurementPeriod(config.VELOCITY_MEASUREMENT_PERIOD, 0);
        victorSPX.configVelocityMeasurementWindow(config.VELOCITY_MEASUREMENT_ROLLING_AVERAGE_WINDOW, 0);
        victorSPX.configOpenloopRamp(config.RAMP_TIME, 0);

        victorSPX.setStatusFramePeriod(StatusFrame.Status_1_General, config.GENERAL_STATUS_FRAME_RATE_MS, 0);
        victorSPX.setStatusFramePeriod(StatusFrame.Status_2_Feedback0, config.FEEDBACK_STATUS_FRAME_RATE_MS, 0);

        // Victor SPX can't do this
        //victorSPX.setStatusFramePeriod(StatusFrame.Status_3_Quadrature, config.QUAD_ENCODER_STATUS_FRAME_RATE_MS, 0);

        victorSPX.setStatusFramePeriod(StatusFrame.Status_4_AinTempVbat,
                config.ANALOG_TEMP_VBAT_STATUS_FRAME_RATE_MS, 0);

        // Victor SPX can't do this
        //victorSPX.setStatusFramePeriod(StatusFrame.Status_8_PulseWidth, config.PULSE_WIDTH_STATUS_FRAME_RATE_MS, 0);

        return victorSPX;
    }
}