# Etapa 1: Compilar el proyecto con Maven y JDK 22
FROM maven:3.9.6-eclipse-temurin-22 AS build
WORKDIR /app

# Copia todo el proyecto desde la raíz del repo (el build context es el repo raíz)
COPY ../.. .

# Compila todos los módulos y salta los tests
RUN mvn clean install -DskipTests

# Etapa 2: Imagen liviana para ejecutar el JAR
FROM eclipse-temurin:22-jdk
WORKDIR /app

# Copia el JAR final de la app principal (confort)
COPY --from=build /app/confort/target/confort-0.1.0-SNAPSHOT.jar app.jar

# Exponer el puerto por defecto
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
