FROM eclipse-temurin:21

# Kopiujemy Twój konkretny plik i zmieniamy mu nazwę na app.jar wewnątrz kontenera
COPY target/lab3-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8081

# Uruchamiamy ten skopiowany plik
ENTRYPOINT ["java", "-jar", "app.jar"]