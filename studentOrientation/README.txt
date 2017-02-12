CS542 Design Patterns
Fall 2016
Assignment-1 README FILE

Submission Date: Tuesday, October 28, 2016
Author(s): Tanmay Kale and Gaurav Deshmukh
e-mail(s): tkale1@binghamton.edu and gdeshmu1@binghamton.edu

PURPOSE:

To build a Student Orientation utility for new Students.

PERCENT COMPLETE:

	The assignment is 100% complete.

BUGS:

	No bugs in the file.

FILES:

This Assignment includes following folders and files:

activity/
---- Activity.java, the interface for all of the four activities.
---- BusTourActivity.java, BusTourActivity implements Activity to choose a type of campus tour.
---- GamingDormSelectionActivity.java, GamingDormSelectionActivity implements Activity inorder to choose the Dorm.
---- InHandCourseRegistrationAcitvity.java, InHandCourseRegistrationAcitvity implements Activity which is used to program
	 course registration by submitting the form inhand
---- InHandDormSelectionActivity.java, InHandDormSelectionActivity implements Activity which is used to program
	 dorm selection by submitting the form inhand
---- MandoBookstoreActivity.java, MandoBookstoreActivity implements Activity which is used to implement MandoBook Store.
---- OnFootActivity.java, OnFootActivity implements Activity to choose a type of campus tour
---- OnlineCourseRegistrationActivity.java, OnlineCourseRegistrationActivity implements Activity a type of class registration
---- UniversityBookStore.java, UniversityBookStore implements Activity which is used to implement UniversityBook store.


Builder/
---- OrientationWorkshop.java - OrientationWorkshop implements OrientationWorkshopInterface and contains the definition of the construct function
	 which is used to construct the flow of the Orientation.
---- OrientationWorkshopInterface.java - an interface that is implemented by the OrientationWorkshop
---- StudentOrientation.java - builds all the acitvities.
---- StudentOrientationInterface.java - an interface which contains all the activities build methods.

collector/
---- BookStoreChoice.java - contains Enums of all the BookStore and also contains their getter and setter methods.
---- CourseRegistrationChoice.java - contains Enums of all the CourseRegistration and also contains their getter and setter methods.
---- DormsChoice.java - contains Enums of all the Dorms and also contains their getter and setter methods.
---- TourChoice.java - contains Enums of all the Tour and also contains their getter and setter methods.

driver/
---- Driver.java - parses the argument to the constructor of StudentOrientation and runs the code

expense/
---- Calories.java - Calories implements Effort and sets the unit of efforts to Calories.
---- CarbonFootprints.java - CarbonFootprints implements CarbonFootprintsInterface and sets the units of CarbonFootprints to tonnes of CO2.
---- CarbonFootprintsInterface.java - an interface that contains methods for the CarbonFootprints.
---- Cost.java - an interface that contains methods for Cost.
---- Dollar.java - Dollar implements Cost and sets the units of Cost to Dollar($).
---- DurationMins.java - DurationMins implements Time and sets the units of Time to minutes.
---- Effort.java - an interface that contains methods for Effort.
---- Time.java - an interface that contains methods for Time.

util/
---- Logger.java - user implemented Logger class.



SAMPLE OUTPUT:

$ ant run -DdebugValue=1
Buildfile: /Users/daniel/Sites/github/studentOrientation/studentOrientation/build.xml


jar:


run:
     [java] Total Time: 205
     [java] Total Effort: 420
     [java] Total Cost: $565.0


BUILD SUCCESSFUL
Total time: 1 second




TO COMPILE:

Run ant-compile in the studentOrientation directory (the same level as build.xml).




TO RUN:

ant run -DdebugValue=<debug_value> where debug_value is a number 0 through 4.


The debug values are:


* 0 - none
* 1 - All constructor calls are printed.
* 2 - When all values are set.