# How to install my software

1. You will need to install the Eclipse IDE for Eclispe Committer's, don't install the normal Eclispe IDE as this project is a plugin development project, meaning that in order to run my code you have to have a plugin project.

2. The whole premise of this project is to generate random test data and format it in JUnit format. So in order for you to be able to run the test or tests that are generated, you will have to install a plugin on the Eclipse marketplace. To install this plugin go to, On the top of your Eclipse go to - Help - Eclipse Marketplace. Then you will just search for "JUnit Tools 4 Spring" then just follow the on screen instructions to install this software to be able to run the generated tests.

3. In order for you to be able to run my software, you are going to need to install some dependencies, here are the dependencies you will need to install, __org.eclipse.jdt.core__, __org.eclipse.ui__, __org.eclipse.core.runtime__, __org.eclipse.ui.workbench.texteditor__, __org.eclipse.jface.text__, __org.junit__ and the final dependencie you will be is, __junit.jupiter-api__. 

4. You are going to also need to install some extentions, here are the extentions you will need to install, __org.eclipse.ui.commands__, __org.eclipse.ui.handlers__ and finally, __org.eclipse.ui.menus__
   
# How to operate my software
1. Go to your C drive and make a folder called "RandomTestDataGeneration".
2. Open your eclipse for committers and do the following, File, New, Project, Plug-in Development, Plugin-in Project.
3. Enter a name for your project, it must be called __rightClickMe__.
4. Download my selectText.java and plugin.xml file this this working directory, C:\RandomTestDataGeneration\rightClickMe\src\rightClickMe, put the downloaded Java file into this directory, copy the contents of the plugin.xml file and paste it into your plugin.xml, it should be in your __META-INF // MANIFEST.MF__.
5. 
