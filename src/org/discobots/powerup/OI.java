/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.discobots.powerup;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

//importing all the commands
import org.discobots.powerup.commands.*;
import org.discobots.powerup.commands.autonomous.subcommands.*;

//importing all the subsystems
import org.discobots.powerup.subsystems.Drivetrain;

//importing all of the utils (mainly gamepad)
import org.discobots.powerup.utils.Gamepad;
import org.discobots.powerup.utils.Constants;

//import org.discobots.steamworks.utils.Gamepad.DPadButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */


public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	//Joystick stick = new Joystick(0);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	 
	 //pov = dpad
	 //axis = joystick
	Gamepad gp1 = new Gamepad(0);
	
	
	//create all the buttons, except for d-pad, probably won't use them all
	private Button button_RB = new JoystickButton(gp1, Gamepad.BTN_RB);
	private Button button_LB = new JoystickButton(gp1, Gamepad.BTN_LB);
	private Button button_back = new JoystickButton(gp1, Gamepad.BTN_BACK);
	private Button button_start = new JoystickButton(gp1, Gamepad.BTN_START);
	private Button button_A = new JoystickButton(gp1, Gamepad.BTN_A);
	private Button button_X = new JoystickButton(gp1, Gamepad.BTN_X);
	private Button button_B = new JoystickButton(gp1, Gamepad.BTN_B);
	private Button button_Y = new JoystickButton(gp1, Gamepad.BTN_Y);
	private Button button_clicR = new JoystickButton(gp1, Gamepad.BTN_AXIS_R);
	private Button button_clicL = new JoystickButton(gp1, Gamepad.BTN_AXIS_L);
	
	
	//in here, give the buttons commands
	public OI() {
		button_A.whenPressed(new AutonArcadeDrive(1.0,0.0,1000));
		button_B.whenPressed(new AutonArcadeDrive(1.0,0.0,500));
		button_X.whenPressed(new AutonArcadeDrive(1.0,0.0,1500));
		button_Y.whenPressed(new AutonArcadeDrive(1.0,0.0,2000));
		
	}
	
	public double getLX() {
		return gp1.getLX();
	}
	
	public double getLY() {
		return gp1.getLY();
	}
	
	public double getRX() {
		return gp1.getRX();
	}
	
	public double getRY() {
		return gp1.getRY();
	}
	
}
