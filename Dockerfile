# Stage 1: Build
FROM eclipse-temurin:17-jdk AS build
WORKDIR /app

# Skopíruj Maven wrapper + pom.xml
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Nastav spustiteľné práva
RUN chmod +x mvnw

# Stiahni závislosti (cache-friendly krok)
RUN ./mvnw dependency:go-offline -B

# Skopíruj zdrojové súbory a postav projekt
COPY src src
RUN ./mvnw clean package -DskipTests

# Stage 2: Run
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
