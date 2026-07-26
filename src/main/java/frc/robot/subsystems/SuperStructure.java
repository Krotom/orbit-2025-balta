package frc.robot.subsystems;

import java.util.ArrayList;

import frc.robot.lib.Subsystem;

public class SuperStructure extends Subsystem {
    private final ArrayList<Subsystem> subsystems;
    private static SuperStructure instance;

    public SuperStructure(ArrayList<Subsystem> subsystems) {
        this.subsystems = subsystems;
    }


    


    private RobotStates currentState = RobotStates.idle;

    public enum RobotStates {
        idle(0),
        intakingCoralL1(1),
        intakingCoralL2(2),
        intakingCoralL3(3),
        intakingCoralL4(4),
        intakingAlgeaLP(5),
        intakingAlgeaHP(6),
        placeAlgea(7),
        placeCoral(8),
        climbing(9);

        public final int stateNum;

        RobotStates(int stateNum) {
            this.stateNum = stateNum;
        }
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
