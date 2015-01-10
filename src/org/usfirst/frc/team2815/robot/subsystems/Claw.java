package org.usfirst.frc.team2815.robot.subsystems;

import org.usfirst.frc.team2815.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Claw extends Subsystem {
    Solenoid clawSolenoid[] = new Solenoid[2];
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Claw(){
		super("Claw");
		clawSolenoid[0] = new Solenoid(RobotMap.clawPiston[0]);
		clawSolenoid[1] = new Solenoid(RobotMap.clawPiston[1]);

	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void openAndClose(boolean open, boolean close){
    	if(open){
    		clawSolenoid[0].set(true);
			clawSolenoid[1].set(false);
    	}
		else if(close){
			clawSolenoid[0].set(false);
    		clawSolenoid[1].set(true);
		}
    }
}

