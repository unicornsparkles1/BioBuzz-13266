package org.firstinspires.ftc.teamcode.limelight;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class measureDistance extends OpMode {

    private Limelight3A limelight3A;

    private double CAMERA_HEIGHT_CM = 18.5;

    private double CAMERA_ANGLE = 7.5;

    private double GOAL_HEIGHT = 25.25;

    private double distance = 0;

    @Override
    public void init() {
        limelight3A = hardwareMap.get(Limelight3A.class, "limelight");
        limelight3A.pipelineSwitch(0 );
    }

    @Override
    public void start(){
        limelight3A.start();
    }


    @Override
    public void loop() {
        LLResult llResult = limelight3A.getLatestResult();

        if (llResult != null && llResult.isValid()){
            distance = getDistance(llResult.getTy());
            telemetry.addData("Distance", distance);
        } else {
            telemetry.addData("No Valid Target", "Found");
        }
      //  telemetry.addData("camera angle", cameraAngle);
    }

    public double getDistance(double ty) {
        double angelToTarget = CAMERA_ANGLE + ty;
        double heightDifference = GOAL_HEIGHT - CAMERA_HEIGHT_CM;

        double knownDistance = 150;
      //  double cameraAngle = Math.toDegrees(Math.atan((GOAL_HEIGHT_CAMERA_CM)/knownDistance)) - llResult.getty();

        return heightDifference / Math.tan(Math.toRadians(angelToTarget));

    }

}
