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
    public Command holdArmPosition() {
        return Commands.startEnd(
            () -> arm.setPosition(0.39),
            () -> arm.setPosition(0),
            arm);
    }

    public Command moveWaitAndReturn() {
        return Commands.sequence(
            Commands.runOnce(() -> arm.setPosition(0.39), arm),
            Commands.waitSeconds(2),
            Commands.runOnce(() -> arm.setPosition(0), arm));
    }

    public Command moveAndPrint() {
        return Commands.parallel(
            Commands.runOnce(() -> arm.setPosition(0.39), arm),
            Commands.print("Moving pivot to 0.39 rotation"));
    }
}
