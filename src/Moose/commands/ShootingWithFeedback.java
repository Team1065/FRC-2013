/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Moose.commands;

import Moose.RobotMap;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO.EnhancedIOException;


public class ShootingWithFeedback extends CommandBase {
    private double speed;
    
    public ShootingWithFeedback() {
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        shooter.setSetpoint(0);
        shooter.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        try {
            
            if(oi.getAngleSwitch()){
                shooter.setAngleAct(true);
            }
            else{
                shooter.setAngleAct(false);
            }
            
            if(oi.getNandoSwitch()){
                shooter.setNandoAct(true);
            }
            else{
                shooter.setNandoAct(false);
            }
            
            if(oi.getDisckLockButton() || shooter.getLock() == 1){
                shooter.lock();
                shooter.retract();
            }
            else{
                shooter.unlock();
                if(oi.getShootButton() || shooter.getshoot() == 1){
                    shooter.extend();
                }
                else{
                    shooter.retract();
                }
            }
            
            if(oi.getPostion() == 1)
            {
                speed = RobotMap.SpeedRpm1;
            }
            else if(oi.getPostion() == 2)
            {
                speed = RobotMap.SpeedRpm2;
            }
            else if(oi.getPostion() == 3)
            {
                speed = RobotMap.SpeedRpm3;
            }
            else if(oi.getPostion() == 4)
            {
                speed = RobotMap.SpeedRpm4;
            }
            else if(oi.getPostion() == 5)
            {
                speed = RobotMap.SpeedRpm5;
            }
            else if(oi.getPostion() == 6)
            {
                speed = RobotMap.SpeedRpm6;
            }
            else
            {
                speed = 0;
            }
            if(oi.getLiftPoition()==1){
                speed-=200;
                
            }
            else if(oi.getLiftPoition()==2){
                speed=speed;
            }
            else if(oi.getLiftPoition()==3){
                speed+=100;
            }
            else{
                speed+=200;
            }
        } catch (EnhancedIOException ex) {
            ex.printStackTrace();
        }
        shooter.setSetpoint(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        shooter.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
