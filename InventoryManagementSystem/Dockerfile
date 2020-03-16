FROM openjdk:8-alpine
COPY ./target/InventoryManagementSystem-0.0.1-SNAPSHOT.war /usr/src/InventoryManagementSystem.war
WORKDIR /usr/src
#EXPOSE 8085:8085
CMD ["java", "-jar", "InventoryManagementSystem.war"]
