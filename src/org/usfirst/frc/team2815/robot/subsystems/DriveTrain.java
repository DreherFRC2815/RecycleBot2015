package org.usfirst.frc.team2815.robot.subsystems;

import org.usfirst.frc.team2815.robot.RobotMap;

import org.usfirst.frc.team2815.robot.commands.HDriveWithJoystick;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	private Victor leftMotors[] = new Victor[2];
	private Victor rightMotors[] = new Victor[2];
	private Talon hDriveMotor;
	private double lTarget;
	private double rTarget;
	private double lspeed;
	private double rspeed;
	private final double ACCEL;
	
	/**
     * This function is run when the class is initialized and should be
     * used for any initialization code.
     */
	public DriveTrain() {
		super("Drive Train");
		leftMotors[0] = new Victor(RobotMap.leftMotors[0]);
		leftMotors[1] = new Victor(RobotMap.leftMotors[1]);
		rightMotors[0] = new Victor(RobotMap.rightMotors[0]);
		rightMotors[1] = new Victor(RobotMap.rightMotors[1]);
		hDriveMotor = new Talon(RobotMap.hDriveMotor);
		ACCEL = .1;
		rspeed = 0;
		lspeed = 0;
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
	 *            a double that sets the left motor speed
	 * @param rightSpeed
	 *            a double that sets the right motor speed
	 * @return void
	 * @see Drive
	 */

	public void tankDrive(double leftSpeed, double rightSpeed) {
		for (Victor lv : leftMotors)
			lv.set(leftSpeed);
		for (Victor rv : rightMotors)
			rv.set(rightSpeed);
	}
	/**
	 * This method takes in two doubles that comprise our arcade drive and sets
	 * the left and right motor values.
	 * @param turnValue a double for the turn value
	 * @param yThrottle a double for the y-Throttle speed
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
		for (Victor lv : leftMotors)
			lv.set(lspeed);
		for (Victor rv : rightMotors)
			rv.set(rspeed);

	}
	/**
	 * Acts the same as arcade drive but also takes in a value for the
	 * h drive motor that allows the robot to strafe side to side
	 * 
	 * @param turnValue a double for the turn value
	 * @param yThrottle a double for the y-Throttle speed
	 * @param hDriveValue a double for the value of the H-drive
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
		for (Victor lv : leftMotors)
			lv.set(lspeed);
		for (Victor rv : rightMotors)
			rv.set(rspeed);
		hDriveMotor.set(hDriveValue);

	}

}

