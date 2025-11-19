# --- Estágio 1: Construção (Build) ---
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app

# Copia os arquivos do projeto
COPY . .

# Garante permissão ao Gradle
RUN chmod +x gradlew

# Gera o .jar (Build bem sucedido confirmado no seu log anterior)
RUN ./gradlew clean build -x test --no-daemon

# --- Estágio 2: Execução (Runtime) ---
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Pega o .jar gerado no estágio 1 e renomeia para app.jar
COPY --from=build /app/build/libs/*.jar app.jar

# --- A MUDANÇA IMPORTANTE ---
# Removemos a cópia do start.sh porque ele tem comandos errados.
# Rodamos o Java diretamente:
ENTRYPOINT ["java", "-jar", "app.jar"]