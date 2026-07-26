package frc.robot.subsystems;

import java.util.ArrayList;

import frc.robot.lib.Subsystem;

public class SuperStructure extends Subsystem {
    private final ArrayList<Subsystem> subsystems;
    private static SuperStructure instance;

    public SuperStructure() {
        this.subsystems = new ArrayList<>();
    }

    public static SuperStructure getInstance() {
        if (instance == null) {
            instance = new SuperStructure();
        }
        return instance;
    }  


    private RobotStates currentState = RobotStates.idle;

    public enum RobotStates {
        idle(0),
        placingCoralL1(1),
        placingCoralL2(2),
        placingCoralL3(3),
        placingCoralL4(4),
        placingAlgeaLP(5),
        placingAlgeaHP(6),
        intakingAlgea(7),
        intakingCoral(8),
        climbing(9);

        public final int stateNum;

        RobotStates(int stateNum) {
            this.stateNum = stateNum;
        }
    }

    public void addSubsystem(Subsystem subsystem) {
        subsystems.add(subsystem);
    }

    @Override
    public void writePeriodicOutputs() {
        for (Subsystem subsystem : subsystems) {
            subsystem.periodicMethods[currentState.stateNum].run();
        }
    }

    public void changeState(RobotStates newState) {
        for (Subsystem subsystem : subsystems) {
            subsystem.enderMethods[currentState.stateNum].run();
        }
        currentState = newState;
        for (Subsystem subsystem : subsystems) {
            subsystem.initMethods[currentState.stateNum].run();
        }
    }

    public RobotStates getCurrentState() {
        return currentState;
    }

}
