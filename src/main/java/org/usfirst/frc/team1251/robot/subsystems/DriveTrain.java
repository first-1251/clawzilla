package org.usfirst.frc.team1251.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1251.robot.RobotMap;

// Talon SRX software manual:
// https://docs.google.com/viewerng/viewer?url=https://link.vex.com/vexpro/pdf/217-8080-Talon-SRX-Software-Reference-Manual
// Victor SPX is mostly the same as that
public class DriveTrain extends Subsystem {

    //PID Values for Drivetrain
    private final int K_P = 0;
    private final int K_I = 0;
    private final int K_D = 0;
    private final int K_F = 0;
    private final int K_INTERCEPT = 0;

    private TalonSRX leftMasterMotor;
    private VictorSPX leftSlaveMotor1;
    private VictorSPX leftSlaveMotor2;
    private VictorSPX leftSlaveMotor3;

    private TalonSRX rightMasterMotor;
    private VictorSPX rightSlaveMotor1;
    private VictorSPX rightSlaveMotor2;
    private VictorSPX rightSlaveMotor3;

    private int leftDistance;
    private int rightDistance;

    private int leftVelocity;
    private int rightVelocity;

    public DriveTrain() {
        //create left motors
        leftMasterMotor = new TalonSRX(RobotMap.LEFT_MASTER_MOTOR_ID);
        leftSlaveMotor1 = new VictorSPX(RobotMap.LEFT_SLAVE_MOTOR1_ID);
        leftSlaveMotor2 = new VictorSPX(RobotMap.LEFT_SLAVE_MOTOR2_ID);
        leftSlaveMotor3 = new VictorSPX(RobotMap.LEFT_SLAVE_MOTOR3_ID);

        //follow the leader
        leftSlaveMotor1.follow(leftMasterMotor);
        leftSlaveMotor2.follow(leftMasterMotor);
        leftSlaveMotor3.follow(leftMasterMotor);

        //create right motors
        rightMasterMotor = new TalonSRX(RobotMap.RIGHT_MASTER_MOTOR_ID);
        rightSlaveMotor1 = new VictorSPX(RobotMap.RIGHT_SLAVE_MOTOR1_ID);
        rightSlaveMotor2 = new VictorSPX(RobotMap.RIGHT_SLAVE_MOTOR2_ID);
        rightSlaveMotor3 = new VictorSPX(RobotMap.RIGHT_SLAVE_MOTOR3_ID);

        //make the slaves follow their master
        rightSlaveMotor1.follow(rightMasterMotor);
        rightSlaveMotor2.follow(rightMasterMotor);
        rightSlaveMotor3.follow(rightMasterMotor);

        //Setup voltage limiting
        leftMasterMotor.configVoltageCompSaturation(9.0, 0);
        rightMasterMotor.configVoltageCompSaturation(9.0, 0);

        //Setup encoders
        leftMasterMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0 , 0);
        rightMasterMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0 , 0);
    }

    @Override
    protected void initDefaultCommand() {

    }

    public void enablePIDMode() {

    }

    public void enableMotionProfileMode() {

    }

    public void enableRegularMode() {

    }

    private void updateSensorData() {
        leftDistance = leftMasterMotor.getSelectedSensorPosition(0);
        rightDistance = rightMasterMotor.getSelectedSensorPosition(0);

        leftVelocity = leftMasterMotor.getSelectedSensorVelocity(0);
        rightVelocity = rightMasterMotor.getSelectedSensorVelocity(0);
    }
}
