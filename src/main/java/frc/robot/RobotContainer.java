package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.arm.ArmSubsystem;
import frc.robot.subsystems.arm.ArmConstants.OperatorConstants;

public class RobotContainer extends Command  {
  // The robot's subsystems are defined here
  ArmSubsystem pivot = new ArmSubsystem();
  TeleopCommands teleopCommands = new TeleopCommands(pivot);
    
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);
  
  public RobotContainer() {
    // Configure the trigger bindings
    
    configureBindings();


  }

  private void configureBindings() {
  
  
    m_driverController.b()
        .onTrue(teleopCommands.objectiveOne());
    m_driverController.x()
        .onTrue(teleopCommands.objectiveTwo());
    m_driverController.b().onTrue(Commands.runOnce(() -> pivot.setPosition(0.39))).onFalse(Commands.runOnce(() -> pivot.setPosition(0)));
  }

}