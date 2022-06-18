#!/usr/bin/env bash
set -e
docker login -u isbobrenok -p $DOCKER_PASSWORD
docker build -t isbobrenok/marathon-demo:$BUILD_NUMBER .
docker push isbobrenok/marathon-demo:$BUILD_NUMBER