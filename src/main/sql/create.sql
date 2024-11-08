CREATE DATABASE ventas;

USE ventas;

CREATE TABLE cliente (
                         clienteid INT NOT NULL AUTO_INCREMENT,
                         dni INT NOT NULL,
                         nombre VARCHAR(255) NOT NULL,
                         apellido VARCHAR(255),
                         PRIMARY KEY (clienteid)
);

CREATE TABLE producto (
                          productoid INT NOT NULL AUTO_INCREMENT,
                          codigo INT NOT NULL,
                          descripcion VARCHAR(255) NOT NULL,
                          cantidad INT,
                          precio FLOAT(10, 2), -- Ajustado para permitir más dígitos
    PRIMARY KEY (productoid)
);

CREATE TABLE comprobante (
                             comprobanteid INT NOT NULL AUTO_INCREMENT,
                             fecha DATETIME,
                             cantidad INT,
                             total FLOAT(10, 2), -- Ajustado para permitir más dígitos
    clienteid INT,
    PRIMARY KEY (comprobanteid),
    CONSTRAINT FK_cliente FOREIGN KEY (clienteid)
        REFERENCES cliente(clienteid)
        ON DELETE CASCADE -- Aquí se define el comportamiento en cascada
);

CREATE TABLE linea (
                       lineaid INT NOT NULL AUTO_INCREMENT,
                       descripcion VARCHAR(255) NOT NULL,
                       cantidad INT,
                       precio FLOAT(10, 2), -- Ajustado para permitir más dígitos
    comprobanteid INT NOT NULL,
    productoid INT NOT NULL,
    PRIMARY KEY (lineaid),
    CONSTRAINT FK_comprobante FOREIGN KEY (comprobanteid)
        REFERENCES comprobante(comprobanteid)
        ON DELETE CASCADE, -- También puedes agregar ON DELETE CASCADE aquí si deseas eliminar líneas al eliminar comprobantes
    CONSTRAINT FK_producto FOREIGN KEY (productoid)
        REFERENCES producto(productoid)
);