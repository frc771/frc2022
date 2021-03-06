// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.Drive;
import frc.robot.commands.DriveCommand;
import frc.robot.RobotContainer;
import frc.robot.Robot;
import frc.robot.subsystems.*;

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
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;
  private Subsystem m_subsystem;
  private double startTime;
  
  
// private Drive m_Drive;
   private Drive m_Drive;
   public static Subsystem m_Intake;

  /**
   * This function is run when the robot is first started up and should be used
   * for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer. This will perform all our button bindings,
    // and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
   //  m_subsystem = new Subsystem(); 
  //  m_subsystem = new subsystem();
    // m_Drive = new Drive();
     m_Drive = new Drive();
     m_Intake = new Intake();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and
   * test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler. This is responsible for polling buttons, adding
    // newly-scheduled
    // commands, running already-scheduled commands, removing finished or
    // interrupted commands,
    // and running subsystem periodic() methods. This must be called from the
    // robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your
   * {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();
    
    

    startTime = Timer.getFPGATimestamp();
    
  


    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      
      m_autonomousCommand.schedule();

    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic( ) {
   double time = Timer.getFPGATimestamp();
   
   //public static void delay = double 3;
  

    if (time-startTime <1.5){
      //time-startime<1.5
     //((Drive) m_subsystem).DriveBackward(-0.6);
     
     //((Drive)m_subsystem).MotorControllerGroup(-0.6);
    // ((Drive)m_subsystem).MotorControllerGroup2(-0.6);
     Drive.MotorControllerGroup.set(0.4);
     Drive.MotorControllerGroup2.set(-0.4);

    }
    else{
      try {((Drive) m_subsystem).DriveBackward(0);}
      catch (NullPointerException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {
  }
}
