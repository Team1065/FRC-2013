/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package Moose;


import Moose.commands.*;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO.EnhancedIOException;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    Command leftAutonomous,rightAutonomous,centerAutonomous;
    Command initDrive,initLift;
    Compressor compressor;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
        CommandBase.init();
        compressor = new Compressor(RobotMap.preassureSwitch, RobotMap.compressor);
        leftAutonomous = new AutonomousLeft();
        rightAutonomous = new AutonomousRight();
        centerAutonomous = new AutonomousCenter();
        // Initialize all subsystems
        initDrive = new DriveWithJoysticks();
        initLift = new Lifting();
        
    }

    public void autonomousInit() {
        compressor.start();
        
        
        try {
            // schedule the autonomous command (example)
            if(CommandBase.oi.getAutoLeft()){
                leftAutonomous.start();
            }
            else if(CommandBase.oi.getAutoRight()){
                rightAutonomous.start();
            }
            else{
                centerAutonomous.start();
            }
        } catch (EnhancedIOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        try {
            // schedule the autonomous command (example)
            if(CommandBase.oi.getAutoLeft()){
                leftAutonomous.cancel();
            }
            else if(CommandBase.oi.getAutoRight()){
                rightAutonomous.cancel();
            }
            else{
                centerAutonomous.cancel();
            }
        } catch (EnhancedIOException ex) {
            ex.printStackTrace();
        }
        initDrive.start();
        initLift.start();
        compressor.start();
        CommandBase.shooter.setLock(0);
        CommandBase.shooter.setshoot(0);
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        try {
            if(CommandBase.oi.getCompressorSwitch()){
                compressor.stop();
            }
            else{
                compressor.start();
            }
        } catch (EnhancedIOException ex) {
            ex.printStackTrace();
        }
        CommandBase.oi.updateStatus();
        CommandBase.drive.updateStatus();
        CommandBase.shooter.updateStatus();
        CommandBase.elevator.updateStatus();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
