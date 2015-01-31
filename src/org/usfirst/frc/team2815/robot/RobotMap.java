package org.usfirst.frc.team2815.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
   

	public static int leftMotors[] = {0,1};
	public static int rightMotors[] = {2,3};
	public static int windowMotor[] = {5,6};
	public static int hDriveMotor = 4;
	public static int clawPiston[] = {0,1};
	public static int encoder[] = {0,2,4};
	public static int encoderModules[] = {1,3,5};
	public static int elevatorSwitch[] ={6,7}; 
	
}
