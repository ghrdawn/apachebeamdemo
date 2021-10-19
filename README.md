# About
This project resolves the initial setup struggle if you decide to go with Apache Beam and SparkRunner tech-stack for your data processing project requirement.

The input file color-code.json is placed inside "input" folder of the project. And processed output will be generated inside "output" folder after the execution of the project as a Java Application.

[Download and Place the WinUtils.exe at C:\hadoop_home\bin location if you are running the project from Windows]

**Versions used:**
- Beam : 2.33.0
- Spark : 2.4.8

A code-hack is added inside ColorCodeProcessorTask.java to keep the Spark UI alive after the execution is finished. You can access the Spark UI at default location http://localhost:4040.

![Spark UI](https://github.com/ghrdawn/apachebeamdemo/blob/main/BeamDemo/img/sparkui.PNG?raw=true)
