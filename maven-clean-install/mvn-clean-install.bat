
cd ../liupengCloud-dependencies
call mvn clean install

cd ../liupengCloud-activemq-java
call mvn clean install

cd ../liupengCloud-activemq-spring
call mvn clean install

cd ../liupengCloud-activemq-springboot-consumer
call mvn clean install

cd ../liupengCloud-activemq-springboot-provider
call mvn clean install

cd ../liupengCloud-rabbitmq-consumer
call mvn clean install

cd ../liupengCloud-rabbitmq-provider
call mvn clean install