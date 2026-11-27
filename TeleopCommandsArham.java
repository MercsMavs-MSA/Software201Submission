public class TeleopCommands {
    private final WheelSubsystem wheelSubsystem;

    public TeleopCommands(WheelSubsystem wheelSubsystem) {
        this.wheelSubsystem = wheelSubsystem;
    }
    public Command spinWhilePressed()
    {
        return wheelSubsystem.startEnd
        (
            () -> wheelSubsystem.goToVelocity(0.39),
            () -> wheelSubsystem.goToVelocity(0)
        );
    }
    public Command spinSequence()
    {
        return Commands.sequence(
            Commands.runOnce(()->wheelSubsystem.goToVelocity(0.39)),
            Commands.waitSeconds(2),
            Commands.runOnce(()->wheelSubsystem.goToVelocity(0))
        );
    }
    public Command parallelSpin()
    {
        return Commands.parallel
        (
            Commands.runOnce(()->wheelSubsystem.goToVelocity(0.39)),
            Commands.print("Wheel subsystem set to 0.39 rotations per second")
        );
    }
}