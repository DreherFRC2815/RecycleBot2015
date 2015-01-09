package org.usfirst.frc.team2815.robot.commands;

import org.usfirst.frc.team2815.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RaiseAndLowerElevatorWithFlightStick extends Command {

    public RaiseAndLowerElevatorWithFlightStick() {
        // Use requires() here to declare subsystem dependencies
         requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    /**
     * The command for using the elevator. Will move the elevator up and down according to the Yspeed returned by a Joystick.
     * @param initialize initializes the command. Uses raiseAndLower from elevator object from Robot class. Uses getYspeed from oi object from
     * robot class to get the y value of the Joystick. 
     */
    protected void execute() {
    	Robot.elevator.raiseAndLower(Robot.oi.getYspeed());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
