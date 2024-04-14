# My tool only works for the following types for the moment: Int, Float, Double, Boolean and Long, so if you are writing your own methods only use these types.

# How to install my software

I would like to mention this installation process does take quite some time, but once this is done it is done. The only thing you will be to install is my new software file and that is only when I update my software. 

1. You will need to install the Eclipse IDE for Eclispe Committer's, don't install the normal Eclispe IDE as this project is a plugin development project, meaning that in order to run my code you have to have a plugin project.

2. The whole premise of this project is to generate random test data and format it in JUnit format. So in order for you to be able to run the test or tests that are generated, you will have to install a plugin on the Eclipse marketplace. To install this plugin go to, On the top of your Eclipse go to - Help - Eclipse Marketplace. Then you will just search for "JUnit Tools 4 Spring" then just follow the on screen instructions to install this software to be able to run the generated tests.

3. In order for you to be able to run my software, you are going to need to install some dependencies, here are the dependencies you will need to install, __org.eclipse.jdt.core__, __org.eclipse.ui__, __org.eclipse.core.runtime__, __org.eclipse.ui.workbench.texteditor__, __org.eclipse.jface.text__, __org.junit__ and the final dependencie you will be is, __junit.jupiter-api__. 

4. You are going to also need to install some extentions, here are the extentions you will need to install, __org.eclipse.ui.commands__, __org.eclipse.ui.handlers__ and finally, __org.eclipse.ui.menus__

5. Finally the last step, this step involves you to install my jar file, this very important because the jar file is needed to run my software on another machine.

# How to operate my software
1. The jar file that you have downloaded from my repository you are going to need to do the following. You need to go to your File Explorer - C: - Users - "Your Name" - eclipse - the committers folder - eclipse, then you need to put the jar file into the "dropins" and "plugins" folders.

2. If you have your Eclispe open and running where you have just put in the jar file, you will need to restart your eclipse.

3. You will need to clone my repository, type in the following command to clone my repository: git clone https://github.com/KyleKinsella/Random-Test-Data-Generation, then go to the cloned folder, then the folder called "I have fixed my code to be able to work with a few new types" and copy that file that is in that folder. 

4. Now that you have my code you now need to make your own eclipse plugin project to be able to run my code. To do this you need to do the following, Go to the top of your eclispe click on File - New - Project - Find the plug-in development folder expand it - click on "Plug-in Project" - give your project a name - next - then finish.

5. Paste the Java file into your new project that you have just made.

6. Then you need to go back to the cloned folder of my repository and go to the folder called "I made a right click", then open the plugin.xml file and copy the contents of that file, then go back to the project that you have just made and make sure that you have did the all of the above steps in "how to install my software", but mainly steps 3 and 4. Then go to the plugin.xml file and paste in the xml file that you copied from my repository. ** I want to emphasize something very important when you are making a new plugin project you __MUST__ have your project called "rightClickMe" I am saying this because I have tried to code it to be able to work for any name but I am having some difficulties to construct this feature at the moment**. Eventually I will get it to work for any project name. 

7. Now you can start to write your own code, but again **I want to point out something very important, when you are making a new Java file it must be called "selectText" again this is for the same reason as I have just mentioned above in step 6.

8. When you are done writing your code, you will need to run my code on your machine, to do this you need to: Right click on the selectText.java file - Run as - Eclipse Application. This will start a new eclipse instance, after a few minutes you will see a runtime eclispe window, this means that my code is running on your machine. In order for you to run your code, you need to open the file (selectText.java) for now, once you have your Java file opened in front of you in the runtime eclispe you will need to follow step 9 below to figure out how to use my software.

9. To use my software you need to, Double click on the name of your method - right click - Generate Test - then just follow the on screen instructions. Once you have seen this message "Your Java file has been created", go back to your eclipse for committers, just keep in mind that eclispe doesn't update automatically so your generated Java file won't be there but __don't panic__ all you have to do is right click on the name of your project (rightClickMe) - refresh, then your Java file will appear. Then you can open up the generated Java file and view either one test or many tests, and if you have followed all of the steps to here, to run the test or tests that have been generated, right click the generated Java file - Run as - Junit. If you haven't ran a JUnit test before you will need to configure it, to do this just do what you did before and just click on "Run Configurations..." there will be a "Test runner" box by default it will be set to JUnit 5, click on this and change it to JUnit 4 - Apply then close. Then do the steps again and your generated Java file with your test or tests will either pass or fail with the use of JUnit.
