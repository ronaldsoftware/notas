# notas

> Registro y consulta de notas

El proyecto usa Java 17, Maven y Springboot 3.0.0

---
## Estructura de carpetas del proyecto

* **Codigo Java** : consta del `pom.xml` y la carpeta `src`
* **Documentacion del api** : la documentación de puede revisar desde la ruta de swagger.ui
* **Docker** : consta de los archivos `Dockerfile`
---

## Modelo base de datos

| usuario       |
|---------------|
| id (PK)       |
| username      |
| password      |
| roles         |

| notas          |
|----------------|
| id (PK)        |
| idUsuario      |
| idCurso        |
| nota1          |
| nota2          |
| nota3          |
| nota4          |
| promedio       |


--- 
