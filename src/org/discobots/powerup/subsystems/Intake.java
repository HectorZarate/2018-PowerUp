package org.discobots.powerup.subsystems;

import org.discobots.powerup.HW;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {
	
	Spark leftIntake;
	Spark rightIntake;
	
	public DoubleSolenoid claw;
	
	//Ultrasonic ultrasonic;
	
	public void initDefaultCommand() {
		
	}
	
	//initialize, doesn't do anything special
	public Intake() {
		leftIntake = new Spark(HW.leftIntake);
		leftIntake.setInverted(true);
		
		rightIntake = new Spark(HW.rightIntake);
		
		claw = new DoubleSolenoid(HW.pcm24v, HW.claw1, HW.claw2);
		
		//ultrasonic = new Ultrasonic();
	}
	
	//close - closes the claw
	public void close() {
		claw.set(DoubleSolenoid.Value.kReverse);
	}
	
	//open - opens the claw
	public void open() {
		claw.set(DoubleSolenoid.Value.kForward);
	}
	
	//toggle - toggles the claw
	public void toggle() {
		if(claw.get().equals(DoubleSolenoid.Value.kReverse)) {
			claw.set(DoubleSolenoid.Value.kForward);
		} else {
			claw.set(DoubleSolenoid.Value.kReverse);
		}
	}
	
	//getState (returns TRUE if closed)
	public boolean getState() {
		return (claw.get().equals(DoubleSolenoid.Value.kReverse));
	}
	
	//set - drives in at a given speed
	public void set(double speed) {
		leftIntake.set(speed);
		rightIntake.set(speed);
	}
}
