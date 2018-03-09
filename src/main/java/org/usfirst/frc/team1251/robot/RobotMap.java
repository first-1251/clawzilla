package org.usfirst.frc.team1251.robot;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 *
 *
 *        MOTOR POSITIONS
 *
 *          ---   ---         F
 *         | L | | 1 |        R
 *          ---   ---         O
 *     ---            ---     N
 *    | 2 |          | 3 |    T
 *     ---            ---
 *
 *`
 */
public class RobotMap
{
    private static class PwmDevices {
        static final int MOTOR_COLLECTOR_LEFT  = 2;
        static final int MOTOR_COLLECTOR_RIGHT = 3;
        static final int MOTOR_ARM = 4;
        static final int MOTOR_ELEVATOR_1 = 5;
        static final int MOTOR_ELEVATOR_2 = 6;
    }

    private static class DioDevices {
        static final int SWITCH_COLLECTOR_LEFT = 0;
        static final int SWITCH_COLLECTOR_RIGHT = 2;

        static final int SWITCH_ARM_TOP = 3;
        static final int SWITCH_ARM_BOTTOM = 4;
    }

    private static class PcmDevices {
        static final int SOLENOID_FORWARD_DRIVE_SHIFTER = 0;
        static final int SOLENOID_REVERSE_DRIVE_SHIFTER = 7;

        static final int SOLENOID_FORWARD_CLAW = 1;
        static final int SOLENOID_REVERSE_CLAW = 6;

        static final int SOLENOID_FORWARD_ELEVATOR_SHIFTER = 2;
        static final int SOLENOID_REVERSE_ELEVATOR_SHIFTER = 5;
    }

    private static class CanDevices {

        static final int MOTOR_LEFT_LEADER = 15;
        static final int MOTOR_LEFT_FOLLOWER_1 = 14;
        static final int MOTOR_LEFT_FOLLOWER_2 = 13;
        static final int MOTOR_LEFT_FOLLOWER_3 = 12;

        static final int MOTOR_RIGHT_LEADER = 0;
        static final int MOTOR_RIGHT_FOLLOWER_1 = 1;
        static final int MOTOR_RIGHT_FOLLOWER_2 = 2;
        static final int MOTOR_RIGHT_FOLLOWER_3 = 3;
    }

    private static class AnalogDevices {
        static final int ENCODER_ELEVATOR_CHANNEL_A = 0;
        static final int ENCODER_ELEVATOR_CHANNEL_B = 1;
    }


    // PUBLIC access to ids.

    public static final int ARM_MOTOR = PwmDevices.MOTOR_ARM;
    public static final int ARM_UPPER_LIMIT_SWITCH = DioDevices.SWITCH_ARM_TOP;
    public static final int ARM_LOWER_LIMIT_SWITCH = DioDevices.SWITCH_ARM_BOTTOM;

    public static final int ELEVATOR_MOTOR_1 = PwmDevices.MOTOR_ELEVATOR_1;
    public static final int ELEVATOR_MOTOR_2 = PwmDevices.MOTOR_ELEVATOR_2;
    public static final int ELEVATOR_ENCODER_CHANNEL_A = AnalogDevices.ENCODER_ELEVATOR_CHANNEL_A;
    public static final int ELEVATOR_ENCODER_CHANNEL_B = AnalogDevices.ENCODER_ELEVATOR_CHANNEL_B;
    public static final int ELEVATOR_SHIFTER_FORWARD = PcmDevices.SOLENOID_FORWARD_ELEVATOR_SHIFTER;
    public static final int ELEVATOR_SHIFTER_REVERSE = PcmDevices.SOLENOID_REVERSE_ELEVATOR_SHIFTER;

    public static final int CLAW_SOLENOID_FORWARD = PcmDevices.SOLENOID_FORWARD_CLAW;
    public static final int CLAW_SOLENOID_REVERSE = PcmDevices.SOLENOID_REVERSE_CLAW;

    public static final int COLLECTOR_LEFT_MOTOR = PwmDevices.MOTOR_COLLECTOR_LEFT;
    public static final int COLLECTOR_RIGHT_MOTOR = PwmDevices.MOTOR_COLLECTOR_RIGHT;
    public static final int COLLECTOR_LEFT_SWITCH = DioDevices.SWITCH_COLLECTOR_LEFT;
    public static final int COLLECTOR_RIGHT_SWITCH = DioDevices.SWITCH_COLLECTOR_RIGHT;

    public static final int DRIVE_LEFT_LEAD_MOTOR = CanDevices.MOTOR_LEFT_LEADER;
    public static final int DRIVE_LEFT_FOLLOW_MOTOR_1 = CanDevices.MOTOR_LEFT_FOLLOWER_1;
    public static final int DRIVE_LEFT_FOLLOW_MOTOR_2 = CanDevices.MOTOR_LEFT_FOLLOWER_2;
    public static final int DRIVE_LEFT_FOLLOW_MOTOR_3 = CanDevices.MOTOR_LEFT_FOLLOWER_3;
    public static final int DRIVE_RIGHT_LEAD_MOTOR = CanDevices.MOTOR_RIGHT_LEADER;
    public static final int DRIVE_RIGHT_FOLLOW_MOTOR_1 = CanDevices.MOTOR_RIGHT_FOLLOWER_1;
    public static final int DRIVE_RIGHT_FOLLOW_MOTOR_2 = CanDevices.MOTOR_RIGHT_FOLLOWER_2;
    public static final int DRIVE_RIGHT_FOLLOW_MOTOR_3 = CanDevices.MOTOR_RIGHT_FOLLOWER_3;

    public static final int DRIVE_SHIFTER_FORWARD = PcmDevices.SOLENOID_FORWARD_DRIVE_SHIFTER;
    public static final int DRIVE_SHIFTER_REVERSE = PcmDevices.SOLENOID_REVERSE_DRIVE_SHIFTER;

    public static final double DRIVE_TICK_VELOCITY_TO_SHIFT = 15;
}