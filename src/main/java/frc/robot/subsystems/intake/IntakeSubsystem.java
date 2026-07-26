package frc.robot.subsystems.intake;

import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.Trigger;

import static frc.robot.Constants.IntakeConstants.*;

import java.util.function.BooleanSupplier;

import frc.robot.lib.Subsystem;
import frc.robot.subsystems.SuperStructure;

public class IntakeSubsystem extends Subsystem {

    private static IntakeSubsystem instance;

    public static Subsystem getInstance() {
        if (instance == null) {
            instance = new IntakeSubsystem();
        }
        return instance;
    }

    public static IntakeSubsystem subsystem() {
        if (instance == null) {
            instance = new IntakeSubsystem();
        }
        return instance;
    }

    private Trigger currentSpikingTrigger = new Trigger((BooleanSupplier) () -> isCurrentSpiking());
    private TalonFX indexerRightMotor = new TalonFX(INDEXER_RIGHT_MOTOR_ID);
    private TalonFX indexerLeftMotor = new TalonFX(INDEXER_LEFT_MOTOR_ID);
    private final TalonFX intakeDriver = new TalonFX(INTAKE_DRIVE_MOTOR_ID);
    private final TalonFX intakeRoller = new TalonFX(INTAKE_ROLLER_MOTOR_ID);
    private final MotionMagicVoltage MotionMagic = new MotionMagicVoltage(0).withEnableFOC(true);
    private final VoltageOut voltage = new VoltageOut(0).withEnableFOC(true);

    public IntakeSubsystem() {
        initMethods[SuperStructure.RobotStates.idle.stateNum] = () -> {
            stop();
        };
        initMethods[SuperStructure.RobotStates.intakingCoral.stateNum] = () -> {
            openIntake(true);
            driveIntake();
        };
        initMethods[SuperStructure.RobotStates.intakingAlgea.stateNum] = () -> {
            openIntake(false);
        };
        initMethods[SuperStructure.RobotStates.placeCoral.stateNum] = () -> {
            openIntake(false);
        };
        initMethods[SuperStructure.RobotStates.placeAlgea.stateNum] = () -> {
            openIntake(false);
        };
        initMethods[SuperStructure.RobotStates.climbing.stateNum] = () -> {
            openIntake(false);
        };
        periodicMethods[SuperStructure.RobotStates.idle.stateNum] = () -> {
            stop();
        };
        periodicMethods[SuperStructure.RobotStates.intakingCoral.stateNum] = () -> {
            openIntake(true);
            driveIntake();
        };
        periodicMethods[SuperStructure.RobotStates.intakingAlgea.stateNum] = () -> {
            openIntake(false);
        };
        periodicMethods[SuperStructure.RobotStates.placeCoral.stateNum] = () -> {
            openIntake(false);
        };
        periodicMethods[SuperStructure.RobotStates.placeAlgea.stateNum] = () -> {
            openIntake(false);
        };
        periodicMethods[SuperStructure.RobotStates.climbing.stateNum] = () -> {
            openIntake(false);
        };
        enderMethods[SuperStructure.RobotStates.idle.stateNum] = () -> {
            stop();
        };
        enderMethods[SuperStructure.RobotStates.intakingCoral.stateNum] = () -> {
            stop();
        };
        enderMethods[SuperStructure.RobotStates.intakingAlgea.stateNum] = () -> {
            stop();
        };
        enderMethods[SuperStructure.RobotStates.climbing.stateNum] = () -> {
            stop();
        };
        currentSpikingTrigger.onTrue(getIntakeSequenceCommand());
    }

    public boolean isCurrentSpiking() {
        double currentAmps = intakeRoller.getStatorCurrent().getValueAsDouble();
        return currentAmps > CURRENT_SPIKE_THRESHOLD;
    }

    private void openIntake(Boolean open) {
        if (open) {
            intakeDriver.setControl(MotionMagic.withPosition(45.0));
        } else {
            intakeDriver.setControl(MotionMagic.withPosition(0));
        }
    }

    private void driveIntake() {
        if (isJammed() && intakeDriver.getPosition().refresh().getValueAsDouble() > 40.0) {
            intakeRoller.setControl(voltage.withOutput(3));
        } else if (!isJammed()) {
            intakeRoller.setControl(voltage.withOutput(-3));
        } else {
            intakeRoller.setControl(voltage.withOutput(0));
        }

    }

    @Override
    public Boolean isJammed() {
        return ACTIVE_STATOR_CURRENT_LIMIT > getStatorCurrent();
    }

    private double getStatorCurrent() {
        return intakeRoller.getStatorCurrent().refresh().getValueAsDouble();
    }

    @Override
    public void stop() {
        intakeDriver.setControl(MotionMagic.withPosition(0));
        intakeRoller.stopMotor();
    }

    public void orientCoral() {
        indexerLeftMotor.setControl(voltage.withOutput(0.3));
        indexerRightMotor.setControl(voltage.withOutput(0.3));
    }

    public void intakeCoral() {
        indexerLeftMotor.setControl(voltage.withOutput(0.5));
        indexerRightMotor.setControl(voltage.withOutput(-0.5));
    }

    public void stopMotors() {
        indexerLeftMotor.setControl(voltage.withOutput(0.0));
        indexerRightMotor.setControl(voltage.withOutput(0.0));
    }

    public Command getIntakeSequenceCommand() {
        return new SequentialCommandGroup(

                new RunCommand(() -> orientCoral(), this)
                        .withTimeout(1),

                new RunCommand(() -> intakeCoral(), this)
                        .withTimeout(2),

                new RunCommand(() -> stopMotors(), this))
                        .withTimeout(0.1    );
    }
}
