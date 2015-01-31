
package org.usfirst.frc.team2815.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2815.robot.autocommands.BasicAuto;
import org.usfirst.frc.team2815.robot.commands.*;
import org.usfirst.frc.team2815.robot.subsystems.*;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory. This class also initializes all Subsystems and the Robots operator
 * interface or OI
 * 
 * @see OI
 * @see DriveTrain
 * @see Elevator
 * @see Claw
 * 
 */
public class Robot extends IterativeRobot {
	//trouble with the curve
	//public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static final DriveTrain driveTrain = new DriveTrain();
	public static final Elevator elevator = new Elevator();
	public static final Claw claw = new Claw();
	
	
	public static OI oi;
	
	SendableChooser driveChoser;
	SendableChooser autoChoser;
    //public static CommandBase base;
    Command autonomousCommand;
	Command driveWithJoystick;
	Command raiseAndLowerElevatorWithJoystick;
	Command openAndCloseClawWithJoystick;

	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
   		oi = new OI();
        // instantiate the command used for the autonomous period
        // autonomousCommand = new ExampleCommand();
   		//driveWithJoystick = new DriveWithJoystick();
   		driveChoser = new SendableChooser();
   		driveChoser.addDefault("H Drive", new HDriveWithJoystick());
   		driveChoser.addObject("Normal Arcade Drive", new ArcadeDriveWithJoystick());
   		driveChoser.addObject("Tank Drive", new TankDriveWithJoystick());
   		SmartDashboard.putData("Drive Types", driveChoser);
   		
   		autoChoser = new SendableChooser();
   		autoChoser.addDefault("Basic Auto", new BasicAuto());
   		
   		SmartDashboard.putData("Autonomous", autoChoser);
   		
   		raiseAndLowerElevatorWithJoystick = new RaiseAndLowerElevatorWithFlightStick();
   		openAndCloseClawWithJoystick = new OpenAndCloseClawWithJoystick();
   		
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        // if (autonomousCommand != null) autonomousCommand.start();
    	autonomousCommand = (Command) autoChoser.getSelected();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        // if (autonomousCommand != null) autonomousCommand.cancel();
        
        driveWithJoystick = (Command) driveChoser.getSelected();
    	driveWithJoystick.start();
        raiseAndLowerElevatorWithJoystick.start();
        openAndCloseClawWithJoystick.start();
    
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
