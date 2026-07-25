package frc.robot.subsystems;

import java.util.ArrayList;

import frc.robot.lib.Subsystem;

public class SuperStructure extends Subsystem {
    private final ArrayList<Subsystem> subsystems;

    public SuperStructure(ArrayList<Subsystem> subsystems) {
        this.subsystems = subsystems;
    }

    private RobotStates currentState = RobotStates.idle;

    public enum RobotStates {
        idle(0),
        intakingCoral(1),
        intakingAlgea(2),
        placeAlgea(3),
        placeCoral(4);

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

}
