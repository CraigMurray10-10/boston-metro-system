# CS308 Boston Metro System Team Group 18
Our Application can run through Intellij as follows:

Application requires the JavaFX lib directory, therefore you must have JavaFX installed.

This can be done here:
https://gluonhq.com/products/javafx/

After this is done, you can open up the project in Intellij.

Click Add Configuration...| + | Add New Configuration | Application

Select 'MVCRouteFinder' as the main class (or BostonMetroSystem.MVCRouteFinder as packaged)

Then, you must add your JavaFX lib directory

Modify options | Add VM options

Add --module-path [your directory to JavaSDK/lib here] --add-modules=javafx.controls
to the VM options box

For example: --module-path C:\Users\Hello\Documents\javafx-sdk-11.0.2\lib --add-modules=javafx.controls

Type BostonMetroSystem as Name at the top

Select Apply then OK

Your program should be ready to run! Press the play button and the GUI should launch.

NB: You may also be required to add the lib directory to Project Structure | Libraries

