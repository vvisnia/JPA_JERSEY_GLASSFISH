# JPA_JERSEY_GLASSFISH


## IMPORTANT! USE GLASSFISH VERSION 3.1.22

## Clone this project and run database server

* clone or update this project (obvious)
* cd to the project folder (do this with any other terminal)
* `chmod 755 ./scripts/*.sh` 
* run HSQLDB server (TCP, in memory mode):  
`./scripts/runHSQLDBServer.sh`



## Define Connection Pool and JNDI JDBC resource

* stop GlassFish if it's running  
`asadmin stop-domain`
* copy jdbc driver hsqldb-2.2.4.jar to glassfish domain lib folder e.g.:  
`cp ./scripts/hsqldb-2.2.4.jar /opt/devel/as/glassfish3/glassfish/domains/domain1/lib/ext/.`
* define resource connection pool and jndi resource. Edit default domain configuration file e.g.:  
`vi /opt/devel/as/glassfish3/glassfish/domains/domain1/config/domain.xml`  
Find `<resource>` element. Copy&Paste following xml fragment next to any other `<jdbc-connection-pool>` element:    
`    <jdbc-connection-pool driver-classname="" datasource-classname="org.hsqldb.jdbc.JDBCDataSource"`  
`    res-type="javax.sql.DataSource" description="" name="HSQLPool" ping="true">`    
`      <property name="DatabaseName" value="jdbc:hsqldb:hsql://localhost/workdb"></property>`    
`      <property name="User" value="SA"></property>`   
`      <property name="Password" value=""></property>`    
`      <property name="connectionAttributes" value=";ifexists=true"></property>`    
`    </jdbc-connection-pool>`    
`    <jdbc-resource pool-name="HSQLPool" description="DataSource for aelo with HSQLDB" `  
`    jndi-name="jdbc/aelo"></jdbc-resource>`        
* start GlassFish  
`asadmin start-domain`
* check out connection from inside GlassFish
 * open web console `http://localhost:4848` 
 * click: Resources/JDBC/JDBC Connection Pools
 * click: HSQLPool
 * try Ping, it must Succeed !
 
## Add Hibernate support to GlassFish

* open web console `http://localhost:4848` 
* click: Update Tool
* find and select Hibertate in Available Add-Ons
* click Install
* restart GlassFish
`asadmin restart-domain`

## Deploy & run project
1. `./scripts/buildRedeploy.sh`
* `http://localhost:4848/library` 

