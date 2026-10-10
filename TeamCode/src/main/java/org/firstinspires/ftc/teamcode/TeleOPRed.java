package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subSystems.intake;
import org.firstinspires.ftc.teamcode.subSystems.mecnum;

@TeleOp(name = "TeleOpRed", group = "TeleOp")
public class TeleOPRed extends OpMode {

    private mecnum drive;
    private intake Intake;

    @Override
    public void init() {
        drive = new mecnum();
        drive.init(hardwareMap);

        Intake = new intake();
        Intake.init(hardwareMap);
    }

    @Override
    public void loop() {
        // Normal mecanum driving
        drive.driveRobot(gamepad1);

        // Intake: A forward, B reverse, neither = stop
        if (gamepad1.a) {
            intake.forwards();
        } else if (gamepad1.b) {
            intake.reverse();
        } else {
            intake.stop();
        }

        telemetry.addData("Intake", gamepad1.a ? "FORWARD" :
                gamepad1.b ? "REVERSE" : "STOPPED");
        telemetry.update();
    }

    @Override
    public void stop() {
        intake.stop();
    }
}