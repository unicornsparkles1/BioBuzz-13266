package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class
Shooter {
    public final DcMotor StateFarm;

    public final HardwareMap hardwareMap;
    public final Gamepad Driver2;
    public final Gamepad Driver1;
    public final Telemetry telemetry;
    public static double POWER = 1;
    public static double NOPOWER = 0;


    public Shooter(OpMode opMode) {

        Driver2 = opMode.gamepad2;
        Driver1 = opMode.gamepad1;
        hardwareMap = opMode.hardwareMap;
        telemetry = opMode.telemetry;

        StateFarm = hardwareMap.get(DcMotor.class,"StateFarm" );

        StateFarm.setDirection(DcMotorSimple.Direction.REVERSE);

        StateFarm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


    }
    public void flyWheelTeleOp() {
        if (Driver2.a) forward();
        else if (Driver2.y) back();
        else stop();
    }

    public void forward(){
        StateFarm.setPower(POWER);
    }
    public void back(){
        StateFarm.setPower(-POWER);
    }
    public void stop(){
        StateFarm.setPower(NOPOWER);
    }
}