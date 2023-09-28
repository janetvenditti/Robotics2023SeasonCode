package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp(name = "NewOPMode (Blocks to Java)")
public class NewOPMode extends LinearOpMode {

  private Servo servoAsServo;
  private DcMotor Motor1AsDcMotor;
  private DcMotor Motor2AsDcMotor;
  private ColorSensor colorSensorAsREVColorRangeSensor;
  private TouchSensor touchSensorAsTouchSensor;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    float tgtPower;

    servoAsServo = hardwareMap.get(Servo.class, "servoAsServo");
    Motor1AsDcMotor = hardwareMap.get(DcMotor.class, "Motor1AsDcMotor");
    Motor2AsDcMotor = hardwareMap.get(DcMotor.class, "Motor2AsDcMotor");
    colorSensorAsREVColorRangeSensor = hardwareMap.get(ColorSensor.class, "colorSensorAsREVColorRangeSensor");
    touchSensorAsTouchSensor = hardwareMap.get(TouchSensor.class, "touchSensorAsTouchSensor");

    // Put initialization blocks here.
    servoAsServo.setPosition(0.5);
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        // Put loop blocks here.
        if (gamepad1.y) {
          servoAsServo.setPosition(0);
        } else if (gamepad1.x || gamepad1.b) {
          servoAsServo.setPosition(0.5);
        } else if (gamepad1.a) {
          servoAsServo.setPosition(1);
          tgtPower = -gamepad1.left_stick_y;
          Motor1AsDcMotor.setPower(tgtPower);
          tgtPower = -gamepad1.right_stick_y;
          Motor2AsDcMotor.setPower(tgtPower);
          telemetry.addData("Target Power", tgtPower);
          telemetry.addData("Motor Power", Motor1AsDcMotor.getPower());
          telemetry.addData("Servo Position", servoAsServo.getPosition());
          telemetry.addData("Distance (cm)", ((DistanceSensor) colorSensorAsREVColorRangeSensor).getDistance(DistanceUnit.CM));
          if (touchSensorAsTouchSensor.isPressed()) {
            telemetry.addData("testTouch", "Is pressed");
          } else {
            telemetry.addData("testTouch", "Is NOT pressed");
          }
          telemetry.update();
        }
      }
    }
  }
}
