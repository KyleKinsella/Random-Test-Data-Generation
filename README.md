# My tool works for the following types: int, float, double, long, boolean, String, char and int[][]. So if you are writing your own methods only use these types. 
I also must mention, if you have a method of type __int__ the parameters much be __int__ you can have as many parameters as you want but they must all be all type __int__.

# How to install my software

1. You will need to install the Eclipse IDE for Eclispe Committer's, don't install the normal Eclispe IDE as this project is a plugin development project, meaning that in order to run my code you have to have a plugin project.

2. The whole premise of this project is to generate random test data and format it in JUnit format. So in order for you to be able to run the test or tests that are generated, you will have to install a plugin on the Eclipse marketplace. To install this plugin go to, On the top of your Eclipse go to - Help - Eclipse Marketplace. Then you will just search for "JUnit Tools 4 Spring" then just follow the on screen instructions to install this software to be able to run the generated tests.

3. In order for you to be able to run my software, you are going to need to install some dependencies, here are the dependencies you will need to install, __org.eclipse.jdt.core__, __org.eclipse.ui__, __org.eclipse.core.runtime__, __org.eclipse.ui.workbench.texteditor__, __org.eclipse.jface.text__, __org.junit__ and the final dependencie you will be is, __junit.jupiter-api__. 

4. You are going to also need to install some extentions, here are the extentions you will need to install, __org.eclipse.ui.commands__, __org.eclipse.ui.handlers__ and finally, __org.eclipse.ui.menus__.

5. For more information see this video that I have made for more guidance: https://www.youtube.com/watch?v=NPL9U9ZY8W8
   
# How to operate my software
1. Go to your C drive and make a folder called "RandomTestDataGeneration".
 
2. Open your eclipse for committers and do the following, File, New, Project, Plug-in Development, Plugin-in Project.
   
3. Enter a name for your project, it must be called __rightClickMe__.
   
4. Download my selectText.java and plugin.xml from my GitHub (Final iteration completed folder)file this this working directory, C:\RandomTestDataGeneration\rightClickMe\src\rightClickMe, put the downloaded Java file into this directory, copy the contents of the plugin.xml file and paste it into your plugin.xml, it should be in your __META-INF // MANIFEST.MF__.
   
5. Go to the bottom of the "selectText.java" file where is says "write your own methods below", that is where you must write your methods.
 
6. Once you are done writing your own method's to test my tool on, right click on the "selectText.java" file and click "run as" - eclipse application, after a few moments a runtime screen will appear, then you will have to open your working directory file "selectText.java" (for the first time) and then double click on the name of any of the method's that you have wrote and then right click and the choose "Generate tests" then just follow the on screen instructions.

7. Once you have seen this message "Your Java file has been created", go back to your eclipse for committers, just keep in mind that eclispe doesn't update automatically so your generated Java file won't be there but __don't panic__ all you have to do is right click on the name of your project (rightClickMe) - refresh, then your Java file will appear. Then you can open up the generated Java file and view the contents of the file, and if you have followed all of the steps to here, to run the test or tests that have been generated, right click the generated Java file - Run as - JUnit test not __JUnit Plug-in test__. If you haven't ran a JUnit test before you will need to configure it, to do this just do what you did before and just click on "Run Configurations..." there will be a "Test runner" box by default it will be set to JUnit 5, click on this and change it to JUnit 4 - Apply then close, or you can do Apply then run. Then do the steps again and your generated Java file with your test or tests will either pass or fail with the use of JUnit.

 
8. For more information see this video that I have made for more guidance: https://www.youtube.com/watch?v=RQti0-McdMs
