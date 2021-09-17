#!/bin/bash

echo "version = $1"

JAR_VERSION=`echo $1 | cut -d'v' -f2`
echo "jar = $JAR_VERSION"

chmod +x gradlew
./gradlew -Pversion=$JAR_VERSION build
mkdir release && cp build/libs/*.jar release

printenv