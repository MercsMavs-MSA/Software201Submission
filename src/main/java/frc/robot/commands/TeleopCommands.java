package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Constants.WheelConstants;
import frc.robot.subsystems.Wheel_subsystem;

public class TeleopCommands {
  private final Wheel_subsystem wheelSubsystem;

  public TeleopCommands(Wheel_subsystem wheelSubsystem) {
    this.wheelSubsystem = wheelSubsystem;
  }

  // Single command, spins wheel while B button is held, stops when released
  public Command spinWheelWhileHeld() {
    return Commands.startEnd(
        () -> wheelSubsystem.goToVelocity(WheelConstants.WHEEL_TARGET_VELOCITY_RPS),
        wheelSubsystem::stop,
        wheelSubsystem);
  }

  //Goes step by step, spins wheel, waits 2 seconds, then stops
  public Command spinThenStopSequence() {
    return Commands.runOnce(
            () -> wheelSubsystem.goToVelocity(WheelConstants.WHEEL_TARGET_VELOCITY_RPS),
            wheelSubsystem)
        .andThen(Commands.waitSeconds(2.0))
        .andThen(Commands.runOnce(wheelSubsystem::stop, wheelSubsystem));
  }

  // Parallel command, spins wheel and prints a message at the same time
  public Command spinAndPrintParallel() {
    return Commands.parallel(
        Commands.runOnce(
            () -> wheelSubsystem.goToVelocity(WheelConstants.WHEEL_TARGET_VELOCITY_RPS),
            wheelSubsystem),
        Commands.runOnce(() -> System.out.println("Spinning wheel to target velocity!")));
  }
}
