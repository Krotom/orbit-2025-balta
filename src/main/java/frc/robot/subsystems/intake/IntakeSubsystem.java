package frc.robot.subsystems.intake;

import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import static frc.robot.Constants.IntakeConstants.ACTIVE_STATOR_CURRENT_LIMIT;
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

    public IntakeSubsystem subsystem() {
        if (instance == null) {
            instance = new IntakeSubsystem();
        }
        return instance;
    }

    private final TalonFX intakeDriver = new TalonFX(0);
    private final TalonFX intakeRoller = new TalonFX(0);
    private final MotionMagicVoltage MotionMagic = new MotionMagicVoltage(0).withEnableFOC(true);
    private final VoltageOut velocity = new VoltageOut(0).withEnableFOC(true);

    public IntakeSubsystem() {
        initMethods[SuperStructure.RobotStates.idle.stateNum] = () -> {
            stop();
        };
        initMethods[SuperStructure.RobotStates.intakingCoral.stateNum] = () -> {
            openIntake(true);driveIntake();
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

        periodicMethods[SuperStructure.RobotStates.idle.stateNum] = () -> {
            stop();
        };
        periodicMethods[SuperStructure.RobotStates.intakingCoral.stateNum] = () -> {
            openIntake(true);driveIntake();
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
        enderMethods[SuperStructure.RobotStates.idle.stateNum] = () -> {
            stop();
        };
        enderMethods[SuperStructure.RobotStates.intakingCoral.stateNum] = () -> {
            stop();
        };
        enderMethods[SuperStructure.RobotStates.intakingAlgea.stateNum] = () -> {
            stop();
        };
        enderMethods[SuperStructure.RobotStates.placeCoral.stateNum] = () -> {
            stop();
        };
        enderMethods[SuperStructure.RobotStates.placeAlgea.stateNum] = () -> {
            stop();
        };

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
            intakeRoller.setControl(velocity.withOutput(3));
        } else if (!isJammed()) {
            intakeRoller.setControl(velocity.withOutput(-3));
        } else {
            intakeRoller.setControl(velocity.withOutput(0));
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
    public void stop(){
        intakeDriver.setControl(MotionMagic.withPosition(0));
        intakeRoller.stopMotor();
    }
}
