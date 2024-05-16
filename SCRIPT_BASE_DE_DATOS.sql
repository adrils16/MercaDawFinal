

CREATE TABLE PRODUCTOS (
                    EAN INTEGER AUTO_INCREMENT PRIMARY KEY,
                    NOMBRE VARCHAR(50),
                    MARCA VARCHAR(25),
                    PRECIO INTEGER,
                    ALTURA INTEGER,  
                    ANCHURA INTEGER,
                    PESO INTEGER,
                    NUM_ELEMENTOS INTEGER,
                    DESCRIPCION VARCHAR(100));

CREATE TABLE EMPLEADOS (
                    ID_EMPLEADO INTEGER AUTO_INCREMENT PRIMARY KEY,
                    NOMBRE VARCHAR(25) ,
                    APELLIDOS VARCHAR(25),
                    SALARIO DOUBLE );

CREATE TABLE CLIENTE (
                    ID_CLIENTE INTEGER AUTO_INCREMENT PRIMARY KEY,
                    NOMBRE VARCHAR(25) ,
                    APELLIDOS VARCHAR(25),
                    COD_POSTAL INTEGER,
                    CORR_ELEC VARCHAR(50));

CREATE TABLE SEDE (
                    UBICACION VARCHAR(25) PRIMARY KEY);

CREATE TABLE COMPRA (
                    ID_COMPRA INTEGER AUTO_INCREMENT,
                    FECHA_COMPRA VARCHAR(25),
                    ID_CLIENTE INTEGER ,
                    PRIMARY KEY (ID_COMPRA),
                    FOREIGN KEY (ID_CLIENTE) REFERENCES CLIENTE(ID_CLIENTE));



CREATE TABLE COMPRA_PRODUCTO (
                    EAN INTEGER,
                    ID_COMPRA INTEGER,
                    CANTIDAD INTEGER,
                    PRIMARY KEY (EAN, ID_COMPRA),
                    FOREIGN KEY (EAN) REFERENCES PRODUCTOS(EAN),
                    FOREIGN KEY (ID_COMPRA) REFERENCES COMPRA(ID_COMPRA));
                    
CREATE TABLE PRODUCTO_SEDE (
                    EAN INTEGER,
                    UBICACION VARCHAR(25),
                    STOCK INTEGER,
                    PRIMARY KEY (EAN, UBICACION),
                    FOREIGN KEY (EAN) REFERENCES PRODUCTOS(EAN),
                    FOREIGN KEY (UBICACION) REFERENCES SEDE(UBICACION));

-- CREACION DE LAS VISTAS
CREATE OR REPLACE VIEW vista_productos AS
SELECT EAN, NOMBRE, MARCA, PRECIO, ALTURA, ANCHURA, PESO, NUM_ELEMENTOS, DESCRIPCION
FROM PRODUCTOS;

CREATE OR REPLACE VIEW vista_empleados AS
SELECT ID_EMPLEADO, NOMBRE, APELLIDOS, SALARIO
FROM EMPLEADOS;

CREATE OR REPLACE VIEW vista_cliente AS
SELECT ID_CLIENTE, NOMBRE, APELLIDOS, COD_POSTAL, CORR_ELEC
FROM CLIENTE;

CREATE OR REPLACE VIEW vista_compra_producto AS
SELECT EAN, ID_COMPRA, CANTIDAD
FROM COMPRA_PRODUCTO;

CREATE OR REPLACE VIEW vista_sede AS
SELECT UBICACION
FROM SEDE;

CREATE OR REPLACE VIEW vista_compra AS
SELECT ID_COMPRA, FECHA_COMPRA
FROM COMPRA;


