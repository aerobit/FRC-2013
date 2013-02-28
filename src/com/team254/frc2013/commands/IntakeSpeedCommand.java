package com.team254.frc2013.commands;

/**
 * Runs the intake a specific power.
 *
 * @author richard@team254.com (Richard Lin)
 */
public class IntakeSpeedCommand extends CommandBase {
  private double speed; 
  
  public IntakeSpeedCommand(double speed) {
    this.speed = speed;
    requires(intake);
  }
  
  protected void initialize() {    
  }

  protected void execute() {
    System.out.println("intake: " + speed);
    intake.setIntakePower(speed);
  }

  protected boolean isFinished() {
    return true;
  }

  protected void end() {
  }

  protected void interrupted() {
  }
}
