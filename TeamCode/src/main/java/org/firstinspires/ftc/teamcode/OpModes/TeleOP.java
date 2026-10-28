package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.DriveTrain.DriveTrain;
import org.firstinspires.ftc.teamcode.Subsystems.Intake;
import org.firstinspires.ftc.teamcode.Subsystems.Shooter;


@TeleOp
public class TeleOP extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        DriveTrain fieldCentricDrive = new DriveTrain(this);
        Shooter StateFarm = new Shooter(this);
        Intake intake = new Intake(this);
        waitForStart();
        while (opModeIsActive()) {
            fieldCentricDrive.fieldCentricDrive();
            StateFarm.flyWheelTeleOp();
            intake.teleOp();
        }
    }

}