package org.usfirst.frc.team2815.robot.subsystems;

import org.usfirst.frc.team2815.robot.RobotMap;
import org.usfirst.frc.team2815.robot.commands.HDriveWithJoystick;


import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *This SubSystem Class initializes motor objects and sets these 
 *variables to different speeds based on the method. This class sets the
 *values of the drive motors based on the drive type. The Subsystem gets motor ports from the RobotMap.
 *
 *@see RobotMap
 */
public class DriveTrain extends PIDSubsystem {
	private Victor leftMotors;
	private Victor rightMotors;
	private Talon hDriveMotor;
	private double lTarget;
	private double rTarget;
	private double lspeed;
	private double rspeed;
	private final double ACCEL;
	private boolean hyperDrive;
	private double percentSpeed;
	//private Encoder encoders[] = new Encoder[3];
	
	/**
     * This function is run when the class is initialized and should be
     * used for any initialization code.
     */
	public DriveTrain() {
		super("Drive Train",1,0,1);
		leftMotors = new Victor(RobotMap.leftMotors);
		
		rightMotors = new Victor(RobotMap.rightMotors);
		
		hDriveMotor = new Talon(RobotMap.hDriveMotor);
		ACCEL = .1;
		rspeed = 0;
		lspeed = 0;
		hyperDrive = false;
		/*for(int i=0; i<encoders.length; i++){
			encoders[i] = new Encoder(RobotMap.encoder[i], RobotMap.encoderModules[i],false, Encoder.EncodingType.k4X);
			encoders[i].setDistancePerPulse(4*Math.PI);
			encoders[i].reset();
		}
		*/
		//encoder = new Encoder(RobotMap.encoder[0], RobotMap.encoder[1],false, Encoder.EncodingType.k4X);
		
		//encoder.setDistancePerPulse(4*Math.PI);
		//encoder.reset();
	}

	/** Set the default command for a subsystem here.
     * setDefaultCommand(new MySpecialCommand());
     */
	public void initDefaultCommand() {
		
		setDefaultCommand(new HDriveWithJoystick());
	}

	/**
	 * This method sets the motor speed for the tank drive setup and takes in
	 * only double values.
	 * <p>
	 * 
	 * @param leftSpeed
	 *            <code>double</code> that sets the left motor speed
	 * @param rightSpeed
	 *            <code>double</code> that sets the right motor speed
	 * @return void
	 * @see Drive
	 */

	public void tankDrive(double leftSpeed, double rightSpeed) {
		 
			leftMotors.set(leftSpeed/2);
			rightMotors.set(rightSpeed/2);
	}
	/**
	 * This method takes in two doubles that comprise our arcade drive and sets
	 * the left and right motor values.
	 * @param turnValue <code>double</code> for the turn value
	 * @param yThrottle <code>double</code> for the y-Throttle speed
	 */
	public void arcadeDrive(double turnValue, double yThrottle) {
		if (Math.abs(yThrottle) < .01) {
			yThrottle = 0;
		}
		lTarget = yThrottle * Math.abs(yThrottle) + turnValue
				* Math.abs(turnValue) * Math.abs(turnValue);
		rTarget = yThrottle * Math.abs(yThrottle) - turnValue
				* Math.abs(turnValue) * Math.abs(turnValue);

		if (lspeed != lTarget) {
			if (lspeed < lTarget) {
				lspeed += ACCEL;
				if (lspeed > lTarget) {
					lspeed = lTarget;
				}
			} else {
				lspeed -= ACCEL;
				if (lspeed < lTarget) {
					lspeed = lTarget;
				}
			}
		}

		if (rspeed != rTarget) {
			if (rspeed < rTarget) {
				rspeed += ACCEL;
				if (rspeed > rTarget) {
					rspeed = rTarget;
				}
			} else {
				rspeed -= ACCEL;
				if (rspeed < rTarget) {
					rspeed = rTarget;
				}
			}
		}

		if (rspeed != 0) {
			rspeed += 0.03;
		}
			leftMotors.set(lspeed*-1);
			rightMotors.set(rspeed);

	}
	/**
	 * Acts the same as arcade drive but also takes in a value for the
	 * h drive motor that allows the robot to strafe side to side
	 * 
	 * @param turnValue <code>double</code> for the turn value
	 * @param yThrottle <code>double</code> for the y-Throttle speed
	 * @param hDriveValue <code>double</code> for the value of the H-drive
	 */
	public void harcadeDrive(double turnValue, double yThrottle, double hDriveValue) {
		if (Math.abs(yThrottle) < .01) {
			yThrottle = 0;
		}
		lTarget = yThrottle * Math.abs(yThrottle) + turnValue
				* Math.abs(turnValue) * Math.abs(turnValue);
		rTarget = yThrottle * Math.abs(yThrottle) - turnValue
				* Math.abs(turnValue) * Math.abs(turnValue);

		if (lspeed != lTarget) {
			if (lspeed < lTarget) {
				lspeed += ACCEL;
				if (lspeed > lTarget) {
					lspeed = lTarget;
				}
			} else {
				lspeed -= ACCEL;
				if (lspeed < lTarget) {
					lspeed = lTarget;
				}
			}
		}

		if (rspeed != rTarget) {
			if (rspeed < rTarget) {
				rspeed += ACCEL;
				if (rspeed > rTarget) {
					rspeed = rTarget;
				}
			} else {
				rspeed -= ACCEL;
				if (rspeed < rTarget) {
					rspeed = rTarget;
				}
			}
		}

		if (rspeed != 0) {
			rspeed += 0.03;
		}
		
		leftMotors.set(lspeed*percentSpeed);
		rightMotors.set(rspeed*percentSpeed);
		hDriveMotor.set(hDriveValue/2);

	}
	
	public void setHDriveMotor(double speed){
		hDriveMotor.set(speed);
	}
	public void setDriveSpeed(boolean driveSpeed){
		if(driveSpeed)
			this.hyperDrive = !this.hyperDrive;
		
		if(this.hyperDrive)
			this.percentSpeed = 1;
		else
			this.percentSpeed = .5;
		
	}
	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		//return encoder.pidGet();
		return 0;
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		/*
		SmartDashboard.putNumber("PID Value", output);
		SmartDashboard.putNumber("Encoder Value", encoder.get());
		SmartDashboard.putNumber("Encoder Value1", encoder.getRate());
		SmartDashboard.putNumber("Encoder Value2", encoder.getDistance());
		SmartDashboard.putNumber("Encoder Value3", encoder.getRaw());
		 */


	}

}

