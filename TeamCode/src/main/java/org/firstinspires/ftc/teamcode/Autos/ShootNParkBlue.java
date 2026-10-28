
package org.firstinspires.ftc.teamcode.Autos;

import static com.pedropathing.ivy.Scheduler.schedule;
import static com.pedropathing.ivy.groups.Groups.sequential;
import static com.pedropathing.ivy.pedro.PedroCommands.follow;
import static com.pedropathing.ivy.commands.Commands.*;

import com.pedropathing.api.Paths;
import com.pedropathing.api.PoseFactory;
import com.pedropathing.follower.Follower;
import com.pedropathing.ivy.Command;
import com.pedropathing.ivy.Scheduler;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.PedroPathing.Constants;
import org.firstinspires.ftc.teamcode.Subsystems.Intake;
import org.firstinspires.ftc.teamcode.Subsystems.Shooter;

@Autonomous
public class ShootNParkBlue extends LinearOpMode {

    private Follower follower;

    private Shooter shooter;
    private Intake intake;

    private final PoseFactory poseFactory = PoseFactory.degrees();

    private final Pose start = poseFactory.of(85.75, 133.75, 90);
    private final Pose path1Pose = poseFactory.of(85.75, 109.75, 270);
    private final Pose point2 = poseFactory.of(112.75, 109.75, 270);
    private final Pose point3 = poseFactory.of(112.75, 34.75, -90);
    private final Pose point4 = poseFactory.of(133.75, 34.75, 180);

    public Path path1() {
        return Paths.line(start, path1Pose).constant(path1Pose);
    }

    public Path path2() {
        return Paths.line(path1Pose, point2).constant(point2);
    }

    public Path path3() {
        return Paths.line(point2, point3).tangent();
    }

    public Path path4() {
        return Paths.line(point3, point4).constant(point4);
    }

    public Command autoRoutine() {
        return sequential(
                follow(follower, path1()),

                // Stop both motors immediately after path 1
                instant(() -> {
                    shooter.stop();
                    intake.none();
                }),
                // Continue the remaining paths with both motors off
                follow(follower, path2()),
                follow(follower, path3()),
                follow(follower, path4())
        );
    }

    @Override
    public void runOpMode() {
        Scheduler.reset();

        follower = Constants.create(hardwareMap);

        // Initialize the subsystems before autonomous starts
        shooter = new Shooter(this);
        intake = new Intake(this);

        follower.setPose(start);
        follower.update();

        telemetry.addLine("Ready to start");
        telemetry.update();

        waitForStart();

        if (isStopRequested()) {
            return;
        }

        // Start both motors and schedule the autonomous routine
        shooter.forward();
        intake.go();

        schedule(autoRoutine());

        while (opModeIsActive()) {
            follower.update();
            Scheduler.execute();

            telemetry.addData("x", follower.pose().x());
            telemetry.addData("y", follower.pose().y());
            telemetry.addData("heading", follower.pose().heading());

            if (follower.currentPath() != null) {
                telemetry.addData(
                        "Distance remaining",
                        follower.distanceToEndpoint()
                );
                telemetry.addData("Path number", follower.pathIndex());
            }

            telemetry.update();
        }
    }
}
