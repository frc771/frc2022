// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class Hanger extends SubsystemBase {
  private WPI_TalonSRX talonSRX7;
  private WPI_TalonSRX talonSRX8;
  public static MotorControllerGroup MotorControllerGroup3;
  /** Creates a new Hanger. */
  public Hanger() {
    talonSRX7 = new WPI_TalonSRX(7);
    talonSRX8 = new WPI_TalonSRX(8);
    MotorControllerGroup3 = new MotorControllerGroup(talonSRX7, talonSRX8);
  }

  public void Up(){
    MotorControllerGroup3.set(0.35);
  }

  public void Down(){
    MotorControllerGroup3.set(-0.35);
  }

  public void Kill(){
    MotorControllerGroup3.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
