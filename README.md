#CACHE
##Description 
This is a simple app for a cache. The user can select from the different available strategies and execute the program

#Reuirements
1.Maven 
2.JDK version 8 or higher

#Installation 
1. Open the terminal and create a file that will store the project (for example mkdir test)
2. Enter the file that you created (cd test)
3. Clone the repositiry: git clone ....

#Navigate through the project
1. cd LRUCache
2. find: to see the file structure to the project

#Compilation and execution
1. Navigate to the project, in the file that contains the pom file
2. mvn clean package (builds the project, creates the target, the jar, and executes all the test)
3. java -cp target/.....jar org.hua.

#Executing the tests
1. mvn test: this command will execute all the junit test that the project has (all the classes and all the tests)
2. mvn -Dtest=class_name test: this command will execute the tests provided in the class_name (the project has 2 classes with tests)
3. mvn -Dtest=class_name#method_name test: this command exexutes a specific test in the class 
