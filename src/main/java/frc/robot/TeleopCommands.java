package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.arm.ArmConstants.OperatorConstants;
import frc.robot.subsystems.arm.ArmSubsystem;

public class TeleopCommands
{

    
    
    private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

    ArmSubsystem arm;
    public TeleopCommands(ArmSubsystem arm)
    {
        this.arm = arm;
    }

    // TODO: your code here

    public Command SequentialCommand(double position){ 

        return Commands.sequence(

         Commands.runOnce( () -> arm.setPosition(position), arm)
        .andThen(Commands.waitSeconds(1))
        .andThen(Commands.runOnce(() -> arm.setPosition(0)))
     
        ); 
    }

    public Command ParallelCommand()

}

