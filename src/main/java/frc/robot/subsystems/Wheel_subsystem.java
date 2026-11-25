package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Wheel_subsystem extends SubsystemBase {
    private final TalonFX wheelMotor;
    private final VelocityVoltage velocityRequest;

    public Wheel_subsystem() {
        wheelMotor = new TalonFX(Constants.WheelConstants.WHEEL_MOTOR_ID);
        velocityRequest = new VelocityVoltage(0);

        TalonFXConfiguration config = new TalonFXConfiguration();

        config.Slot0.kV = Constants.WheelConstants.WHEEL_KV;
        config.Slot0.kA = Constants.WheelConstants.WHEEL_KA;
        config.Slot0.kP = Constants.WheelConstants.WHEEL_KP;
        config.Slot0.kI = Constants.WheelConstants.WHEEL_KI;
        config.Slot0.kD = Constants.WheelConstants.WHEEL_KD;

        config.CurrentLimits.StatorCurrentLimitEnable = true;
        config.CurrentLimits.SupplyCurrentLimitEnable = true;
        config.CurrentLimits.StatorCurrentLimit = 80;
        config.CurrentLimits.SupplyCurrentLimit = 60;

        config.Feedback.SensorToMechanismRatio = Constants.WheelConstants.wheel_gear_ratio;

        wheelMotor.getConfigurator().apply(config);
    }

    public void goToVelocity(double rps) {
        wheelMotor.setControl(velocityRequest.withVelocity(rps));
    }

    public void stop() {
        wheelMotor.setControl(velocityRequest.withVelocity(0));
    }
}