package org.usfirst.frc.team2815.robot.subsystems;

import org.usfirst.frc.team2815.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Claw extends Subsystem {
    Solenoid clawSolenoid[] = new Solenoid[2];
    
    /**
     * This function is run when the class is initialized and should be
     * used for any initialization code.
     */
	public Claw(){
		super("Claw");
		clawSolenoid[0] = new Solenoid(RobotMap.clawPiston[0]);
		clawSolenoid[1] = new Solenoid(RobotMap.clawPiston[1]);

	}
	/** Set the default command for a subsystem here.
     * setDefaultCommand(new MySpecialCommand());
     */
    public void initDefaultCommand() {
        
    }
    /**
     * This method uses boolean logic to open and close out double acting claw solenoid
     * @param open	a boolean if true the clawSoleonid[0] is set to true and clawSolenoid[1] is set to false
     * @param close	a boolean if true the clawSoleonid[0] is set to false and clawSolenoid[1] is set to true
     */
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

