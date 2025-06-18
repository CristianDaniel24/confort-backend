# Usa una imagen de Maven para compilar el proyecto
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copia el contenido completo del proyecto multi-módulo
COPY ../ ./

# Compila el proyecto (empacando confort y sus módulos)
RUN mvn clean package -DskipTests

# Imagen final con solo el JAR ejecutable
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copia el JAR desde la imagen anterior
COPY --from=build /app/confort/target/confort-0.1.0-SNAPSHOT.jar app.jar

# Puerto que expone Spring Boot por defecto
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
