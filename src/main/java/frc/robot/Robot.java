package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
//has periodical callbacks, all the overrides and the inits and periodics
public class Robot extends TimedRobot {
  private Command autonomousCommand;
  private RobotContainer robotContainer;
  //once when robot boots up
  @Override 
  public void robotInit() {
    robotContainer = new RobotContainer();
  }
  //runs continously with commandscheduler help
  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}
  //once when autonomous starts, starts the code in RobotContainer I think
  @Override
  public void autonomousInit() {
    autonomousCommand = robotContainer.getAutonomousCommand();

    if (autonomousCommand != null) {
      autonomousCommand.schedule();
    }
  }
  @Override
  public void autonomousPeriodic() {}
  //once when teleop starts
  @Override
  public void teleopInit() {
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }
  }
  @Override
  public void teleopPeriodic() {}
  //once when test mode starts, cancels all the other commands
  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }
  @Override
  public void testPeriodic() {}
}