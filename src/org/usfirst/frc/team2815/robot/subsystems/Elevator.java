package org.usfirst.frc.team2815.robot.subsystems;

import org.usfirst.frc.team2815.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *This SubSystem Class initializes motor objects and sets these 
 *variables to different speeds based on the method. Uses the methods
 *to raise and lower the elevator. The Subsystem gets motor ports from the RobotMap.
 *
 *@see RobotMap
 */
public class Elevator extends Subsystem {
    
    
	private Talon windowMotors[] = new Talon[2];
	private DigitalInput limitSwitch[] = new DigitalInput[2];
	/**
     * This function is run when the class is initialized and should be
     * used for any initialization code.
     */
	public Elevator(){
		super("Elevator");
		windowMotors[0] = new Talon(RobotMap.windowMotor[0]);
		windowMotors[1] = new Talon(RobotMap.windowMotor[1]);
		limitSwitch[0] = new DigitalInput(RobotMap.elevatorSwitch[0]);
		limitSwitch[1] = new DigitalInput(RobotMap.elevatorSwitch[1]);
		
	}
	/** Set the default command for a subsystem here.
     * setDefaultCommand(new MySpecialCommand());
     */
    public void initDefaultCommand() {
       
    	
    }
    /**
     * Moves the elevator platform up and down according to the value of yValue. Uses a windowmotor.
     * 
     * @param yValue <code>double</code> value between -1.0 and 1.0 used to set the motor speed
     */
    public void raiseAndLower(double yValue){
    	windowMotors[0].set(yValue);
    	windowMotors[1].set(yValue);
    }
    public boolean getLimitSwitchValueTop(){
    	return limitSwitch[0].get();
    }
    public boolean getLimitSwitchValueBot(){
    	return limitSwitch[1].get();
    }

	public void raiseAndLowerWithJoystick(double yValue) {
		while (this.getLimitSwitchValueTop() == true) {
			if (yValue < 0) {
				windowMotors[0].set(0);
				windowMotors[1].set(0);
			} else {
				windowMotors[0].set(yValue);
				windowMotors[1].set(yValue);
			}
		}
		while (this.getLimitSwitchValueBot() == true) {
			if (yValue > 0) {
				windowMotors[0].set(0);
				windowMotors[1].set(0);
			}else{
				windowMotors[0].set(yValue);
				windowMotors[1].set(yValue);			
			}
		}
		windowMotors[0].set(yValue);
		windowMotors[1].set(yValue);  

	}

}

