package org.usfirst.frc.team2815.robot.autocommands;

import org.usfirst.frc.team2815.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This Command Class raises the Elevator for a set amount
 * of time using the drive train subsystem from robot and the FPGA
 * time stamp. 
 * 
 * @see Robot
 */
public class LowerElevator extends Command {
	private int state;
	private double startTime;
	private final int BOOTING = 0, LOWER_ELEVATOR = 1, FINISHED = 2;
	private final double LOWER_TIME = 1.5;
    public LowerElevator() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
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
			state = LOWER_ELEVATOR;
			break;
		case LOWER_ELEVATOR:
			if(Timer.getFPGATimestamp() >= startTime + LOWER_TIME){
				Robot.elevator.raiseAndLower(0);
				state = FINISHED;
				break;
			}
			Robot.elevator.raiseAndLower(1);
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
