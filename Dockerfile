FROM eclipse-temurin:17-jre-alpine
# Render irá ignorar o CMD abaixo, pois você usou o Docker Command no painel:
CMD ["echo", "Starting Java application via Docker Command override."]