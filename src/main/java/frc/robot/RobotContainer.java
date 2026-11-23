package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.arm.ArmSubsystem;
import frc.robot.subsystems.arm.ArmConstants.OperatorConstants;

public class RobotContainer {
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

    // TODO: move these command definitions into a new file called TeleopCommands.java

    // TODO: replace this with a single command using m_driverController.b().whileTrue(...)
    m_driverController.b().whileTrue(teleopCommands.holdArmPosition());

    // TODO: Add a sequential command to button B that sets the pivot to 0.39 rotations, waits 2 seconds, and then sets the pivot back to 0 
    // Can't do B since line 27 says to use B so I will use A instead.
    
    m_driverController.a().onTrue(teleopCommands.moveWaitAndReturn());
      
    // TODO: Add a parallel command to button X that sets the pivot to 0.39 rotations and prints a message to the console at the same time
    m_driverController.x().onTrue(teleopCommands.moveAndPrint());
  }
}
