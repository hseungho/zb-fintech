docker network create redis-network

docker run -d \
--name fintech-redis \
--network redis-network \
-p 6369:6379 \
redis:latest