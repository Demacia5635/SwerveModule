// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.Constants.Swerve;
import frc.robot.commands.SetModuleByJoystick;
import frc.robot.utils.SwerveModule;

public class OneModule extends SubsystemBase {
  private final SwerveModule module;
  /** Creates a new OneModule. */
  public OneModule() {
    module = new SwerveModule(Swerve.FRONT_LEFT_SPEED_MOTOR, Swerve.FRONT_LEFT_ANGLE_MOTOR, Swerve.FRONT_LEFT_ANGLE_ENCODER);
    SmartDashboard.putData(module);

    setDefaultCommand(new SetModuleByJoystick(this, RobotContainer.controller));
  }

  public void setModuleSpeedAngle(double speed, double angle) {
    module.setSpeed(speed);
    module.setAngle(angle);
  }

  public void setPowerSpeed(double power) {
    module.setPowerSpeed(power);
  }

  public void setPowerAngle(double power) {
    module.setPowerAngle(power);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
