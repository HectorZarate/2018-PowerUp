package org.discobots.powerup.utils;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.discobots.powerup.utils.Constants;


public class Gamepad extends Joystick {

	public static String name = "genericHID";
	
	public static int AXIS_LX = 0;
	public static int AXIS_LY = 1;
	
	public static int AXIS_LT = 2;
	public static int AXIS_RT = 3;
	
	public static int AXIS_RX = 4;
	public static int AXIS_RY = 5;
	
	
	
	
	private static final int DEFAULT_USB_PORT = 0;
	
	public Gamepad() {
		super(DEFAULT_USB_PORT);
	}
	
	public Gamepad(int port) {
		super(port);
	}
	
	public Gamepad(int port, String name) {
		super(port);
		this.name = name;
	}
	
	private double deadband(double val) {
		if(Math.abs(val) <= Constants.kDeadband) {
			return 0.0;
		}
		return val;
	}
	
	public double getLX() {
		double val = this.getRawAxis(AXIS_LX);
		//return deadband(val);
		return val;
	}

	public double getLY() {
		double val = this.getRawAxis(AXIS_LY) * -1;
		//return deadband(val);
		return val;
	}

	public double getRX() {
		double val = this.getRawAxis(AXIS_RX);
		//return deadband(val);
		return val;
	}

	public double getRY() {
		double val = this.getRawAxis(AXIS_RY);
		//return deadband(val);
		return val;
	}
	
	public double getDPAD() {
		double val = this.getPOV();
		if(45 <= val && val < 135) {
			val = 90;
		} else if(135 <= val && val < 225) {
			val = 180;
		} else if(225 <= val && val < 315) {
			val = 270;
		} else {
			val = 0;
		}
		return val;
	}
}
