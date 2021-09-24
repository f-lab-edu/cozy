#!/bin/bash

echo "version = $1"

# Get version number from version tag
JAR_VERSION=`echo $1 | cut -d'v' -f2`
echo "jar = $JAR_VERSION"

chmod +x gradlew
./gradlew -Pversion=$JAR_VERSION build \
          -DEV_MYSQL_URL=$DEV_MYSQL_URL \
          -DEV_MYSQL_PORT=$DEV_MYSQL_PORT \
          -MYSQL_DATABASE_NAME=$MYSQL_DATABASE_NAME \
          -DEV_MYSQL_USERNAME=$DEV_MYSQL_USERNAME \
          -DEV_MYSQL_PASSWORD=$DEV_MYSQL_PASSWORD \
          -H2_USERNAME=$H2_USERNAME \
          -H2_PASSWORD=$H2_PASSWORD

mkdir release && cp build/libs/*.jar release

printenv