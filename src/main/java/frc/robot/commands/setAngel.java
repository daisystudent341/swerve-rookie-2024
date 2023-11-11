// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import javax.swing.text.StyleContext.SmallAttributeSet;

import org.opencv.features2d.MSER;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.swerve;

public class setAngel extends CommandBase {
  /** Creates a new setAngel. */
  swerve mSwerveModule;
  double targetAngel;
  public setAngel(swerve swerveModule, double targetAngle) {
    mSwerveModule = swerveModule;
    targetAngel = targetAngle;
    addRequirements(swerveModule);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double currentAngel = mSwerveModule.Angel();
    double error = targetAngel - currentAngel;

    double kP = 1.0/360.0;
    SmartDashboard.putNumber("error", error);
    mSwerveModule.setTurnSpeedy(kP * error);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    mSwerveModule.setSpeed(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    double currentAngle = mSwerveModule.Angel();
    if (Math.abs(targetAngel - currentAngle) < 4.76543) return true;
    else return false; // :)
  }
}
