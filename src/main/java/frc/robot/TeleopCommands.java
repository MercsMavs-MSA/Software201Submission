package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.arm.ArmSubsystem;

public class TeleopCommands
{
    private ArmSubsystem arm;

    public TeleopCommands(ArmSubsystem arm)
    {
        this.arm = arm;
    }

    // My Code:

    public Command practiceCommand(){
        return Commands.sequence(
            Commands.runOnce(
                () -> arm.setPosition(0.0) //Replace with Min
            
    
            ),
        

            Commands.waitSeconds(1.0),
        
            Commands.runOnce(
                () -> arm.setPosition(0.2) //Replace With Midpoint
            ),

            Commands.waitSeconds(1.0),

            Commands.runOnce(
                () -> arm.setPosition(0.4)  //Replace With Extreme

            )

        
     
        );
    }
    public Command parallelCommand(){
        return Commands.parallel(
            Commands.runOnce(
                ()->arm.setPosition(0.2)

            ),
            Commands.runOnce(
               () -> System.out.println("Pivot Arm is moving. X button has been activated!")

            )

        );
    }

}