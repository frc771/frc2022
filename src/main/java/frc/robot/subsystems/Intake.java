package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import com.ctre.phoenix.motorcontrol.can.*;
import frc.robot.commands.*;


public class Intake extends SubsystemBase {
    private WPI_TalonSRX talon7;

    public Intake(){
        talon7 = new WPI_TalonSRX(7);
    }

    public void In(){
        talon7.set(0.35);
    }  

    public void Out(){
        talon7.set(-0.35);
    }

    public void Kill(){
        talon7.set(0);
    }
}