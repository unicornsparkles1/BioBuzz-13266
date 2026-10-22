//package org.firstinspires.ftc.teamcode.Autos;

//import com.pedropathing.api.Paths;

//import com.pedropathing.api.PoseFactory;
//import com.pedropathing.follower.Follower;
//import com.pedropathing.math.Pose;
//import com.pedropathing.paths.Path;
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//Import com.qualcomm.robotcore.robocol.Command;

//import org.firstinspires.ftc.teamcode.PedroPathing.Constants;

//import java.io.BufferedInputStream;

//@Autonomous(name = "AutoPath", group = "Autonomous")
//public class Autos extends LinearOpMode {

    //private Follower follower;

   // private final PoseFactory poseFactory = PoseFactory.degrees();

//import com.pedropathing.math.Pose;

//private final Pose start = poseFactory.of(5, 30, 90);
    //private final Pose path1 = poseFactory.of(59, 30, 90);
    //private final Pose point2 = poseFactory.of(30, 33, 174.0939);
   // private final Pose point3 = poseFactory.of(29, 106, 90.7848);
   // private final Pose point4 = poseFactory.of(9, 106, 180);

    // Autonomous routine
   // public Command autoRoutine() {
   //     return equals(
               // follower.follow(path1()),
             //   follower.follow(path2()),
              //  follower.follow(path3()),
             //   follower.follow(path4())
      //  );
  //  }

    //@Override
  //  public void runOpMode() {
       // BufferedInputStream Scheduler;
       // Scheduler.reset();
       // follower = Constants.create(hardwareMap);
       // follower.setPose(start);
       // follower.update();

       // waitForStart();
      //  schedule(autoRoutine());

      //  while (opModeIsActive()) {
       //     follower.update();
        //    Scheduler.execute();

          //  telemetry.addData("x", follower.pose().x());
         //   telemetry.addData("y", follower.pose().y());
          //  telemetry.addData("heading", follower.pose().heading());

          //  if (follower.currentPath() != null) {
          //      telemetry.addData("Current path distance remaining", follower.distanceToEndpoint());
          //      telemetry.addData("Path number", follower.pathIndex());
         //   }

       //     telemetry.update();
       // }
  //  }

 //   private void schedule(Command command) {
 //   }

  //  public Path path1() {
     //   return Paths.line(start, path1).constant(path1);
 //   }

  //  public Path path2() {
      //  return Paths.line(path1, point2).tangent();
  //  }

  //  public Path path3() {
   //     return Paths.line(point2, point3).tangent();
 //   }

   // public Path path4() {
       // return Paths.line(point3, point4).tangent();
 //   }
//}



//This is auto that only parks

package org.firstinspires.ftc.teamcode.Autos;

import static com.pedropathing.api.Paths.*;
import com.pedropathing.api.Paths;

import com.pedropathing.api.PoseFactory;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;
import com.pedropathing.ivy.Command;
import com.pedropathing.ivy.Scheduler;
import static com.pedropathing.ivy.Scheduler.schedule;
import static com.pedropathing.ivy.commands.Commands.*;
import static com.pedropathing.ivy.groups.Groups.sequential;
import static com.pedropathing.ivy.pedro.PedroCommands.follow;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "AutoPath", group = "Autonomous")
public class AutoPath extends LinearOpMode {

    private Follower follower;

    private final PoseFactory poseFactory = PoseFactory.degrees();

    private final Pose start = poseFactory.of(0.9292, 29.4548, 90);
    private final Pose path1 = poseFactory.of(24.1426, 29.6285, 0);
    private final Pose point2 = poseFactory.of(21.0366, 107.7777, 92.276);
    private final Pose point3 = poseFactory.of(4.1876, 107.6191, 0.5391);

    // Autonomous routine
    public Command autoRoutine() {
        return sequential(
                follow(follower, path1()),
                follow(follower, path2()),
                follow(follower, path3())
        );
    }

    @Override
    public void runOpMode() {
        Scheduler.reset();
        follower = Constants.create(hardwareMap);
        follower.setPose(start);
        follower.update();

        waitForStart();
        schedule(autoRoutine());

        while (opModeIsActive()) {
            follower.update();
            Scheduler.execute();

            telemetry.addData("x", follower.pose().x());
            telemetry.addData("y", follower.pose().y());
            telemetry.addData("heading", follower.pose().heading());

            if (follower.currentPath() != null) {
                telemetry.addData("Current path distance remaining", follower.distanceToEndpoint());
                telemetry.addData("Path number", follower.pathIndex());
            }

            telemetry.update();
        }
    }

    public Path path1() {
        return Paths.line(start, path1).constant(path1);
    }

    public Path path2() {
        return Paths.line(path1, point2).tangent();
    }

    public Path path3() {
        return Paths.line(point2, point3).reverseTangent();
    }