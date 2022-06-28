# tfgFinal

## Requisitos

Primero se debe instalar en el ordenador el programa Docker Desktop, durante el proceso de instalación se necesita activar el WSL 2 para que se instale también, ya que es necesario para la ejecución del mismo.
Una vez instalado, te pedirá reiniciar el ordenador, si este no posee el WSL 2 configurado.

## Ficheros de arranque y apagado de los dockers

En el proyecto se ha desarrollado dos ficheros para realizar el apagado e inicio de los dockers, estos son "run" y "stop"

### RUN

Este fichero es el encargado de compilar las imágenes, crea una subnet para que puedan comunicarse la base de datos y la api, levantar el servidor sbt y levantar la base de datos.
Se tiene que esperar 30 segundos, dado que el contenedor de mysql necesita ese tiempo para levantarse correctamente y por último se levanta la API.

### STOP
Es el encargado de apagar los elementos levantados borrando los nombres de las imágenes para que se puedan levantar de nuevo ejecutar de nuevo el fichero "run"

## Pasos para realizar pruebas

Primero se debe comprobar que se han levantado correctamente la base de datos y la API, esto se puede comprobar si en el navegador aparece la siguiente frase "API iniciada", seguido esto se debe crear un usuario siempre para después de ello puedas acceder a todas las funcionalidades de la aplicación. Para realizar las llamadas se puede hacer uso del programa Postman y de los ficheros de ejemplos alojados en la carpeta JSON.
En caso de un ejemplo detallado, se puede observar el capítulo 7 de la memoria.

