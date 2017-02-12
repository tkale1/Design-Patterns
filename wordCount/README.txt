CS542 Design Patterns
Fall 2016
Assignment-4 README FILE


Submission Date: Wednesday, Wednesday 23, 2016
Author(s): Tanmay Kale
e-mail(s): tkale1@binghamton.edu


PURPOSE:

	A simple Java program and develop Java application, which implements a BST Tree using Visitors which will
	Populate the tree, Get statistics from the tree (word Count)and Clone the tree(backup) and do a conditional
	update to the backup tree.


PERCENT COMPLETE:

	The assignment is 100% complete.


BUGS:

	No bugs in the file.


FILES:

		This Assignment includes following folders and files:
		kale_tanmay_assign4
		-- input.txt
		-- input1.txt
		-- input2.txt
		-- wordCount
     		----- README.txt
     		----- build.xml
     		----- src
        		-----wordCount
     	   			---------driver
	        	   		1. Driver.java : parses the argument to the constructor of BST and all Visitors and runs the code
           			---------dsForString
	           			1. BST.java : Implements and overrides the method of BSTInterface.
	       				2. BSTInterface.java : Interface that contains the methods needed to create a BST Tree.
	                	3. Node.Java : Contains getter and setter methods and data member that are necessary to implement a BST Tree. Also 								implements the Observer and Subject interface.
           			---------Observer
	              		1. ObeserverInterface.java : Interface that contains methods of an Obeserver.
	              		2. SubjectInterface.java : Interface that contains methods of a Subject.
           			---------Util
						1. FileProcessor.java : This class contains methods that are used to read the contents of the input file.
						2. Logger.java : Is used to create a log of all the debug information
						3. Test.java : Is used for creating a backup of the tree and updating the backup tree.
					----------Util
						-----------CloneVisitor
							1. CloneVisitor.java : Calls the CloneTraverse() which clone the BST tree Node by Node.
						----------DSProcessingVisitorI
							1. Visitor.java : Interface which contains method for implementing a Visitor
						----------PopulateVisior
							1. Visitor that populates the BST Tree.
						----------UpdateVisitor
							1. UpdateVisitor.java : Updates the frequency of all the nodes in the tree by 10.
	              		-----------WordCountVisitor
							1. GetStatistic.java : a method that calculates the total number of words, total number of unique words, and characters stored in the data structure	
							2. WordCountVisitor.java : Visitor calls the methods of GetStatistics class to get the above details of BST Tree.


TO COMPILE:

		Run ant-compile in the wordCount directory.
		remote06:~/kale_tanmay_assign4/wordCount> ant all


TO RUN:
		The driver code takes 3 arguments:
			1. Name of the input file : input.txt
			2. Name of the output file : output.txt
			3. Number of iteration : 10

		Using ant pass the arguments as below :
			ant run -Darg0=input.txt -Darg1=output.txt -Darg2=10 <where -Darg2 is the No of Iteration>


SAMPLE OUTPUT:
		remote06:~/kale_tanmay_assign4/wordCount> ant run -Darg0=input2.txt -Darg1=output.txt -Darg2=10
		Buildfile: /import/linux/home/tkale1/kale_tanmay_assign4/wordCount/build.xml

		jar:

		run:
     			[java] Total Time : 22 milliseconds

		BUILD SUCCESSFUL
		Total time: 1 second


The debug values are:

		* 0 - To check Clone Tree.
		* 1 - Prints when backup Tree is been updated.
		* 2 - When all data is read from file.
		* 3 - When Constructors are called.


JUSTIFICATION FOR DATA STRUCTURE USED:
		I have used Arrays as the data structure in this project assignment, as it has a better time complexity of O(n). of 
		all add, write and get. I have not used arrayList as it takes more memory. Almost 50% more of what is required, So of a 
		very large tree there will be 50% more memory that will be allocated which is of no use.
		

TO CHECK BACKUP TREE AND UPDATE TREE FUNCTIONALITY.

		1. The Test Class is used for creating a backup of the tree and updating the backup tree.
		2. Inorder to test both the functionalities please use the input.txt and input1.txt file.
		3. The Test.java file contians the CreateBackup() and CheckBackup() which respectively creates
			and updates the backup tree.
		4. To check the authenticity of the update function and backup function please remove the comment
			of printInorder in both the functions.
		5. The lines for both the functions are Line 42 for Checking creation of backupTree and Line 63 for
			Check Update of backup tree.


BIBLIOGRAPHY:
This serves as evidence that we are in no way intending Academic Dishonesty.

		1. All my previous assignments for Filereading and Filewriting code.
		2. Class Notes.
		
		