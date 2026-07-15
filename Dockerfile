# Этап 1: Сборка приложения
FROM gradle:jdk25 AS builder

# Определение рабочей директории для сборки
WORKDIR /app

# Копирование файлов сборки Gradle для кеширования зависимостей
COPY gradle .
COPY gradle gradle
COPY settings.gradle.kts .
# Если есть build.gradle.kts, раскомментируйте строку ниже:
# COPY build.gradle.kts .

# Загрузка зависимостей (кеширование)
RUN ./gradlew dependencies --no-daemon

# Копирование исходного кода
COPY src ./src

# Сборка проекта (jar-файла)
RUN ./gradlew bootJar --no-daemon || ./gradlew jar --no-daemon

# Этап 2: Запуск приложения
FROM eclipse-temurin:25-jre-alpine

# Определение рабочей директории для запуска
WORKDIR /app

# Копирование собранного jar-файла из первого этапа
COPY --from=builder /app/build/libs/*.jar app.jar

# Команда для запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]