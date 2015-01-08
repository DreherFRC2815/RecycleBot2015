package org.usfirst.frc.team2815.robot.subsystems;

import org.usfirst.frc.team2815.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Victor windowMotor ;
	public Elevator(){
		super("Elevator");
		windowMotor = new Victor(RobotMap.windowMotor);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
 
    public void raiseAndLower(double yValue){
    	windowMotor.set(yValue);
    }
}

