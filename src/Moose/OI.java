
package Moose;

import Moose.commands.ShootingWithFeedback;
import Moose.commands.ShootingWithoutFeedback;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO.EnhancedIOException;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class OI {
    DriverStationEnhancedIO ds;
    
    Joystick leftStick = new Joystick(RobotMap.leftJoyPort);
    Joystick rightStick = new Joystick(RobotMap.rightJoyPort);
    
    Button tractionButton = new JoystickButton(leftStick, RobotMap.triggerPort);
    Button shootButton = new JoystickButton(rightStick, RobotMap.triggerPort);
    Button mecanumButton = new JoystickButton(rightStick, RobotMap.mecanumButtonPort);
    Button shooterFeedbackEnableButton = new DigitalIOButton(RobotMap.shooterFeedbackEnablePort);
    //Button disckLockButton = new DigitalIOButton(RobotMap.discLock);
    //Button liftEnableButton = new DigitalIOButton(RobotMap.liftEnablePort);
    private int liftPosition, position;
     public OI(){
         ds =DriverStation.getInstance().getEnhancedIO();
         shooterFeedbackEnableButton.whileHeld(new ShootingWithFeedback());
     }
     
     public double getLeftY() {
        return -leftStick.getY();
    }
    
    public double getLeftX() {
        return leftStick.getX();
    }
 
    public double getRightY() {
        return -rightStick.getY();
    }
    
    public double getRightX() {
        return rightStick.getX();
    }
    
    public double getYAverage(){
        return ((-leftStick.getY()) + (-rightStick.getY()))/2.0;
    }
    
    public boolean getTracktionButton(){
        return tractionButton.get();
    }
    
    public boolean getMecanumButton(){
        return mecanumButton.get();
    }
    
    public boolean getShootButton(){
        return shootButton.get();
    }
    
    public boolean getDisckLockButton() throws EnhancedIOException{
        return ds.getDigital(8);
    }
    public boolean getAutoLeft() throws EnhancedIOException{
        return ds.getDigital(3);
    }
    public boolean getAutoRight() throws EnhancedIOException{
        return ds.getDigital(7);
    }
    public boolean getCompressorSwitch() throws EnhancedIOException{
        return ds.getDigital(1);
    }
    public boolean getAngleSwitch() throws EnhancedIOException{
        return ds.getDigital(2);
    }
    public boolean getNandoSwitch() throws EnhancedIOException{
        return ds.getDigital(5);
    }
    /*
    public boolean getLiftEnableButton(){
        return liftEnableButton.get();
    }*/
    
     public int getLiftPoition() throws DriverStationEnhancedIO.EnhancedIOException{
        if(ds.getAnalogIn(2)<RobotMap.liftVDposition1){
            liftPosition = 1;
        }
        else if(ds.getAnalogIn(2)<RobotMap.liftVDposition2){
            liftPosition = 2;
        }
        else if(ds.getAnalogIn(2)<RobotMap.liftVDposition3){
            liftPosition = 3;
        }
        else{
            liftPosition = 4;
        }
        return liftPosition;
    }
     
         public int getPostion() throws DriverStationEnhancedIO.EnhancedIOException{
        
        if(ds.getAnalogIn(1)<RobotMap.shooterVDposition0){
            position = 1;
        }
        //If Station Knob is at 
        else if(ds.getAnalogIn(1)>=RobotMap.shooterVDposition1 && ds.getAnalogIn(1)<RobotMap.shooterVDposition1+.3){
            position = 2;
        }
        //If Station Knob is at 
        else if(ds.getAnalogIn(1)>=RobotMap.shooterVDposition2 && ds.getAnalogIn(1)<RobotMap.shooterVDposition2+.2){
            position = 3;
        }
        //If Station Knob is at 
        else if(ds.getAnalogIn(1)>=RobotMap.shooterVDposition3&& ds.getAnalogIn(1)<RobotMap.shooterVDposition3+.3){
            position = 4;
        }
        //If Station Knob is at 
        else if(ds.getAnalogIn(1)>=RobotMap.shooterVDposition4&& ds.getAnalogIn(1)<RobotMap.shooterVDposition4+.3){
            position = 5;
        }
        //If Station Knob is at 
        else if(ds.getAnalogIn(1)>=RobotMap.shooterVDposition5){
            position = 6;
         }
         return position;
    }

    
    public void updateStatus(){
        //SmartDashboard.putNumber("Left Joystick Y",getLeftY());
        //SmartDashboard.putNumber("left Joystick X",getLeftX());
        //SmartDashboard.putNumber("Right Joystick Y",getRightY());
        //SmartDashboard.putNumber("Right Joystick X",getRightX());
        //SmartDashboard.putBoolean("Tracktion Button",getTracktionButton());
        //SmartDashboard.putBoolean("Mecanum Button",getMecanumButton());
    }
}

