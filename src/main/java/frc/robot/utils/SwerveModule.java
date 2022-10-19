// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.utils;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.sensors.CANCoder;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.util.sendable.SendableBuilder;
import frc.robot.Constants.Swerve;

public class SwerveModule implements Sendable {
  /** Creates a new SwerveModule. */
  private final TalonFX speedMotor, angleMotor;
  private final CANCoder angleEncoder;
  private boolean reversed = false;

  private static final SimpleMotorFeedforward feedforward =
      new SimpleMotorFeedforward(Swerve.SPEED_KS, Swerve.SPEED_KV);

  public SwerveModule(int speedMotorPort, int angleMotorPort, int cancoderPort) {
    speedMotor = new TalonFX(speedMotorPort);
    angleMotor = new TalonFX(angleMotorPort);
    angleEncoder = new CANCoder(cancoderPort);

    speedMotor.configFactoryDefault();
    angleMotor.configFactoryDefault();

    speedMotor.config_kP(0, Swerve.SPEED_KP);
    angleMotor.config_kP(0, Swerve.ANGLE_KP);
  }

  private double getAngleChangeOnSpeed() {
    return angleMotor.getMotorOutputPercent() * Swerve.GEAR_RATIO_ANGLE_TO_SPEED / Swerve.GEAR_RATIO_SPEED;
  }

  public void setSpeed(double speed) {
    speed = speed * (reversed ? -1 : 1);
    speedMotor.set(ControlMode.Velocity, speed / Swerve.TICKS_PER_MS_TO_MPS,
        DemandType.ArbitraryFeedForward, feedforward.calculate(speed) + getAngleChangeOnSpeed());
  }

  public void setPowerSpeed(double power) {
    power = power * (reversed ? -1 : 1);
    speedMotor.set(ControlMode.PercentOutput, power);
  }

  /**
   * Gets the difference between the target angle and the current angle accourding to the cancoder.
   * @param angle the target angle
   * @return the difference between the target angle and the current angle
   */
  private double getAngleDiff(double angle) {
    double currentAngle = getAngle();
    double diff = angle - currentAngle;
    if (diff > 180) {
      diff -= 360;
    } else if (diff < -180) {
      diff += 360;
    }
    return diff;
  }

  public void setAngle(double angle) {
    double diff = getAngleDiff(angle);
    if (Math.abs(diff) > 90) {
      diff = Math.copySign(180 - Math.abs(diff), diff);
      reversed = true;
    }
    angleMotor.set(ControlMode.Position, angleMotor.getSelectedSensorPosition() + diff);
  }

  public void setPowerAngle(double power) {
    angleMotor.set(ControlMode.PercentOutput, power);
  }

  public double getAngle() {
    return angleEncoder.getAbsolutePosition();
  }

  @Override
  public void initSendable(SendableBuilder builder) {
    builder.addDoubleProperty("Angle", this::getAngle, null);
    builder.addDoubleProperty("Speed", () -> speedMotor.getSelectedSensorVelocity() * Swerve.TICKS_PER_MS_TO_MPS, null);
    builder.addBooleanProperty("Reversed", () -> reversed, null);
  }
}
