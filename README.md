# CACHE
## Description 
This is a simple app for a cache. The user can select from the different available strategies and execute the program

# Reuirements
   ```bash	
   1.Maven 
   2.JDK version 8 or higher
   ```
# Installation 
1. Clone the repository to your local machine:

    ```bash
    git clone https://github.com/PanosVaritis/LRUcache.git
    ```
# Compilation and execution
1. Enter project directory
    ```bash
    cd LRUcache
    ```
2.  Build the project using Maven:

    ```bash
    mvn clean package
    ```
3. Execute main
    ```bash
    java -cp target/cache-1.0-SNAPSHOT.jar org.hua.cache.App
    ```


# Executing the tests
1. this command will execute all the junit test that the project has (all the classes and all the tests)
    ```bash
    mvn test
    ```
2. this command will execute the tests provided in the class_name (the project has 2 classes with tests)
    ```bash
    mvn -Dtest=class_name test
    ```
3. mvn -Dtest=class_name#method_name test: this command exexutes a specific test in the class
    ```bash
    mvn -Dtest=class_name#method_name test
    ``` 
