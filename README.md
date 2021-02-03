# spring-boot-test-proj

This project illustrates a situation when the interceptor is called twice per request.
The request made toward the **spring-data-rest** endpoint http://localhost:8080/as.
To reproduce:
- run the application
- go to http://localhost:8080/as
- you should be able to see the message in console, printed twice per request


The bug is present on spring boot 2.4.x
On 2.3.x the interceptor is called  once.
