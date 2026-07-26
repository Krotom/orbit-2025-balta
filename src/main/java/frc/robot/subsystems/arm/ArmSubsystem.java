package frc.robot.subsystems.arm;

import frc.robot.lib.Subsystem;
import frc.robot.subsystems.SuperStructure;

import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

public class ArmSubsystem extends Subsystem{
    private static ArmSubsystem instance;

    public static ArmSubsystem getInstance() {
        if (instance == null) {
            instance = new ArmSubsystem();
        }
        return instance;
    }

    public ArmSubsystem subsystem() {
        if (instance == null) {
            instance = new ArmSubsystem();
        }
        return instance;
    }

    private final TalonFX elevMotorR = new TalonFX(0);
    private final TalonFX elevMotorL = new TalonFX(0);
    private final MotionMagicVoltage motion = new MotionMagicVoltage(0).withEnableFOC(true);
    public final int[] setTarget = { 0, 1, 2, 3 ,4};
    int currentstate;

    public ArmSubsystem() {
        initMethods[SuperStructure.RobotStates.idle.stateNum] = () -> {
            stop();
        };
        initMethods[SuperStructure.RobotStates.intakingCoralL1.stateNum] = () -> {
            
        };
        initMethods[SuperStructure.RobotStates.intakingCoralL2.stateNum] = () -> {
           
        };
        initMethods[SuperStructure.RobotStates.intakingCoralL3.stateNum] = () -> {
            
        };
        initMethods[SuperStructure.RobotStates.intakingCoralL4.stateNum] = () -> {
            
        };
        initMethods[SuperStructure.RobotStates.intakingAlgeaLP.stateNum] = () -> {
           
        };
        initMethods[SuperStructure.RobotStates.intakingAlgeaHP.stateNum] = () -> {
            
        };
        initMethods[SuperStructure.RobotStates.placeCoral.stateNum] = () -> {
            
        };
        initMethods[SuperStructure.RobotStates.placeAlgea.stateNum] = () -> {
            
        };
        initMethods[SuperStructure.RobotStates.climbing.stateNum] = () -> {
            
        };
        periodicMethods[SuperStructure.RobotStates.idle.stateNum] = () -> {
            stop();
        };
        periodicMethods[SuperStructure.RobotStates.intakingCoralL1.stateNum] = () -> {
           
        };
        periodicMethods[SuperStructure.RobotStates.intakingCoralL2.stateNum] = () -> {
            
        };
        periodicMethods[SuperStructure.RobotStates.intakingCoralL3.stateNum] = () -> {
           
        };
        periodicMethods[SuperStructure.RobotStates.intakingCoralL4.stateNum] = () -> {
            
        };
        periodicMethods[SuperStructure.RobotStates.intakingAlgeaLP.stateNum] = () -> {
          
        };
        periodicMethods[SuperStructure.RobotStates.intakingAlgeaHP.stateNum] = () -> {
            
        };
        periodicMethods[SuperStructure.RobotStates.placeCoral.stateNum] = () -> {
          
        };
        periodicMethods[SuperStructure.RobotStates.placeAlgea.stateNum] = () -> {
           
        };
        periodicMethods[SuperStructure.RobotStates.climbing.stateNum] = () -> {
            
        };
        enderMethods[SuperStructure.RobotStates.idle.stateNum] = () -> {
            stop();
        };
        enderMethods[SuperStructure.RobotStates.intakingCoralL1.stateNum] = () -> {
            stop();
        };
        enderMethods[SuperStructure.RobotStates.intakingCoralL2.stateNum] = () -> {
            stop();
        };
        enderMethods[SuperStructure.RobotStates.intakingCoralL3.stateNum] = () -> {
            stop();
        };
        enderMethods[SuperStructure.RobotStates.intakingCoralL4.stateNum] = () -> {
            stop();
        };
        enderMethods[SuperStructure.RobotStates.intakingAlgeaLP.stateNum] = () -> {
            stop();
        };
        enderMethods[SuperStructure.RobotStates.intakingAlgeaHP.stateNum] = () -> {
            stop();
        };
        enderMethods[SuperStructure.RobotStates.climbing.stateNum] = () -> {
            stop();
        };
    }
    public void driveElev(){
        if(setTarget[0]==0){
            elevMotorL.setControl(motion.withPosition(15));
            elevMotorR.setControl(motion.withPosition(15));
        }
        else if(setTarget[1]==1){
            elevMotorL.setControl(motion.withPosition(30));
            elevMotorR.setControl(motion.withPosition(30));
        }
        else if(setTarget[2]==2){
            elevMotorL.setControl(motion.withPosition(45));
            elevMotorR.setControl(motion.withPosition(45));
        }
        else if(setTarget[3]==3){
            elevMotorL.setControl(motion.withPosition(60));
            elevMotorR.setControl(motion.withPosition(60));
        }
        else {
            elevMotorL.setControl(motion.withPosition(0));
            elevMotorR.setControl(motion.withPosition(0));
        }
    }
    
    private int setPos(int desiredPos){
        return setTarget[desiredPos];
    
    }
    //l1 50 l2l3l4110 lphp90 algae atma 190
    

}
