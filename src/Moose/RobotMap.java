package Moose;


public class RobotMap {
    
    //Lift Knob values
    public static final double 
            liftVDposition1 = 0.5,
            liftVDposition2 = 1.2,
            liftVDposition3 = 2,
            liftVDposition4 = 3;// not used because an else is used in logic
    
    //Shooter Knob values
    public static final double 
            shooterVDposition0 = 0.5,
            shooterVDposition1 = 1,
            shooterVDposition2 = 1.7,
            shooterVDposition3 = 2.05,
            shooterVDposition4 = 2.7,
            shooterVDposition5 = 3.15;
    
    //Motors PMW input on Robot
    public static final int 
            frontLeftMotor  = 1,  
            frontRightMotor = 2,  
            backLeftMotor   = 3,  
            backRightMotor  = 4,  
            shooterMotor    = 5,
            liftMotor       = 6;
    
    //Pnuematic Actuator
    public static final int
            shooterAct = 1,
            discLock   = 2,
            angleAct    =3,
            //liftAct    = 3,
            nandoAct    =4,
            //dropDown   = 4,
            greenLight = 5,
            redLight   = 6,
            whiteLight = 7,
            BlueLight  = 8;
    
    //Digital Input
    public static final int
           preassureSwitch   = 1,
           encoderLeftA      = 2,
           encoderLeftB      = 3,
           encoderRightA     = 4,
           encoderRightB     = 5,
           shooterEncoder    = 6,
           LiftEncoderA      = 7,
           LiftEncoderB      = 8,
           LiftBottom        = 9,
           LiftTop           = 10,
           LiftMiddle        = 11;
    
    //Relays
    public static final int
           compressor   = 1;
    
    //JoyStick Inpts
    public static final int 
            leftJoyPort       = 1,
            rightJoyPort      = 2,
            extraJoyPort      = 3,
            triggerPort       = 1,  // shoot the balls
            mecanumButtonPort = 2;  // turn on mecanum
    //Enhanced IO
    public static final int 
            shooterFeedbackEnablePort = 6,
            //liftEnablePort            = 2,
            disckLockPort             = 8;  // turn on mecanum

    //Shooter PID values 
    public static final double
            proportional = 1.0,//.0000295,
            iterative    = .00000,
            derivative   = 0.0;//.00009;
    
    //Shooter RPM values
    public static final double
            SpeedRpm1 = 0000.00,
            SpeedRpm2 = 2700.00,
            SpeedRpm3 = 2900.00,
            SpeedRpm4 = 4100.00,
            SpeedRpm5 = 4300.00,
            SpeedRpm6 = 5000.00;
    
    //Shooter PWM values
    public static final double
            SpeedPwm1 = 0,
            SpeedPwm2 = .3,
            SpeedPwm3 = .4,
            SpeedPwm4 = .5,
            SpeedPwm5 = .8,
            SpeedPwm6 = 1;
            
    
}      