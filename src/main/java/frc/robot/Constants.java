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
}
