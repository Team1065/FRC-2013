
package Moose.commands;

/**
 *
 * @author Team1065
 */
public class DriveWithJoysticks extends CommandBase {
    
    public DriveWithJoysticks() {
        requires(drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        drive.startEncoders();
        drive.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(oi.getTracktionButton()){
            drive.TractionDown();
            drive.tankDrive(oi.getLeftY(), oi.getRightY());
            drive.resetEncoders();
        }
        else{
            drive.TractionUp();
            
            double joystickDiff = Math.abs(oi.getLeftY()-oi.getRightY());
            double leftMotorValue,rightMotorValue;
            
            if(oi.getMecanumButton())
            {
                if(oi.getRightY()<.5 && oi.getRightY()>-.5 && Math.abs(oi.getLeftY())<.5)
                {
                    drive.mecanumFeedback(oi.getRightX()-drive.getEncoderDifference(), oi.getRightX()+drive.getEncoderDifference()); 
                }
                else
                {
                    drive.mecanumDriveCartesian(oi.getRightX(), -oi.getRightY(), oi.getLeftY(),0);
                }
            }
            else
            {
                if(oi.getLeftY() > .5 && oi.getRightY() > .5)
                {
                    if(joystickDiff < .40)
                    {
                        leftMotorValue = oi.getYAverage() - drive.getEncoderDifference();
                        rightMotorValue = oi.getYAverage() + drive.getEncoderDifference();
                        if(leftMotorValue < 0)
                        {
                            leftMotorValue = 0;
                        }
                        if(rightMotorValue < 0)
                        {
                            rightMotorValue = 0;
                        }
                        drive.tankDrive(leftMotorValue, rightMotorValue);
                    }
                    else
                    {
                        drive.tankDrive(oi.getLeftY(), oi.getRightY());
                    }
                }
                else if(oi.getLeftY() > 0 && oi.getRightY() > 0)
                {
                    if(joystickDiff < .30)
                    {
                        leftMotorValue = oi.getYAverage() - drive.getEncoderDifference();
                        rightMotorValue = oi.getYAverage() + drive.getEncoderDifference();
                        if(leftMotorValue < 0)
                        {
                            leftMotorValue = 0;
                        }
                        if(rightMotorValue < 0)
                        {
                            rightMotorValue = 0;
                        }
                        drive.tankDrive(leftMotorValue, rightMotorValue);
                   }
                   else
                   {
                        drive.tankDrive(oi.getLeftY(), oi.getRightY());
                   }
                }
                else if(oi.getLeftY() < -.5 && oi.getRightY() < -.5)
                {
                    if(joystickDiff < .40)
                    {
                        leftMotorValue = oi.getYAverage() - drive.getEncoderDifference();
                        rightMotorValue = oi.getYAverage() + drive.getEncoderDifference();
                        if(leftMotorValue > 0)
                        {
                            leftMotorValue = 0;
                        }
                        if(rightMotorValue > 0)
                        {
                            rightMotorValue = 0;
                        }
                        drive.tankDrive(leftMotorValue, rightMotorValue);
                    }
                    else
                    {
                        drive.tankDrive(oi.getLeftY(), oi.getRightY());
                    }
                }
                else if(oi.getLeftY() < 0 && oi.getRightY() < 0)
                {
                    if(joystickDiff < .30)
                    {
                        leftMotorValue = oi.getYAverage() - drive.getEncoderDifference();
                        rightMotorValue = oi.getYAverage() + drive.getEncoderDifference();
                        if(leftMotorValue > 0)
                        {
                            leftMotorValue = 0;
                        }
                        if(rightMotorValue > 0)
                        {
                            rightMotorValue = 0;
                        }
                        drive.tankDrive(leftMotorValue, rightMotorValue);
                    }
                    else
                    {
                        drive.tankDrive(oi.getLeftY(), oi.getRightY());
                    }
                }
                else
                {
                    drive.tankDrive(oi.getLeftY(), oi.getRightY());
                }
            }
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        drive.TractionUp();
        drive.stopEncoders();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
