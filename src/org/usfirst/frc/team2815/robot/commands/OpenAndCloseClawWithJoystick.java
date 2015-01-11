package org.usfirst.frc.team2815.robot.commands;

import org.usfirst.frc.team2815.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
/**
 * This Command Class requires the Claw SubSystem and uses the Flight joystick to
 * open and close the claw. The execute method opens and closes the claw using input
 * from OI. The execute method does not stop running unless it is interrupted because 
 * the isFinished method always returns false.This class uses requires the Robot 
 * class, the OI class, and the Claw class.
 *
 * @see Robot
 *
 */
public class OpenAndCloseClawWithJoystick extends Command {
	/**
     * This function is run when the class is initialized and should be
     * used for any initialization code. This Class also Specifies the
     * particular subsystem this command requires().
     */
    public OpenAndCloseClawWithJoystick() {
        requires(Robot.claw);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.claw.openAndClose(Robot.oi.getOpenClaw(), Robot.oi.getClosedClaw());
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
