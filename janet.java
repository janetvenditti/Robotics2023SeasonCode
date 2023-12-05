package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "AutonomousArmControl", group = "Autonomous")
public class AutonomousArmControl extends OpMode {

    private DcMotor armMotor;

    // Constants
    private static final double ARM_POWER = 0.5;  // Adjust as needed
    private static final int TARGET_POSITION_UP = 1000;  // Adjust as needed
    private static final int TARGET_POSITION_DOWN = 0;  // Adjust as needed

    @Override
    public void init() {
        // Initialize the hardware variables
        armMotor = hardwareMap.get(DcMotor.class, "armMotor");

        // Set motor direction (based on your configuration)
        armMotor.setDirection(DcMotor.Direction.FORWARD);

        // Set motor mode to use encoders
        armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    @Override
    public void loop() {
        // Move the arm up to the target position
        moveArmToPosition(TARGET_POSITION_UP);

        // Move the arm down to the target position
        moveArmToPosition(TARGET_POSITION_DOWN);

        // Display information on the driver station
        telemetry.addData("Status", "Autonomous Arm Control");
        telemetry.addData("Arm Position", armMotor.getCurrentPosition());
        telemetry.update();
    }

    // Method to move the arm to a specific encoder target position
    private void moveArmToPosition(int targetPosition) {
        // Set the target position for the arm motor
        armMotor.setTargetPosition(targetPosition);
        // Set motor mode to run to position
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        // Set motor power to move the arm
        armMotor.setPower(ARM_POWER);

        // Wait until the motor reaches the target position
        while (armMotor.isBusy()) {
            // Continue with other tasks if needed
            telemetry.addData("Arm Position", armMotor.getCurrentPosition());
            telemetry.update();
        }

        // Stop the motor after reaching the target position
        armMotor.setPower(0);
        // Set motor mode back to using encoders
        armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
}
