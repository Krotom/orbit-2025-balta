package frc.robot.lib.controller;

import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class PS4Controller implements UniversalController {
    private CommandPS4Controller controller;

    public PS4Controller(int port) {
        this.controller = new CommandPS4Controller(port);
    }

    @Override
    public double getDriveForwardAxis() {
        return -controller.getLeftY();
    }

    @Override
    public double getDriveStrafeAxis() {
        return -controller.getLeftX();
    }

    @Override
    public double getDriveRotationAxis() {
        return -controller.getRightX();
    }

    @Override
    public Trigger getIntakeButton() {
        return controller.square();
    }

    @Override
    public Trigger getIdleButton() {
        return controller.triangle();
    }

    @Override
    public Trigger getShootButton() {
        return controller.R2();
    }

    @Override
    public Trigger getShootOnTheMoveButton() {
        return controller.L2();
    }
    
}
