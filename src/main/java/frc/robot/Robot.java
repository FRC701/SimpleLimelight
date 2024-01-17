/*
 * MIT License
 *
 * Copyright (c) PhotonVision
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package frc.robot;

import static frc.robot.Constants.*;

import java.util.List;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Transform2d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.net.PortForwarder;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import frc.robot.sim.VisionSim;
import org.photonvision.PhotonCamera;
import org.photonvision.PhotonUtils;
import org.photonvision.common.hardware.VisionLEDMode;
import org.photonvision.targeting.PhotonTrackedTarget;
import org.photonvision.targeting.TargetCorner;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.VisionSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the
 * name of this class or
 * the package after creating this project, you must also update the
 * build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  // Change this to match the name of your camera
  // PhotonCamera camera = new PhotonCamera("PV");
  private RobotContainer m_robotContainer;
  private VisionSubsystem vision = new VisionSubsystem();

  // PID constants should be tuned per robot
  //PIDController forwardController = new PIDController(LINEAR_P, 0, LINEAR_D);
  //PIDController turnController = new PIDController(ANGULAR_P, 0, ANGULAR_D);

  XboxController xboxController = new XboxController(0);

  // Drive motors
  // PWMVictorSPX leftMotor = new PWMVictorSPX(LEFT_MOTOR_CHANNEL);
  // PWMVictorSPX rightMotor = new PWMVictorSPX(RIGHT_MOTOR_CHANNEL);
  // DifferentialDrive drive = new DifferentialDrive(leftMotor, rightMotor);

  @Override
  public void robotInit() {
    // leftMotor.setInverted(false);
    // rightMotor.setInverted(true);
    m_robotContainer = new RobotContainer();
    SmartDashboard.putData(CommandScheduler.getInstance());

    PortForwarder.add(8888, "wpilibpi.local", 80);
    PortForwarder.add(5800, "photonvision.local", 5800);


  }
  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run(); 
  }

  @Override
  public void teleopPeriodic() {

    // if (xboxController.getAButton()) {
    // Vision-alignment mode
    // Query the latest result from PhotonVision
    // var result = camera.getLatestResult();
    // boolean hasTargets = result.hasTargets();
    // SmartDashboard.putBoolean("Has AprilTag Target", hasTargets);

    // if (hasTargets) {

    // PhotonTrackedTarget target = result.getBestTarget();
    // double m_yaw = target.getYaw();
    // double kpitch = target.getPitch();
    // double karea = target.getArea();
    // int FiducialID = target.getFiducialId();

    // double skew = target.getSkew();//All of the data above (except skew) is
    // available when using AprilTags.

    // Transform2d pose = target.getCameraToTarget();
    // List<TargetCorner> corners = target.getDetectedCorners();
    // First calculate range

    // double range = PhotonUtils.calculateDistanceToTargetMeters(
    // CAMERA_HEIGHT_METERS,
    // TARGET_POSE.getZ(),
    // CAMERA_PITCH_RADIANS,
    // Units.degreesToRadians(result.getBestTarget().getPitch()));

    // SmartDashboard.putNumber("Target Fiducial", FiducialID);
    // SmartDashboard.putNumber("Target yaw", yaw);
    // SmartDashboard.putNumber("Target pitch", pitch);
    // SmartDashboard.putNumber("Target area", area);
    // SmartDashboard.putNumber("Target range", range);
    // SmartDashboard.putBoolean("Has AprilTag Target", hasTargets);

    // }

    // }
  }
}