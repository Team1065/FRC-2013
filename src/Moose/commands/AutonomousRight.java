/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Moose.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Team1065
 */
public class AutonomousRight extends CommandGroup {
    
    public AutonomousRight() {
        addSequential(new LockShooter(.5));
        addSequential(new DriveToDistance(.5,1300));//1500
        addSequential(new DriveToDistance(.2,100));
        addSequential(new StopAndWait(1));
        addSequential(new RotateToDistance(-.4,70));
        addSequential(new StopAndWait(.5));
        addSequential(new UnlockShooter(.5));
        addSequential(new StopAndWait(1));
        addSequential(new ShootOnce());
        addSequential(new StopAndWait(1.5));
        addSequential(new ShootOnce());
        addSequential(new StopAndWait(1.5));
        addSequential(new ShootOnce());
        addSequential(new DriveToDistance(-1,2000));
        addSequential(new StopAndWait(1));
    }
}
