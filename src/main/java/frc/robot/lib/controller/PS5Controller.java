package frc.robot.lib.controller;

import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;

public class PS5Controller implements UniversalController {
    private CommandPS5Controller controller;

    public PS5Controller(int port) {
        this.controller = new CommandPS5Controller(port);
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
}
