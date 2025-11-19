FROM openjdk:17-jre-slim
# Render irá ignorar o CMD abaixo, pois você usou o Docker Command no painel:
CMD ["echo", "Starting Java application via Docker Command override."]