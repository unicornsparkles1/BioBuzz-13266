
package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;

public class Intake {

    private final DcMotor biteof27;
    private final Gamepad fortnite;
    private final Gamepad etintrof;

    public static double POWER = 1.0;
    public static double NOPOWER = 0.0;

    public Intake(OpMode opMode) {

        biteof27 = opMode.hardwareMap.get(DcMotor.class, "intake");

        biteof27.setDirection(DcMotorSimple.Direction.FORWARD);
        biteof27.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        biteof27.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        fortnite = opMode.gamepad1;
        etintrof = opMode.gamepad2;
    }

    public void teleOp() {
        if (etintrof.left_trigger > 0.1) {
            go();
        } else if (etintrof.right_trigger > 0.1) {
            no();
        } else {
            none();
        }
    }

    public void go() {
        biteof27.setPower(POWER);
    }

    public void no() {
        biteof27.setPower(-POWER);
    }

    public void none() {
        biteof27.setPower(NOPOWER);
    }
}
