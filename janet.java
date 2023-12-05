//NO ENCODER







/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This file illustrates the concept of driving a path based on time.
 * It uses the common Pushbot hardware class to define the drive on the robot.
 * The code is structured as a LinearOpMode
 *
 * The code assumes that you do NOT have encoders on the wheels,
 *   otherwise you would use: PushbotAutoDriveByEncoder;
 *
 *   The desired path in this example is:
 *   - Drive forward for 3 seconds
 *   - Spin right for 1.3 seconds
 *   - Drive Backwards for 1 Second
 *   - Stop and close the claw.
 *
 *  The code is written in a simple form with no optimizations.
 *  However, there are several ways that this type of sequence could be streamlined,
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@Autonomous(name="Auto1", group="Pushbot")
//@Disabled
public class PushbotAutoDriveByTime_Linear extends LinearOpMode {

    /* Declare OpMode members. */
    HardwarePushbot robot = new HardwarePushbot();   // Use a Pushbot's hardware
    private ElapsedTime runtime = new ElapsedTime();


    static final double FORWARD_SPEED = 0.6; //this is backwards so when going forward; FOWARD is negative
    static final double TURN_SPEED = 0.5;

    @Override
    public void runOpMode() {

        /*
         * Initialize the drive system variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Step through each leg of the path, ensuring that the Auto mode has not been stopped along the way
        //robot.rightArmMotor.setPower(robot.ARM_DOWN_POWER); //REMEBER TO CHANGE THIS JUST SAID
                                                            // RIGHTARMMOTOR TO GET RID OF ERROR
        //robot.armMotor.setPower(robot.ARM_UP_POWER);
        // Step 1:  Drive forward for 3 seconds
        // forward(1.15);
        // turnRight(1.4);
        // forward(2.9);
        // backward(1);

        // //done shoving
        // turnRight(0.8);
        // forward(0.9);
        // turnRight(0.8);
        // forward(5.5);
        
        //Step 1: drive left 
        forward(1.3);
        turnRight(2.2);
        forward(2);
        turnRight(0.5);
        forward(1.5);

        // Step 4:  Stop and close the claw.
        //robot.leftDriveWheel.setPower(0);  //REMEMBER TO CHANGE NAME (DID IT TO PREVENT ERROR)
        //robot.rightDriveWheel.setPower(0); //REMEMBER TO CHANGE NAME (DID IT TO PREVENT ERROR)

        /**
         robot.leftClaw.setPosition(1.0);
         robot.rightClaw.setPosition(0.0);
         **/

        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);
    }

    public void forward(double time)
    {
        robot.leftDriveWheel.setPower(-FORWARD_SPEED); //REMEMBER TO CHANGE NAME (DID IT TO PREVENT ERROR)
        robot.rightDriveWheel.setPower(-FORWARD_SPEED); //REMEMBER TO CHANGE NAME (DID IT TO PREVENT ERROR)
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < time)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
    }

    public void backward(double time)
    {
        robot.leftDriveWheel.setPower(FORWARD_SPEED); //REMEMBER TO CHANGE NAME (DID IT TO PREVENT ERROR)
        robot.rightDriveWheel.setPower(FORWARD_SPEED); //REMEMBER TO CHANGE NAME (DID IT TO PREVENT ERROR)
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < time)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
    }

    public void turnRight(double time)
    {
        robot.leftDriveWheel.setPower(-FORWARD_SPEED); //REMEMBER TO CHANGE NAME (DID IT TO PREVENT ERROR)
        robot.rightDriveWheel.setPower(FORWARD_SPEED); //REMEMBER TO CHANGE NAME (DID IT TO PREVENT ERROR)
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < time)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
    }

    public void turnLeft(double time)
    {
        robot.leftDriveWheel.setPower(FORWARD_SPEED); //REMEMBER TO CHANGE NAME (DID IT TO PREVENT ERROR)
        robot.rightDriveWheel.setPower(-FORWARD_SPEED); //REMEMBER TO CHANGE NAME (DID IT TO PREVEN
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < time)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
    }
}
