--DELETE FROM cat_articulos;
--DELETE FROM cat_cliente;
--DELETE FROM cat_configuracion;
--DELETE FROM cat_ventas;


-- ARTICULOS
INSERT INTO cat_articulos(descripcion,modelo,existencia,precio) VALUES('REFRIGERADOR','MABE',4,8500);
INSERT INTO cat_articulos(descripcion,modelo,existencia,precio) VALUES('LICUADORA','OSTER',4,1000);
INSERT INTO cat_articulos(descripcion,modelo,existencia,precio) VALUES('ESTUFA','WHIRLPOOL',4,7000);


-- CLIENTES
INSERT INTO cat_cliente(nombre,clave,rfc) VALUES('EDDER SANCHEZ',1,'SALE123432DSAWESA');
INSERT INTO cat_cliente(nombre,clave,rfc) VALUES('JUAN PEREZ',11,'JUPE123432213ASD312');
INSERT INTO cat_cliente(nombre,clave,rfc) VALUES('PABLO ANGULO',12,'PAAN12DSA3DA22432');

--CONFIGURACION
INSERT INTO cat_configuracion(plazomaximo,tasainteres,porcentajeenganche) VALUES(12,3,20);

--VENTAS (DEBEN MOSTRAR EN EL GRID)
INSERT INTO cat_ventas(folioventa,clave,nombre,total,fecha,estatus) VALUES(1,1,'EDDER SANCHEZ',1485,'2018-12-12','ACTIVA');
INSERT INTO cat_ventas(folioventa,clave,nombre,total,fecha,estatus) VALUES(2,11,'JUAN PEREZ',1485,'2018-12-12','ACTIVA');
INSERT INTO cat_ventas(folioventa,clave,nombre,total,fecha,estatus) VALUES(3,12,'PABLO ANGULO',1485,'2018-12-12','ACTIVA');
