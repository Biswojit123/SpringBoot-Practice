Profiles in Spring Boot
===========================
-> Both Spring and Spring Boot support profiles.
-> We work with profiles while developing Spring applications using:
      a) XML-driven configurations
      b) XML + annotation-driven configurations
      c) 100% code-driven configurations
      d) Spring Boot
-> The setup required to execute the application is called the environment. This environment includes compiled code + database software + server + DataSource + JRE/JVM, and so on.

#Note: This environment is also called a profile. These are like Netflix, Amazon Prime profiles, which keep track of various activities of the user, such as movie watching history, watch list, recommendations, etc.

-> As part of project development to project production, we need different environments/profiles, such as:

a) Profile/environment for development
b) Profile/environment for testing
c) Profile/environment for UAT (User Acceptance Testing at the client organization)
d) Profile/environment for production

Environments for Different Profiles
===================================
 1.Proj1 - Dev
     Profile
     
         a. MySQL database software
         b. Tomcat server
         c. Apache DBCP2

 2.Proj1 - Testing
    Profile
    
         a. MySQL database software
         b. Tomcat server
         c. C3P0 DataSource
          
-> At software company (It can be done using a local setup or cloud setup like AWS/Azure/GCP, etc.)

3.Proj1 - UAT
  Profile
  
         a. Oracle database
         b. Tomcat server
         c. Oracle UCP

4.Proj1 - Production
  Profile
  
         a. Oracle database
         b. WildFly server
         c. HikariCP

Technology Used
===============
1. Spring Boot
2. Java
3. Maven tools
4. Spring Framework

Output
======
![Screenshot 2024-10-17 152623](https://github.com/user-attachments/assets/d750d283-64e9-4ea7-93c3-b144d4b7bd0e)
