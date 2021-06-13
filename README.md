# target-generic-notifer
Repo hosts the code of generic notification system.

Steps to install the  module.  
Need Java 1.8 or higher version


Checkout the code  
git clone https://github.com/CodeKarRohan/target-generic-notifer.git  
git checkout main  

### Import the project in any ide (Intelij) as maven project  
### Run the NotifierApplication class  

### If IDE is not present run the following command 
Go to target-generic-notifer directory
### mvn spring-boot:run  

Access the Swagger using
http://localhost:8080/


Request body
	{
   "message": "test Message",
	"from" : "ORDER",
	"to":"ALL"
  }
  
// send to all consumer who have subscriber for topic workflow  
http://localhost:8080/api/v1/notification/topic/WORKFLOW    

//send message to all consumers  
http://localhost:8080/api/v1/notification    

// Send message to particular consumer  
http://localhost:8080/api/v1/notification/topic/WORKFLOW/consumer/Customer1  
	
 // Geeneric message sender   
http://localhost:8080/api/v1/notification/nofify?email=rohan1404n@gmail.com&slackid=testslack  


Other pais are present for adding topics, consumerrs and all  



