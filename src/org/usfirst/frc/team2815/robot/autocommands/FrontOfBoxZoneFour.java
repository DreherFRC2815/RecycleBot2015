package org.usfirst.frc.team2815.robot.autocommands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FrontOfBoxZoneFour extends CommandGroup {
    
    public  FrontOfBoxZoneFour() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	addSequential(new DriveForward(2));
    	addParallel(new RaiseElevator(2));
    	addSequential(new IterativeDriveForward(3,1,1));
    	
    	//addSequential(new TurnRight(1));
    	//addSequential(new LowerElevator(1.5));
    	//addSequential(new DriveBackward(1));
    	
        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
