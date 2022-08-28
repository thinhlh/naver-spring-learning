# Run at local

# Build JAR file
./mvnw clean -q package -q

# Run cluster
docker compose up -d

# Logging
docker ps -a