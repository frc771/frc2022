package frc.robot.commands;


import frc.robot.subsystems.Drive;
import edu.wpi.first.wpilibj2.command.CommandBase;

import java.util.DoubleSummaryStatistics;
import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Robot;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

public class IntakeOut extends CommandBase{
    private final Intake m_Intake;

    public IntakeOut(Intake intake){
        m_Intake = intake;
        addRequirements(m_Intake);
    }

    @Override
  public void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() { 
    m_Intake.Out();
  }

  // Make this return true when this Command no longer needs to run execute()
 @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

