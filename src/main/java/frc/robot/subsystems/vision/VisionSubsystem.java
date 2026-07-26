package frc.robot.subsystems.vision;
import static frc.robot.Constants.VisionConstants.*;

import frc.robot.LimelightHelpers;

public class VisionSubsystem {
    
    // constructor
    public VisionSubsystem() {
    }

    public boolean isReadyToPlaceAlgae() {
        LimelightHelpers.getFiducialID(limelightName);
        
    }
}
