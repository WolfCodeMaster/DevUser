# Proyecto DevUser

Este repositorio contiene el código fuente y los archivos necesarios para construir y ejecutar el proyecto Trabajo GlobalLogic.

#### Requisitos Previos

Asegúrate de tener instalado lo siguiente:

- Java JDK 11 o superior
- Gradle (puedes usar el wrapper proporcionado)

#### Construcción del Proyecto

Para construir el proyecto, ejecuta el siguiente comando desde la raíz del proyecto:

```bash
./gradlew build

```
#### Desactivar las pruebas en la tarea test:

```bash
./gradlew assemble   

./gradlew dependencies

./gradlew build --exclude-task test

```

#### Ejecución del Proyecto

```bash
./gradlew bootRun
```

#### Perfil de Configuración

```bash
spring.profiles.active=dev
```
# dev
