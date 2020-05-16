# springboot-rest-service
A simple spring boot rest service

build command [project path] : mvnw clean package <br>
start command [project path] : java -jar target\spring-boot-rest-service-0.0.1-SNAPSHOT.jar <br>

request POST: http://localhost:8083/question/registration/  <br>

{<br>
	"seqNo" : 1,<br>
	"question" : "asil gelistiricinn mail adresi nedir?",<br>
	"answer" : "fuat.cakir@outlook.com"<br>
}<br>

request GET : http://localhost:8083/question/allquestions/

