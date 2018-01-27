package org.discobots.powerup.utils;

public class Constants {
	
	//kDeadband - driving ignores this value and lower for the controller inputs (0.1 covers most joystick "default" positions)
	public static double kDeadband = 0.1;
	
	//kLaunchwait - waits this period of time (milliseconds) after a successful launch
	public static long kLaunchwait = 750;
	
	public static long kScaleCooldown = 750;
	public static long kSwitchCooldown = 750;
}
