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
}