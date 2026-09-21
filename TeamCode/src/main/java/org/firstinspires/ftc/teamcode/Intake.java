package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    private DcMotor biteof27;
    private Gamepad fortnite;
    private Gamepad etintrof;
    public Intake (OpMode opMode) {
        HardwareMap hardwareMap = opMode.hardwareMap;

        // Find a motor in the hardware map named Intake
        biteof27 = hardwareMap.dcMotor.get("intake");

        //Set up motor
        biteof27.setDirection(DcMotorSimple.Direction.FORWARD);
        biteof27.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        biteof27.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        fortnite = opMode.gamepad1;
    }
    public void teleOp() {
        if (fortnite.left_trigger_pressed){
            biteof27.setPower(.5);
        }
        else if (fortnite.right_trigger_pressed) {
            biteof27.setPower(-.5);
        }
        else{
            biteof27.setPower(0);
        }
    }
}
