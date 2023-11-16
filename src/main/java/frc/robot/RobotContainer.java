// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.TeleopSwerve;
import frc.robot.commands.setAngel;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.swerve;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final XboxController mProgrammingController = new XboxController(
    0);
    swerve backLeft = new swerve(15, 7, 11);
    swerve backRight = new swerve(16, 8, 12);
    swerve FrontLeft = new swerve(14, 6, 10 );
    swerve FrontRight = new swerve(17, 9, 13);
    Drivebase s = new Drivebase(backLeft, backRight, FrontLeft, FrontRight);
    double angle = 0.0;
   
    private final Joystick joystick = new Joystick(0);

    private final int yTranslationAxis = XboxController.Axis.kLeftY.value;  //  Gets how much the left joystick is pushed in the y-axis.
    private final int xTranslationAxis = XboxController.Axis.kLeftX.value;  //  Gets how much the left joystick is pushed in the x-axis.
    private final int turnAxis = XboxController.Axis.kRightX.value; //  Gets how much the right joystick is pushed in the x-axis.
    //  Or something like that.

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Trigger mProgrammingRB = new Trigger(() -> mProgrammingController.getRightBumper());
    // mProgrammingRB.whileTrue(new InstantCommand(() -> s.setSpeed(1.0)));
    // Trigger mProgrammingLB = new Trigger(() -> mProgrammingController.getLeftBumper());
    // mProgrammingLB.whileTrue(new setAngel(s, angle));
    // Trigger mProgrammingA = new Trigger(() -> mProgrammingController.getAButton());
    // mProgrammingA.whileTrue(new setAngel(s, 90));
    // mProgrammingController.getLeftX();
    // mProgrammingController.getLeftY();

    s.setDefaultCommand(new TeleopSwerve(s, ()->  mProgrammingController.getLeftX(), ()-> mProgrammingController.getLeftY()));

    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    
    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return null;
    // An example command will be run in autonomous
  }
}
