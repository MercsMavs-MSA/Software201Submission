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

    // Sequence: move to .39, wait 2 seconds, stow
    public Command objectiveOne() {
        return Commands.sequence(
            Commands.runOnce(() -> arm.setPosition(0.39)),
            Commands.waitSeconds(2),
            Commands.runOnce(() -> arm.setPosition(0))
        );
    }

    // Race: move to .39 and print
    public Command objectiveTwo() {
        return Commands.race(
            Commands.runOnce(() -> arm.setPosition(0.39)),
            Commands.print("Arm set to .39")
        );
    }

    // runEnd: hold at .39, stow when it ends
    public Command stowArm() {
        return Commands.runEnd(
            () -> arm.setPosition(0.39),
            () -> arm.setPosition(0)
        );
    }

    // Mix: move + print together, hold 2 seconds, then stow
    public Command objectiveMix() {
        return Commands.sequence(
            Commands.parallel(
                Commands.runOnce(() -> arm.setPosition(0.39)),
                Commands.print("Arm set to .39")
            ),
            Commands.runEnd(
                () -> arm.setPosition(0.39),
                () -> arm.setPosition(0)
            ).withTimeout(2)
        );
    }
}