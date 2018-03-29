package org.usfirst.frc.team1251.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import openrio.powerup.MatchData;
import org.usfirst.frc.team1251.robot.commands.AutoPathPermutations.*;
import org.usfirst.frc.team1251.robot.subsystems.*;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;
import org.usfirst.frc.team1251.robot.virtualSensors.ElevatorPosition;

public class AutoChooser extends CommandGroup {

    private SendableChooser<RobotStart> sideChooser;
    private SendableChooser<CommandGroup> autoOverrideChooser;

    private DoNothingDefaultAuto defaultAuto;

    private CSwitchLeft cSwitchLeft;
    private CSwitchRight cSwitchRight;

    private LSwitchAwayScaleAway lSwitchAwayScaleAway;
    private LSwitchAwayScaleHome lSwitchAwayScaleHome;
    private LSwitchHomeScaleAway lSwitchHomeScaleAway;
    private LSwitchHomeScaleHome lSwitchHomeScaleHome;

    private RSwitchAwayScaleAway rSwitchAwayScaleAway;
    private RSwitchAwayScaleHome rSwitchAwayScaleHome;
    private RSwitchHomeScaleAway rSwitchHomeScaleAway;
    private RSwitchHomeScaleHome rSwitchHomeScaleHome;

    private CrossLineAuto crossLineAuto;

    public enum RobotStart {
        LEFT, CENTER, RIGHT;
    }

    public AutoChooser(Arm arm, ArmPosition armPosition,Claw claw, Collector collector, DriveTrain driveTrain, DriveFeedback driveFeedback, DriveTrainShifter shifter, Elevator elevator, ElevatorPosition elevatorPosition) {

        sideChooser = new SendableChooser<>();
        autoOverrideChooser = new SendableChooser<>();

        this.defaultAuto = new DoNothingDefaultAuto();

        this.crossLineAuto = new CrossLineAuto(driveTrain, driveFeedback, shifter);

        this.cSwitchLeft = new CSwitchLeft();
        this.cSwitchRight = new CSwitchRight(arm, armPosition, claw, collector, driveFeedback, driveTrain, shifter, elevator, elevatorPosition);

        this.lSwitchAwayScaleAway = new LSwitchAwayScaleAway();
        this.lSwitchAwayScaleHome = new LSwitchAwayScaleHome();
        this.lSwitchHomeScaleAway = new LSwitchHomeScaleAway();
        this.lSwitchHomeScaleHome = new LSwitchHomeScaleHome();

        this.rSwitchAwayScaleAway = new RSwitchAwayScaleAway(arm, armPosition, claw, collector, driveTrain, driveFeedback, shifter, elevator, elevatorPosition);
        this.rSwitchAwayScaleHome = new RSwitchAwayScaleHome(arm, armPosition, claw, collector, driveTrain, driveFeedback, shifter, elevator, elevatorPosition);
        this.rSwitchHomeScaleAway = new RSwitchHomeScaleAway(arm, armPosition, claw, collector, driveTrain, driveFeedback, shifter, elevator, elevatorPosition);
        this.rSwitchHomeScaleHome = new RSwitchHomeScaleHome(arm, armPosition, claw, collector, driveTrain, driveFeedback, shifter, elevator, elevatorPosition);

        sideChooser.addObject("Starting Left", RobotStart.LEFT);
        sideChooser.addObject("Starting Center", RobotStart.CENTER);
        sideChooser.addObject("Starting Right", RobotStart.RIGHT);



        autoOverrideChooser.addDefault("Default - No Override", defaultAuto);

        autoOverrideChooser.addObject("Cross Line", crossLineAuto);

        autoOverrideChooser.addObject("Left - Switch Away - Scale Away", lSwitchAwayScaleAway);
        autoOverrideChooser.addObject("Left - Switch Away - Scale Home", lSwitchAwayScaleHome);
        autoOverrideChooser.addObject("Left - Switch Home - Scale Away", lSwitchHomeScaleAway);
        autoOverrideChooser.addObject("Left - Switch Home - Scale Home", lSwitchHomeScaleHome);

        autoOverrideChooser.addObject("Right - Switch Away - Scale Away", rSwitchAwayScaleAway);
        autoOverrideChooser.addObject("Right - Switch Away - Scale Home", rSwitchAwayScaleHome);
        autoOverrideChooser.addObject("Right - Switch Home - Scale Away", rSwitchHomeScaleAway);
        autoOverrideChooser.addObject("Right - Switch Home - Scale Home", rSwitchHomeScaleHome);
    }

    @Override
    protected void initialize() {
        if (!autoOverrideChooser.getSelected().equals(defaultAuto)) {
            MatchData.OwnedSide ourSwitch = MatchData.getOwnedSide(MatchData.GameFeature.SWITCH_NEAR);
            MatchData.OwnedSide scale = MatchData.getOwnedSide(MatchData.GameFeature.SCALE);

            if (sideChooser.getSelected() == RobotStart.RIGHT) {
                if (ourSwitch == MatchData.OwnedSide.LEFT && scale == MatchData.OwnedSide.LEFT) {
                    addSequential(rSwitchAwayScaleAway);
                } else if (ourSwitch == MatchData.OwnedSide.LEFT && scale == MatchData.OwnedSide.RIGHT) {
                    addSequential(rSwitchAwayScaleHome);
                } else if (ourSwitch == MatchData.OwnedSide.RIGHT && scale == MatchData.OwnedSide.LEFT) {
                    addSequential(rSwitchHomeScaleAway);
                } else if (ourSwitch == MatchData.OwnedSide.RIGHT && scale == MatchData.OwnedSide.RIGHT) {
                    addSequential(rSwitchHomeScaleHome);
                } else {
                    System.out.println("Unknown switch/scale combination, just crossing line.");
                    addSequential(crossLineAuto);
                }
            } else if (sideChooser.getSelected() == RobotStart.LEFT) {
                if (ourSwitch == MatchData.OwnedSide.RIGHT && scale == MatchData.OwnedSide.RIGHT) {
                    addSequential(lSwitchAwayScaleAway);
                } else if (ourSwitch == MatchData.OwnedSide.RIGHT && scale == MatchData.OwnedSide.LEFT) {
                    addSequential(lSwitchAwayScaleHome);
                } else if (ourSwitch == MatchData.OwnedSide.LEFT && scale == MatchData.OwnedSide.RIGHT) {
                    addSequential(lSwitchHomeScaleAway);
                } else if (ourSwitch == MatchData.OwnedSide.LEFT && scale == MatchData.OwnedSide.LEFT) {
                    addSequential(lSwitchHomeScaleHome);
                } else {
                    System.out.println("Unknown switch/scale combination, just crossing line.");
                    addSequential(crossLineAuto);
                }
            } else {
                // center, don't have those autos yet
                addSequential(crossLineAuto);
            }
        } else {
            addSequential(autoOverrideChooser.getSelected());
        }
    }
}