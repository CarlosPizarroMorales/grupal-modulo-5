-- CREATE DATABASE m5_ejercicio_extra;
-- CREATE USER 'admin_modulo5'@'localhost' IDENTIFIED BY 'abcd1234';
-- GRANT INSERT, SELECT, UPDATE, DELETE ON m5_ejercicio_extra.* TO 'admin_modulo5'@'localhost'; 

CREATE TABLE usuario (
	-- comunes
	id INT PRIMARY KEY AUTO_INCREMENT,
    rut VARCHAR(12) NOT NULL,
    nombres VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    fechaNacimiento DATE NOT NULL,
    tipoUsuario VARCHAR(20) NOT NULL,
    -- cliente
    telefono VARCHAR(12),
    direccion VARCHAR(50),
    comuna VARCHAR(50),
    afp VARCHAR(20),
    sistemaSalud VARCHAR(10),
    edad INT,
    -- administrativo
    area VARCHAR(30),
    expPrevia VARCHAR(100),
    -- profesional
    titulo VARCHAR(30),
    fechaIngreso DATE
 );   
 
 CREATE TABLE capacitaciones (
  idCapacitacion INT PRIMARY KEY AUTO_INCREMENT,
  rutCliente VARCHAR(30) NOT NULL,
  dia VARCHAR(20) NOT NULL,
  fecha DATE NOT NULL,
  hora TIME NOT NULL,
  lugar VARCHAR(100) NOT NULL,
  duracion FLOAT NOT NULL,
  asistentes INT NOT NULL
);

