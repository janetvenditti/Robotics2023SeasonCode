# Robotics2023SeasonCode
Files from onBotJava, these are from our 22/23 season, adapted for 23/24. Files are in .blk and .java file types.

MAJOR END GOALS:


Before we do anything with AI look at the following:
<details>
 <summary><h3> 🎀 AI (Tensorflow Lite) Resources </h3></summary>
   The colab notebook that guides us on model buildining, make sure to RUN ALL the cells: 
   https://colab.research.google.com/github/EdjeElectronics/TensorFlow-Lite-Object-Detection-on-Android-and-Raspberry-Pi/blob/master/Train_TFLite2_Object_Detction_Model.ipynb

   Other training example for TROUBLESHOOTING ONLY:
   https://colab.research.google.com/github/tensorflow/docs/blob/master/site/en/tutorials/customization/custom_training_walkthrough.ipynb

   FTC Resource for tensorflow lite connecting and how to implement into code:
   https://ftc-docs.firstinspires.org/en/latest/programming_resources/vision/tensorflow_pp_2022/tensorflow_pp_2022.html
   https://www.tensorflow.org/tutorials/customization/custom_training_walkthrough 
</details>

<br />

(until team element is photographed)
- make the dataset and train it for best accuracy
- connect the trained model to onbotJava and the webcam and use it in our code 
- research and confirm thought on april tags 
--> note we also need to take photos of april tags, and the area that tells us R L and C before placing team element ontop april tags

Other non-AI goals (in order of priority):
- Test out motors 
- Make sure everything on control hub works 
- Update all for control hub
- Plan out autonomous needs and path
- Figure out how to do drive by encoders, traveling distancing rather than seconds
- Once arm is built, test driver controlled section 
- Plan, code, test and prototype for airplane (spring? pressured air? slingshot?)

Strat Method:
- preloaded with two pixels purple and yellow, start in the corner base of the team 
- drop off purple pixel at coresponding team element position
- turn towards april tags and see coresponding location and move there
- place yellow pixel at backdrop of corresponding location found from april tag 
  
claire was here, she was.
