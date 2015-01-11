package org.usfirst.frc.team2815.robot.commands;

import org.usfirst.frc.team2815.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


/**
 * This Command Class requires the DriveTrain subsystem to drive the
 * robot using the arcade drive type with a joystick. The execute method calls the drive type
 * method in the sub system. This command runs until it is interrupted 
 * because the isFinished method always returns false. This class uses requires the Robot 
 * class, the OI class, and the DriveTrain Class.
 * 
 * @see Robot
 *
 */
public class ArcadeDriveWithJoystick extends Command {
	/**
     * This function is run when the class is initialized and should be
     * used for any initialization code. This Class also Specifies the
     * particular subsystem this command requires().
     */
    public ArcadeDriveWithJoystick() {
        requires(Robot.driveTrain);
        
    }

    //Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.arcadeDrive(Robot.oi.getLeftSpeed(),Robot.oi.getRightSpeed());
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
