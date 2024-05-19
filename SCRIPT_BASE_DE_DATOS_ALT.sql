
DROP TABLE PRODUCTOS;
CREATE TABLE PRODUCTOS (
                    EAN INTEGER AUTO_INCREMENT PRIMARY KEY,
                    NOMBRE VARCHAR(50),
                    MARCA VARCHAR(25),
                    PRECIO DECIMAL(5,2),
                    ALTURA DECIMAL(5,2),  
                    ANCHURA DECIMAL(5,2),
                    PESO DECIMAL(5,2),
                    NUM_ELEMENTOS INTEGER,
                    DESCRIPCION VARCHAR(100),
                    CATEGORIA VARCHAR(25),
                    CHECK (CATEGORIA IN ('Alimentacion', 'Drogueria', 'Cosmetica')));
DROP TABLE EMPLEADOS;
CREATE TABLE EMPLEADOS (
                    ID_EMPLEADO INTEGER AUTO_INCREMENT PRIMARY KEY,
                    NOMBRE VARCHAR(25) ,
                    APELLIDOS VARCHAR(25),
                    SALARIO INTEGER,
                    CATEGORIA VARCHAR(25),
                    CHECK (CATEGORIA IN ('Reponedor', 'Cajero', 'Empleado', 'Encargado')));

DROP TABLE CLIENTE;
CREATE TABLE CLIENTES (
                    ID_CLIENTE INTEGER AUTO_INCREMENT PRIMARY KEY,
                    NOMBRE VARCHAR(25) ,
                    APELLIDOS VARCHAR(25),
                    COD_POSTAL INTEGER);

DROP TABLE SEDE;
CREATE TABLE SEDE (
                    UBICACION VARCHAR(25) PRIMARY KEY);

DROP TABLE COMPRA;
CREATE TABLE COMPRAS (
                    ID_COMPRA INTEGER AUTO_INCREMENT,
                    FECHA_COMPRA VARCHAR(25),
                    ID_CLIENTE INTEGER ,
                    PRIMARY KEY (ID_COMPRA),
                    FOREIGN KEY (ID_CLIENTE) REFERENCES CLIENTES(ID_CLIENTE));


DROP TABLE COMPRA_PRODUCTO;
CREATE TABLE COMPRA_PRODUCTO (
                    EAN INTEGER,
                    ID_COMPRA INTEGER,
                    CANTIDAD INTEGER,
                    PRIMARY KEY (EAN, ID_COMPRA),
                    FOREIGN KEY (EAN) REFERENCES PRODUCTOS(EAN),
                    FOREIGN KEY (ID_COMPRA) REFERENCES COMPRAS(ID_COMPRA));
                    
DROP TABLE PRODUCTO_SEDE;
CREATE TABLE PRODUCTO_SEDE (
                    EAN INTEGER,
                    UBICACION VARCHAR(25),
                    STOCK INTEGER,
                    PRIMARY KEY (EAN, UBICACION),
                    FOREIGN KEY (EAN) REFERENCES PRODUCTOS(EAN),
                    FOREIGN KEY (UBICACION) REFERENCES SEDE(UBICACION));

-- CREACION DE LAS VISTAS

--! COMPRAS POR CÓDIGO POSTAL
CREATE OR REPLACE VIEW COMPRAS_POR_CODIGO_POSTAL AS
SELECT COD_POSTAL, COUNT(ID_COMPRA) AS NUM_COMPRAS
FROM CLIENTE
JOIN COMPRA ON CLIENTE.ID_CLIENTE = COMPRA.ID_CLIENTE
GROUP BY COD_POSTAL;

--! STOCK DE PRODUCTOS
CREATE OR REPLACE VIEW STOCK_PRODUCTOS AS
SELECT P.NOMBRE, PS.STOCK
FROM PRODUCTOS P
JOIN PRODUCTO_SEDE PS ON P.EAN = PS.EAN;

CREATE OR REPLACE VIEW VISTA_PRODUCTOS AS
SELECT EAN, NOMBRE, MARCA, PRECIO, ALTURA, ANCHURA, PESO, NUM_ELEMENTOS, DESCRIPCION, CATEGORIA
FROM PRODUCTOS;

CREATE OR REPLACE VIEW VISTA_EMPLEADOS AS
SELECT ID_EMPLEADO, NOMBRE, APELLIDOS, SALARIO, CATEGORIA
FROM EMPLEADOS;

