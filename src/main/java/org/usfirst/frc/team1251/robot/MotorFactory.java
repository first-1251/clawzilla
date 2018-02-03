package org.usfirst.frc.team1251.robot;

import com.ctre.CANTalon;
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.MotorSafety;

public class MotorFactory {

    public static class Configuration {
        public boolean LIMIT_SWITCH_NORMALLY_OPEN = true;
        public double MAX_OUTPUT_VOLTAGE = 9;
        public double NOMINAL_VOLTAGE = 0;
        public double PEAK_VOLTAGE = 9;
        public NeutralMode ENABLE_BRAKE = NeutralMode.Brake;
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
        public int MOTION_CONTROL_FRAME_PERIOD_MS = 100;
        public int GENERAL_STATUS_FRAME_RATE_MS = 5;
        public int FEEDBACK_STATUS_FRAME_RATE_MS = 100;
        public int QUAD_ENCODER_STATUS_FRAME_RATE_MS = 100;
        public int ANALOG_TEMP_VBAT_STATUS_FRAME_RATE_MS = 100;
        public int PULSE_WIDTH_STATUS_FRAME_RATE_MS = 100;

        public VelocityMeasPeriod VELOCITY_MEASUREMENT_PERIOD = VelocityMeasPeriod.Period_100Ms;
        public int VELOCITY_MEASUREMENT_ROLLING_AVERAGE_WINDOW = 64;

        public double VOLTAGE_COMPENSATION_RAMP_RATE = 0;
        public double VOLTAGE_RAMP_RATE = 0;
    }

    private static final Configuration kDefaultConfiguration = new Configuration();
    private static final Configuration kSlaveConfiguration = new Configuration();

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
        TalonSRX talon = new TalonSRX(id);
        talon.set(ControlMode.Current, 0);
        talon.changeMotionControlFramePeriod(config.MOTION_CONTROL_FRAME_PERIOD_MS);
        talon.setIntegralAccumulator(0, 0, 0);
        talon.clearMotionProfileHasUnderrun(0);
        talon.clearMotionProfileTrajectories();
        talon.clearStickyFaults(0);
        //talon.configForwardLimitSwitchSource(LimitSwitchSource.RemoteTalonSRXconfig.LIMIT_SWITCH_NORMALLY_OPEN);
        talon.configVoltageCompSaturation(config.MAX_OUTPUT_VOLTAGE, 0);
        //talon.ConfigRevLimitSwitchNormallyOpen(config.LIMIT_SWITCH_NORMALLY_OPEN);
        talon.setNeutralMode(config.ENABLE_BRAKE);
        talon.enableCurrentLimit(config.ENABLE_CURRENT_LIMIT);
        talon.configForwardSoftLimitEnable(config.ENABLE_SOFT_LIMIT, 0);
        //talon.enableLimitSwitch(config.ENABLE_LIMIT_SWITCH, config.ENABLE_LIMIT_SWITCH);
        talon.configReverseSoftLimitEnable(config.ENABLE_SOFT_LIMIT, 0);
        //talon.enableZeroSensorPositionOnForwardLimit(false);
        //talon.enableZeroSensorPositionOnIndex(false, false);
        //talon.enableZeroSensorPositionOnReverseLimit(false);
        //talon.reverseOutput(false);
        talon.setSensorPhase(false);
        //talon.setAnalogPosition(0);
        talon.configContinuousCurrentLimit(config.CURRENT_LIMIT, 0);
        //talon.setExpiration(config.EXPIRATION_TIMEOUT_SECONDS);
        talon.configForwardSoftLimitThreshold(config.FORWARD_SOFT_LIMIT, 0);
        talon.setInverted(config.INVERTED);
        //talon.setNominalClosedLoopVoltage(config.NOMINAL_CLOSED_LOOP_VOLTAGE);
        //talon.setPosition(0);
        //talon.setProfile(0);
        talon.selectProfileSlot(0, 0);
        talon.configReverseSoftLimitThreshold(config.REVERSE_SOFT_LIMIT, 0);
        //talon.setSafetyEnabled(config.SAFETY_ENABLED);
        talon.configVelocityMeasurementPeriod(config.VELOCITY_MEASUREMENT_PERIOD, 0);
        talon.configVelocityMeasurementWindow(config.VELOCITY_MEASUREMENT_ROLLING_AVERAGE_WINDOW, 0);
        talon.configClosedloopRamp(config.VOLTAGE_COMPENSATION_RAMP_RATE, 0);
        talon.configOpenloopRamp(config.VOLTAGE_RAMP_RATE, 0);

        talon.setStatusFramePeriod(StatusFrameEnhanced.Status_1_General, config.GENERAL_STATUS_FRAME_RATE_MS, 0);
        talon.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, config.FEEDBACK_STATUS_FRAME_RATE_MS, 0);
        talon.setStatusFramePeriod(StatusFrameEnhanced.Status_3_Quadrature, config.QUAD_ENCODER_STATUS_FRAME_RATE_MS, 0);
        talon.setStatusFramePeriod(StatusFrameEnhanced.Status_4_AinTempVbat,
                config.ANALOG_TEMP_VBAT_STATUS_FRAME_RATE_MS, 0);
        talon.setStatusFramePeriod(StatusFrameEnhanced.Status_8_PulseWidth, config.PULSE_WIDTH_STATUS_FRAME_RATE_MS, 0);

        return talon;
    }
}
