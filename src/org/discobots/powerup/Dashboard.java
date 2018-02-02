package org.discobots.powerup;

import org.discobots.powerup.commands.autonomous.TimedAuton;
import org.discobots.powerup.utils.Constants;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard {
	
	private static final double SHORT_DELAY = 0.1;
	private static final double LONG_DELAY = 0.5;
	
	private static double shortTime = 0.0;
	private static double longTime = 0.0;
	
	public static void init() {
		Robot.autonChooser.addObject("Drive Past Line (Timed)", new TimedAuton(TimedAuton.direction.FORWARD, 1));
		Robot.autonChooser.addObject("Drive Past Line", new TimedAuton(TimedAuton.direction.FORWARD, 1));
		Robot.autonChooser.addObject("Score Switch (Timed)", new TimedAuton(TimedAuton.direction.FORWARD, 1));
		Robot.autonChooser.addObject("Score Switch", new TimedAuton(TimedAuton.direction.FORWARD, 1));
		Robot.autonChooser.addObject("Score Switch & Scale (Timed)", new TimedAuton(TimedAuton.direction.FORWARD, 1));
		Robot.autonChooser.addObject("Score Switch and Scale", new TimedAuton(TimedAuton.direction.FORWARD, 1));
		
		SmartDashboard.putData("Auton Chooser", Robot.autonChooser);
	}
	
	public static void autoInit() {
		for(int k = 0; k < 6; k++)
			SmartDashboard.putBoolean(k+"",Autonomous.scoreSide[k]);
	}
	
	//Short & Long dashboard update based of off 3847's dashboard
	public static void update() {
		if((Timer.getFPGATimestamp() - shortTime) > SHORT_DELAY) {
			shortTime = Timer.getFPGATimestamp();
			updateShort();
		}
		if((Timer.getFPGATimestamp() - longTime) > LONG_DELAY) {
			longTime = Timer.getFPGATimestamp();
			updateLong();
		}
	}
	
	public static void updateShort() {
		SmartDashboard.putBoolean("Launcher Ready?", !(Robot.launcher.checkOnCooldown()||Robot.launcher.anyActivated()));
	}
	
	public static void updateLong() {
		SmartDashboard.putNumber("Match Time", Timer.getMatchTime());
	}
}
