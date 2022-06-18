set -e
docker login -u mogronalol -p $DOCKER_PASSWORD
docker build -t isbobrenok/mongo-demo:$BUILD_NUMBER .
docker push isbobrenok/mongo-demo:$BUILD_NUMBER