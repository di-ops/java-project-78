setup:
	gradle wrapper --gradle-version 7.5

clean:
	./gradlew clean

build:
	./gradlew clean build

lint:
	./gradlew checkstyleMain checkstyleTest

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

install:
	./gradlew install

check-updates:
	./gradlew dependencyUpdates

.PHONY: build
