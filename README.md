### Source: 

# Getting Started

## Guides

   ### 1. Postgres
       
        steps:
        
           enter database: psql
           
           create db:      "CREATE DATABASE netbooktest;"
           
           quit database:  "\q"
           
           go to 'content-service/dataset' folder and edit 'script.sql' - change the relative path to all csv files
           
           in terminal (stay in '/dataset' folder) execute: "psql -d netbooktest -f script.sql"
               
   ### 2. Setting up Content-Service
        steps:
            
            edit /resources/application.properties: set up your 'username' and 'password' for postgresql 
            
   ### 3. Run
        Intellij - steps: File -> New -> Project From Existing Sources, then click next..
        
        
        Terminal
            steps:
                terminal: "mvn clean install", or "mvn install"
                terminal: "mvn spring-boot:run"
            
   ### 4. Testing with Postman
            
            Please refer to 'README.md' placed in 'Authentication' folder

## References

### Project Structure References Docs:
https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-structuring-your-code.html
