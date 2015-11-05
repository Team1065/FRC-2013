
package Moose.commands;

/**
 *
 * @author atenc_000
 */
public class DriveForTime extends CommandBase {
    
	double lVal, rVal;
	
    public DriveForTime(double lVal, double rVal, double t) {
        requires(drive);
	this.setTimeout(t);
	this.lVal = lVal;
	this.rVal = rVal;
    }
    protected void initialize() {
    }

    protected void execute() {
		drive.tankDrive(lVal, rVal);
    }


    protected boolean isFinished() {
        return this.isTimedOut();
    }

    protected void end() {
		drive.tankDrive(0, 0);
    }

    protected void interrupted() {
		end();
    }
}

