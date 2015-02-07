package org.usfirst.frc.team2815.robot.autocommands;

import org.usfirst.frc.team2815.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This Command Class strafes the robot side to side using a the h-drive from
 * the drive train for a set amount
 * of time using the drive train subsystem from robot and the FPGA
 * time stamp. 
 * 
 * @see Robot
 */
public class Strafe extends Command {
	private int state;
	private double startTime;
	private final int STRAFE_TIME = 2;
	private final int BOOTING = 0, STRAFEING = 1, FINISHED = 2;
	
	
    public Strafe() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.setInterruptible(false);
    	state = BOOTING;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	switch(state){
    		case BOOTING:
    			startTime = Timer.getFPGATimestamp();
    			state = STRAFEING;
    		case STRAFEING:
    			if(Timer.getFPGATimestamp() >= startTime + STRAFE_TIME){
    				Robot.driveTrain.setHDriveMotor(0);
    				state = FINISHED;
    			}
    			Robot.driveTrain.setHDriveMotor(.25);
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
