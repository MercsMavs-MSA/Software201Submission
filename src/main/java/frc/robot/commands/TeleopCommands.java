package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.Transfer.TransferSubsystem;

public class TeleopCommands {
    private TransferSubsystem transfer;
    public TeleopCommands(TransferSubsystem transfer){
      this.transfer = transfer;
    }

    public Command runTransferSequence() {
        return Commands.sequence(
            Commands.runOnce(() -> transfer.runTransfer(10), transfer),
            Commands.waitSeconds(1.0),
            Commands.runOnce(() -> transfer.runTransfer(25), transfer),
            Commands.waitSeconds(1.0),
            Commands.runOnce(() -> transfer.runTransfer(50), transfer)
        );
    }

    public Command parallelRace() {
        return Commands.runOnce(
            () -> transfer.runTransfer(15), transfer)
            .raceWith(Commands.print("Running"))
            .andThen(Commands.runOnce(() -> transfer.runTransfer(0), transfer));
            
    }
}
