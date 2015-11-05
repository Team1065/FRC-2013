
package Moose.commands;

import Moose.RobotMap;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO.EnhancedIOException;

/**
 *
 * @author Team1065
 */
public class ShootingWithoutFeedback extends CommandBase {
    private double speed;
    public ShootingWithoutFeedback() {
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
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
            if(oi.getDisckLockButton()){
                shooter.lock();
                shooter.retract();
            }
            else{
                shooter.unlock();
                if(oi.getShootButton()){
                    shooter.extend();
                }
                else{
                    shooter.retract();
                }
            }
            if(oi.getPostion() == 1)
            {
                speed = RobotMap.SpeedPwm1;
            }
            else if(oi.getPostion() == 2)
            {
                speed = RobotMap.SpeedPwm2;
            }
            else if(oi.getPostion() == 3)
            {
                speed = RobotMap.SpeedPwm3;
            }
            else if(oi.getPostion() == 4)
            {
                speed = RobotMap.SpeedPwm4;
            }
            else if(oi.getPostion() == 5)
            {
                speed = RobotMap.SpeedPwm5;
            }
            else if(oi.getPostion() == 6)
            {
                speed = RobotMap.SpeedPwm6;
            }
            else
            {
                speed = 0;
            }
        } catch (EnhancedIOException ex) {
            ex.printStackTrace();
        }
        shooter.shooterSet(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
