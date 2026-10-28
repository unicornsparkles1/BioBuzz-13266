package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    private DcMotor biteof27;
    private Gamepad fortnite;
    private Gamepad etintrof;
    public static double POWER = 1;
    public static double NOPOWER = 0;
    public Intake (OpMode opMode) {
        HardwareMap hardwareMap = opMode.hardwareMap;

        // Find a motor in the hardware map named Intake
        biteof27 = hardwareMap.dcMotor.get("intake");

        //Set up motor
        biteof27.setDirection(DcMotorSimple.Direction.FORWARD);
        biteof27.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        biteof27.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        fortnite = opMode.gamepad1;
        etintrof = opMode.gamepad2;
    }
    public void teleOp() {
        if (etintrof.left_trigger_pressed){
           go();
        }
        else if (etintrof.right_trigger_pressed) {
            no();
        }
        else{
            none();
        }
    }
    public void go(){
        biteof27.setPower(POWER);
    }
    public void no(){
        biteof27.setPower(-POWER);
    }
    public void none(){
        biteof27.setPower(NOPOWER);
    }
}
