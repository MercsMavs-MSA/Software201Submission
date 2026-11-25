
package frc.robot;

import frc.robot.Constants.OperatorConstants;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.WheelConstants;
import frc.robot.subsystems.WheelSubsystem;

public class RobotContainer {
  //putting in system
  private final WheelSubsystem wheelSubsystem = new WheelSubsystem();
  //putting in driver controller
  private final CommandXboxController driverController =
    new CommandXboxController(OperatorConstants.kDriverControllerPort);
  public RobotContainer() {
    configureBindings();
  }
  private void configureBindings() {
    //xbox a button will spin wheel to target velocity
    driverController.a().onTrue(
      wheelSubsystem.runOnce(() ->
        wheelSubsystem.goToVelocity(WheelConstants.WHEEL_TARGET_VELOCITY_RPS))
    );
    //Xbox b button will stop wheel
    driverController.b().onTrue(
      wheelSubsystem.runOnce(wheelSubsystem::stop)
    );
  } 
  public Command getAutonomousCommand() {
    return Commands.none();
  } 
}