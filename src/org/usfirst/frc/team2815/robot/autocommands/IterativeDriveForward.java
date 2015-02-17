package org.usfirst.frc.team2815.robot.autocommands;

import org.usfirst.frc.team2815.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IterativeDriveForward extends Command {
	private int state;
	private double startTime;
	private final int BOOTING = 0, DRIVING_FROWARD = 1, FINISHED = 2;
	private final double DRIVE_TIME; //DRIVE_TIME is 4.3
	private double iteration;
	private final double TARGET_ITERATION = .4;
	double speedLEdit;
	double speedREdit;
    public IterativeDriveForward(double time,double speedLEdit, double speedREdit) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
    	iteration = 0;
    	DRIVE_TIME = time;
    	this.speedLEdit = speedLEdit;
    	this.speedREdit = speedREdit;
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
    			if(TARGET_ITERATION >= iteration ){
    				Robot.driveTrain.tankDrive(iteration, -1*iteration);
    				iteration += .1;
    			}
    			else
    				Robot.driveTrain.tankDrive(1*speedLEdit, -1*speedREdit);    			
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
