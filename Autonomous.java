package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Autonomous (Blocks to Java)")
public class Autonomous extends LinearOpMode {

  private DcMotor Motor2AsDcMotor;
  private DcMotor Motor1AsDcMotor;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    Motor2AsDcMotor = hardwareMap.get(DcMotor.class, "Motor2AsDcMotor");
    Motor1AsDcMotor = hardwareMap.get(DcMotor.class, "Motor1AsDcMotor");

    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      turnLeft();
    }
  }

  /**
   * Describe this function...
   */
  private void forward() {
    // this thing needs time :)
    Motor2AsDcMotor.setDirection(DcMotorSimple.Direction.FORWARD);
    Motor1AsDcMotor.setDirection(DcMotorSimple.Direction.FORWARD);
  }

  /**
   * Describe this function...
   */
  private void backwards() {
    Motor2AsDcMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    Motor1AsDcMotor.setDirection(DcMotorSimple.Direction.REVERSE);
  }

  /**
   * Describe this function...
   */
  private void turnLeft() {
    Motor2AsDcMotor.setDirection(DcMotorSimple.Direction.FORWARD);
    Motor1AsDcMotor.setDirection(DcMotorSimple.Direction.REVERSE);
  }

  /**
   * Describe this function...
   */
  private void turnRight() {
    Motor2AsDcMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    Motor1AsDcMotor.setDirection(DcMotorSimple.Direction.FORWARD);
  }
}
