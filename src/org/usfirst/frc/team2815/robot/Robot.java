package org.usfirst.frc.team2815.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2815.robot.autocommands.BasicAuto;
import org.usfirst.frc.team2815.robot.autocommands.FrontOfBoxZoneFour;
import org.usfirst.frc.team2815.robot.autocommands.FrontOfBoxZoneOne;
import org.usfirst.frc.team2815.robot.commands.*;
import org.usfirst.frc.team2815.robot.subsystems.*;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;

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
	// trouble with the curve
	// public static final ExampleSubsystem exampleSubsystem = new
	// ExampleSubsystem();
	public static final DriveTrain driveTrain = new DriveTrain();
	public static final Elevator elevator = new Elevator();
	public static final Claw claw = new Claw();

	public static OI oi;

	SendableChooser driveChoser;
	SendableChooser autoChoser;
	// public static CommandBase base;
	Command autonomousCommand;
	Command driveWithJoystick;
	Command raiseAndLowerElevatorWithJoystick;
	Command openAndCloseClawWithJoystick;

	int session;
	Image frame;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		oi = new OI();
		// instantiate the command used for the autonomous period
		// autonomousCommand = new ExampleCommand();
		// driveWithJoystick = new DriveWithJoystick();
		driveChoser = new SendableChooser();
		driveChoser.addDefault("H Drive", new HDriveWithJoystick());
		driveChoser.addObject("Normal Arcade Drive",
				new ArcadeDriveWithJoystick());
		driveChoser.addObject("Tank Drive", new TankDriveWithJoystick());
		SmartDashboard.putData("Drive Types", driveChoser);

		autoChoser = new SendableChooser();
		autoChoser.addDefault("Test Auto", new BasicAuto());
		autoChoser.addObject("Right Zone One", new FrontOfBoxZoneOne());
		autoChoser.addObject("Left Zone Four", new FrontOfBoxZoneFour());
		SmartDashboard.putData("Autonomous", autoChoser);

		raiseAndLowerElevatorWithJoystick = new RaiseAndLowerElevatorWithFlightStick();
		openAndCloseClawWithJoystick = new OpenAndCloseClawWithJoystick();

		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);

		// the camera name (ex "cam0") can be found through the roborio web
		// interface
		session = NIVision.IMAQdxOpenCamera("cam0",
				NIVision.IMAQdxCameraControlMode.CameraControlModeController);

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		// schedule the autonomous command (example)
		// if (autonomousCommand != null) autonomousCommand.start();
		autonomousCommand = (Command) autoChoser.getSelected();
		autonomousCommand.start();
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
		NIVision.IMAQdxConfigureGrab(session);
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {
		NIVision.IMAQdxStopAcquisition(session);
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		
		// NIVision.Rect rect = new NIVision.Rect(10, 10, 100, 100);
		NIVision.IMAQdxGrab(session, frame, 1);
		// NIVision.imaqDrawShapeOnImage(frame, frame, rect,
		// DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);

		CameraServer.getInstance().setImage(frame);
		Scheduler.getInstance().run();

	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
