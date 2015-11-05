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
public class AutonomousCenter extends CommandGroup {
    
    public AutonomousCenter() {
        addSequential(new UnlockShooter(.5));
        addSequential(new StopAndWait(7));
        addSequential(new ShootOnce());
        addSequential(new StopAndWait(1));
        addSequential(new ShootOnce());
        addSequential(new StopAndWait(1));
        addSequential(new ShootOnce());
        addSequential(new StopAndWait(1));
        addSequential(new ShootOnce());
        addSequential(new StopAndWait(1));
        addSequential(new ShootOnce());
    }
}
