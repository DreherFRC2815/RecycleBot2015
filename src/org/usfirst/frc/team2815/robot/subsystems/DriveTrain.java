package org.usfirst.frc.team2815.robot.subsystems;

import org.usfirst.frc.team2815.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
    Victor victL1 = RobotMap.vicL1;
    Victor victL2 = RobotMap.vicL2;
    Victor victR1 = RobotMap.vicR1;
    Victor victR2 = RobotMap.vicR2;
    
    public void tankDrive(int leftSpeed, int rightSpeed) {
    	victL1.set(leftSpeed);
    	victL2.set(leftSpeed);
    	victR1.set(rightSpeed);
    	victR2.set(rightSpeed);
    	
    }
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

