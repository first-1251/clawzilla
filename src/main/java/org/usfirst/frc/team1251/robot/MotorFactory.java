package org.usfirst.frc.team1251.robot;

import com.ctre.CANTalon;
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
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
        TalonSRX talonSRX = new TalonSRX(id);
        talonSRX.set(ControlMode.Current, 0);
        talonSRX.changeMotionControlFramePeriod(config.MOTION_CONTROL_FRAME_PERIOD_MS);
        talonSRX.setIntegralAccumulator(0, 0, 0);
        talonSRX.clearMotionProfileHasUnderrun(0);
        talonSRX.clearMotionProfileTrajectories();
        talonSRX.clearStickyFaults(0);
        //talonSRX.configForwardLimitSwitchSource(LimitSwitchSource.RemoteTalonSRXconfig.LIMIT_SWITCH_NORMALLY_OPEN);
        talonSRX.configVoltageCompSaturation(config.MAX_OUTPUT_VOLTAGE, 0);
        //talonSRX.ConfigRevLimitSwitchNormallyOpen(config.LIMIT_SWITCH_NORMALLY_OPEN);
        talonSRX.setNeutralMode(config.ENABLE_BRAKE);
        talonSRX.enableCurrentLimit(config.ENABLE_CURRENT_LIMIT);
        talonSRX.configForwardSoftLimitEnable(config.ENABLE_SOFT_LIMIT, 0);
        //talonSRX.enableLimitSwitch(config.ENABLE_LIMIT_SWITCH, config.ENABLE_LIMIT_SWITCH);
        talonSRX.configReverseSoftLimitEnable(config.ENABLE_SOFT_LIMIT, 0);
        //talonSRX.enableZeroSensorPositionOnForwardLimit(false);
        //talonSRX.enableZeroSensorPositionOnIndex(false, false);
        //talonSRX.enableZeroSensorPositionOnReverseLimit(false);
        //talonSRX.reverseOutput(false);
        talonSRX.setSensorPhase(false);
        //talonSRX.setAnalogPosition(0);
        talonSRX.configContinuousCurrentLimit(config.CURRENT_LIMIT, 0);
        //talonSRX.setExpiration(config.EXPIRATION_TIMEOUT_SECONDS);
        talonSRX.configForwardSoftLimitThreshold(config.FORWARD_SOFT_LIMIT, 0);
        talonSRX.setInverted(config.INVERTED);
        //talonSRX.setNominalClosedLoopVoltage(config.NOMINAL_CLOSED_LOOP_VOLTAGE);
        //talonSRX.setPosition(0);
        //talonSRX.setProfile(0);
        talonSRX.selectProfileSlot(0, 0);
        talonSRX.configReverseSoftLimitThreshold(config.REVERSE_SOFT_LIMIT, 0);
        //talonSRX.setSafetyEnabled(config.SAFETY_ENABLED);
        talonSRX.configVelocityMeasurementPeriod(config.VELOCITY_MEASUREMENT_PERIOD, 0);
        talonSRX.configVelocityMeasurementWindow(config.VELOCITY_MEASUREMENT_ROLLING_AVERAGE_WINDOW, 0);
        talonSRX.configClosedloopRamp(config.VOLTAGE_COMPENSATION_RAMP_RATE, 0);
        talonSRX.configOpenloopRamp(config.VOLTAGE_RAMP_RATE, 0);

        talonSRX.setStatusFramePeriod(StatusFrameEnhanced.Status_1_General, config.GENERAL_STATUS_FRAME_RATE_MS, 0);
        talonSRX.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, config.FEEDBACK_STATUS_FRAME_RATE_MS, 0);
        talonSRX.setStatusFramePeriod(StatusFrameEnhanced.Status_3_Quadrature, config.QUAD_ENCODER_STATUS_FRAME_RATE_MS, 0);
        talonSRX.setStatusFramePeriod(StatusFrameEnhanced.Status_4_AinTempVbat,
                config.ANALOG_TEMP_VBAT_STATUS_FRAME_RATE_MS, 0);
        talonSRX.setStatusFramePeriod(StatusFrameEnhanced.Status_8_PulseWidth, config.PULSE_WIDTH_STATUS_FRAME_RATE_MS, 0);

        return talonSRX;
    }

    public static VictorSPX createVictor(int id, Configuration config) {
        VictorSPX victorSPX = new VictorSPX(id);
        victorSPX.set(ControlMode.Current, 0);
        victorSPX.changeMotionControlFramePeriod(config.MOTION_CONTROL_FRAME_PERIOD_MS);
        victorSPX.setIntegralAccumulator(0, 0, 0);
        victorSPX.clearMotionProfileHasUnderrun(0);
        victorSPX.clearMotionProfileTrajectories();
        victorSPX.clearStickyFaults(0);
        //victorSPX.configForwardLimitSwitchSource(LimitSwitchSource.RemoteTalonSRXconfig.LIMIT_SWITCH_NORMALLY_OPEN);
        victorSPX.configVoltageCompSaturation(config.MAX_OUTPUT_VOLTAGE, 0);
        //victorSPX.ConfigRevLimitSwitchNormallyOpen(config.LIMIT_SWITCH_NORMALLY_OPEN);
        victorSPX.setNeutralMode(config.ENABLE_BRAKE);

        // Victor SPX can't do this
        //victorSPX.enableCurrentLimit(config.ENABLE_CURRENT_LIMIT);

        victorSPX.configForwardSoftLimitEnable(config.ENABLE_SOFT_LIMIT, 0);
        //victorSPX.enableLimitSwitch(config.ENABLE_LIMIT_SWITCH, config.ENABLE_LIMIT_SWITCH);
        victorSPX.configReverseSoftLimitEnable(config.ENABLE_SOFT_LIMIT, 0);
        //victorSPX.enableZeroSensorPositionOnForwardLimit(false);
        //victorSPX.enableZeroSensorPositionOnIndex(false, false);
        //victorSPX.enableZeroSensorPositionOnReverseLimit(false);
        //victorSPX.reverseOutput(false);
        victorSPX.setSensorPhase(false);
        //victorSPX.setAnalogPosition(0);

        // Victor SPX can't do this
        //victorSPX.configContinuousCurrentLimit(config.CURRENT_LIMIT, 0);

        //victorSPX.setExpiration(config.EXPIRATION_TIMEOUT_SECONDS);
        victorSPX.configForwardSoftLimitThreshold(config.FORWARD_SOFT_LIMIT, 0);
        victorSPX.setInverted(config.INVERTED);
        //victorSPX.setNominalClosedLoopVoltage(config.NOMINAL_CLOSED_LOOP_VOLTAGE);
        //victorSPX.setPosition(0);
        //victorSPX.setProfile(0);
        victorSPX.selectProfileSlot(0, 0);
        victorSPX.configReverseSoftLimitThreshold(config.REVERSE_SOFT_LIMIT, 0);
        //victorSPX.setSafetyEnabled(config.SAFETY_ENABLED);
        victorSPX.configVelocityMeasurementPeriod(config.VELOCITY_MEASUREMENT_PERIOD, 0);
        victorSPX.configVelocityMeasurementWindow(config.VELOCITY_MEASUREMENT_ROLLING_AVERAGE_WINDOW, 0);
        victorSPX.configClosedloopRamp(config.VOLTAGE_COMPENSATION_RAMP_RATE, 0);
        victorSPX.configOpenloopRamp(config.VOLTAGE_RAMP_RATE, 0);

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
