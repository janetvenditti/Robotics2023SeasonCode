# Robotics2023SeasonCode
Files from onBotJava, these are from our 22/23 season, adapted for 23/24. Files are in .blk and .java file types.


Next time => ✨

- figure out arm movements. What was wrong with the arm last time, are we using autonomous.java to control the arm add stuff like that here in case someone misses a practice!
- otherwise, today I updated the control hub, check if it actually updated

MAJOR END GOALS:

Before we do anything with AI look at the following:
<details>
 <summary><h3> 🎀 AI (Tensorflow Lite) Resources </h3></summary>
   - https://www.youtube.com/watch?v=XZ7FYAMCc4M
   - https://colab.research.google.com/drive/1_oftxFviiT_TVfmr-ZzdDm5a3IJ8ETPy
   - https://firstroboticsbc.org/ftc/ftc-team-resources/centerstage-team-props/
   - https://ftc-qa.firstinspires.org/qa/hot
   
</details>

<details>
 <summary><h3> 🐋 AI Concerns </h3></summary>
   Is it better to use a pre-trained model from tensorflow and avoid taking photos and hope our 3D print will be rocognized? Or should we train our own model and work through properly labeling photos?
   
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
