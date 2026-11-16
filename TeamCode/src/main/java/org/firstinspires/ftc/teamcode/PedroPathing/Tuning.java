package org.firstinspires.ftc.teamcode.PedroPathing;

import com.pedropathing.revhub.drivetrains.Mecanum;
import com.pedropathing.tuning.autotune.Procedure;
import com.pedropathing.tuning.autotune.Tuner;

import org.firstinspires.ftc.teamcode.PedroPathing.procedures.MecanumTuner;
import org.firstinspires.ftc.teamcode.PedroPathing.procedures.Tests;
import org.firstinspires.ftc.teamcode.PedroPathing.procedures.TwoWheelTuner;

public class Tuning {
    @Tuner
    public static Procedure mecanumTuner() {
        return new MecanumTuner();

    }
    @Tuner
    public static Procedure test() {
        return new Tests(hardwareMap -> new Mecanum(hardwareMap, Constants.drivetrainConfig), null, null);
    }
    @Tuner
    public static Procedure twoWheelTunner() {
        return new TwoWheelTuner();
    }
}

