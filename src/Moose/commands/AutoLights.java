/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Moose.commands;

/**
 *
 * @author Team1065
 */
public class AutoLights extends CommandBase {
    
    public AutoLights() {
        // Use requires() here to declare subsystem dependencies
        requires(lights);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        lights.setRed(elevator.getTop());
        lights.setWhite(elevator.getMiddle());
        lights.setBlue(elevator.getBottom());
        if((Math.abs(shooter.getPosition()-shooter.getSetpoint()))/shooter.getSetpoint()<.08){
            lights.setGreen(true);
        }
        else{
            lights.setGreen(false);
        }
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
