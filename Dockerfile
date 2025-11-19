# --- Estágio 1: Construção (Build com Gradle) ---
# Usamos a imagem JDK (Java Development Kit) para ter as ferramentas de build
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app

# Copia todos os arquivos do projeto para dentro do container
COPY . .

# Dá permissão de execução ao gradlew (essencial para Linux/Docker)
RUN chmod +x gradlew

# Executa o build com Gradle (pulando testes para ser mais rápido)
RUN ./gradlew clean build -x test --no-daemon

# --- Estágio 2: Execução (Runtime) ---
# Usamos a imagem JRE (Java Runtime Environment) que é mais leve
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copia o jar gerado na pasta build/libs para o nome app.jar
# O Gradle gera o arquivo em build/libs/, diferente do Maven que é em target/
COPY --from=build /app/build/libs/*.jar app.jar

# Copia o script start.sh
COPY start.sh .

# Dá permissão e define o comando de inicialização
RUN chmod +x start.sh
CMD ["./start.sh"]