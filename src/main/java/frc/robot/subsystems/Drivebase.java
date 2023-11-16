// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.sensors.Pigeon2;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivebase extends SubsystemBase {
  swerve mBackLeft;
  swerve mBackRight;
  swerve mFrontLeft;
  swerve mFrontRight;
  Pigeon2 mGyro = new Pigeon2(0,"CANivore");
  double trackWidth = Units.inchesToMeters(17.73);
  double wheelBase = Units.inchesToMeters(24.73);
  SwerveDriveKinematics swerveKinematic;
  SwerveDriveOdometry swerveOdometry;

  
  /** Creates a new Drivebase. */
  public Drivebase(swerve backLeft, swerve backRight, swerve frontLeft, swerve frontRight) 
  {
    mBackLeft = backLeft; 
    mBackRight = backRight;
    mFrontLeft = frontLeft;
    mFrontRight = frontRight;
    SwerveModulePosition [] ModulePositions = {mFrontLeft.getPosition(), mFrontRight.getPosition(), mBackLeft.getPosition(), mBackRight.getPosition()};
    swerveKinematic = new SwerveDriveKinematics(new Translation2d(wheelBase / 2.0, trackWidth / 2.0), new Translation2d(wheelBase / 2.0, -trackWidth / 2.0), new Translation2d(-wheelBase / 2.0, trackWidth / 2.0), new Translation2d(-wheelBase / 2.0, -trackWidth / 2.0));
    swerveOdometry = new SwerveDriveOdometry(swerveKinematic, new Rotation2d(mGyro.getYaw()), ModulePositions);
  }
  /**
   * drives 
   * @param moreunderstandingname translsation speeds for x and y
   * @param veryprofessionalcode rotation speed
   * @param kevinsameany max speed of robot
   */
  public void drive(Translation2d moreunderstandingname, double veryprofessionalcode, double kevinsameany)
  {
    ChassisSpeeds swerveChassisSpeeds = ChassisSpeeds.fromFieldRelativeSpeeds(moreunderstandingname.getX(), moreunderstandingname.getY(), veryprofessionalcode, new Rotation2d(mGyro.getYaw()));
    SwerveModuleState[] name = swerveKinematic.toSwerveModuleStates(swerveChassisSpeeds);
    SwerveDriveKinematics.desaturateWheelSpeeds(name, kevinsameany);
    mBackLeft.setAngle(name[2].angle.getRadians());
    mBackRight.setAngle(name[3].angle.getRadians());
    mFrontRight.setAngle(name[1].angle.getRadians());
    mFrontLeft.setAngle(name[0].angle.getRadians());

    mBackLeft.setVelocity(name[2].speedMetersPerSecond);
    mBackRight.setVelocity(name[3].speedMetersPerSecond);
    mFrontRight.setVelocity(name[1].speedMetersPerSecond);
    mFrontLeft.setVelocity(name[0].speedMetersPerSecond);
  }
  @Override
  public void periodic() 
  {
    // This method will be called once per scheduler run
  }
}
