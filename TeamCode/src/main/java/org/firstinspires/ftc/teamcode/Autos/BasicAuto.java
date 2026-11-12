package org.firstinspires.ftc.teamcode.Autos;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous
public class BasicAuto extends LinearOpMode {

private DcMotor leftFront;
private DcMotor leftBack;
private DcMotor rightFront;
private DcMotor rightBack;

private double POWER = 1;
private double NOPOWER= 0;


    @Override
    public void runOpMode() throws InterruptedException {
        leftFront = hardwareMap.get(DcMotor.class, "frontLeft");
        leftBack = hardwareMap.get(DcMotor.class, "backLeft");
        rightFront = hardwareMap.get(DcMotor.class, "frontRight");
        rightBack = hardwareMap.get(DcMotor.class, "backRight");


        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBack.setDirection(DcMotorSimple.Direction.FORWARD);
        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE);



        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        waitForStart();
        drivestart();
        sleep(3000);
        driverhalt();

    }


    public void drivereverse() {
        leftBack.setPower(-POWER);
        leftFront.setPower(-POWER);
        rightFront.setPower(-POWER);
        leftFront.setPower(-POWER);
    }

    public void driverstrafeleft() {
        leftBack.setPower(POWER);
        leftFront.setPower(-POWER);
        rightFront.setPower(POWER);
        rightBack.setPower(-POWER);
    }

    public void driverstraferight() {
        leftBack.setPower(-POWER);
        leftFront.setPower(POWER);
        rightFront.setPower(-POWER);
        rightBack.setPower(POWER);
    }

    public void driverhalt() {
        leftBack.setPower(NOPOWER);
        leftFront.setPower(NOPOWER);
        rightFront.setPower(NOPOWER);
        rightBack.setPower(NOPOWER);
    }

    public void drivestart() {
        leftBack.setPower(POWER);
        leftFront.setPower(POWER);
        rightFront.setPower(POWER);
        rightBack.setPower(POWER);
    }


}




