package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;


import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

import frc.robot.subsystems.arm.ArmSubsystem;
import frc.robot.subsystems.arm.ArmConstants.OperatorConstants;


public class RobotContainer extends Command  {
  // The robot's subsystems are defined here
  ArmSubsystem pivot = new ArmSubsystem();
  TeleopCommands teleopCommands = new TeleopCommands(pivot);
    
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);
  
  public RobotContainer() {
    // Configure the trigger bindings
    
    configureBindings();




  }

  private void configureBindings() {
    // TODO: move these command definitions into a new file called TeleopCommands.java
  
    m_driverController.b()
        .onTrue(teleopCommands.practiceCommand());
    m_driverController.x()
        .onTrue(teleopCommands.parallelCommand());
  }

    // TODO: replace this with a single command using m_driverController.b().whileTrue(...)
   // m_driverController.b().onTrue(Commands.runOnce(() -> pivot.setPosition(0.39))).onFalse(Commands.runOnce(() -> pivot.setPosition(0)));

    // TODO: Add a sequential command to button B that sets the pivot to 0.39 rotations, waits 2 seconds, and then sets the pivot back to 0 

    // TODO: Add a parallel command to button X that sets the pivot to 0.39 rotations and prints a message to the console at the same time 
}

