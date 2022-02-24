// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import com.ctre.phoenix.motorcontrol.can.*;

public class Drive extends SubsystemBase {
  /** Creates a new Drive. */
  private WPI_TalonSRX talonSRX1;
  private WPI_TalonSRX talonSRX2;
  private WPI_TalonSRX talonSRX3;
  private MotorControllerGroup MotorControllerGroup;
  private WPI_TalonSRX talonSRX4;
  private WPI_TalonSRX talonSRX5;
  private WPI_TalonSRX talonSRX6;
  private MotorControllerGroup MotorControllerGroup2;
  public DifferentialDrive differentialDrive1;

  public Drive() {
    talonSRX1 = new WPI_TalonSRX(1);
    talonSRX2 = new WPI_TalonSRX(2);
    talonSRX3 = new WPI_TalonSRX(3);
    MotorControllerGroup = new MotorControllerGroup(talonSRX1, talonSRX2, talonSRX3);
    talonSRX4 = new WPI_TalonSRX(4);
    talonSRX5 = new WPI_TalonSRX(5);
    talonSRX6 = new WPI_TalonSRX(6);
    MotorControllerGroup2 = new MotorControllerGroup(talonSRX4, talonSRX5, talonSRX6);

    differentialDrive1 = new DifferentialDrive(MotorControllerGroup, MotorControllerGroup2);

  }

  public void broombroom() {
    talonSRX1.set(0.8);
    MotorControllerGroup2.set(0.5);
  }

  public void Drivecode(double x, double y) {
    // Joystick joy = m_robotContainer.driverJoystick;
    // double x = (double) joy.getRawAxis(1);
    // double y = (double) joy.getRawAxis(5);
    // differentialDrive1.tankDrive(Math.pow(Math.sin(((Math.abs(x)) * Math.PI) /
    // 2), 2) * Math.signum(x),
    // Math.pow(Math.sin(((Math.abs(y)) * Math.PI) / 2), 2) * Math.signum(y));
    differentialDrive1.tankDrive(x * -0.75, y * 0.75);
    System.out.print("hi");
   // differentialDrive1.curvatureDrive(x * 0.75, y * 0.75, false);


  }
  /*
   * public void DriveForward() {
   * TimedCommand
   * 
   * 
   * }
   * 
   */

  public void onTest() {
    talonSRX1.set(1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
