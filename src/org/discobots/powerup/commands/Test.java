package org.discobots.powerup.commands;

import org.discobots.powerup.Robot;
import org.discobots.powerup.utils.*;

import edu.wpi.first.wpilibj.command.Command;


public class Test extends Command {
	
	int num = 0;
	
	public Test(int input) {
		num = input;
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Constants.kSwitchWait+=num;
		System.out.println(Constants.kSwitchWait);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
