Corey Craddock
CS 414

### Individual work: Garage Project (3 parts)

<center>

#### <font color="DARKRED">DUE:</font>  
Part P1: 11:59PM, Wednesday 28 March 2018  
Part P2: 11:59PM, Sunday 15 April 2018  
Part P3: 11:59PM, Sunday 29 April 2018

#### 50 points for each part

</center>

* * *

## 1\. Objectives

In this project you will use the techniques you learned in the course to (1) analyze the requirements, and (2) implement an application in two iterations. The project involves building a parking system for a city's computerized parking garage.

Since you do not have actual hardware (e.g., card reader, ticket dispenser, garage gate, and garage signs) you will implement them in software (through user interfaces). The UI must be interactive, which means that the driver using it must be able to type or click on something to enter or exit through the gate, enter ticket information, etc. The core application logic must be implemented in Java.

In the first iteration, you will start with one garage that allows cars to park using parking tickets. The garage will use one entry gate and one exit gate. Tickets are obtained at the entry gate and paid for at the time of exiting. The gates are fully automated; there is no attendant. Only cash payments will be handled. The same ticket obtained while entering must be used to exit, i.e., bogus or fake tickets cannot be used to exit and cheat the system. You must allow multiple cars to enter and exit the garage. The user interface in the first iteration can be textual or graphical.

The system keeps track of the current levels of occupancy in the garage and displays a sign showing whether the garage is full or not. The system also keeps tracks of payments and ticket sales, and collects occupancy summaries for each hour of the day. Garage administrators should be able to query and view garage usage in various forms (be creative and specific here: hourly, daily, weekly, and monthly basis). The more flexible applications will allow the user to answer sophisticated questions such as, which hours are the most used on an average day over the last month.

In the second iteration, you will extend the application to support multiple entry and exit gates. This brings up the distributed nature of the system. Each gate is connected to a central location for processing payments and collecting usage data. You will also implement a graphical user interface to support the old and new features. The graphical user interface can use any programming language and technology but the core application logic must be written in Java.

* * *

## 2\. P1: Requirements Analysis (50 points) Due 11:59PM, Wednesday 28 March 2018

You will analyze the requirements to cover both the iterations.

### 2.1\. Tasks

1.  **(5 points)**: Create an activity diagram to show the workflow of a driver who uses the garage.

2.  **(5 points)**: Create an activity diagram to show the workflow of a garage administrator.

3.  **(5 points)**: Create a use case diagram showing the actors and use cases.

4.  **(20 points)**: Describe the use cases as done in the lectures.

5.  **(10 points)**: Create a domain model using UML notation. Provide the definitions of each class name and attribute name used in the diagram.

6.  **(5 points)**: Create a plan for the user interfaces (textual and graphical) that will be developed in the next two parts of the projects. For the textual UI, create a textual plan for the menu options that will be used to drive the garage application. For the graphical UI, create a powerpoint sketch of the layouts, buttons, etc.

### 2.2\. Submission

You must use UML drawing tools to create the UML diagrams. All the diagrams and text must be entered in a single PDF document called **p1.pdf**. Submit the file via the Canvas submission system.

You will lose points if there are inconsistencies between the diagrams.

* * *

## 3\. P2: Design, Implementation, and Testing in Iteration 1 (50 points) Due 11:59PM, Sunday 15 April 2018

Design, implement, and test the features described for iteration 1\. The application must have a user interface: text-based menus are acceptable. However, it should be possible to view what is happening to the garage and what it's current state is at any time. If your menus are long and/or nested, please design them to make them user-friendly. The code must be written in Java.

### 3.1\. Using GitHub

**(4 points)** You must use the GitHub repo that we created for CS414\. We will inspect the activity in your repository and look for frequent checkins. Points will be deducted in situations where we see no activity in the beginning but all the checkins happen just before the deadline, or very few checkins, etc.

### 3.2\. Submission

Submit via Canvas a zip file containing the following items:

1.  **(1 point)** A **README.txt** file describing the below contents and how to install and run your program.
2.  **(5 points)** PDF file called **cd.pdf** containing a UML class diagram showing the overall design of the core functionality.
3.  **(5 points)** PDF file called **design.pdf** with a single-spaced one-page description of the design rationale, design principles and what patterns were used and where. It should be consistent with the code you submit. Points will be taken off for poor design quality.
4.  **(5 points)** JUnit tests in appropriately structured folders. A generated coverage report must be submitted as **coverage.pdf** and must show the statement and branch coverage obtained for the Java classes written for the program.
5.  **(5 points)** PDF file called **test.pdf** describing system tests in the form of automated scripts or clear instructions on how to run the tests, what inputs to give, and what outputs to expect.
6.  **(25 points)** Java implementation of iteration 1 in appropriately structured folders. The grading of the implementation is based on code quality as well as the functionality. Functionality will be graded in multiple ways. We will ask you to submit a video where you will follow a script that the GTA will give you at a later date. We will also run your application and JUnit tests on our machines. If there are problems, the GTA will schedule a skype/google hangout session and you will walk him through the steps.

* * *

## 4\. P3: Design, Implementation, and Testing in Iteration 2 (50 points) Due 11:59PM, Sunday 29 April 2018

Design, implement, and test the features described for iteration 2\. The application must have a graphical user interface. The code for the application logic must be written in Java. The graphical user interface can be implemented using any programming language/technology.

### 4.1\. Using GitHub

**(4 points)** You must use the GitHub repo that we created for CS414\. We will inspect the activity in your repository and check for frequest checkins. Points will be deducted in situations where we see no activity in the beginning but all the checkins happen just before the deadline, or very few checkins, etc.

### 4.2\. Submission

Submit via Canvas a zip file containing the following items:

1.  **(1 point)** A **README.txt** file describing the below contents and how to install and run your program.
2.  **(5 points)** PDF file called **cd.pdf** containing a UML class diagram showing the overall design of the core functionality.
3.  **(5 points)** PDF file called **design.pdf** with a single-spaced one-page description of the design rationale, design principles and what patterns were used and where. It should be consistent with the code you submit. Points will be taken off for poor design quality.
4.  **(5 points)** JUnit tests in appropriately structured folders. A generated coverage report must be submitted as **coverage.pdf** and must show the statement and branch coverage obtained for the Java classes written for the program.
5.  **(5 points)** PDF file called **test.pdf** describing system tests in the form of automated scripts or clear instructions on how to run the tests, what inputs to give, and what outputs to expect.
6.  **(25 points)** Java implementation of iteration 2 in appropriately structured folders. The grading of the implementation is based on code quality as well as the functionality. Functionality will be graded in multiple ways. We will ask you to submit a video where you will follow a script that the GTA will give you at a later date. We will also run your application and JUnit tests on our machines. If there are problems, the GTA will schedule a skype/google hangout session and you will walk him through the steps.

* * *

</div>

</div>

<div id="footer">

<div id="footerLeft">Session Time 0 Secs.  
Originating IP 75.163.139.98  
User: [Guest](../ztools/authenticLogin.php)</div>

<div id="footerRight">[![CS Department](../res_images/csBuildingLowerRight.png)](http://www.cs.colostate.edu)</div>

<div id="footerCenter">[Apply to CSU](http://admissions.colostate.edu) | [Contact CSU](http://welcome.colostate.edu/info-contact.aspx) | [Disclaimer](http://welcome.colostate.edu/info-disclaimer.aspx) | [Equal Opportunity](http://welcome.colostate.edu/info-equalop.aspx)  
Colorado State University, Fort Collins, CO 80523 USA  
© 2018 Colorado State University</div>

</div>

</div>
