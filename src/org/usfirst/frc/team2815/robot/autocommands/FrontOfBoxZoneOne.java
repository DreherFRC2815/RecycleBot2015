package org.usfirst.frc.team2815.robot.autocommands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FrontOfBoxZoneOne extends CommandGroup {
    
    public  FrontOfBoxZoneOne() {
    	addSequential(new DriveForward(2));
    	addSequential(new RaiseElevator(2));
    	addSequential(new IterativeDriveForward(4,1,.8));
    	//addSequential(new TurnRight(2));
    	//addSequential(new LowerElevator(1.5));
    	//addSequential(new DriveBackward(2));
    }
}
