#!/bin/sh

# Setting version
VERSION="1.0.0"

./gradlew clean build -x test

echo 'api Docker image build...'
docker build -t fintech-api:$VERSION -f api/Dockerfile .
echo 'api Docker image build... Done'

echo 'consumer Docker image build...'
docker build -t fintech-consumer:$VERSION -f consumer/Dockerfile .
echo 'consumer Docker image build... Done'

echo 'css Docker image build...'
docker build -t fintech-css:$VERSION -f css/Dockerfile .
echo 'css Docker image build... Done'

echo 'nginx Docker image build...'
docker build -t fintech-nginx:$VERSION -f nginx/Dockerfile .
echo 'nginx Docker image build... Done'
