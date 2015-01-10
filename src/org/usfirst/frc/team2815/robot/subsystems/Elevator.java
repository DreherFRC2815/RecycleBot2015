package org.usfirst.frc.team2815.robot.subsystems;

import org.usfirst.frc.team2815.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *@param Elevator is the elevator Subsystem
 */
public class Elevator extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Talon windowMotors[] = new Talon[2];
	public Elevator(){
		super("Elevator");
		windowMotors[0] = new Talon(RobotMap.windowMotor[0]);
		windowMotors[1] = new Talon(RobotMap.windowMotor[1]);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
    /**
     * Moves the elevator platform up and down according to the value of yValue. Uses a windowmotor.
     * @param raiseAndLower takes in a value and sets a window motor to that speed
     * @param yValue value received by raiseAndLower between -1.0 and 1.0
     */
    public void raiseAndLower(double yValue){
    	windowMotors[0].set(yValue);
    	windowMotors[1].set(yValue);
    }
}

