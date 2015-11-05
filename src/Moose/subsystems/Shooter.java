/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Moose.subsystems;

import Moose.RobotMap;
import Moose.commands.ShootingWithFeedback;
import Moose.commands.ShootingWithoutFeedback;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Elisabeth
 */
public class Shooter extends PIDSubsystem {

    Jaguar shootingMotor,shootingMotor2;
    Counter shooterEncoder;
    Solenoid shooterActuator, discLock,angleAct,nandoAct;  
    
    private int lock=0;
     private int shoot=0;

    private static final double Kp = RobotMap.proportional;           
    private static final double Ki = RobotMap.iterative;
    private static final double Kd = RobotMap.derivative;
    

    // Initialize your subsystem here
    public Shooter(int motor, int encoder) {
  
        super("Shooter", Kp, Ki, Kd);
        shootingMotor = new Jaguar(motor);
        shootingMotor2 = new Jaguar(7);
        shooterEncoder = new Counter(encoder);
        shooterEncoder.start();
        shooterActuator = new Solenoid (RobotMap.shooterAct);
        discLock = new Solenoid (RobotMap.discLock);
        angleAct = new Solenoid (RobotMap.angleAct);
        nandoAct = new Solenoid (RobotMap.nandoAct);
        setSetpoint(0);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ShootingWithoutFeedback());
        
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        return getRPM();
    }
    
    public void setLock(int x) {
        // Return your input value for the PID loop
        lock = x;
    }
    
    public int getLock() {
        // Return your input value for the PID loop
        return lock;
    }
    
    public void setshoot(int x) {
        // Return your input value for the PID loop
        shoot = x;
    }
    
    public int getshoot() {
        // Return your input value for the PID loop
        return shoot;
    }
    
    protected void usePIDOutput(double output) {
        double speed = shootingMotor.get() + output;
        if (speed > .75 && this.getSetpoint()<2600) {
            speed = .7;
        }
        else if (speed > .85 && this.getSetpoint()<3600) {
            speed = .8;
        }
        else if (speed < 0) {
            speed = 0;
        }
       shooterSet (speed);
    }
    public void stopShooter (){
        shootingMotor.set(0);
        shootingMotor2.set(0);
    }
    public void shooterSet (double speed) {
        shootingMotor.set(speed);
        shootingMotor2.set(speed);
    }
    
    public double getRPM () {
        return 60.00/shooterEncoder.getPeriod();
    }
    
    public double getEncoderRaw () {
        return shooterEncoder.get();
    }
    
    public void extend(){
        shooterActuator.set(true);
    }
    
    public void retract(){
        shooterActuator.set(false);
    }
    public void lock(){
        discLock.set(true);
    }
    public void unlock(){
        discLock.set(false);
    }
    public void setAngleAct(boolean x){
        angleAct.set(x);
    }
    public void setNandoAct(boolean x){
        nandoAct.set(x);
    }
    
    public void updateStatus(){
        SmartDashboard.putNumber("shooting RPM", getRPM());
        //SmartDashboard.putNumber("shooting raw", getEncoderRaw());
        //SmartDashboard.getNumber("Threashold", (Math.abs(this.getPosition()-this.getSetpoint()))/this.getSetpoint());
        
    }
}
