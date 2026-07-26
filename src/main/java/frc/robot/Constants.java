package frc.robot;

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

    public static class FieldConstants {
        public static final int[] BLUE_REEF_TAGS = {17, 18, 19, 20, 21, 22};
        public static final int[] RED_REEF_TAGS = {6, 7, 8, 9, 10, 11};
        public static final int[] ALL_REEF_TAGS = {6, 7, 8, 9, 10, 11, 17, 18, 19, 20, 21, 22};
    }
}
