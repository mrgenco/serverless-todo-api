# serverless-todo-api

### Background
I created this simple SpringBoot application for experimenting
Cloud Run and Cloud Datastore platforms.

[CloudRun](https://cloud.google.com/run) is a serverless computing platform for deploying and scaling containerized applications quickly and securely.

[Cloud Datastore](https://cloud.google.com/datastore) is a NoSQL document database built for automatic scaling, high performance, and ease of application development.

[Spring Cloud GCP](https://spring.io/projects/spring-cloud-gcp)  helps a lot while developing Google Cloud Platform (GCP) applications with Spring Framework by providing auto-configuration facilities. 

### Setup (Local and Cloud)

### Run this project on local machine :
 
 1. Login to your [GCP(Google Cloud Platform) account](https://cloud.google.com/). 

 2. [Install Google Cloud SDK](https://cloud.google.com/sdk/docs/quickstarts?hl=tr) to your local machine.

 3. Create a project in the console. [See this link](https://cloud.google.com/resource-manager/docs/creating-managing-projects) for how to create and manage projects. 

 4. Make sure we are pointing to the correct project and authenticate using following commands:
    ``` sh
    gcloud config set project <YOUR PROJECT ID>
    gcloud auth login
    ``` 
 5. Make sure your machine has app credentials to run your app.
     ``` sh
    gcloud auth application-default login
    ``` 
 6. Run your application locally
    ``` sh
    mvn spring-boot:run
    ``` 
    
### Run this project on Cloud Run : 
Follow first 5 steps above and run following command
 ``` sh
mvn jib:build
```
This command will build and push your image to your GCR (Google Cloud Registery) automatically.
Then you need to create a new Cloud Run service in the console and select your uploaded image.
Now your endpoints are ready!

<b>Note:</b>
You dont need Docker installed on your machine since we have [jib](https://github.com/GoogleContainerTools/jib) dependency.
It is a great way to containerize your Java application. It allows you to create optimized images without Docker using Maven or Gradle.


## Endpoints

<b>Get all records (HTTP : GET)</b>
<p>{YOUR_CLOUDRUN_SERVICE_URL}/api/todo/all</p>

<b>Get single record (HTTP : GET)</b>
<p>{YOUR_CLOUDRUN_SERVICE_URL}/api/todo/get/{id}</p>

<b>Save new record (HTTP : POST)</b>
<p>{YOUR_CLOUDRUN_SERVICE_URL}/api/todo/save</p>

<b>Update single record (HTTP : POST)</b>
<p>{YOUR_CLOUDRUN_SERVICE_URL}/api/todo/update</p>

<b>Delete single record (HTTP : GET)</b>
<p>{YOUR_CLOUDRUN_SERVICE_URL}/api/todo/delete/{id}</p>

Any Questions?

If you have any questions feel free to contact. 
I will be writing a detailed blog post in the next days for Cloud Run and Spring.
If you dont miss it follow me on twitter :) [mr_genco](https://twitter.com/mr_genco) 

###TODOS : 
-  Add a UI (VueJS)
-  Secure the endpoints with [Okta](https://developer.okta.com/)

