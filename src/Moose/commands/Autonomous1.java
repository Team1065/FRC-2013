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
public class Autonomous1 extends CommandGroup {
    
    public Autonomous1() {
        addSequential(new LiftTop());
        addSequential(new StopAndWait(1));
        addSequential(new LiftBottom());
        addSequential(new StopAndWait(1));
        addSequential(new DriveToDistance(.4,100));
        addSequential(new StopAndWait(1));
        addSequential(new RotateToDistance(.4,20));
        addSequential(new StopAndWait(1));
        addSequential(new DriveToDistance(.4,50));
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
