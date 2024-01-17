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

import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;

public class Constants {
        // ---------- Vision
        // Constants about how your camera is mounted to the robot
        public static final double CAMERA_PITCH_RADIANS = Units.degreesToRadians(90); // Angle "up" from horizontal
        public static final double CAMERA_HEIGHT_METERS = Units.inchesToMeters(76); // Height above floor

        // How far from the target we want to be (need to be up against the note)
        public static final double GOAL_RANGE_METERS = Units.feetToMeters(1);

        // Where one of the Blue Source AprilTags is located
        public static final Pose3d TARGET_POSE = new Pose3d(
                        new Translation3d(
                                        Units.inchesToMeters(593.68),
                                        Units.inchesToMeters(9.68),
                                        Units.inchesToMeters(53.38)), // (center of vision target)
                        new Rotation3d(0.0, 0.0, Units.degreesToRadians(120)));
        // ----------

        // ----------
        /** Constants revolving around the vision subsystem. */
        public static final class VisionConstants {
                // Camera name
                // Must match camera set at photonvision.local:5800

                // Default
                public static final String cameraName = "Camera_Module_v1";
                //public static final String cameraName = "photonvision";
                
                // Robot to camera transform
                public static final Transform3d robotToCam = new Transform3d(
                                new Translation3d(0.0, Units.inchesToMeters(0), Units.inchesToMeters(76)),
                                new Rotation3d(0.0, 0.0, 0.0));
        }

        // Swerve modules
        public static final class ModuleConstants {
                public static final double kWheelDiameterMeters = Units.inchesToMeters(4);
                public static final double kDriveMotorGearRatio = 1 / 6.75; // old value 1 / 5.8462
                public static final double kTurningMotorGearRatio = 1 / 12.8; // old value 1 / 18.0
                public static final double kDriveEncoderRot2Meter = kDriveMotorGearRatio * Math.PI
                                * kWheelDiameterMeters;
                public static final double kTurningEncoderRot2Rad = kTurningMotorGearRatio * 2 * Math.PI;
                public static final double kDriveEncoderRPM2MeterPerSec = kDriveEncoderRot2Meter / 60;
                public static final double kTurningEncoderRPM2RadPerSec = kTurningEncoderRot2Rad / 60;

                // Used in working code currently
                public static final double kPTurning = 0.5;

                // These two used for simulation currently
                public static final double kITurning = 0.0;
                public static final double kDTurning = 0.005;

        }

        public static final class DriveConstants {

                // Distance between right and left wheels
                public static final double kTrackWidth = Units.inchesToMeters(20.1);

                // Distance between front and back wheels
                public static final double kWheelBase = Units.inchesToMeters(20.1);

                // Need to update to correct values, I dont remember the value we set last meet
                public static final SwerveDriveKinematics kDriveKinematics = new SwerveDriveKinematics(
                                new Translation2d(kWheelBase / 2, kTrackWidth / 2), // fl
                                new Translation2d(-kWheelBase / 2, kTrackWidth / 2), // fr
                                new Translation2d(kWheelBase / 2, -kTrackWidth / 2), // bl
                                new Translation2d(-kWheelBase / 2, -kTrackWidth / 2)); // br

                /*
                 * 
                 * 
                 * new Translation2d(-kWheelBase / 2, -kTrackWidth / 2), //br
                 * new Translation2d(kWheelBase / 2, -kTrackWidth / 2), //fr
                 * new Translation2d(-kWheelBase / 2, kTrackWidth / 2), //bl
                 * new Translation2d(kWheelBase / 2, kTrackWidth / 2)); //fl
                 * 
                 */

                // Driving Motor Ports
                public static final int kFrontLeftDriveMotorPort = 1; // Front Left
                public static final int kFrontRightDriveMotorPort = 3; // Front Right
                public static final int kBackRightDriveMotorPort = 5; // Back Right
                public static final int kBackLeftDriveMotorPort = 7; // Back Left

                // Turning Motor Ports
                public static final int kFrontLeftTurningMotorPort = 2; // Front Left
                public static final int kFrontRightTurningMotorPort = 4;// Front Right
                public static final int kBackRightTurningMotorPort = 6; // Back Right
                public static final int kBackLeftTurningMotorPort = 8; // Back Left

                // Encoder on NEO turning
                public static final boolean kFrontLeftTurningEncoderReversed = true;
                public static final boolean kBackLeftTurningEncoderReversed = true;
                public static final boolean kFrontRightTurningEncoderReversed = true;
                public static final boolean kBackRightTurningEncoderReversed = true;

                // Encoder for NEO drive
                public static final boolean kFrontLeftDriveEncoderReversed = true;
                public static final boolean kBackLeftDriveEncoderReversed = true;
                public static final boolean kFrontRightDriveEncoderReversed = true; //
                public static final boolean kBackRightDriveEncoderReversed = true; //

                // -------> ABE <-------- //
                public static final int kFrontLeftDriveAbsoluteEncoderPort = 0;
                public static final int kBackLeftDriveAbsoluteEncoderPort = 3;
                public static final int kFrontRightDriveAbsoluteEncoderPort = 1;
                public static final int kBackRightDriveAbsoluteEncoderPort = 2;
                // -------> ABE <-------- //

                // Absolute encoders reversed
                public static final boolean kFrontLeftDriveAbsoluteEncoderReversed = false;
                public static final boolean kBackLeftDriveAbsoluteEncoderReversed = false;
                public static final boolean kFrontRightDriveAbsoluteEncoderReversed = false;
                public static final boolean kBackRightDriveAbsoluteEncoderReversed = false;

                // Need to update values for our specific magnetic fields
                // NOT IN RADIANS!
                public static final double kFrontLeftDriveAbsoluteEncoderOffsetRad = 1.658063;// 0.98 * 2 * Math.PI;
                public static final double kBackLeftDriveAbsoluteEncoderOffsetRad = 1.4; // 1.04719 //1.04719
                public static final double kFrontRightDriveAbsoluteEncoderOffsetRad = 1.39626;// (0.0141+.25) * 2 *
                                                                                              // Math.PI;
                public static final double kBackRightDriveAbsoluteEncoderOffsetRad = -0.122173;// 0.2577 * 2 * Math.PI;

                public static final double kPhysicalMaxSpeedMetersPerSecond = 5;
                public static final double kPhysicalMaxAngularSpeedRadiansPerSecond = 2 * 2 * Math.PI;

                public static final double kTeleDriveMaxSpeedMetersPerSecond = kPhysicalMaxSpeedMetersPerSecond;
                public static final double kTeleDriveMaxAngularSpeedRadiansPerSecond = kPhysicalMaxAngularSpeedRadiansPerSecond;
                public static final double kTeleDriveMaxAccelerationUnitsPerSecond = 8; // 1.75
                // public static final double kTeleDriveMaxAccelerationUnitsPerSecond = 5;
                // //1.75
                public static final double kTeleDriveMaxAngularAccelerationUnitsPerSecond = 2; // 2

                public static final double kPThetaController = 0.001;
                public static final double kIThetaController = 0.0;
                public static final double kDThetaController = 0.00;

                public static final double kMaxDriveMotorTemp = 33.0;

        }
}
