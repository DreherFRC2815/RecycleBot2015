package org.usfirst.frc.team2815.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    Joystick xbox = new Joystick(0);
    Joystick flight = new Joystick(1);
    public double getLeftSpeed(){
    	return xbox.getRawAxis(1)*-1;
    }
    public double getRightSpeed(){
    	if(Math.abs(xbox.getRawAxis(4))>0.1)
    		return xbox.getRawAxis(4);
    	else 
    		return 0;
    }
    public double getRightTrigger(){
    	return xbox.getRawAxis(3);
    }
    public double getLeftTrigger(){
    	return xbox.getRawAxis(2);
    }
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
    public double getYspeed(){
    	return flight.getRawAxis(1);
    }
    Button button1 = new JoystickButton(flight, 4);
    Button button2 = new JoystickButton(flight, 5);
    public boolean getOpenClaw(){
    	return button1.get();
    }
    public boolean getClosedClaw(){
    	return button2.get();
    }
    
    // Button button = new JoystickButton(stick, buttonNumber);
    
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

