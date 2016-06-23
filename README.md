<h1>MIGDB SERVER APPLICATION</h1>
</br>
<h2>Instructions</h2>
<p>When you need to access services of MigDB server please follow below steps</p>
<h3>step1:</h3>
<p>add Basic Authentication headers</p>
<p>Username=</p>
<p>/migdbserver/src/main/java/org/migdb/migdbserver/main/config/AuthenticationParameters.java/APPLICATION_ID</p>
<p>Password=</p>
<p>/migdbserver/src/main/java/org/migdb/migdbserver/main/config/AuthenticationParameters.java/SECURITY_KEY</p>
<h3>step2:</h3>
<p>Specify your Accept and Content-type headers.</p>
<p>Supported formats: application/json , application/xml</p>
<h3>step3:</h3>
<h4>[for getting mapping model]</h4>
<p>Create object from /migdbserver/src/main/java/org/migdb/migdbserver/main/resources/MappingRequestMessage and encode to JSON format or XML format. Send [POST] request to <a href="http://{your-host}:8080/migdbserver/services/mappingrequest">http://{your-host}:8080/migdbserver/services/mappingrequest </a></p>
<h4>[for updating learning data set]</h4>
<p>Create object from /migdbserver/src/main/java/org/migdb/migdbserver/main/resources/DataSetUpdateRequestMessage and encode to JSON or XML format. Send [POST] request to <a href="http://{your-host}:8080/migdbserver/services/learnnetwork">http://{your-host}:8080/migdbserver/services/learnnetwork</a></p>
<p>&nbsp;</p>
