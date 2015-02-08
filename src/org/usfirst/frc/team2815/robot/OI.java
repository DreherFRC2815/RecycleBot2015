package org.usfirst.frc.team2815.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
    Joystick xbox = new Joystick(0);
    Joystick flight = new Joystick(1);
    Button button1 = new JoystickButton(flight, 4);
    Button button2 = new JoystickButton(flight, 5);
    Button hyperBoost = new JoystickButton(xbox, 2);
    Button slowButton = new JoystickButton(xbox,4);
    /**
     * @return double returns the value of the left stick y-axis of the Xbox controller at port 1 w/ correction for dead zone
     */
    public double getLeftSpeed(){
    	if(Math.abs(xbox.getRawAxis(1))>0.1)
    		return xbox.getRawAxis(1)*-1;
    	else 
    		return 0;
    }
    /**
     * @return double returns the value of the right stick x-axis of the Xbox controller at port 4 w/ correction for dead zone
     */
    public double getRightSpeed(){
    	if(Math.abs(xbox.getRawAxis(4))>0.1)
    		return xbox.getRawAxis(4);
    	else 
    		return 0;
    }
    /** 
     * @return double gets the right trigger value of the Xbox controller at port 3
     */
    public double getRightTrigger(){
    	return xbox.getRawAxis(3);
    }
    /**
     * @return double gets the left trigger value of the Xbox controller at port 2
     */
    public double getLeftTrigger(){
    	return xbox.getRawAxis(2);
    }
    
    /**
     * This method returns the value of both the right and left trigger by
     * getting the right and left trigger values, inverting one and 
     * adding the values to a single variable. This method is used to allow
     * the HDriveWithJoystick method to take in one variable for the h drive motor.
     * 
     * @return double gets the value of the right and left trigger
     */
    public double getRightAndLeftTrigger(){
    	double value = 0;
    	if(getRightTrigger()>.5){
    		value += getRightTrigger();
    	}else if(getLeftTrigger()>.5){
    		value += getLeftTrigger() *-1;
    	}else{
    		value = 0;
    	}
    	return value; 
    }
    
    /**
     * @return double returns the y-axis value of the Flight joystick at port 1
     */
    public double getYspeed(){
    	if(Math.abs(flight.getRawAxis(1)) > .1)
    		return flight.getRawAxis(1);
    	else
    		return 0;
    }
  
    /**
     * @return boolean returns the value of button on port 4 on the Flight joystick
     */
    public boolean getOpenClaw(){
    	return button1.get();
    }
    /**
     * @return boolean returns the value of button on port 5 on the Flight joystick
     */
    public boolean getClosedClaw(){
    	return button2.get();
    }
    
    public boolean getBoost(){
    
    	return hyperBoost.get();
    }
    public boolean getSlow(){
    	return slowButton.get();
    }

}

