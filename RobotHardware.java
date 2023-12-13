package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class HardwarePushbot {
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
    /**
     * This is NOT an opmode.
     *
     * This class can be used to define all the specific hardware for a single robot.
     * In this case that robot is a Pushbot.
     * See PushbotTeleopTank_Iterative and others classes starting with "Pushbot" for usage examples.
     *
     * This hardware class assumes the following device names have been configured on the robot:
     * Note:  All names are lower case and some have single spaces between words.
     *
     * Motor channel:  Left  drive motor:        "left_drive"
     * Motor channel:  Right drive motor:        "right_drive"
     * Motor channel:  Manipulator drive motor:  "left_arm"
     * Servo channel:  Servo to open left claw:  "left_hand"
     * Servo channel:  Servo to open right claw: "right_hand"
     */
// hello this is testing :)


        /* Public OpMode members. */
        public DcMotor  leftDriveWheel   = null; //motor for left wheel
        public DcMotor  rightDriveWheel  = null; //motor for right wheel
        public DcMotor  armMotor   = null; //new var i added for arm
        public DcMotor  shoulderMotor = null;
        //public RevColorSensorV3 colorSensor;

        public Servo grip = null;
        //public Servo    rightClaw   = null;

        public static final double MID_SERVO       =  0.0 ;
        public static final double ARM_UP_POWER    =  -0.4;
        public static final double ARM_DOWN_POWER  = 0.4;

        /* local OpMode members. */
        HardwareMap hwMap           =  null;
        private ElapsedTime period  = new ElapsedTime();

        /* Constructor */
        public HardwarePushbot(){

        }

        /* Initialize standard Hardware interfaces */
        public void init(HardwareMap ahwMap) {
            // Save reference to Hardware map
            hwMap = ahwMap;

            // Define and Initialize Motors
            leftDriveWheel  = hwMap.get(DcMotor.class, "leftDriveWheel");
            rightDriveWheel = hwMap.get(DcMotor.class, "rightDriveWheel");

            //Define and initialize color sensor
            //colorSensor = hwMap.get(RevColorSensorV3.class, "colorSensor");
            armMotor = hwMap.get(DcMotor.class, "armMotor");
            shoulderMotor = hwMap.get(DcMotor.class,"shoulderMotor");

            leftDriveWheel.setDirection(DcMotor.Direction.REVERSE); // Set to REVERSE if using AndyMark motors
            rightDriveWheel.setDirection(DcMotor.Direction.FORWARD);// Set to FORWARD if using AndyMark motors
            armMotor.setDirection(DcMotor.Direction.REVERSE);
            shoulderMotor.setDirection(DcMotor.Direction.REVERSE);

            // Set all motors to zero power
            leftDriveWheel.setPower(0);
            rightDriveWheel.setPower(0);
            armMotor.setPower(0);
            shoulderMotor.setPower(0);


            // Set all motors to run without encoders.
            // May want to use RUN_USING_ENCODERS if encoders are installed.
            leftDriveWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            rightDriveWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            armMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            shoulderMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

            // Define and initialize ALL installed servos.
            // leftClaw  = hwMap.get(Servo.class, "left_hand");
            grip = hwMap.get(Servo.class, "grip");
            // leftClaw.setPosition(MID_SERVO);
            grip.setPosition(MID_SERVO);
        }
    }


