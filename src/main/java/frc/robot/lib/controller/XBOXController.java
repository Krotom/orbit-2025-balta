package frc.robot.lib.controller;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class XBOXController implements UniversalController {
    public CommandXboxController controller;

    public XBOXController(int port) {
        this.controller = new CommandXboxController(port);
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
