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
	private double lTarget;
	private double rTarget;
	private double lspeed;
	private double rspeed;
	private final double ACCEL;

	public DriveTrain() {
		super("Drive Train");
		leftMotors[0] = new Victor(RobotMap.leftMotors[0]);
		leftMotors[1] = new Victor(RobotMap.leftMotors[1]);
		rightMotors[0] = new Victor(RobotMap.rightMotors[0]);
		rightMotors[1] = new Victor(RobotMap.rightMotors[1]);
		ACCEL = .1;
		rspeed = 0;
		lspeed = 0;
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new DriveWithJoystick());
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

}

