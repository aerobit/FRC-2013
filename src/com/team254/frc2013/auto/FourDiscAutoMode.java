package com.team254.frc2013.auto;

import com.team254.frc2013.commands.CheckIntakeCalibratedCommand;
import com.team254.frc2013.commands.DriveAtSpeedCommand;
import com.team254.frc2013.commands.DriveProfiledCommand;
import com.team254.frc2013.commands.ResetDriveEncodersCommand;
import com.team254.frc2013.commands.ResetGyroCommand;
import com.team254.frc2013.commands.RunIntakeCommand;
import com.team254.frc2013.commands.SetIntakeDownCommand;
import com.team254.frc2013.commands.ShiftCommand;
import com.team254.frc2013.commands.ShootSequenceCommand;
import com.team254.frc2013.commands.ShooterOnCommand;
import com.team254.frc2013.commands.ShooterPresetCommand;
import com.team254.frc2013.commands.WaitCommand;
import com.team254.frc2013.subsystems.Shooter;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Shoots two preload discs from the front of the pyramid, intakes 2 discs in
 * front of the pyramid, and returns to the start point to shoot them
 *
 * @author jonathan.chang13@gmail.com (Jonathan Chang)
 */
public class FourDiscAutoMode extends CommandGroup {

  public FourDiscAutoMode() {
    // Shoot first set of discs
    addSequential(new ShooterOnCommand(true));
    addSequential(new SetIntakeDownCommand());
    addSequential(new ShooterPresetCommand(Shooter.PRESET_FRONT_PYRAMID));
    addSequential(new ShiftCommand(false));
    addSequential(new ShootSequenceCommand());
    addSequential(new ShootSequenceCommand());

    // Drive to get second set
    addSequential(new CheckIntakeCalibratedCommand(.5));
    addSequential(new ResetDriveEncodersCommand());
    addSequential(new ResetGyroCommand());
    addSequential(new RunIntakeCommand(1));
    addSequential(new DriveAtSpeedCommand(3.5, 2, 0, 5));
    addSequential(new WaitCommand(1));

    // Drive back and shoot
    addSequential(new DriveProfiledCommand(0, 5, 0, 5));
    addSequential(new RunIntakeCommand(0.0));
    addSequential(new ShootSequenceCommand());
    addSequential(new ShootSequenceCommand());

    addSequential(new ShooterOnCommand(false));
    addSequential(new RunIntakeCommand(0.0));
  }
}
