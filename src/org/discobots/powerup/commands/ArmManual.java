package org.discobots.powerup.commands;

import org.discobots.powerup.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArmManual extends Command {

	public ArmManual() {
		requires(Robot.arm);
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		//don't set it when the joystick is low, so we won't freeze the arm
		if(Math.abs(Robot.oi.s_gp.getLY())>0.1) {
			Robot.arm.getPIDController().disable();
			Robot.arm.set(Robot.oi.s_gp.getLY());
		} else {
			if(!Robot.arm.getPIDController().isEnabled()) {
				Robot.arm.getPIDController().setSetpoint(Robot.arm.armPot.get());
			}
			Robot.arm.getPIDController().enable();
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.arm.set(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}

}