-- INSERT A LAS TABLAS.
INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO) 
VALUES ('Juan', 'Gómez', 2000.00);

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO) 
VALUES ('María', 'López', 2200.00);

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO) 
VALUES ('Pedro', 'Martínez', 2500.00);

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO) 
VALUES ('Ana', 'Sánchez', 1900.00);

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO) 
VALUES ('Miguel', 'González', 2300.00);

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO) 
VALUES ('Laura', 'Rodríguez', 2100.00);

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO) 
VALUES ('David', 'Fernández', 2400.00);

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO) 
VALUES ('Sara', 'Pérez', 2000.00);

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO) 
VALUES ('Carlos', 'Ruiz', 2200.00);

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO) 
VALUES ('Elena', 'Gómez', 2300.00);

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO) 
VALUES ('Pablo', 'Hernández', 2400.00);

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO) 
VALUES ('Carmen', 'Díaz', 2000.00);

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO) 
VALUES ('José', 'Moreno', 2200.00);

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO) 
VALUES ('Paula', 'Muñoz', 2100.00);

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO) 
VALUES ('Manuel', 'Jiménez', 2500.00);

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO) 
VALUES ('Isabel', 'Álvarez', 2300.00);

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO) 
VALUES ('Raúl', 'Romero', 2400.00);

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO) 
VALUES ('Eva', 'Torres', 2000.00);

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO) 
VALUES ('Javier', 'Giménez', 2200.00);

INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, SALARIO) 
VALUES ('Nuria', 'Navarro', 2100.00);



INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL, CORR_ELEC) 
VALUES ('Juan', 'García', 28001, 'juan.garcia@example.com');

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL, CORR_ELEC) 
VALUES ('María', 'López', 28002, 'maria.lopez@example.com');

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL, CORR_ELEC) 
VALUES ('Pedro', 'Martínez', 28003, 'pedro.martinez@example.com');

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL, CORR_ELEC) 
VALUES ('Ana', 'Sánchez', 28004, 'ana.sanchez@example.com');

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL, CORR_ELEC) 
VALUES ('Miguel', 'González', 28005, 'miguel.gonzalez@example.com');

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL, CORR_ELEC) 
VALUES ('Laura', 'Rodríguez', 28006, 'laura.rodriguez@example.com');

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL, CORR_ELEC) 
VALUES ('David', 'Fernández', 28007, 'david.fernandez@example.com');

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL, CORR_ELEC) 
VALUES ('Sara', 'Pérez', 28008, 'sara.perez@example.com');

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL, CORR_ELEC) 
VALUES ('Carlos', 'Ruiz', 28009, 'carlos.ruiz@example.com');

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL, CORR_ELEC) 
VALUES ('Elena', 'Gómez', 28010, 'elena.gomez@example.com');

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL, CORR_ELEC) 
VALUES ('Pablo', 'Hernández', 28011, 'pablo.hernandez@example.com');

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL, CORR_ELEC) 
VALUES ('Carmen', 'Díaz', 28012, 'carmen.diaz@example.com');

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL, CORR_ELEC) 
VALUES ('José', 'Moreno', 28013, 'jose.moreno@example.com');

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL, CORR_ELEC) 
VALUES ('Paula', 'Muñoz', 28014, 'paula.munoz@example.com');

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL, CORR_ELEC) 
VALUES ('Manuel', 'Jiménez', 28015, 'manuel.jimenez@example.com');

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL, CORR_ELEC) 
VALUES ('Isabel', 'Álvarez', 28016, 'isabel.alvarez@example.com');

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL, CORR_ELEC) 
VALUES ('Raúl', 'Romero', 28017, 'raul.romero@example.com');

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL, CORR_ELEC) 
VALUES ('Eva', 'Torres', 28018, 'eva.torres@example.com');

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL, CORR_ELEC) 
VALUES ('Javier', 'Giménez', 28019, 'javier.gimenez@example.com');

INSERT INTO CLIENTE (NOMBRE, APELLIDOS, COD_POSTAL, CORR_ELEC) 
VALUES ('Nuria', 'Navarro', 28020, 'nuria.navarro@example.com');



INSERT INTO PRODUCTOS (NOMBRE, MARCA, PRECIO, ALTURA, ANCHURA, PESO, NUM_ELEMENTOS, DESCRIPCION) 
VALUES ('Leche entera', 'Pascual', 1.20, 20, 10, 1, 50, 'Leche entera pasteurizada en envase de cartón de 1 litro');

