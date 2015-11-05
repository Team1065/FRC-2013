package Moose.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import Moose.OI;
import Moose.RobotMap;
import Moose.subsystems.DriveTrain;
import Moose.subsystems.Elevator;
import Moose.subsystems.Lights;
import Moose.subsystems.Shooter;

public abstract class CommandBase extends Command {

    public static OI oi;
    public static DriveTrain drive;
    public static Shooter shooter;
    public static Elevator elevator;
    public static Lights lights;

    public static void init() {

        
        drive = new DriveTrain(RobotMap.frontLeftMotor, RobotMap.frontRightMotor ,RobotMap.backLeftMotor,RobotMap.backRightMotor, 
                               0, RobotMap.encoderLeftA,RobotMap.encoderLeftB,RobotMap.encoderRightA,RobotMap.encoderRightB);
        shooter = new Shooter(RobotMap.shooterMotor,RobotMap.shooterEncoder);
        elevator = new Elevator(RobotMap.liftMotor,RobotMap.LiftTop,RobotMap.LiftBottom, RobotMap.LiftMiddle,RobotMap.LiftEncoderA,RobotMap.LiftEncoderB,0);
        lights = new Lights(RobotMap.redLight,RobotMap.whiteLight, RobotMap.BlueLight, RobotMap.greenLight);
        oi = new OI();
        //SmartDashboard.putData(drive);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
