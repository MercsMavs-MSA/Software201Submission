package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.Wheel_subsystem;

public final class Autos {
    public static Command wheelAuto(Wheel_subsystem wheelSubsystem) {
        return Commands.none();
    }

    private Autos() {
        throw new UnsupportedOperationException("This is a utility class!");
    }
}