package org.usfirst.frc.team1251.robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import openrio.powerup.MatchData;
import org.usfirst.frc.team1251.robot.commands.AutoPathPermutations.*;
import org.usfirst.frc.team1251.robot.commands.CrossLineAuto;
import org.usfirst.frc.team1251.robot.commands.DoNothingDefaultAuto;
import org.usfirst.frc.team1251.robot.subsystems.*;
import org.usfirst.frc.team1251.robot.virtualSensors.ArmPosition;
import org.usfirst.frc.team1251.robot.virtualSensors.DriveFeedback;

public class AutoChooser{

    private SendableChooser<RobotStart> sideChooser;
    private SendableChooser<CommandGroup> autoOverrideChooser;

    private DoNothingDefaultAuto defaultAuto;

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

    public AutoChooser(Arm arm, ArmPosition armPosition, Claw claw, Collector collector, DriveTrain driveTrain, DriveFeedback driveFeedback, DriveTrainShifter shifter) {

        sideChooser = new SendableChooser<>();
        autoOverrideChooser = new SendableChooser<>();

        SmartDashboard.putData("Side", sideChooser);
        SmartDashboard.putData("Override", autoOverrideChooser);

        this.defaultAuto = new DoNothingDefaultAuto();

        this.crossLineAuto = new CrossLineAuto(driveTrain, driveFeedback, shifter);

        this.lSwitchAwayScaleAway = new LSwitchAwayScaleAway(arm, armPosition, claw, collector, driveFeedback, driveTrain, shifter);
        this.lSwitchAwayScaleHome = new LSwitchAwayScaleHome(arm, armPosition, claw, collector, driveFeedback, driveTrain, shifter);
        this.lSwitchHomeScaleAway = new LSwitchHomeScaleAway(arm, armPosition, claw, collector, driveFeedback, driveTrain, shifter);
        this.lSwitchHomeScaleHome = new LSwitchHomeScaleHome(arm, armPosition, claw, collector, driveFeedback, driveTrain, shifter);

        this.rSwitchAwayScaleAway = new RSwitchAwayScaleAway();
        this.rSwitchAwayScaleHome = new RSwitchAwayScaleHome();
        this.rSwitchHomeScaleAway = new RSwitchHomeScaleAway();
        this.rSwitchHomeScaleHome = new RSwitchHomeScaleHome();

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

    public void initialize() {
        if (autoOverrideChooser.getSelected().equals(defaultAuto)) {
            MatchData.OwnedSide ourSwitch;
            MatchData.OwnedSide scale;

            do {
                ourSwitch = MatchData.getOwnedSide(MatchData.GameFeature.SWITCH_NEAR);
                scale = MatchData.getOwnedSide(MatchData.GameFeature.SCALE);

                System.out.println("(1) We have scale " + scale.name());
                System.out.println("(2) We have switch " + ourSwitch.name());
            } while (scale == MatchData.OwnedSide.UNKNOWN || ourSwitch == MatchData.OwnedSide.UNKNOWN);


            if (sideChooser.getSelected() == RobotStart.RIGHT) {
                if (ourSwitch == MatchData.OwnedSide.LEFT && scale == MatchData.OwnedSide.LEFT) {
                    rSwitchAwayScaleAway.start();
                } else if (ourSwitch == MatchData.OwnedSide.LEFT && scale == MatchData.OwnedSide.RIGHT) {
                    rSwitchAwayScaleHome.start();
                } else if (ourSwitch == MatchData.OwnedSide.RIGHT && scale == MatchData.OwnedSide.LEFT) {
                    rSwitchHomeScaleAway.start();
                } else if (ourSwitch == MatchData.OwnedSide.RIGHT && scale == MatchData.OwnedSide.RIGHT) {
                    rSwitchHomeScaleHome.start();
                } else {
                    System.out.println("Unknown switch/scale combination, just crossing line.");
                    crossLineAuto.start();
                }
            } else if (sideChooser.getSelected() == RobotStart.LEFT) {
                if (ourSwitch == MatchData.OwnedSide.RIGHT && scale == MatchData.OwnedSide.RIGHT) {
                    lSwitchAwayScaleAway.start();
                } else if (ourSwitch == MatchData.OwnedSide.RIGHT && scale == MatchData.OwnedSide.LEFT) {
                    lSwitchAwayScaleHome.start();
                } else if (ourSwitch == MatchData.OwnedSide.LEFT && scale == MatchData.OwnedSide.RIGHT) {
                    lSwitchHomeScaleAway.start();
                } else if (ourSwitch == MatchData.OwnedSide.LEFT && scale == MatchData.OwnedSide.LEFT) {
                    lSwitchHomeScaleHome.start();
                } else {
                    System.out.println("Unknown switch/scale combination, just crossing line.");
                    crossLineAuto.start();
                }
            } else {
                // center, don't have those autos yet
                crossLineAuto.start();
            }
        } else {
            autoOverrideChooser.getSelected().start();
        }
    }
}