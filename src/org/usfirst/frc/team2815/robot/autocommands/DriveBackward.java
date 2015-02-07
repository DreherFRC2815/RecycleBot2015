package org.usfirst.frc.team2815.robot.autocommands;

import org.usfirst.frc.team2815.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This Command Class drives the robot Backward for a set amount
 * of time using the drive train subsystem from robot and the FPGA
 * time stamp. 
 * 
 * @see Robot
 */
public class DriveBackward extends Command {
	private int state;
	private double startTime;
	private final int BOOTING = 0, DRIVING_FROWARD = 1, FINISHED = 2;
	private final double DRIVE_TIME;//DRIVE_TIME is 2
    public DriveBackward(double time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    		DRIVE_TIME = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.setInterruptible(false);
    	state = BOOTING;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	switch(state) {
		case BOOTING: 
			startTime = Timer.getFPGATimestamp();
			state = DRIVING_FROWARD;
			break;
		case DRIVING_FROWARD:
			if(Timer.getFPGATimestamp() >= startTime + DRIVE_TIME){
				Robot.driveTrain.tankDrive(0, 0);
				state = FINISHED;
				break;
			}
			Robot.driveTrain.tankDrive(-.75, .75);
			break;
	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (state == FINISHED);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
