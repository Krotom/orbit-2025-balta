// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.lib.controller;


/* An interface class for usage in other controller types wrappers. */
public interface UniversalController {
    /**
     * @return The forward/backward translation axis (usually left Y) as forward
     *         positive
     */
    double getDriveForwardAxis();

    /** @return The left/right translation axis (usually left X) as left positive */
    double getDriveStrafeAxis();

    /**
     * @return The rotational axis (usually right X) as counterclockwise positive
     */
    double getDriveRotationAxis();
}
