Use the commands below assuming you have maven and tomcat installed and configured.

mvn install
mvn compile

start app

go to http://localhost:8080/swagger-ui/index.html

use the path below for the api-docs in the swagger ui then press Explore.
http://localhost:8080/v3/api-docs

Testing:
src/main/test/java/me.iit.w5openapi
Tests can be run individually or together, in IntelliJ
select the test you wish to run or select the test class itself
to run all the tests in it.