INSERT INTO PRODUCTOS (NOMBRE, MARCA, PRECIO, ALTURA, ANCHURA, PESO, NUM_ELEMENTOS, DESCRIPCION) 
VALUES ('Pan de molde integral', 'Bimbo', 1.50, 15, 10, 0.5, 20, 'Pan de molde integral envasado, ideal para sandwiches');

INSERT INTO PRODUCTOS (NOMBRE, MARCA, PRECIO, ALTURA, ANCHURA, PESO, NUM_ELEMENTOS, DESCRIPCION) 
VALUES ('Arroz blanco', 'SOS', 0.90, 25, 15, 1, 30, 'Arroz de grano largo para guarniciones y platos principales');

INSERT INTO PRODUCTOS (NOMBRE, MARCA, PRECIO, ALTURA, ANCHURA, PESO, NUM_ELEMENTOS, DESCRIPCION) 
VALUES ('Pasta italiana', 'Barilla', 1.20, 20, 15, 0.5, 25, 'Pasta italiana tipo espagueti, hecha de sémola de trigo');

INSERT INTO PRODUCTOS (NOMBRE, MARCA, PRECIO, ALTURA, ANCHURA, PESO, NUM_ELEMENTOS, DESCRIPCION) 
VALUES ('Aceite de oliva virgen extra', 'Carbonell', 3.50, 25, 8, 1, 40, 'Aceite de oliva virgen extra de primera calidad');

INSERT INTO PRODUCTOS (NOMBRE, MARCA, PRECIO, ALTURA, ANCHURA, PESO, NUM_ELEMENTOS, DESCRIPCION) 
VALUES ('Atún en conserva', 'Calvo', 2.00, 10, 5, 0.2, 60, 'Atún en conserva en aceite vegetal, lata de 80 gramos');

INSERT INTO PRODUCTOS (NOMBRE, MARCA, PRECIO, ALTURA, ANCHURA, PESO, NUM_ELEMENTOS, DESCRIPCION) 
VALUES ('Huevos de gallina', 'Campofrío', 2.50, 8, 6, 0.3, 12, 'Docena de huevos de gallina frescos, categoría A');

INSERT INTO PRODUCTOS (NOMBRE, MARCA, PRECIO, ALTURA, ANCHURA, PESO, NUM_ELEMENTOS, DESCRIPCION) 
VALUES ('Tomate pera', 'Cocinero', 1.80, 10, 5, 0.2, 15, 'Tomate pera fresco y jugoso, ideal para ensaladas');

INSERT INTO PRODUCTOS (NOMBRE, MARCA, PRECIO, ALTURA, ANCHURA, PESO, NUM_ELEMENTOS, DESCRIPCION) 
VALUES ('Queso manchego', 'La Casota', 5.00, 10, 15, 0.4, 8, 'Queso manchego semicurado, elaborado con leche de oveja');

INSERT INTO PRODUCTOS (NOMBRE, MARCA, PRECIO, ALTURA, ANCHURA, PESO, NUM_ELEMENTOS, DESCRIPCION) 
VALUES ('Cerveza rubia', 'Estrella Galicia', 1.20, 20, 7, 0.5, 24, 'Cerveza rubia tipo Lager, botella de 33 cl');

INSERT INTO PRODUCTOS (NOMBRE, MARCA, PRECIO, ALTURA, ANCHURA, PESO, NUM_ELEMENTOS, DESCRIPCION) 
VALUES ('Papel higiénico', 'Scottex', 2.50, 25, 20, 1, 16, 'Rollo de papel higiénico de doble capa, paquete de 12 unidades');

INSERT INTO PRODUCTOS (NOMBRE, MARCA, PRECIO, ALTURA, ANCHURA, PESO, NUM_ELEMENTOS, DESCRIPCION) 
VALUES ('Detergente líquido', 'Ariel', 4.00, 30, 15, 1.5, 10, 'Detergente líquido para lavadora, formato de 3 litros');