-- Inserciones para la tabla usuarios. 
INSERT INTO usuario (rut, nombres, apellidos, fechaNacimiento, tipoUsuario, telefono, direccion, comuna, afp, sistemaSalud, edad, area, expPrevia, titulo, fechaIngreso)
VALUES
    -- Registros para tipo de usuario 'cliente'
    ('12345678-9', 'Juan', 'Perez', '1990-01-01', 'cliente', '123456789', 'Calle 123', 'Santiago', 'AFP Provida', 'FONASA', 30, NULL, NULL, NULL, NULL),
    ('98765432-1', 'María', 'López', '1985-05-10', 'cliente', '987654321', 'Avenida 456', 'Valparaíso', 'AFP Cuprum', 'Isapre', 36, NULL, NULL, NULL, NULL),
    ('11111111-1', 'Pedro', 'González', '1995-09-15', 'cliente', '111111111', 'Calle Principal', 'Concepción', 'AFP Habitat', 'FONASA', 26, NULL, NULL, NULL, NULL),
    ('99999999-9', 'Ana', 'Martínez', '1988-12-20', 'cliente', '999999999', 'Avenida Central', 'La Serena', 'AFP Modelo', 'FONASA', 33, NULL, NULL, NULL, NULL),
    ('77777777-7', 'Carlos', 'Rojas', '1975-03-25', 'cliente', '777777777', 'Calle 789', 'Antofagasta', 'AFP ProVida', 'FONASA', 48, NULL, NULL, NULL, NULL),
    ('55555555-5', 'Laura', 'García', '1992-07-05', 'cliente', '555555555', 'Calle 246', 'Viña del Mar', 'AFP Capital', 'Isapre', 31, NULL, NULL, NULL, NULL),
    ('44444444-4', 'Andrés', 'Silva', '1982-11-12', 'cliente', '444444444', 'Avenida 789', 'La Serena', 'AFP Cuprum', 'FONASA', 41, NULL, NULL, NULL, NULL),
    ('66666666-6', 'Isabel', 'Torres', '1998-02-28', 'cliente', '666666666', 'Calle 135', 'Santiago', 'AFP ProVida', 'Isapre', 25, NULL, NULL, NULL, NULL),
    ('22222222-2', 'Fernando', 'Mendoza', '1991-04-18', 'cliente', '222222222', 'Calle 678', 'Concepción', 'AFP Habitat', 'FONASA', 30, NULL, NULL, NULL, NULL),
    ('88888888-8', 'Silvia', 'Hernández', '1980-08-07', 'cliente', '888888888', 'Avenida 345', 'Antofagasta', 'AFP Modelo', 'FONASA', 43, NULL, NULL, NULL, NULL),
    -- Registros para tipo de usuario 'profesional'
    ('11223344-5', 'Luis', 'Ramírez', '1978-06-15', 'profesional', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Ingeniero', '2020-01-01'),
    ('55667788-9', 'Marcela', 'Guzmán', '1986-03-12', 'profesional', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Doctor', '2018-07-15'),
    ('99001122-3', 'Carolina', 'Muñoz', '1993-09-20', 'profesional', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Arquitecto', '2019-04-30'),
    ('33445566-7', 'Andrés', 'Herrera', '1982-12-08', 'profesional', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Abogado', '2017-10-20'),
    ('77889900-1', 'Mónica', 'Vargas', '1990-02-28', 'profesional', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Psicólogo', '2022-03-01'),
    -- Registros para tipo de usuario 'administrativo'
    ('54321098-7', 'Roberto', 'Gómez', '1984-09-05', 'administrativo', NULL, NULL, NULL, NULL, NULL, NULL, 'Recursos Humanos', '2 años de experiencia en RRHH', NULL, NULL),
    ('87654321-6', 'María', 'Fernández', '1977-11-22', 'administrativo', NULL, NULL, NULL, NULL, NULL, NULL, 'Finanzas', '5 años de experiencia en contabilidad', NULL, NULL),
    ('24681357-9', 'Pedro', 'Martínez', '1992-08-14', 'administrativo', NULL, NULL, NULL, NULL, NULL, NULL, 'Logística', '3 años de experiencia en logística', NULL, NULL),
    ('98765432-1', 'Carolina', 'González', '1988-04-30', 'administrativo', NULL, NULL, NULL, NULL, NULL, NULL, 'Ventas', '4 años de experiencia en ventas', NULL, NULL),
    ('13579135-9', 'Diego', 'López', '1995-01-18', 'administrativo', NULL, NULL, NULL, NULL, NULL, NULL, 'Marketing', '2 años de experiencia en marketing', NULL, NULL);

-- Inserciones en la tabla capacitaciones    
INSERT INTO capacitaciones (rutCliente, dia, fecha, hora, lugar, duracion, asistentes) 
VALUES
	('123456789', 'Lunes', '2023-06-01', '09:00:00', 'Sala A', 2.5, 10),
	('987654321', 'Martes', '2023-06-02', '14:30:00', 'Sala B', 1.5, 15),
	('456789123', 'Miércoles', '2023-06-03', '10:45:00', 'Sala C', 3.0, 8),
	('321654987', 'Jueves', '2023-06-04', '11:15:00', 'Sala D', 2.0, 12),
	('789123456', 'Viernes', '2023-06-05', '16:00:00', 'Sala E', 2.5, 20),
	('654987321', 'Sábado', '2023-06-06', '09:30:00', 'Sala F', 1.0, 7),
	('147258369', 'Domingo', '2023-06-07', '12:00:00', 'Sala G', 2.0, 18),
	('963852741', 'Lunes', '2023-06-08', '15:45:00', 'Sala H', 2.5, 11),
	('258369147', 'Martes', '2023-06-09', '11:30:00', 'Sala I', 3.0, 9),
	('852741963', 'Miércoles', '2023-06-10', '10:00:00', 'Sala J', 1.5, 14),
	('741852963', 'Jueves', '2023-06-11', '13:15:00', 'Sala K', 2.0, 16),
	('369147258', 'Viernes', '2023-06-12', '14:45:00', 'Sala L', 1.0, 13),
	('654123987', 'Sábado', '2023-06-13', '16:30:00', 'Sala M', 2.5, 19),
	('987321654', 'Domingo', '2023-06-14', '09:15:00', 'Sala N', 3.0, 6),
	('852963741', 'Lunes', '2023-06-15', '12:30:00', 'Sala O', 2.0, 17),
	('321987654', 'Martes', '2023-06-16', '13:45:00', 'Sala P', 2.5, 10),
	('963741852', 'Miércoles', '2023-06-17', '15:00:00', 'Sala Q', 1.5, 12),
	('369852147', 'Jueves', '2023-06-18', '10:30:00', 'Sala R', 2.0, 15),
	('741963852', 'Viernes', '2023-06-19', '11:45:00', 'Sala S', 1.0, 8),
	('258741369', 'Sábado', '2023-06-20', '14:15:00', 'Sala T', 2.5, 11);