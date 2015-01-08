package org.usfirst.frc.team2815.robot.subsystems;

import org.usfirst.frc.team2815.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Claw extends Subsystem {
    Solenoid clawSolenoid;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Claw(){
		super("Claw");
		clawSolenoid = new Solenoid(RobotMap.clawPiston);
		
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void openAndClose(boolean openorclose){
    	clawSolenoid.set(openorclose);
    	
    }
}

