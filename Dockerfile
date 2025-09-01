# Stage 1: Build
FROM eclipse-temurin:17-jdk AS build

WORKDIR /app
COPY . .

# Spustí maven wrapper
RUN ./mvnw clean package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:17-jdk

WORKDIR /app
# Skopíruje vybuildovaný jar z predošlého kroku
COPY --from=build /app/target/destinations-0.0.1-SNAPSHOT.jar app.jar

# Spustí aplikáciu
ENTRYPOINT ["java", "-jar", "app.jar"]
