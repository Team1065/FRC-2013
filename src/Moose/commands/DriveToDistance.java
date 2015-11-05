package Moose.commands;

/**
 *
 * @author atenc_000
 */

//set speed to a negative value [-1,0) to go backwards. distance should allways be positive
public class DriveToDistance extends CommandBase {
    private double speed, distance;
    
    public DriveToDistance(double speed, double distance) {
        requires(drive);
	this.speed = speed;
	this.distance = distance;
    }

    protected void initialize() {
        drive.startEncoders();
	drive.resetEncoders();
    }

    protected void execute() {
        double lVal,rVal;
        
	if(Math.abs(drive.avgEncoderCount()) <= 360 || (distance - Math.abs(drive.avgEncoderCount())) <= 360)
	{
		lVal = (speed - drive.getEncoderDifference())/2;
		rVal = (speed + drive.getEncoderDifference())/2;
	}
	else
	{
		lVal = speed - drive.getEncoderDifference();
		rVal = speed + drive.getEncoderDifference();
	}
	drive.tankDrive(lVal, rVal);
    }

    protected boolean isFinished() {
        return Math.abs(drive.avgEncoderCount()) >= distance;
    }

    protected void end() {
        drive.tankDrive(0, 0);
        drive.stopEncoders();
    }


    protected void interrupted() {
        end();
    }
}
