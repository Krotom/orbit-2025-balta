package frc.robot.subsystems.arm.pneumatic;

import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;

import frc.robot.lib.Subsystem;
import frc.robot.subsystems.SuperStructure;

public class PneumaticSubsystem extends Subsystem {
    private static PneumaticSubsystem instance;

    public static PneumaticSubsystem getInstance() {
        if (instance == null) {
            instance = new PneumaticSubsystem();
        }
        return instance;
    }

    public PneumaticSubsystem subsystem() {
        if (instance == null) {
            instance = new PneumaticSubsystem();
        }
        return instance;
    }

    private final TalonFX pneuMotor = new TalonFX(0);
    private final VoltageOut voltage = new VoltageOut(0).withEnableFOC(true);

    public PneumaticSubsystem() {
        initMethods[SuperStructure.RobotStates.idle.stateNum] = () -> {
            stop();
        };

        initMethods[SuperStructure.RobotStates.placeCoral.stateNum] = () -> {
            controlVacuum();
        };
        initMethods[SuperStructure.RobotStates.placeAlgea.stateNum] = () -> {
            controlVacuum();
        };

        periodicMethods[SuperStructure.RobotStates.idle.stateNum] = () -> {
            stop();
        };

        periodicMethods[SuperStructure.RobotStates.placeCoral.stateNum] = () -> {
            controlVacuum();
        };
        periodicMethods[SuperStructure.RobotStates.placeAlgea.stateNum] = () -> {
            controlVacuum();
        };

        enderMethods[SuperStructure.RobotStates.idle.stateNum] = () -> {
            stop();
        };

        enderMethods[SuperStructure.RobotStates.placeCoral.stateNum] = () -> {
            stop();
        };
        enderMethods[SuperStructure.RobotStates.placeAlgea.stateNum] = () -> {
            stop();
        };
        enderMethods[SuperStructure.RobotStates.climbing.stateNum] = () -> {
            stop();
        };
    }

    public void controlVacuum() {
        // if(isReady()){
        // pneuMotor.stopMotor();}
        // else{
        pneuMotor.setControl(voltage.withOutput(9.0));
        // }

    }

    @Override
    public void stop() {
        pneuMotor.stopMotor();
    }
   
    // public boolean ready(){
    // return burada swerve eğer ki tam kilitlenmişse true döncek;

}
