CS542 Design Patterns
Fall 2016
Assignment-1 README FILE

Submission Date: Tuesday, August 30, 2016
Author: Tanmay Kale
e-mail: tkale1@binghamton.edu

PURPOSE:

	A simple Java program and develop a program, using Java, to assign courses to students based on their preferences.
	
PERCENT COMPLETE:

	The assignment is 100% complete.

BUGS:

	No bugs in the file.

FILES:

This Assignment includes 4 Files, namely

	1) Driver.java- Main file which contains the main method to run the code.
	2) README.txt- The documentation part of the Assignment. 

SAMPLE OUTPUT:

remote04:~/DP/tanmay_kale_assign1/Starting-with-java/src> javac Driver.java           
remote04:~/DP/tanmay_kale_assign1/Starting-with-java/src> java Driver input.txt output.txt
input.txt file successfully opened for reading
Details of student 1
s1 3 2 1 4
Details of student 2
s2 4 2 1 3
Details of student 3
s3 3 1 4 2
Details of student 4
s4 4 3 2 1
Details of student 5
s5 1 2 4 3
Details of student 6
s6 3 1 2 4
Details of student 7
s7 1 4 2 3
Details of student 8
s8 1 3 4 2
Details of student 9
s9 2 3 4 1
Details of student 10
s10 2 1 4 3
Details of student 11
s11 4 2 1 3
Details of student 12
s12 1 2 3 4

Student_1 C B A 6
Student_2 C B D 6
Student_3 B D A 6
Student_4 D C B 6
Student_5 A B D 6
Student_6 B C A 6
Student_7 A C D 6
Student_8 A D B 6
Student_9 D A C 7
Student_10 B A D 6
Student_11 C B D 6
Student_12 A B C 6
Average preference_score is : 6.0833335

TO COMPILE:

	On terminal after extracting the files from the tarball, 
	1. Navigate to the src folder of project directory.
		tanmay_kale_assign1/Starting-with-java/src/Driver.java
	2. Type the command javac *.java and press Enter Key.

TO RUN:

  * After successful compilation use the below command on the command line and press enter 
	java Driver input.txt output.txt

BIBLIOGRAPHY:

This serves as evidence that we are in no way intending Academic Dishonesty.

  * File read code:
	http://stackoverflow.com/questions/18021218/create-a-list-of-primitive-int
  * File Write code:
	https://www.mkyong.com/java/how-to-write-to-file-in-java-bufferedwriter-example/