
package Moose.commands;

public class LiftTop extends CommandBase {
    
    public LiftTop() {
        // Use requires() here to declare subsystem dependencies
        requires(elevator);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (!elevator.getTop()) {
            elevator.cilinderRelease();
            elevator.setMotors(0.8);
        } else {
            elevator.setMotors(0);
            elevator.cilinderExtend();
        }
    }
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return elevator.getTop();
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
