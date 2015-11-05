
package Moose.commands;

import edu.wpi.first.wpilibj.DriverStationEnhancedIO.EnhancedIOException;

/**
 *
 * @author Team1065
 */
public class Lifting extends CommandBase {
    private int desiredCount;
    public Lifting() {
        // Use requires() here to declare subsystem dependencies
        requires(elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        elevator.resetCounter();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        try {
            desiredCount = elevator.positionToCounts(oi.getLiftPoition());
        } catch (EnhancedIOException ex) {
            ex.printStackTrace();
        }
        if(desiredCount > 5 && desiredCount < 95 && elevator.getMiddle()){
            elevator.setMotors(0);
            elevator.cilinderExtend();
        }
        else if(desiredCount+1 < elevator.getCount()&& !elevator.getBottom()){
            elevator.cilinderRelease();
            elevator.setMotors(-0.3);
            /*
            if(oi.getLiftEnableButton()){
                elevator.setMotors(-0.6);
            }
            else{
                elevator.setMotors(0);
            }*/
        }
        else if(desiredCount-1 > elevator.getCount() && !elevator.getTop()){
            elevator.cilinderRelease();
            elevator.setMotors(0.8);
        }
        else{
            elevator.setMotors(0);
            elevator.cilinderExtend();
        }
        
        if(elevator.getBottom()){
            elevator.resetCounter();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        elevator.setMotors(0);
        elevator.cilinderExtend();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
