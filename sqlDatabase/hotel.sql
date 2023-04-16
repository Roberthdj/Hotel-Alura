CREATE DATABASE Hotel_Alura;
USE Hotel_Alura;

CREATE TABLE reservas (
id INT UNSIGNED AUTO_INCREMENT, 
fechaEntrada DATE NOT NULL,
fechaSalida DATE NOT NULL,
valor double NOT NULL,
tipoHabitacion VARCHAR(30) NOT NULL,
formaPago VARCHAR(35) NOT NULL,
PRIMARY KEY (id)
)ENGINE=InnoDB;

CREATE TABLE huespedes (
id INT UNSIGNED AUTO_INCREMENT, 
id_reserva INT UNSIGNED NOT NULL,
nombre VARCHAR(50) NOT NULL,
apellido VARCHAR(50) NOT NULL,
fechaNacimiento DATE NOT NULL,
nacionalidad VARCHAR(50) NOT NULL,
telefono VARCHAR(35) NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (id_reserva) REFERENCES reservas(id) 
)ENGINE=InnoDB;

CREATE TABLE usuarios (
id INT UNSIGNED AUTO_INCREMENT, 
usuario VARCHAR(25) NOT NULL,
contrasena VARCHAR(25) NOT NULL,
PRIMARY KEY (id)
)ENGINE=InnoDB;

INSERT INTO usuarios(usuario, contrasena) VALUES ('admin', 'admin');
INSERT INTO usuarios(usuario, contrasena) VALUES ('usuario1', '123456');


