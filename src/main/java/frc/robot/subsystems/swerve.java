// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.sensors.CANCoder;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
public class swerve extends SubsystemBase 
{
  int avaisthebest; //this port is turn 
  int kevinGKindaSucks; /// this port is drive
  TalonFX kevinLalsokindasucks; //talon motor turn
  TalonFX whatisyourssn; //talon motor drivee
  CANCoder encoder; // turning coder
  /** Creates a new swerve. */
  public swerve(int port1,int port2, int port34) //construchutghre
  {
    this.avaisthebest = port1; //turn port
    this.kevinGKindaSucks = port34; //drive port
    kevinLalsokindasucks = new WPI_TalonFX(avaisthebest, "CANivore");
    whatisyourssn = new WPI_TalonFX(kevinGKindaSucks,"CANivore");
    encoder = new CANCoder(port2, "CANivore"); 
  }
  public Double Angel () {
    return encoder.getAbsolutePosition();
  }
  public void setSpeed(double speed) {
    whatisyourssn.set(TalonFXControlMode.PercentOutput, speed);
    
  }
  public void setTurnSpeedy (double turnspeedy) { 
kevinLalsokindasucks.set(TalonFXControlMode.PercentOutput, turnspeedy);
   
  }
  public void setAngle(double targetAngel)
  {
    
  }


  @Override
  public void periodic() 
  {
    // This method will be called once per scheduler run
  }
}
