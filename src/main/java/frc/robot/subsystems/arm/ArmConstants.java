// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.arm;

import com.ctre.phoenix6.signals.NeutralModeValue;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class ArmConstants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public record PivotGains(double p, double i, double d, double g) 
  {}

  public record PivotConfigs(
    boolean invert,
    boolean enableSupplyCurrent,
    boolean enableStatorCurrent,
    double supplyCurrentAmps,
    double statorCurrentAmps,
    NeutralModeValue neutralMode
  ) {}

  public record PivotHardware(int deviceID, double gearing){}

  public static final PivotGains PIVOT_GAINS = new PivotGains(140.0, 0.0, 0.0, 0.2);

  public static final PivotConfigs PIVOT_CONFIGS = new PivotConfigs(
    true, // invert
    true, // enableSupplyCurrent
    true, // enableStatorCurrent
    28.0, // supplyCurrentAmps
    80.0, // statorCurrentAmps
    NeutralModeValue.Brake // neutralMode
  );

  public static final PivotHardware PIVOT_HARDWARE = new PivotHardware(31, 110);
}