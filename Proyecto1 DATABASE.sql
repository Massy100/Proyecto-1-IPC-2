CREATE DATABASE Proyecto1;
USE  Proyecto1;
CREATE TABLE Ensamblador(
	id_ensamblador INT NOT NULL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL
);
CREATE TABLE Tipo_pieza(
	id_tipo_pieza INT NOT NULL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);
CREATE TABLE Mueble_ensamblado(
	id_mueble INT NOT NULL PRIMARY KEY,
    precio_final DOUBLE NOT NULL,
    cantidad INT NOT NULL,
    fecha_ensamblado DATE NOT NULL
);
CREATE TABLE Pieza(
	id_pieza INT NOT NULL PRIMARY KEY,
    precio DOUBLE NOT NULL,
    fecha_ingreso DATE NOT NULL,
    cantidad_ingreso INT NOT NULL,
    id_mueble INT NOT NULL,
    FOREIGN KEY(id_mueble) REFERENCES Mueble_ensamblado(id_mueble)
);
CREATE TABLE Tipo_mueble(
	id_tipo_mueble INT NOT NULL PRIMARY KEY,
    nombre VARCHAR(45) NOT NULL
);
CREATE TABLE Compra_venta(
	id_compra_venta INT NOT NULL PRIMARY KEY,
    precio DOUBLE NOT NULL,
    id_mueble INT NOT NULL,
	FOREIGN KEY(id_mueble) REFERENCES Mueble_ensamblado(id_mueble)
);
CREATE TABLE Factura(
	id_factura INT NOT NULL PRIMARY KEY,
    cantidad DOUBLE NOT NULL,
    fecha_transaccion DATE NOT NULL,
    id_compra_venta INT NOT NULL,
	FOREIGN KEY(id_compra_venta) REFERENCES Compra_venta(id_compra_venta)
);
CREATE TABLE Cliente(
	id_cliente INT NOT NULL PRIMARY KEY,
    direccion VARCHAR(100) NOT NULL,
    nit VARCHAR(45) NOT NULL,
    nombre VARCHAR(45),
    apellido VARCHAR(45),
    id_compra_venta INT NOT NULL,
    FOREIGN KEY(id_compra_venta) REFERENCES Compra_venta(id_compra_venta)
);
CREATE TABLE Vendedor(
	id_vendedor INT NOT NULL PRIMARY KEY,
    nombre VARCHAR(45) NOT NULL,
    apellido VARCHAR(45) NOT NULL,
    id_compra_venta INT NOT NULL,
    FOREIGN KEY(id_compra_venta) REFERENCES Compra_venta(id_compra_venta)
);
CREATE TABLE Mueble_devuelto(
	id_mueble_devuelto INT NOT NULL PRIMARY KEY,
    motivo VARCHAR(100) NOT NULL,
    id_compra_venta INT NOT NULL,
    FOREIGN KEY(id_compra_venta) REFERENCES Compra_venta(id_compra_venta)
);
CREATE TABLE Financiero(
	id_financiero INT NOT NULL PRIMARY KEY,
    nombre VARCHAR(45) NOT NULL,
    apellido VARCHAR(45) NOT NULL
);
INSERT INTO Ensamblador(id_ensamblador, nombre, apellido) VALUES
('289','Luis','Morales'),
('392','Valerio','Rojas'),
('296', 'Sam','Gomez');
INSERT INTO Tipo_pieza(id_tipo_pieza, nombre) VALUES
('001','Pata de madera'),
('002','Plancha de madera'),
('056', 'Pata de cedro'),
('117','Planca de cedro');
INSERT INTO Mueble_ensamblado(id_mueble, precio_final, cantidad, fecha_ensamblado) VALUES
('045', 100.00, 1, '2021/02/02'),
('554', 200.00, 1, '2021/08/11');
INSERT INTO Pieza(id_pieza, precio, fecha_ingreso, cantidad_ingreso, id_mueble) VALUES
('045', 100.00,'2021/02/02', 1 ,'045'),
('554', 200.00, '2021/08/11',1 ,'554');