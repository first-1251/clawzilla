package org.usfirst.frc.team1251.robot;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // collector Class


    // For example to map the left and right motors, you could define the
    // following variables to use with your drive-train subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;

    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;


    //Ports
    //MUST CHANGE THE PORT #S TO PROPER PORTS ON ROBOT


    //Arm ports
    public static final int armMotor = 5;
    public static final int armLimitSwitch = 3;

    public static final int armPotentiometer = 0;

    //Claw ports
    public static final int clawSolenoidLeft = 7;
    public static final int clawSolenoidRight = 6;

    // Elevator Motors - MUST CORRECT PORT VALUES
    // Elevator Motors
    public static final int ELEVATOR_VICTOR = 10;
    //TODO: UPDATE VICTOR PORT ACCORDINGLY

    // Elevator Limit Switch
    public static final int ELEVATOR_LIMIT_SWITCH = 2;
    //TODO: UPDATE LS PORT ACCORDINGLY

    // Elevator Encoder
    public static final int ELEVATOR_ENCODER = 1;
    //TODO: UPDATE ENCODER PORT ACCORDINGLY

    // DIO ports for Encoder?
    //TODO: ADD DIO PORTS

    //Collector Victors
    public static final int COLLECTOR_LEFT_VICTOR = 2;
    public static final int COLLECTOR_RIGHT_VICTOR = 3;

    //Collector Limit Switch
    public static final int COLLECTOR_LEFT_SWITCH = 0;
    public static final int COLLECTOR_MIDDLE_SWITCH = 1;
    public static final int COLLECTOR_RIGHT_SWITCH = 2;

    //Drivetrain port values / Device IDs
    public static final int LEFT_MASTER_MOTOR_ID = 0;
    public static final int LEFT_SLAVE_MOTOR1_ID = 1;
    public static final int LEFT_SLAVE_MOTOR2_ID = 2;
    public static final int LEFT_SLAVE_MOTOR3_ID = 3;

    public static final int RIGHT_MASTER_MOTOR_ID = 15;
    public static final int RIGHT_SLAVE_MOTOR1_ID = 14;
    public static final int RIGHT_SLAVE_MOTOR2_ID = 13;
    public static final int RIGHT_SLAVE_MOTOR3_ID = 12;

    public static final int DRIVE_GEAR_SHIFT_PORT1 = 0;
    public static final int DRIVE_GEAR_SHIFT_PORT2 = 7;


    public static final double DRIVE_TICK_VELOCITY_TO_SHIFT = 15;
}