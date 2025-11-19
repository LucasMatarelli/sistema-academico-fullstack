#!/bin/sh

# Final commit to force file permissions for Render

chmod +x gradlew
./gradlew clean build
java -jar build/libs/*.jar