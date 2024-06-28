-- Drop existing tables
DROP TABLE topicos;
DROP TABLE usuarios;

-- Create usuarios table
CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- Create topicos table
CREATE TABLE topicos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) UNIQUE,
    mensaje VARCHAR(280) UNIQUE,
    fecha_creacion TIMESTAMP,
    status VARCHAR(50),
    usuario_id BIGINT,
    curso VARCHAR(255),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);
