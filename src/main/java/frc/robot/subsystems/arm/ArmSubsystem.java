package frc.robot.subsystems.arm;

import frc.robot.subsystems.SuperStructure;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

public class ArmSubsystem {
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
    public final Double[] setTarget = { 1.0, 2.0, 3.0, 4.0 };
    int currentstate;

    public ArmSubsystem() {
        
    }
    public void driveElev(){
        
    }
    
    private int setTarget(int desiredPos){
        return setTarget(desiredPos);
    
    } 

}
