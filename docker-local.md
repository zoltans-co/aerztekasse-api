# Aerztekasse docker-local documentation

### MySQL only

#### start
````bash
docker-compose -f aerztekasse-api-local-mysql-only-docker-compose.yml up -d
````

#### stop
````bash
docker-compose -f aerztekasse-api-local-mysql-only-docker-compose.yml down
````

### API

#### start
````bash
docker-compose -f aerztekasse-api-local-docker-compose.yml up -d
````

#### stop
````bash
docker-compose -f aerztekasse-api-local-docker-compose.yml down
````
