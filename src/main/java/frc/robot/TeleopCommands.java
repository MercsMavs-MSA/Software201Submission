package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.arm.ArmSubsystem;

public class TeleopCommands {
    private ArmSubsystem arm;
    public TeleopCommands(ArmSubsystem arm){
        this.arm = arm;
    }
    public Command objectiveOne(){
        return Commands.sequence(
            Commands.runOnce(() -> arm.setPosition(0.39)),
            Commands.waitSeconds(1),
            Commands.runOnce(()-> arm.setPosition(0))
        );


    }
    public Command objectiveTwo(){
        return Commands.race(
            Commands.runOnce(() -> arm.setPosition(0.39)),
            Commands.print("Arm set to .39")
            );
    }
    public Command stowArm(){
        return Commands.runOnce(()-> arm.setPosition(0));
    }
}