CREATE OR REPLACE VIEW VISTA_CLIENTES AS
SELECT ID_CLIENTE, NOMBRE, APELLIDOS, COD_POSTAL
FROM CLIENTE;

CREATE OR REPLACE VIEW VISTA_COMPRA_PRODUCTOS AS
SELECT EAN, ID_COMPRA, CANTIDAD
FROM COMPRA_PRODUCTO;

CREATE OR REPLACE VIEW VISTA_SEDE AS
SELECT UBICACION
FROM SEDE;

CREATE OR REPLACE VIEW VISTA_COMPRA AS
SELECT ID_COMPRA, FECHA_COMPRA, ID_CLIENTE
FROM COMPRA;

CREATE OR REPLACE VIEW VISTA_PRODUCTO_SEDE AS
SELECT EAN, UBICACION, STOCK
FROM PRODUCTO_SEDE;


-- INSERT A LAS TABLAS.
INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO, CATEGORIA) 
VALUES ('Juan', 'Gómez', 2000.00, 'Reponedor');

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO, CATEGORIA) 
VALUES ('María', 'López', 2200.00, 'Reponedor');

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO, CATEGORIA) 
VALUES ('Pedro', 'Martínez', 2500.00, 'Empleado');

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO, CATEGORIA) 
VALUES ('Ana', 'Sánchez', 1900.00, 'Encargado');

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO, CATEGORIA) 
VALUES ('Miguel', 'González', 2300.00, 'Reponedor');

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO, CATEGORIA) 
VALUES ('Laura', 'Rodríguez', 2100.00, 'Cajero');

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO, CATEGORIA) 
VALUES ('David', 'Fernández', 2400.00, 'Empleado');

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO, CATEGORIA) 
VALUES ('Sara', 'Pérez', 2000.00, 'Empleado');

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO, CATEGORIA) 
VALUES ('Carlos', 'Ruiz', 2200.00, 'Reponedor');

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO, CATEGORIA) 
VALUES ('Elena', 'Gómez', 2300.00, 'Reponedor');

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO, CATEGORIA) 
VALUES ('Pablo', 'Hernández', 2400.00, 'Cajero');

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO, CATEGORIA) 
VALUES ('Carmen', 'Díaz', 2000.00, 'Reponedor');

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO, CATEGORIA) 
VALUES ('José', 'Moreno', 2200.00, 'Empleado');

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO, CATEGORIA) 
VALUES ('Paula', 'Muñoz', 2100.00, 'Reponedor');

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO, CATEGORIA) 
VALUES ('Manuel', 'Jiménez', 2500.00, 'Encargado');

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO, CATEGORIA) 
VALUES ('Isabel', 'Álvarez', 2300.00, 'Encargado');

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO, CATEGORIA) 
VALUES ('Raúl', 'Romero', 2400.00, 'Reponedor');

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO, CATEGORIA) 
VALUES ('Eva', 'Torres', 2000.00, 'Cajero');

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO, CATEGORIA) 
VALUES ('Javier', 'Giménez', 2200.00, 'Empleado');

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO, CATEGORIA) 
VALUES ('Nuria', 'Navarro', 2100.00, 'Cajero');



INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL) 
VALUES ('Juan', 'García', 28001);

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL) 
VALUES ('María', 'López', 28002);

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL) 
VALUES ('Pedro', 'Martínez', 28003);

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL) 
VALUES ('Ana', 'Sánchez', 28004);

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL) 
VALUES ('Miguel', 'González', 28005);

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL) 
VALUES ('Laura', 'Rodríguez', 28006);

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL) 
VALUES ('David', 'Fernández', 28007);

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL) 
VALUES ('Sara', 'Pérez', 28008);

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL) 
VALUES ('Carlos', 'Ruiz', 28009);

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL) 
VALUES ('Elena', 'Gómez', 28010);

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL) 
VALUES ('Pablo', 'Hernández', 28011);

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL) 
VALUES ('Carmen', 'Díaz', 28012);

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL) 
VALUES ('José', 'Moreno', 28013);

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL) 
VALUES ('Paula', 'Muñoz', 28014);

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL) 
VALUES ('Manuel', 'Jiménez', 28015);

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL) 
VALUES ('Isabel', 'Álvarez', 28016);

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL) 
VALUES ('Raúl', 'Romero', 28017);

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL) 
VALUES ('Eva', 'Torres', 28018);

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL) 
VALUES ('Javier', 'Giménez', 28019);

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL) 
VALUES ('Nuria', 'Navarro', 28020);


