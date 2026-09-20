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
    public Command minMaxCommand() {
        return Commands.sequence(
            Commands.runOnce(() -> arm.setPosition(0)),
            Commands.waitSeconds(1),
            Commands.runOnce(() -> arm.setPosition(0.39))
        );
    }

    public Command printMoveCommand() {
        return Commands.parallel(
            Commands.runOnce(() -> arm.setPosition(0.39)),
            Commands.print("Arm Subsystem Set to 0.39 rotations")
        );
    }

    public Command pivotCommand() {
        return Commands.runEnd(
            () -> arm.setPosition(0.39), 
            () -> arm.setPosition(0)
        );
    }
}