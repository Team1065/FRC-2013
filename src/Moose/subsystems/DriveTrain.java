
package Moose.subsystems;

import Moose.commands.DriveWithJoysticks;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Team1065
 */
public class DriveTrain extends Subsystem {
    private Jaguar fLeft, fRight, bLeft, bRight;
    //private Solenoid traction;
    private Encoder leftFrontEncoder, rightBackEncoder;
    private RobotDrive drive;
    private double proportional;
    
    public DriveTrain(int flm,int frm,int blm,int brm,int solenoid,int lfeA, int lfeB,
                      int rbeA, int rbeB)
    {
        fLeft = new Jaguar(flm);
        fRight = new Jaguar(frm);
        bLeft = new Jaguar(blm);
        bRight = new Jaguar(brm);
        //traction = new Solenoid(solenoid);
        leftFrontEncoder = new Encoder(lfeA, lfeB,true,CounterBase.EncodingType.k1X);
        rightBackEncoder = new Encoder(rbeA, rbeB,false,CounterBase.EncodingType.k1X);
        drive = new RobotDrive(fLeft,bLeft, fRight, bRight);
        leftFrontEncoder.setDistancePerPulse(6*3.14/360);
        rightBackEncoder.setDistancePerPulse(6*3.14/360);
        drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        proportional = (1.00/200.00);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoysticks());
    }
    
    public void startEncoders()
    {
        leftFrontEncoder.start();
        rightBackEncoder.start();
    }
    
    public void stopEncoders()
    {
        leftFrontEncoder.stop();
        rightBackEncoder.stop();
    }
    
    public void resetEncoders()
    {
        leftFrontEncoder.reset();
        rightBackEncoder.reset();
    }
    
    public double avgEncoderCount()
    {
        return (leftFrontEncoder.get()+rightBackEncoder.get())/2.0;
    }
    
    public double avgEncoderAbsCount()
    {
        return (Math.abs(leftFrontEncoder.get())+Math.abs(rightBackEncoder.get()))/2.0;
    }
    //in case we want to change it somewhere else in the code
    public void setEncoderProportional(double proportional)
    {
        this.proportional = proportional;
    }
    //for straight drive
    public double getEncoderDifference()
    {
        double diff = (leftFrontEncoder.getRate()-rightBackEncoder.getRate())*proportional;
        if (diff >.5)
        {
            diff = .5;
        }
        else if (diff < -.5)
        {
            diff = -.5;
        }
        return diff;
    }
    
    //
    public double getEncoderAbsDifference()
    {
        double diff = (Math.abs(leftFrontEncoder.getRate())-Math.abs(rightBackEncoder.getRate()))*proportional;
        if (diff >.5)
        {
            diff = .5;
        }
        else if (diff < -.5)
        {
            diff = -.5;
        }
        return diff;
    }
    
    public void TractionDown()
    {
        //traction.set(true);
    }
    
    public void TractionUp()
    {
        //traction.set(false);
    }
    
    public void tankDrive(double leftVal, double rightVal)
    {
        fLeft.set(leftVal);
        bLeft.set(leftVal);
        fRight.set(-rightVal);
        bRight.set(-rightVal);
    }
    //for straight mecanum drive
    public void mecanumFeedback(double motors1,double motors2)
    {
        fLeft.set(motors1);
        bRight.set(-motors2);
        bLeft.set(-motors2);
        fRight.set(motors1);
    }
    
    public void mecanumDriveCartesian(double xVal, double yVal, double rotation, double gyroAngle)
    {
        drive.mecanumDrive_Cartesian(xVal, yVal, rotation, gyroAngle);
    }
    
    public void updateStatus()
    {
        //SmartDashboard.putNumber("Encoder Left Rate",leftFrontEncoder.getRate());
        //SmartDashboard.putNumber("Encoder Right Rate",rightBackEncoder.getRate());
        //SmartDashboard.putNumber("Encoder Left Count",leftFrontEncoder.get());
        //SmartDashboard.putNumber("Encoder Right Count",rightBackEncoder.get());
        //SmartDashboard.putNumber("front left",fLeft.get());
        //SmartDashboard.putNumber("front right",fRight.get());
        //SmartDashboard.putNumber("Encoder Difference",getEncoderDifference());
    }
}
