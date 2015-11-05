
package Moose.subsystems;

import Moose.commands.Lifting;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Elevator extends Subsystem {
   private Victor theOneVictor;
   private DigitalInput sensorTop, sensorBottom, sensorMiddle, encoderA, encoderB;
   private Counter counter;
   //private Solenoid cilinder;

   public Elevator (int ov, int st,int sb, int sm,int eA,int eB,int ci){
       theOneVictor       = new Victor (ov);
       sensorTop          = new DigitalInput(st);
       sensorBottom       = new DigitalInput(sb);
       sensorMiddle       = new DigitalInput(sm);
       encoderA           = new DigitalInput(eA);
       encoderB           = new DigitalInput(eB);
       counter            = new Counter(CounterBase.EncodingType.k2X, encoderA,encoderB,true);
       //cilinder           = new Solenoid(ci);
       counter.start();
   }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Lifting());    
    }
    
    public void resetCounter(){
        counter.reset();
    }
    public int getCount(){
        return counter.get();
    }
    
    public boolean getBottom(){
        return sensorBottom.get();
    }
    
    public boolean getTop(){
        return sensorTop.get();
    }
    
    public boolean getMiddle(){
        return sensorMiddle.get();
    }
    
    public void cilinderRelease(){
        //cilinder.set(false);
    }
    public void cilinderExtend(){
        //cilinder.set(true);
    }
    public void setMotors(double speed){
        theOneVictor.set(speed);
    }
    public int positionToCounts(int pos){
        if(pos == 1){
            return -100;
        }
        else if(pos == 2){
            return 7;
        }
        else if(pos == 3){
            return 15;
        }
        else if(pos == 4){
            return 100;
        }
        else{
            return 0;
        }
    }
   
    public void updateStatus(){
        SmartDashboard.putNumber("Lift Count", getCount());        
    }
}
