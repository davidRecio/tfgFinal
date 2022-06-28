@ECHO OFF
ECHO Compilacion y lanzamiento de la aplicacion docker

docker build -t tfgsbt -f Dockerfile .  

docker network create --subnet=172.18.0.0/16 mynettfg

docker run --name mysql8 --net mynettfg --ip 172.18.0.22 -e MYSQL_ROOT_PASSWORD=1234  -d mysql:8.0.29-debian

TIMEOUT 30

docker run --name tfgapi -p 9000:9000 --net mynettfg -d tfgsbt:latest