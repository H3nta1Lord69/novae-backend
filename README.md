
# Novae Technical Test

Se presenta a continuación la información, la configuración y detalles importantes de la aplicación realizada.

## Comenzando 🚀
Como nota principal se debe aclarar que el proyecto está basado en las siguientes tecnologías:

* [PostgreSQL](http://www.dropwizard.io/1.0.2/docs/) - Base de datos SQL
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [Spring Boot](https://spring.io/projects/spring-boot/) - Framework Java
* [Java](https://www.java.com/es/) - Lenguaje backend
* [Angular](https://angular.io/) - Framework para interfaz gráfica
* [Ionic](https://ionicframework.com/) - Framework para compatibilidad en iOS y Android

## Pre-requisitos 📋

Se necesitan cierta ambientación para nuestra máquina para poder ejecutar sin problemas las 
aplicaciones con tecnologías como las mencionadas anteriormente. Entre los paquetes que necesitamos encontramos:
* [Node](https://nodejs.org/es/) - Entorno de ejecución para JavaScript
* [NPM](https://www.npmjs.com/) - Gestor de paquetes
```bash
npm install -g npm
```
* [Angular](https://angular.io/cli/) - Framework para interfaz gráfica
```bash
npm install -g @angular/cli
```
* [Ionic](https://ionicframework.com/docs/intro/cli/) - Framework para compatibilidad en iOS y Android
```bash
npm install -g @ionic/cli
```
* [Java](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html) - Lenguaje backend
* [Maven](https://maven.apache.org/download.cgi) - Manejador de dependencias
* [PostgreSQL](https://www.postgresql.org/download/) - Base de datos SQL

## Instalación 🔧

En orden de ejecutar el proyecto se deben tener ciertas pautas para poder tener un correcto y satisfactorio despliegue.  
Para la **base de datos** las condiciones son las siguientes:

```bash
  port:5432
  password:69420
  url:jdbc:postgresql://localhost:5432/novae
```
Para el **backend** las condiciones son las siguiente:
```bash
  port:8888 (Tomcat web server)
  url:http://localhost:8888/api/
```
Para el **frontend** las condiciones son las siguiente:
```bash
  port:8100
  url:http://localhost:8100/
  npm install
```

## Ejecutando el proyecto ⚙️
* Se debe tener configurada la conexión a la base de datos en PostgreSQL.  
* Una vez lista la configuración se debe ejecutar el archivo main del proyecto Java. 
  Este archivo main es el que se encargará de ejecutar todos los servicios, métodos, 
  controladores, objetos y demás clases que tengamos dentro de nuestro proyecto.  
* Con el backend funcionando solo resta ejecutar el frontend. Se hace de la siguiente manera:
```bash
  ionic serve
```
De esta manera el despliegue queda completado y ya se puede interactuar con la aplicación.

## Autores ✒️
* **Carlos Garcia Saenz** - *Trabajo Inicial* - [H3nta1Lord69](https://github.com/H3nta1Lord69)

⌨️ con ❤️ por [H3nta1Lord69](https://github.com/H3nta1Lord69)