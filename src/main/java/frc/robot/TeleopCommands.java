package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.arm.ArmSubsystem;

public class TeleopCommands {
    ArmSubsystem arm;
    public TeleopCommands(ArmSubsystem arm){
        this.arm = arm;
    }
    // Running a sequential command to set the arm to a position .39 and waiting 2 seconds then stowing the arm \\
    public Command objectiveOne(){
        return Commands.sequence(
            Commands.runOnce(() -> arm.setPosition(0.39)),
            Commands.waitSeconds(2),
            Commands.runOnce(()-> arm.setPosition(0))
        );


    }
    // Running the parallel command to set position to .39 and running a print command while racing the two \\
    public Command objectiveTwo(){
        return Commands.race(
            Commands.runOnce(() -> arm.setPosition(0.39)),
            Commands.print("Arm set to .39")
            );
    }
    // Running the single command \\
    public Command stowArm(){
        return Commands.runEnd(
            () -> arm.setPosition(.39),
            () -> arm.setPosition(0));
    }
}
