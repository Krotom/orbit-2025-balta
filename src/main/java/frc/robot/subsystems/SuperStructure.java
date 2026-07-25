package frc.robot.subsystems;

import java.util.ArrayList;

public class SuperStructure extends Subsystem{
    private final ArrayList <Subsystem> subsystems;
    public SuperStructure(ArrayList<Subsystem> subsystems){
        this.subsystems=subsystems; 

    }
    
}
