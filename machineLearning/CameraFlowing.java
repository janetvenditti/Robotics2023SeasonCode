package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.robotcore.external.JavaUtil;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaCurrentGame;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.Tfod;

@Autonomous(name = "CameraFlowing (Blocks to Java)")
public class CameraFlowing extends LinearOpMode {

  private VuforiaCurrentGame vuforiaPOWERPLAY;
  private Tfod tfod;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    vuforiaPOWERPLAY = new VuforiaCurrentGame();
    tfod = new Tfod();

    // Sample TFOD Op Mode using a Custom Model
    // Initialize Vuforia to provide TFOD with camera
    // images.
    // The following block uses the device's back camera.

    vuforiaPOWERPLAY.close();
    tfod.close();
  }

  /**
   * Describe this function...
   */
  private void displayInfo(
      // TODO: Enter the type for argument named i
      UNKNOWN_TYPE i) {
    Recognition recognition;

    // Display the location of the top left corner
    // of the detection boundary for the recognition
    telemetry.addData("Label: " + recognition.getLabel() + ", Confidence: " + recognition.getConfidence(), "X: " + Math.round(JavaUtil.averageOfList(JavaUtil.createListWith(Double.parseDouble(JavaUtil.formatNumber(recognition.getLeft(), 0)), Double.parseDouble(JavaUtil.formatNumber(recognition.getRight(), 0))))) + ", Y: " + Math.round(JavaUtil.averageOfList(JavaUtil.createListWith(Double.parseDouble(JavaUtil.formatNumber(recognition.getTop(), 0)), Double.parseDouble(JavaUtil.formatNumber(recognition.getBottom(), 0))))));
  }
}
