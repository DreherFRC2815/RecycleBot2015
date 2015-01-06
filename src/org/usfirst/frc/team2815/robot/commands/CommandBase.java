package org.usfirst.frc.team2815.robot.commands;

import org.usfirst.frc.team2815.robot.OI;
import org.usfirst.frc.team2815.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public abstract class CommandBase extends Command {
	
	public static OI oi;
	
	public static final DriveTrain driveTrain = new DriveTrain();
	
	public static void init(){
		oi = new OI();
	}
	public CommandBase(String name) {
        super(name);
    }
    public CommandBase() {
        super();
    }

   
}
