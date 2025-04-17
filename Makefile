.PHONY: dev run build api all test clean mongo infra help pre report

help:
	@echo "Kotlin Hexagonal"
	@echo "https://github.com/leandrogoncalves/kotlin_spring_hexagonal
	@echo "-------------------------------------------------------"
	@echo "Usage:"
	@echo "make up      # runs all containers                 "
	@echo "make down    # stop all containers                 "
	@echo "make test    # runs unit tests                     "

build:
	mvn clean package -DskipTests

compile-image:
	docker build -f ./docker-local/Dockerfile-m1 --tag kotlin-hexagonal.
	@echo "Image built successfully"

up-build: build compile-image
	docker compose -f ./docker-local/docker-compose.yaml up --build -d

up:
	docker compose up -d

down:
	docker compose down

test:
	mvn test