--Atencion chavales en un solo insert :D
INSERT INTO PRODUCTOS (NOMBRE, MARCA, PRECIO, ALTURA, ANCHURA, PESO, NUM_ELEMENTOS, DESCRIPCION, CATEGORIA) VALUES
('Leche Entera', 'Puleva', 1.20, 20.00, 10.00, 1.00, 1, 'Leche de vaca entera en brik', 'Alimentacion'),
('Galletas Maria', 'Fontaneda', 1.50, 15.00, 5.00, 0.30, 1, 'Galletas clásicas', 'Alimentacion'),
('Champú Anticaspa', 'H&S', 4.75, 22.00, 8.00, 0.50, 1, 'Champú para el cuidado del cabello', 'Cosmetica'),
('Papel Higiénico', 'Scottex', 3.90, 10.00, 10.00, 0.20, 6, 'Papel higiénico suave', 'Drogueria'),
('Café Molido', 'Marcilla', 2.80, 15.00, 5.00, 0.25, 1, 'Café molido 250g', 'Alimentacion'),
('Detergente Líquido', 'Ariel', 5.60, 25.00, 15.00, 3.00, 1, 'Detergente para lavadora', 'Drogueria'),
('Crema Hidratante', 'Nivea', 7.50, 10.00, 5.00, 0.20, 1, 'Crema hidratante para la piel', 'Cosmetica'),
('Cereales Choco', 'Kelloggs', 3.20, 30.00, 10.00, 0.40, 1, 'Cereales de chocolate', 'Alimentacion'),
('Limpia Cristales', 'Cristasol', 2.50, 25.00, 8.00, 0.75, 1, 'Limpia cristales en spray', 'Drogueria'),
('Pasta de Dientes', 'Colgate', 2.00, 15.00, 5.00, 0.10, 1, 'Pasta dental', 'Cosmetica'),
('Aceite de Oliva', 'Carbonell', 4.60, 30.00, 7.00, 1.00, 1, 'Aceite de oliva virgen extra', 'Alimentacion'),
('Gel de Ducha', 'Dove', 3.50, 22.00, 8.00, 0.50, 1, 'Gel de ducha nutritivo', 'Cosmetica'),
('Detergente en Polvo', 'Skip', 7.00, 25.00, 15.00, 3.00, 1, 'Detergente en polvo', 'Drogueria'),
('Chocolate Negro', 'Lindt', 2.90, 10.00, 5.00, 0.10, 1, 'Chocolate negro 85% cacao', 'Alimentacion'),
('Laca para el Cabello', 'Pantene', 4.20, 25.00, 7.00, 0.30, 1, 'Laca fijadora', 'Cosmetica'),
('Limpia Suelos', 'Asevi', 2.70, 30.00, 10.00, 2.00, 1, 'Limpia suelos con aroma', 'Drogueria'),
('Yogur Natural', 'Danone', 1.10, 10.00, 10.00, 0.50, 4, 'Yogur natural en pack de 4', 'Alimentacion'),
('Maquillaje Líquido', 'Maybelline', 8.50, 10.00, 3.00, 0.05, 1, 'Base de maquillaje líquida', 'Cosmetica'),
('Lavavajillas', 'Fairy', 2.90, 25.00, 10.00, 1.00, 1, 'Lavavajillas concentrado', 'Drogueria'),
('Arroz Bomba', 'La Fallera', 2.30, 25.00, 15.00, 1.00, 1, 'Arroz de grano redondo', 'Alimentacion'),
('Jabón de Manos', 'Palmolive', 1.80, 15.00, 5.00, 0.25, 1, 'Jabón líquido para manos', 'Cosmetica'),
('Refresco Cola', 'Coca-Cola', 1.50, 25.00, 8.00, 1.00, 2, 'Refresco de cola en pack de 2', 'Alimentacion'),
('Desodorante Spray', 'Rexona', 3.00, 15.00, 5.00, 0.20, 1, 'Desodorante en spray', 'Cosmetica'),
('Toallitas Húmedas', 'Dodot', 4.00, 15.00, 10.00, 0.50, 3, 'Toallitas húmedas para bebé', 'Drogueria'),
('Galletas Digestive', 'McVities', 2.70, 15.00, 5.00, 0.30, 1, 'Galletas digestivas', 'Alimentacion'),
('Cacao en Polvo', 'Valor', 3.40, 20.00, 10.00, 0.50, 1, 'Cacao puro en polvo', 'Alimentacion'),
('Suavizante Ropa', 'Vernel', 3.20, 30.00, 10.00, 2.00, 1, 'Suavizante para la ropa', 'Drogueria'),
('Mermelada Fresa', 'Hero', 2.10, 15.00, 5.00, 0.30, 1, 'Mermelada de fresa', 'Alimentacion'),
('Desmaquillante', 'Garnier', 4.50, 20.00, 5.00, 0.25, 1, 'Desmaquillante de ojos', 'Cosmetica'),
('Detergente Cápsulas', 'Ariel', 9.50, 20.00, 15.00, 0.60, 1, 'Cápsulas para la lavadora', 'Drogueria'),
('Helado de Vainilla', 'Häagen-Dazs', 5.60, 12.00, 12.00, 0.50, 1, 'Helado de vainilla', 'Alimentacion'),
('Agua Mineral', 'Lanjarón', 0.85, 25.00, 8.00, 1.50, 6, 'Agua mineral natural', 'Alimentacion'),
('Loción Corporal', 'Eucerin', 6.90, 20.00, 7.00, 0.40, 1, 'Loción hidratante corporal', 'Cosmetica'),
('Limpiador Multiusos', 'Cillit Bang', 3.70, 25.00, 10.00, 0.75, 1, 'Limpiador multiusos en spray', 'Drogueria'),
('Galletas de Chocolate', 'Chips Ahoy', 2.80, 15.00, 5.00, 0.30, 1, 'Galletas con trozos de chocolate', 'Alimentacion'),
('Mascarilla Capilar', 'LOréal', 5.30, 10.00, 5.00, 0.30, 1, 'Mascarilla para el cabello', 'Cosmetica'),
('Ambientador Spray', 'Ambi Pur', 3.50, 25.00, 7.00, 0.30, 1, 'Ambientador en spray', 'Drogueria'),
('Pan de Molde', 'Bimbo', 1.90, 20.00, 10.00, 0.50, 1, 'Pan de molde blanco', 'Alimentacion'),
('Colonia Fresca', 'Nenuco', 4.00, 25.00, 8.00, 0.50, 1, 'Colonia para bebés', 'Cosmetica'),
('Lejía', 'Neutrex', 1.30, 30.00, 10.00, 1.50, 1, 'Lejía para limpieza', 'Drogueria'),
('Queso Rallado', 'García Baquero', 2.50, 10.00, 5.00, 0.20, 1, 'Queso rallado', 'Alimentacion');

