<h1>MIGDB SERVER APPLICATION</h1>

<table class="tg">
  <tr>
    <th class="tg-yw4l">Version</th>
    <th class="tg-yw4l">Build Status</th>
  </tr>
  <tr>
    <td class="tg-yw4l">v1.00</td>
    <td class="tg-yw4l">
    <img src="https://travis-ci.org/migdbdev/migdbserver.svg?branch=master"/>
    </td>
  </tr>
</table>
<h2>Instructions</h2>
<p>When you need to access services of MigDB server please follow below steps</p>
<h4>Step1:</h4>
<p>Add Basic Authentication headers</p>
<p>Username=</p>
<p>/migdbserver/src/main/java/org/migdb/migdbserver/main/config/AuthenticationParameters.java/APPLICATION_ID</p>
<p>Password=</p>
<p>/migdbserver/src/main/java/org/migdb/migdbserver/main/config/AuthenticationParameters.java/SECURITY_KEY</p>
<h4>Step2:</h4>
<p>Specify your Accept and Content-type headers.</p>
<p>Supported formats: application/json , application/xml</p>
<h4>Step3:</h4>
<h4>[for getting mapping model]</h4>
<p>Create object from /migdbserver/src/main/java/org/migdb/migdbserver/main/resources/MappingRequestMessage and encode to JSON format or XML format. Send [POST] request to <a href="http://{your-host}:8080/migdbserver/services/mappingrequest">http://{your-host}:8080/migdbserver/services/mappingrequest </a></p>
<h4>[for updating learning data set]</h4>
<p>Create object from /migdbserver/src/main/java/org/migdb/migdbserver/main/resources/DataSetUpdateRequestMessage and encode to JSON or XML format. Send [POST] request to <a href="http://{your-host}:8080/migdbserver/services/learnnetwork">http://{your-host}:8080/migdbserver/services/learnnetwork</a></p>
<p>&nbsp;</p>
<hr/>
<p style="text-align: left;"><strong>Sample API Request</strong></p>
<p style="text-align: left;"><strong>---url</strong><br />[post] http://localhost:8080/migdbserver/services/mappingrequest</p>
<p style="text-align: left;"><strong>---basic authentication</strong><br />username : fhgi8598ugh985yhob580uojg0t<br />password : dfjgn984u608jb950o9bipj0945yjpbjmgi</p>
<p style="text-align: left;"><strong>---headers</strong><br />Accept : application/json<br />Content-Type : application/json</p>
<p style="text-align: left;"><strong>---body</strong><br />{<br /> "clientId": "req123457",<br /> "createdTime": "2016-05-17T16:31:31.348+05:30",<br /> "requestId": "123345346458",<br /> "columnCount": "2",<br /> "numericCount" : "0",<br /> "stringCount":"0",<br /> "calenderCount":"0"<br />}</p>
