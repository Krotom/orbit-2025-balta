package frc.robot.lib.controller;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class XBOXController implements UniversalController {
    private CommandXboxController controller;

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

    @Override
    public Trigger getIntakeButton() {
        return controller.a();
    }

    @Override
    public Trigger getIdleButton() {
        return controller.b();
    }

    @Override
    public Trigger getShootButton() {
        return controller.rightTrigger();
    }

    @Override
    public Trigger getShootOnTheMoveButton() {
        return controller.leftTrigger();
    }
}
