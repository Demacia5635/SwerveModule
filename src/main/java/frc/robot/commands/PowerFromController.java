// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.OneModule;

public class PowerFromController extends CommandBase {

  private final XboxController controller;
  private final OneModule module;
  /** Creates a new PowerFromController. */
  public PowerFromController(XboxController controller, OneModule module) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.controller = controller;
    this.module = module;
    addRequirements(module);
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    module.setPowerSpeed(-controller.getRightY());
    module.setPowerAngle(controller.getRightX());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    module.setPowerSpeed(0);
    module.setPowerAngle(0);
  }
}
