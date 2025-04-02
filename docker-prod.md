# Aerztekasse docker-prod documentation

### Build and push the api image to docker hub in one command
````bash
docker buildx build --push --platform linux/amd64 -t zoltansco/aerztekasse:aerztekasse-api-2025.04.02 -f Dockerfile .
````

### MySQL only

#### start
````bash
docker-compose -f aerztekasse-api-prod-mysql-only-docker-compose.yml up -d
````

#### stop
````bash
docker-compose -f aerztekasse-api-prod-mysql-only-docker-compose.yml down
````

### API

#### start
````bash
docker-compose -f aerztekasse-api-prod-docker-compose.yml up -d
````

#### stop
````bash
docker-compose -f aerztekasse-api-prod-docker-compose.yml down
````
