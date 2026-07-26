package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;

public class Constants {
    public static class RobotStateConstants{
        public static final Integer stateCount = 3;
    }
    public static class IntakeConstants{
        public static final Double ACTIVE_STATOR_CURRENT_LIMIT=40.0;
        public static final double CURRENT_SPIKE_THRESHOLD = 35.0;
        public static final Integer INDEXER_RIGHT_MOTOR_ID=0;
        public static final Integer INDEXER_LEFT_MOTOR_ID=0;
        public static final Integer INTAKE_DRIVE_MOTOR_ID=0;
        public static final Integer INTAKE_ROLLER_MOTOR_ID=0;
    }
    public static class ClimbConstants{
        public static final Integer CLIMB_MOTOR_ID =0;
    }

    public static class VisionConstants {
        public static final String limelightName = "balta-limelight";
    }

    public static class FieldConstants [
        public static final var allianceColor = DriverStation.getAlliance();
        public static final ArrayList<int> BLUE_REEF_TAGS = {};
    ]
}
