-- Script de creación de las tablas de la base de datos

-- Tabla OCUPACION
CREATE TABLE ocupacion (
	fila INTEGER CHECK (fila >= 0 AND fila <=10), -- Restricción semántica
	asiento INTEGER, 
	ocupado BOOLEAN DEFAULT FALSE, 
	id_cliente INTEGER, 
	CONSTRAINT pk_ocupacion PRIMARY KEY(fila, asiento), -- Restricción de integridad
	CHECK (asiento >= 0 AND asiento <= 15)
);

CREATE TABLE cliente (
	id INTEGER AUTO_INCREMENT, 
	nombre VARCHAR(100) NOT NULL,
	fecha_nac DATE NOT NULL
);

ALTER TABLE cliente
ADD CONSTRAINT pk_cliente PRIMARY KEY (id);

ALTER TABLE cliente
ADD COLUMN password VARCHAR(20) NOT NULL;

ALTER TABLE cliente
ADD CONSTRAINT uk_cliente UNIQUE (nombre, password);

ALTER TABLE ocupacion
ADD CONSTRAINT fk_ocupacion_cliente FOREIGN KEY (id_cliente) REFERENCES cliente(id);


-- Tuplas de la tabla
INSERT INTO ocupacion (fila, asiento, ocupado)
	VALUES (1, 1, FALSE), 
	(1, 2, FALSE), 
	(1, 3, FALSE), 
	(1, 4, FALSE), 
	(1, 5, FALSE), 
	(1, 6, FALSE), 
	(1, 7, FALSE), 
	(1, 8, FALSE), 
	(1, 9, FALSE), 
	(1, 10, FALSE), 
	(1, 11, FALSE), 
	(1, 12, FALSE),
	(1, 13, FALSE), 
	(1, 14, FALSE), 
	(1, 15, FALSE),
	
	(2, 1, FALSE), 
	(2, 2, FALSE), 
	(2, 3, FALSE), 
	(2, 4, FALSE), 
	(2, 5, FALSE), 
	(2, 6, FALSE), 
	(2, 7, FALSE), 
	(2, 8, FALSE), 
	(2, 9, FALSE), 
	(2, 10, FALSE), 
	(2, 11, FALSE), 
	(2, 12, FALSE),
	(2, 13, FALSE), 
	(2, 14, FALSE), 
	(2, 15, FALSE),

	(3, 1, FALSE), 
	(3, 2, FALSE), 
	(3, 3, FALSE), 
	(3, 4, FALSE), 
	(3, 5, FALSE), 
	(3, 6, FALSE), 
	(3, 7, FALSE), 
	(3, 8, FALSE), 
	(3, 9, FALSE), 
	(3, 10, FALSE), 
	(3, 11, FALSE), 
	(3, 12, FALSE),
	(3, 13, FALSE), 
	(3, 14, FALSE), 
	(3, 15, FALSE),
	
	(4, 1, FALSE), 
	(4, 2, FALSE), 
	(4, 3, FALSE), 
	(4, 4, FALSE), 
	(4, 5, FALSE), 
	(4, 6, FALSE), 
	(4, 7, FALSE), 
	(4, 8, FALSE), 
	(4, 9, FALSE), 
	(4, 10, FALSE), 
	(4, 11, FALSE), 
	(4, 12, FALSE),
	(4, 13, FALSE), 
	(4, 14, FALSE), 
	(4, 15, FALSE),
	
	(5, 1, FALSE), 
	(5, 2, FALSE), 
	(5, 3, FALSE), 
	(5, 4, FALSE), 
	(5, 5, FALSE), 
	(5, 6, FALSE), 
	(5, 7, FALSE), 
	(5, 8, FALSE), 
	(5, 9, FALSE), 
	(5, 10, FALSE), 
	(5, 11, FALSE), 
	(5, 12, FALSE),
	(5, 13, FALSE), 
	(5, 14, FALSE), 
	(5, 15, FALSE),

	(6, 1, FALSE), 
	(6, 2, FALSE), 
	(6, 3, FALSE), 
	(6, 4, FALSE), 
	(6, 5, FALSE), 
	(6, 6, FALSE), 
	(6, 7, FALSE), 
	(6, 8, FALSE), 
	(6, 9, FALSE), 
	(6, 10, FALSE), 
	(6, 11, FALSE), 
	(6, 12, FALSE),
	(6, 13, FALSE), 
	(6, 14, FALSE), 
	(6, 15, FALSE),
	
	(7, 1, FALSE), 
	(7, 2, FALSE), 
	(7, 3, FALSE), 
	(7, 4, FALSE), 
	(7, 5, FALSE), 
	(7, 6, FALSE), 
	(7, 7, FALSE), 
	(7, 8, FALSE), 
	(7, 9, FALSE), 
	(7, 10, FALSE), 
	(7, 11, FALSE), 
	(7, 12, FALSE),
	(7, 13, FALSE), 
	(7, 14, FALSE), 
	(7, 15, FALSE),
	
	(8, 1, FALSE), 
	(8, 2, FALSE), 
	(8, 3, FALSE), 
	(8, 4, FALSE), 
	(8, 5, FALSE), 
	(8, 6, FALSE), 
	(8, 7, FALSE), 
	(8, 8, FALSE), 
	(8, 9, FALSE), 
	(8, 10, FALSE), 
	(8, 11, FALSE), 
	(8, 12, FALSE),
	(8, 13, FALSE), 
	(8, 14, FALSE), 
	(8, 15, FALSE),
		
	(9, 1, FALSE), 
	(9, 2, FALSE), 
	(9, 3, FALSE), 
	(9, 4, FALSE), 
	(9, 5, FALSE), 
	(9, 6, FALSE), 
	(9, 7, FALSE), 
	(9, 8, FALSE), 
	(9, 9, FALSE), 
	(9, 10, FALSE), 
	(9, 11, FALSE), 
	(9, 12, FALSE),
	(9, 13, FALSE), 
	(9, 14, FALSE), 
	(9, 15, FALSE),
		
	(10, 1, FALSE), 
	(10, 2, FALSE), 
	(10, 3, FALSE), 
	(10, 4, FALSE), 
	(10, 5, FALSE), 
	(10, 6, FALSE), 
	(10, 7, FALSE), 
	(10, 8, FALSE), 
	(10, 9, FALSE), 
	(10, 10, FALSE), 
	(10, 11, FALSE), 
	(10, 12, FALSE),
	(10, 13, FALSE), 
	(10, 14, FALSE), 
	(10, 15, FALSE);
	
	
INSERT INTO cliente (nombre, fecha_nac, password)
	VALUES ('John', '2002-01-30', 'doe');


	