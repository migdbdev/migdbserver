<h1>MIGDB SERVER APPLICATION</h1>
</br>
<h2>Instructions</h2>

When you need to access services of MigDB server please follow below steps

step1:
add Basic Authentication headers
Username = /migdbserver/src/main/java/org/migdb/migdbserver/main/config/AuthenticationParameters.java/APPLICATION_ID
Password = /migdbserver/src/main/java/org/migdb/migdbserver/main/config/AuthenticationParameters.java/SECURITY_KEY

step2:
Specify your Accept and Content-type headers.
supported formats: application/json , application/xml

step3:
[for getting mapping model]
Create object from /migdbserver/src/main/java/org/migdb/migdbserver/main/resources/MappingRequestMessage and encode to JSON format or XML format.
Send [POST] request to http://{your-host}:8080/migdbserver/services/mappingrequest

[for updating learning data set]
Create object from /migdbserver/src/main/java/org/migdb/migdbserver/main/resources/DataSetUpdateRequestMessage and encode to JSON or XML format.
Send [POST] request to http://{your-host}:8080/migdbserver/services/learnnetwork
