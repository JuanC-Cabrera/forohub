# Forohub

Forohub es una API rest de foro desarrollada en Java con Spring Boot, que permite a los usuarios crear, leer, actualizar y eliminar tópicos de discusión. Desarrolle esta API como parte de un challenge de Alura Latam por el programa de Oracle Next Education

## Funcionalidades

- Autenticación de usuarios utilizando JWT (JSON Web Token).
- Creación de nuevos usuarios.
- Creación, lectura, actualización y eliminación de tópicos.
- Listado de tópicos paginados y ordenados por fecha de creación.
- Validación de integridad para evitar la creación de tópicos duplicados y usuarios con datos duplicados.

## Tecnologías Utilizadas

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL
- JWT (JSON Web Token)
- Lombok

## Estructura del Proyecto

El proyecto está estructurado de la siguiente manera:

- `com.aluracursos.forohub.controller`: Controladores REST para manejar las solicitudes HTTP.
- `com.aluracursos.forohub.domain.topico`: Entidades y servicios relacionados con los tópicos.
- `com.aluracursos.forohub.domain.usuario`: Entidades y servicios relacionados con los usuarios.
- `com.aluracursos.forohub.infra.security`: Configuración de seguridad, incluyendo la autenticación JWT.
- `com.aluracursos.forohub.infra.errores`: Manejo de errores personalizados.
- `com.aluracursos.forohub`: Clases de configuración general y la aplicación Spring Boot.

## Configuración

1. **Base de Datos**: Configura tu base de datos MySQL y asegúrate de que esté accesible en `application.properties`.
2. **Configuración de Seguridad**: Asegúrate de que la configuración de seguridad JWT esté correctamente establecida en `application.properties`.
3. **Ejecución**: Ejecuta la aplicación desde tu IDE favorito.

## Uso

1. **Creación de Usuarios**: Registra nuevos usuarios utilizando el endpoint `/registrar`.
2. **Autenticación**: Inicia sesión utilizando el endpoint `/login` para obtener un token JWT válido.
3. **Operaciones con Tópicos**: Utiliza los endpoints `/topicos` para crear, listar, actualizar y eliminar tópicos, no olvides usar el token JWT para validar tu acceso


