CS542 Design Patterns
Fall 2016
Assignment-2 README FILE

Author: Tanmay Kale
e-mail: tkale1@binghamton.edu

Submission Date: Friday, September 30, 2016
Submitted Date : Saturday, October 1,2016

Grace Period Used This Project: 1 Days
Grace Period Remaining: 3 Days

PURPOSE:
	To develop a simple program, using Java adn basic design pattern principles,
	to assign courses to students based on their preferences. While using concepts of Multi-Threading.

PERCENT COMPLETE:
	The assignment is 100% complete.

PARTS THAT ARE NOT COMPLETE:
	None.

BUGS:
		No bugs.

FILES:

The assignment folder has the following files included in it.
1. Driver.java, the file has main function and does the desired functions' call.
2. FileDisplayInterface.java : Interface that has a method which is implemented to Write the result contents to a file.
3. StdoutDisplayInterface.java : Interface that has a method which is implemented to Write the result contents to the screen.
4. Results.java : Contains DataStructures and methods that are needed to store and allocate the preferences/subjects to the students.
5. Createworker.java : Is used to create the number of working threads that are needed to execute the algorithm
6. Worker.java : It contains the implementation of the run method. The run method is used to call the main algorithm which is the StoreDataClass.
7. FileProcessor : This class contains methods that are used to read the contents of the input file.
8. Logger.java : Is used to create a log of all the debug information.
9. ObjectPool.java : Is an abstract class which contains methods that are used to check if the courses are available to borrow and return
10. StoreDataClass.java : This class contains the main Registration Scheduler algorithm and the necessary data structures.
11. build.xml : Is an ANT configuration file. Which is used for cleanign, compiling, Running the code.
12. README.tx : It contains all the needed information of the project.

SAMPLE OUTPUT:
1. After the project has been built.

Buildfile: /import/linux/home/tkale1/DP/Assignment2/src/build.xml

prepare:
    [mkdir] Created dir: /import/linux/home/tkale1/DP/Assignment2/BUILD
    [mkdir] Created dir: /import/linux/home/tkale1/DP/Assignment2/BUILD/classes

registrationScheduler:
    [javac] /import/linux/home/tkale1/DP/Assignment2/src/build.xml:48: warning: 'includeantruntime' was not set, defaulting to build.sysclasspath=last; set to false for repeatable builds
    [javac] Compiling 10 source files to /import/linux/home/tkale1/DP/Assignment2/BUILD/classes

compile_all:

all:

BUILD SUCCESSFUL
Total time: 3 seconds

TO COMPILE and TO RUN :
On terminal use the following commands : 
1. Open tanmay_kale_assign1/registrationScheduler folder.
2. Use the following command 'ant -buildfile src/build.xml clean' and press Enter.
	Note :On successfull build you will get the output as shown above.
3. Use the following command 'ant -buildfile src/build.xml all' to compile and press Enter.
4. Use the following command 'ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=3 -Darg3=0' and press Enter


JUSTIFICATION FOR DATA STRUCTURE USED:
I have used Arrays and ArrayList data structure in this project assignment, as it has a better space complexity.
The arraylists grows by 50% so it saves a lot of space if the total input lenght is variable. I also used arrays as it is easier to manipluate arrays while using multi-threading. 

EXTRA CREDIT:
none

BIBLIOGRAPHY:
This serves as evidence that we are in no way intending Academic Dishonesty.

  * File read code:
	http://stackoverflow.com/questions/18021218/create-a-list-of-primitive-int
  * File Write code:
	https://www.mkyong.com/java/how-to-write-to-file-in-java-bufferedwriter-example/