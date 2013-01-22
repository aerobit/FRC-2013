package com.team254.frc2013;

import com.team254.frc2013.commands.CommandBase;
import com.team254.frc2013.commands.DriveDistanceCommand;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * Main class of the robot.
 *
 * @author richard@team254.com (Richard Lin)
 */
public class Travus extends IterativeRobot {
  private Command autonomousCommand;

  /**
   * Called when the robot is first started up and should be used for any initialization code.
   */
  public void robotInit() {
    // Initialize all subsystems.
    CommandBase.init();
  }

  /**
   * Called once at the start of the autonomous period.
   */
  public void autonomousInit() {
    autonomousCommand = new DriveDistanceCommand(12, 1, 10);
  }

  /**
   * Called periodically during the autonomous period.
   */
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * Called once at the start of the teleoperated period.
   */
  public void teleopInit() {
    // Make sure that the autonomous stops running when teleop begins.
    autonomousCommand.cancel();
  }

  /**
   * Called periodically during the teleoperated period.
   */
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }
}