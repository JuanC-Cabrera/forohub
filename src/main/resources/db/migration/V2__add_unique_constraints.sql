-- Eliminar todos los registros de la tabla 'topicos'
DELETE FROM topicos;

-- Reiniciar el contador de IDs (AUTO_INCREMENT)
ALTER TABLE topicos AUTO_INCREMENT = 1;

-- Cambiar el tipo de datos de 'mensaje' a VARCHAR con longitud máxima 280
ALTER TABLE topicos MODIFY COLUMN mensaje VARCHAR(280);

-- Agregar una restricción única en 'titulo'
ALTER TABLE topicos ADD CONSTRAINT UK_titulo UNIQUE (titulo);

-- Agregar una restricción única en 'mensaje'
ALTER TABLE topicos ADD CONSTRAINT UK_mensaje UNIQUE (mensaje);