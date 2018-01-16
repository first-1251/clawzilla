package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1251.robot.subsystems.MinimalDriveTrain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Based on the findings of : https://www.chiefdelphi.com/media/papers/3402?
 *
 */
public class FindSteadyStateVoltageError extends Command {

    public static final double VOLTAGE_PER_SECOND_RAMP = 0.25;
    public static final double VOLTAGE_PER_LOOP_RAMP = 0.25 / 50.0;
    public static final double VOLTAGE_RANGE_START = 1.0;
    public static final double VOLTAGE_RANGE_END = 4.5;

    private Map<Double, Double> leftVoltageVelocity;
    private Map<Double, Double> rightVoltageVelocity;
    private List<Double> voltages;

    private double voltageLoopCount;
    private boolean finished = false;
    private MinimalDriveTrain driveTrain;
    public FindSteadyStateVoltageError(MinimalDriveTrain driveTrain) {
        requires(driveTrain);
        this.driveTrain = driveTrain;
        voltageLoopCount = VOLTAGE_RANGE_START;

        leftVoltageVelocity = new HashMap<>();
        rightVoltageVelocity = new HashMap<>();
    }

    @Override
    protected void execute() {
        if (!(voltageLoopCount < VOLTAGE_RANGE_END)) {
            finished = true;
        }

        if (!finished) {
            driveTrain.setLeftVoltage(voltageLoopCount);
            driveTrain.setRightVoltage(voltageLoopCount);

            voltages.add(voltageLoopCount);
            leftVoltageVelocity.put(voltageLoopCount, driveTrain.getLeftSpeed());
            rightVoltageVelocity.put(voltageLoopCount, driveTrain.getRightSpeed());
            voltageLoopCount += VOLTAGE_PER_LOOP_RAMP;
        }
    }

    @Override
    protected boolean isFinished() {
        return finished;
    }
}