INSERT INTO SEDE (UBICACION) VALUES ('Madrid');

INSERT INTO PRODUCTO_SEDE (EAN, UBICACION, STOCK) VALUES (1, 'Madrid', 96);
INSERT INTO PRODUCTO_SEDE (EAN, UBICACION, STOCK) VALUES (2, 'Madrid', 40);
INSERT INTO PRODUCTO_SEDE (EAN, UBICACION, STOCK) VALUES (3, 'Madrid', 60);
INSERT INTO PRODUCTO_SEDE (EAN, UBICACION, STOCK) VALUES (4, 'Madrid', 50);
INSERT INTO PRODUCTO_SEDE (EAN, UBICACION, STOCK) VALUES (5, 'Madrid', 80);
INSERT INTO PRODUCTO_SEDE (EAN, UBICACION, STOCK) VALUES (6, 'Madrid', 72);
INSERT INTO PRODUCTO_SEDE (EAN, UBICACION, STOCK) VALUES (7, 'Madrid', 36);
INSERT INTO PRODUCTO_SEDE (EAN, UBICACION, STOCK) VALUES (8, 'Madrid', 45);

INSERT INTO COMPRA (FECHA_COMPRA, ID_CLIENTE) VALUES (SYSDATE(), 1);
INSERT INTO COMPRA (FECHA_COMPRA, ID_CLIENTE) VALUES (SYSDATE(), 2);
INSERT INTO COMPRA (FECHA_COMPRA, ID_CLIENTE) VALUES (SYSDATE(), 3);
INSERT INTO COMPRA (FECHA_COMPRA, ID_CLIENTE) VALUES (SYSDATE(), 4);
INSERT INTO COMPRA (FECHA_COMPRA, ID_CLIENTE) VALUES (SYSDATE(), 5);
INSERT INTO COMPRA (FECHA_COMPRA, ID_CLIENTE) VALUES (SYSDATE(), 6);
INSERT INTO COMPRA (FECHA_COMPRA, ID_CLIENTE) VALUES (SYSDATE(), 7);
INSERT INTO COMPRA (FECHA_COMPRA, ID_CLIENTE) VALUES (SYSDATE(), 8);