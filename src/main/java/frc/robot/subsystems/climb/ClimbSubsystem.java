// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.climb;

import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import frc.robot.lib.Subsystem;

public class ClimbSubsystem extends Subsystem {
  private static ClimbSubsystem instance;
  private boolean isOpen = false;

  public static ClimbSubsystem getInstance() {
    if (instance == null)
      instance = new ClimbSubsystem();
    return instance;
  }

  public static ClimbSubsystem subsystem() {
    if (instance == null)
      instance = new ClimbSubsystem();
    return instance;
  }

  private TalonFX climbMotor = new TalonFX(0);
  private MotionMagicVoltage MotionMagic = new MotionMagicVoltage(0).withEnableFOC(true);

  public ClimbSubsystem() {
  }

  private void setMotorPos(boolean open) {
    if (open)
      climbMotor.setControl(MotionMagic.withPosition(90));
    else
      climbMotor.setControl(MotionMagic.withPosition(0));
    isOpen = open;
  }

  public void togglePos() {
    setMotorPos(!isOpen);
  }

}
