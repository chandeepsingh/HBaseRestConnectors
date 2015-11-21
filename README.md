A Minimal RestExpress Server + HBase Custom Client
=========================

Uses the template RestExpress project and adds features to query HBase.

To run the project:
	mvn clean package exec:java

To create a project deployable assembly (zip file):
	mvn clean package -DskipTests
	mvn assembly:single

Main - src/main/java/hbase/hbase/rest/
Client - src/main/java/hbase/hbase/client/
RestExpress Port - 8081
Sample UI Request - localhost:8081/tableName/rowId/cF.json
