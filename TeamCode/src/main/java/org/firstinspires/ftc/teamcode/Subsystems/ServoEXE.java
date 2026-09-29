package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class ServoEXE extends OpMode {
    TestBenchServo bench = new TestBenchServo();
    @Override
    public void init() {
        bench.init(hardwareMap);
    }

    @Override
    public void loop() {

        if (gamepad1.a) {
            bench.setServoPos(-1.0);
        }
        else {
            bench.setServoPos(1.0); {

            }
            if (gamepad1.b) {
                bench.setServoRot(1.0);
            }
            else {
                bench.setServoRot(0);
            }
        }
    }
}


/*
1. set your CR to reverse it's direction.
2. set your op mode so when you pull the left gamepad trigger, it sets the position of the pos servo
and when you pull the right gamepad trigger, 0 is off and 1 is fully on.
 */