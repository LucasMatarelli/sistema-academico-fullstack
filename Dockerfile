# --- Estágio 1: Construção (Build) ---
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
# Copia todos os arquivos do seu projeto para dentro do container de build
COPY . .
# Executa o build (gera o arquivo .jar)
RUN mvn clean package -DskipTests

# --- Estágio 2: Execução (Runtime) ---
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copia o arquivo .jar gerado no estágio anterior
COPY --from=build /app/target/*.jar app.jar

# AQUI ESTÁ A SOLUÇÃO DO SEU ERRO:
# Copia o script start.sh para dentro do container final
COPY start.sh .

# Dá permissão de execução para o script (essencial para Linux)
RUN chmod +x start.sh

# Comando padrão para iniciar (pode ser sobrescrito pelo Render)
CMD ["./start.sh"]