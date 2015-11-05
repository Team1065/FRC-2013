/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Moose.commands;

/**
 *
 * @author Team1065
 */
public class ShootOnce extends CommandBase {
    
    public ShootOnce() {
        this.setTimeout(1.5);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //shooter.extend();
        shooter.setshoot(1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return this.isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        //shooter.retract();
        shooter.setshoot(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
