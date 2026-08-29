package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.arm.ArmSubsystem;
import frc.robot.subsystems.arm.ArmConstants.OperatorConstants;

public class RobotContainer {
  // The robot's subsystems are defined here
  ArmSubsystem pivot = new ArmSubsystem();
  TeleopCommands teleop = new TeleopCommands(pivot);

  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  private void configureBindings() {
    m_driverController.b().whileTrue(teleop.holdPivot());

    m_driverController.x().onTrue(teleop.pivotAndPrint());
  }
}
