// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.arm;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {
  private final TalonFX pivotMotor = new TalonFX(ArmConstants.PIVOT_HARDWARE.deviceID());
  private final PositionVoltage control = new PositionVoltage(0);
  /** Creates a new ArmSubsystem. */
  public ArmSubsystem() {
    TalonFXConfiguration config = new TalonFXConfiguration();
    config.Slot0.kP = ArmConstants.PIVOT_GAINS.p();
    config.Slot0.kI = ArmConstants.PIVOT_GAINS.i();
    config.Slot0.kD = ArmConstants.PIVOT_GAINS.d();
    config.Slot0.kG = ArmConstants.PIVOT_GAINS.g();
    config.Feedback.SensorToMechanismRatio = ArmConstants.PIVOT_HARDWARE.gearing();
    config.MotorOutput.Inverted = ArmConstants.PIVOT_CONFIGS.invert() ? InvertedValue.Clockwise_Positive : InvertedValue.CounterClockwise_Positive;
    config.MotorOutput.NeutralMode = ArmConstants.PIVOT_CONFIGS.neutralMode();
    config.CurrentLimits.StatorCurrentLimitEnable = ArmConstants.PIVOT_CONFIGS.enableStatorCurrent();
    config.CurrentLimits.SupplyCurrentLimitEnable = ArmConstants.PIVOT_CONFIGS.enableSupplyCurrent();
    config.CurrentLimits.StatorCurrentLimit = ArmConstants.PIVOT_CONFIGS.statorCurrentAmps();
    config.CurrentLimits.StatorCurrentLimit = ArmConstants.PIVOT_CONFIGS.supplyCurrentAmps();
    pivotMotor.getConfigurator().apply(config);
  }
  
  public void setPosition(double rotations) {
    pivotMotor.setControl(control.withPosition(rotations));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
