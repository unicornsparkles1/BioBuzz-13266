package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class hood {
    private DcMotor mahhood;
    private Gamepad fortnite;
    private Gamepad etintrof;

    public hood(OpMode opMode) {
        HardwareMap hardwareMap = opMode.hardwareMap;

        // Find a motor in the hardware map named Intake
        mahhood = hardwareMap.dcMotor.get("Hood");

        //Set up motor
        mahhood.setDirection(DcMotorSimple.Direction.FORWARD);
        mahhood.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        mahhood.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        fortnite = opMode.gamepad1;
        etintrof = opMode.gamepad2;
    }

    public void teleOp() {
        if (etintrof.left_stick_y > 1) {
            mahhood.setPower(.5);
        } else if (fortnite.left_stick_y > -1) {
            mahhood.setPower(-.5);
        } else {
            mahhood.setPower(0);
        }
    }

}
