// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.swerve;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TeleopSwerve extends CommandBase {
  /** Creates a new TeleopSwerve. */
  private Drivebase swerve50;
  DoubleSupplier xTranslationSupplier, yTranslationSupplier, turnSupplier;
  private Double maxSpeed;
  public TeleopSwerve(Drivebase swerve50, DoubleSupplier xTranslationSupplier, DoubleSupplier yTranslationSupplier) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.swerve50 = swerve50;
    this.xTranslationSupplier = xTranslationSupplier; //  Moving.
    this.yTranslationSupplier = yTranslationSupplier; //  Turning.
    addRequirements(swerve50);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //  Sets the speed of the movement and turning.
    double xspeed=xTranslationSupplier.getAsDouble()*-5;
    double yspeed=yTranslationSupplier.getAsDouble()*5;
    double turnspeed=turnSupplier.getAsDouble();
    swerve50.drive(new Translation2d(xspeed, yspeed), turnspeed, 5.);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
