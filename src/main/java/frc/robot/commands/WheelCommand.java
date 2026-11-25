// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Wheel_subsystem;

public class ExampleCommand extends Command {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final Wheel_subsystem wheelSubsystem;

    private final double targetRps;

    public ExampleCommand(Wheel_subsystem wheelSubsystem, double targetRps) {
        this.wheelSubsystem = wheelSubsystem;
        this.targetRps = targetRps;
        addRequirements(wheelSubsystem);
    }

    @Override
    public void initialize() {
        wheelSubsystem.goToVelocity(targetRps);
    }

    @Override
    public void execute() {}

    @Override
    public void end(boolean interrupted) {
        wheelSubsystem.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
