package org.usfirst.frc.team2815.robot;

import edu.wpi.first.wpilibj.Victor;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
	public static int leftMotor1 = 0, 
					  leftMotor2 = 1, 
					  rightMotor1 = 2, 
					  rightMotor2 = 3;
	
	public static Victor vicL1 = new Victor(leftMotor1);
	public static Victor vicL2 = new Victor(leftMotor2);
	public static Victor vicR1 = new Victor(rightMotor1);
	public static Victor vicR2 = new Victor(rightMotor2);
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
}