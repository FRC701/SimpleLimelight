 // FRC2106 Junkyard Dogs - Continuity Base Code - www.team2106.org

package frc.robot;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.filter.Debouncer.DebounceType;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.networktables.StringPublisher;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.VisionSubsystem;
import frc.robot.subsystems.SwerveSubsystem;
import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandGenericHID;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

// Ignore unused variable warnings
@SuppressWarnings("unused")

public class RobotContainer {

  // Converted to 2023 wpiblib

  //------------------------------------O-B-J-E-C-T-S-----------------------------------//

  // Deprecated joysticks
  //private final Joystick leftJoystick = new Joystick(IOConstants.kLeftJoystick);
  //private final Joystick rightJoystick = new Joystick(IOConstants.kRightJoystick);


  // Create led strips
 // private final LightStrip strips = new LightStrip(tx16s,0);


  
  // Create vision subsystem
  private final VisionSubsystem visionSubsystem = new VisionSubsystem();

  

  // Create xbox controller
  //private final XboxController xbox = new XboxController(3);
  private final CommandXboxController xbox = new CommandXboxController(3);
  private final XboxController xboxNC = new XboxController(3);

  // private final VL53L4CX vl53l4cx = new VL53L4CX(20000);

  //----------------------A-U-T-O---C-O-M-M-A-N-D-S----------------------------//


  //Command REDtwoPieceWithLessPaths = new TwoPieceWithLessPaths(swerveSubsystem, elevatorSubsystem, grabberSubsystem, xController, yController, ppThetaController, strips);
  //------------------------------------C-O-N-S-T-R-U-C-T-O-R----------------------------//

  public RobotContainer(){

    //CameraServer.startAutomaticCapture();
    //PathPlannerServer.startServer(5811);

  
    // Set swerve subsystem default command to swerve joystick with respective joystick inputs
  //>--------------O-L-D--T-R-A-N-S----------------//

  // Joystick Numbers 0 = LEFT : 1 = RIGHT
  // Joystick Axises: 0 = left/right : 1 = forward/backwards : 2 = dial
  // OLD-> Transmitter Axises: 0 = roll : 1 = pitch : 2 = throttle : 3 = yaw : 4 = analog1 : 5 = analog2

  /* 
    swerveSubsystem.setDefaultCommand(new SwerveJoystick(swerveSubsystem,
    () -> tx16s.getRawAxis(0), // X-Axis
    () -> -tx16s.getRawAxis(1), // Y-Axis
    () -> tx16s.getRawAxis(3), // R-Axis
    () -> tx16s.getRawButton(0), // Field oriented -does nothing right now
    () -> swerveSubsystem.getHeading(), // Navx heading
    () -> tx16s.getRawButton(4))); // Flick offset button, should be toggle!
  */

 //>-----------T-X-1-6-S---------<//

//swerveSubsystem.setDefaultCommand(new SwerveJoystick(swerveSubsystem,
//() -> -tx16sCOMD.getRawAxis(0), // X-Axis
//() -> tx16sCOMD.getRawAxis(1), // Y-Axis
//() -> tx16sCOMD.getRawAxis(3), // R-Axis
//() -> tx16s.getRawButton(2), // Field oriented -does nothing right now
//() -> swerveSubsystem.getHeading(), // Navx heading
//() -> tx16s.getRawButton(4))); // Flick offset button, should be toggle!

  //>----------S-E-N-D-E-R----------<//

    // Run button binding method
    configureButtonBindings();

  //>---------D-E-F-A-U-L-T----------<//

  /* elevatorSubsystem.setDefaultCommand(new ElevatorJoystick(elevatorSubsystem,
  () -> xbox.getRawAxis(1))); */

  /* grabberSubsystem.setDefaultCommand(new GrabberTrigger(grabberSubsystem,
  () -> xbox.getRawAxis(3))); */

  }

  //------------------------------------D-E-B-U-G------------------------------------//

  private double zeroFunct(){return 0;}

  private boolean trueFunct(){return true;}

  private boolean falseFunct(){return false;}

  //------------------------------------B-U-T-T-O-N-S------------------------------------//

  // Create button bindings
  private void configureButtonBindings(){

    // ELEVATOR SOLENOID
   // new JoystickButton(tx16s, 3).onTrue(new ElevatorSolenoid(elevatorSubsystem));

    // 4 Y - Garbber Solenoid
    //xbox.y().onTrue(new GrabberSolenoid(grabberSubsystem));

    // 1 A - Grabber Intake Forward
  //  xbox.a().onTrue(new GrabberForward(grabberSubsystem));
//    xbox.a().toggleOnFalse(new GrabberHold(grabberSubsystem));

    // 2 B - Grabber Intake Reverse
    //xbox.b().onTrue(new GrabberReverse(grabberSubsystem));
    //xbox.b().toggleOnFalse(new GrabberHold(grabberSubsystem));

    // 3 X - Elevator Zero
    //xbox.x().onTrue(new ElevatorZero(elevatorSubsystem, grabberSubsystem));

    // 5 LB - Low Score
   // xbox.leftBumper().onTrue(new ScoreBottom(elevatorSubsystem, grabberSubsystem));

    // 6 RB - High Score
   // xbox.rightBumper().onTrue(new ScoreTop(elevatorSubsystem, grabberSubsystem));

    // 9 LJ - Loading station
   // xbox.button(9).onTrue(new LoadPlatform(elevatorSubsystem, grabberSubsystem));

    // 10 RJ - GrabrveMove(swerveSubsystem,
   // () -> swerveSubsystem.getHber angle zero
    //xbox.button(10).onTrue(new Sweeading(), 1.0,1.0));

   //xbox.button(10).onTrue(new AutoBalance(swerveSubsystem, strips));
   //xbox.button(10).onTrue(new LoadSlide(elevatorSubsystem, grabberSubsystem));

    // 10 RJ - Reset Odometry
   // xbox.button(10).onTrue(new ResetOdometry(swerveSubsystem, new Pose2d()));
   // xbox.button(10).onTrue(new ResetOdometry(swerveSubsystem, new Pose2d()));

    // Manual grabber angle test code
   // xbox.axisGreaterThan(1, 0.55).onTrue(new GrabberTrigger(grabberSubsystem, () -> xbox.getRawAxis(1)));
    
    // D-PAD LED Color selection
   // xbox.povUp().toggleOnTrue(new SetLedGameObject(leds, true));

   // xbox.povDown().toggleOnTrue(new SetLedGameObject(leds, false));

    //xbox.povLeft().toggleOnTrue(new SetLedWhiteMode(leds, "strobe"));
    //xbox.povRight().toggleOnTrue(new SetLedRed(strips));

    //tx16sCOMD.axisGreaterThan(1, 50.0).toggleOnTrue(new ElevatorZero(elevatorSubsystem, grabberSubsystem));

    // Homing
    //new JoystickButton(xbox, 1).onTrue(new ElevatorHome(elevatorSubsystem));
    // Apriltag
    // new JoystickButton(xbox, 2).onTrue(new ElevatorApriltag(elevatorSubsystem, visionSubsystem));
    // Meters
    // new JoystickButton(xbox, 3).onTrue(new ElevatorMeters(elevatorSubsystem, 1.0));

    //--------------// Auto Bindings

  }

  //------------------------------------R-E-F-E-R-R-E-R-S------------------------------------//

   // public void containerResetAllEncoders(){ swerveSubsystem.resetAllEncoders();}

}