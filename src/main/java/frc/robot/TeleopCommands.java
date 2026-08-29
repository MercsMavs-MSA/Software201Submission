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

    /** Holds the pivot at 0.39 rotations while scheduled, then returns to 0. */
    public Command holdPivot()
    {
        return Commands.startEnd(
            () -> arm.setPosition(0.39),
            () -> arm.setPosition(0),
            arm
        );
    }

    // I want to move the pivot to 0.39 rotations, and then it is going to wait 2 seconds, then returns to 0.
    public Command pivotSequence()
    {
        return Commands.sequence(
            Commands.runOnce(() -> arm.setPosition(0.39), arm),
            Commands.waitSeconds(2),
            Commands.runOnce(() -> arm.setPosition(0), arm)
        );
    }

    /** Sets the pivot to 0.39 rotations and prints a message at the same time. */
    public Command pivotAndPrint()
    {
        return Commands.parallel(
            Commands.runOnce(() -> arm.setPosition(0.39), arm),
            Commands.runOnce(() -> System.out.println("pivot moved to 0.39 rotations"))
        );
    }
}
