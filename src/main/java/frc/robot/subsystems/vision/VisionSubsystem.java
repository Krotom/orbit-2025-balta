package frc.robot.subsystems.vision;
import static frc.robot.Constants.VisionConstants.*;
import static frc.robot.Constants.FieldConstants.*;

import java.util.Arrays;

import frc.robot.Constants.VisionConstants;
import frc.robot.LimelightHelpers;
import frc.robot.lib.Subsystem;

public class VisionSubsystem extends Subsystem {
    
    // constructor
    public VisionSubsystem() {
    }

    public boolean isReadyToPlaceCoral() {
        if (Arrays.stream(ALL_REEF_TAGS).anyMatch(x -> x==LimelightHelpers.getFiducialID(this.getLimelightName()))) {
            LimelightHelpers.
        }
    }

    public String getLimelightName() {
        return VisionConstants.limelightName;
    }
}
