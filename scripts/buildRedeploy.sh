#!/bin/sh

echo "************ UNDEPLOYING *******************"
/home/student/glassfish3/bin/asadmin undeploy aelo
echo "************ BUILDING **********************"
mvn package
echo "************ DEPLOYING *********************"
/home/student/glassfish3/bin/asadmin deploy target/aelo.war
