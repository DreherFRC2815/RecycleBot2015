package org.usfirst.frc.team2815.robot.autocommands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * A command group that adds sequentials for a basic autonomous run, this '
 * autonomous set raises the elevator, strafes, lowers the elevator,drives backwards,
 * lowers the elevator, drives forward, raises the elevator, drives forward again.
 * 
 * @see RaiseElevator
 * @see LowerElevator
 * @see DriveBackward
 * @see DriveForward
 * @see Strafe
 * 
 */
public class BasicAuto extends CommandGroup {
    
    public  BasicAuto() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	
    	addSequential(new IterativeDriveForward());






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
