package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.arm.ArmSubsystem;

public class TeleopCommands
{
    ArmSubsystem arm;
    public TeleopCommands(ArmSubsystem arm)
    {
        this.arm = arm;
    }

    // TODO: your code here
    public Command Sequential() {
        return Commands.sequence(
          Commands.runOnce(() -> arm.setPosition(0.39)),
          Commands.waitSeconds(2),
          Commands.runOnce(() -> arm.setPosition(0))
          );
    }
    public Command Parallel() {
        return Commands.parallel(
            Commands.runOnce(() -> arm.setPosition(0.39)),
            Commands.print("arm set to position 0.5")
        );
    }
    public Command Pivot() {
        return Commands.runEnd(() -> arm.setPosition(0.39), () -> arm.setPosition(0));
    }
}