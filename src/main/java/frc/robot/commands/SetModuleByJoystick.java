// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.OneModule;

public class SetModuleByJoystick extends CommandBase {

  private final OneModule module;
  private final Joystick joystick;
  /** Creates a new SetModuleByJoystick. */
  public SetModuleByJoystick(OneModule module, Joystick joystick) {
    this.module = module;
    this.joystick = joystick;
    addRequirements(module);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    module.setModuleSpeedAngle(joystick.getZ(), joystick.getDirectionDegrees());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    module.setPowerAngle(0);
    module.setPowerSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
