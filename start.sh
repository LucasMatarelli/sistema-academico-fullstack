#!/bin/sh

# 1. Torna o wrapper do Gradle executável
chmod +x gradlew

# 2. Compila o projeto (Build)
./gradlew clean build

# 3. Inicia a aplicação (Start)
java -jar build/libs/*.jar