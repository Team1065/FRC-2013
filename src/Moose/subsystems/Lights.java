
package Moose.subsystems;

import Moose.commands.AutoLights;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lights extends Subsystem {
    
    Solenoid red,white,blue,green;
    
    public Lights(int r, int w, int b, int g){
        red= new Solenoid(r);
        white = new Solenoid(w);
        blue = new Solenoid(b);
        green = new Solenoid(g);
        
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new AutoLights());
    }
    public void setRed(boolean x){
       red.set(x);
    }
    public void setWhite(boolean x){
       white.set(x);
    }
    public void setBlue(boolean x){
       blue.set(x);
    }
    public void setGreen(boolean x){
       green.set(x);
    }
}
