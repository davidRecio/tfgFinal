@ECHO OFF
ECHO Parada aplicacion docker

docker stop tfgapi
docker stop mysql8

docker rm tfgapi
docker rm mysql8