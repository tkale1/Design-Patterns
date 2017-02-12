CS542 Design Patterns
Fall 2016
Assignment-5 README FILE


Submission Date: Thrusday, December 15, 2016
Author(s): Tanmay Kale
e-mail(s): tkale1@binghamton.edu


PURPOSE:

	A simple Java program, which implements Java Reflection and Object Comparison


PERCENT COMPLETE:

	The assignment is 100% complete.


BUGS:

	No bugs in the file.

FILES:

This Assignment includes following folders and files:
	kale_tanmay_assign5
		— genericDeser/
		----- README.txt
     		----- build.xml
	 	----- input.txt
    		----- src
     		    ———genericDeser/
     	   		---driver/
	       			1. Driver.java : Creates an instance of PopulateObject and called its methods to find out the total count of objects created using reflection.
           		---fileOperations/
				1. FileProcessor.java : This class contains methods that are used to read the contents of the input file.
				2. FileProcessorI.java : Interface which contains method for implementing a FileProcessor.
           		—util/
				1. First.java : Contains 4 data members which are used to test reflection and it overrides the hasCode and equals methods.
				2. Second.java : Contains 3 data members which are used to test reflection and it overrides the hasCode and equals methods.
				3. Logger.java : Is used to create a log of all the debug information
				4. PopulateObjects.java : Is used creating all the object and invoke the methods of Frist and Second class using 
				concepts of Java Reflection

TO COMPILE:

	Run ant-compile in the home directory: kale_tanmay_assign5/genericDeser/
	remote00:~/DP/kale_tanmay_assign5/genericDeser> ant all


TO RUN:
		The driver code takes 3 arguments:
			1. Name of the input file : input.txt
			2. Debug value for Logger : 0

		Using ant pass the arguments as below :
		 	ant run -Darg0=input.txt -Darg1=0


SAMPLE OUTPUT:
		remote00:~/DP/kale_tanmay_assign5/genericDeser> ant run -Darg0=input.txt -Darg1=0
		Buildfile: /import/linux/home/tkale1/DP/kale_tanmay_assign5/genericDeser/build.xml

		jar:
    		[mkdir] Created dir: /import/linux/home/tkale1/DP/kale_tanmay_assign5/genericDeser/BUILD/jar
      		[jar] Building jar: /import/linux/home/tkale1/DP/kale_tanmay_assign5/genericDeser/BUILD/jar/genericDeser.jar

		run:
     		[java] Number of unique First objects: 4952
     		[java] Total Number of First objects: 4952
     		[java] Number of unique Second objects: 5018
     		[java] Total Number of Second objects: 5048

		BUILD SUCCESSFUL
		Total time: 1 second


The debug values are:

		0 = Get the output of unique object instances and total objects instances of class First and Second.
		1 = When functions called
		2 = When file read operations are called
		3 = When constructors are called

JUSTIFICATION FOR DATA STRUCTURE USED:

		I have used HashMaps because they are much faster for retrieving data than arrays and linked lists. A HashMap can check if it contains a particular key in O(1) provided that all keys are unique. So this provided me with a faster way of checking to whether the object exists or not.


BIBLIOGRAPHY:
This serves as evidence that we are in no way intending Academic Dishonesty.

		1. All my previous assignments for Filereading code.
		2. Class Notes.