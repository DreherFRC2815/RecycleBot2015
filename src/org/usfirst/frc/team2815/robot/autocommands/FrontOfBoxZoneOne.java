package org.usfirst.frc.team2815.robot.autocommands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FrontOfBoxZoneOne extends CommandGroup {
    
    public  FrontOfBoxZoneOne() {
    	addSequential(new DriveForward());
    	addSequential(new RaiseElevator());
    	addSequential(new IterativeDriveForward());
    	addSequential(new TurnRight());
    	addSequential(new LowerElevator());
    	addSequential(new DriveBackward());
    }
}
