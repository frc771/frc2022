// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import javax.swing.text.html.HTMLDocument.HTMLReader.HiddenAction;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.GenericHID;
//import edu.wpi.first.wpilibj.buttons.Button;
//import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.*;
import frc.robot.commands.*;
import frc.robot.subsystems.*;


/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drive m_Drive = new Drive();
  public Joystick driverJoystick = new Joystick(0);
  private final Hanger m_Hanger = new Hanger();
  private final Intake m_Intake = new Intake();

  private final auto m_autoCommand = new auto(m_Drive);

  public Joystick oJoystick = new Joystick(1);

  public JoystickButton A1 = new JoystickButton(oJoystick, 1);
  public JoystickButton B1 = new JoystickButton(oJoystick, 2);
  public JoystickButton X1 = new JoystickButton(oJoystick, 3);
  public JoystickButton Y1 = new JoystickButton(oJoystick, 4);
  public JoystickButton TL = new JoystickButton(oJoystick, 5);
  public JoystickButton TR = new JoystickButton(oJoystick, 6);
  public JoystickButton back = new JoystickButton(oJoystick, 7);
  public JoystickButton start = new JoystickButton(oJoystick, 8);
  public JoystickButton lStick = new JoystickButton(oJoystick, 9);
  public JoystickButton A2 = new JoystickButton(driverJoystick, 1);
  public JoystickButton B2 = new JoystickButton(driverJoystick, 2);
  public JoystickButton X2 = new JoystickButton(driverJoystick, 3);
  public JoystickButton Y2 = new JoystickButton(driverJoystick, 4);
  public JoystickButton TL2 = new JoystickButton(driverJoystick, 5);
  public JoystickButton TR2 = new JoystickButton(driverJoystick, 6);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    m_Drive.setDefaultCommand(new DriveCommand(m_Drive, () -> driverJoystick.getRawAxis(1), () -> driverJoystick.getRawAxis(5)));
    m_Hanger.setDefaultCommand(new HangerKill(m_Hanger));
    m_Intake.setDefaultCommand(new IntakeKill(m_Intake)); 


  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */

   //

   
  private void configureButtonBindings() {

    Y1.whileHeld(new HangerUp(m_Hanger));
    A1.whileHeld(new HangerDown(m_Hanger));
    TR.whileHeld(new HangerKill(m_Hanger));
    B1.whileHeld(new IntakeIn(m_Intake));
    X1.whileHeld(new IntakeOut(m_Intake));
    Y1.whileHeld(new IntakeKill(m_Intake));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An DriveCommand will run in autonomous
    return m_autoCommand;
  }
}
