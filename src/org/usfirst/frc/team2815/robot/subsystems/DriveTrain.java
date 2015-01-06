package org.usfirst.frc.team2815.robot.subsystems;

import org.usfirst.frc.team2815.robot.RobotMap;
import org.usfirst.frc.team2815.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	private Victor leftMotors[] = new Victor[2];
    private Victor rightMotors[] = new Victor[2];
    public  DriveTrain() {
    	super("Drive Train");
    	leftMotors[0] = new Victor(RobotMap.leftMotors[0]);
    	leftMotors[1] = new Victor(RobotMap.leftMotors[1]);
    	rightMotors[0] = new Victor(RobotMap.rightMotors[0]);
    	rightMotors[2] = new Victor(RobotMap.rightMotors[1]);
    }
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveWithJoystick());
    }
    /**
     * This method sets the motor speed for the tank drive setup and takes in only double values.
     * <p>
     * 
     * @param 	leftSpeed 	a double that sets the left motor speed
     * @param 	rightSpeed 	a double that sets the right motor speed
     * @return 				void
     * @see 				Drive 
     */
    
    public void tankDrive(double leftSpeed, double rightSpeed){
    	for(Victor lv : leftMotors) lv.set(leftSpeed);
    	for(Victor rv : rightMotors) rv.set(rightSpeed);
    }
    
    public void arcadeDrive(){
    	
    }
    
}

