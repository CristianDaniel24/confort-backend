# Etapa 1: Compilar el proyecto con Maven y JDK 22
FROM maven:3.9.6-eclipse-temurin-22 AS build
WORKDIR /app

# Copiar todo el código del repositorio
COPY . .

# Compilar todos los módulos sin ejecutar tests
RUN mvn clean install -DskipTests

# Etapa 2: Crear imagen liviana para producción
FROM eclipse-temurin:22-jdk
WORKDIR /app

# Copiar el JAR generado de la app principal (confort)
COPY --from=build /app/confort/target/confort-0.1.0-SNAPSHOT.jar app.jar

# Exponer el puerto por defecto de Spring Boot
EXPOSE 8080

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
