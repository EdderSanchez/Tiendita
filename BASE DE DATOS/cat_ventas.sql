create table cat_ventas(
  folioventa integer default 0,
  clave integer default 0, 
  nombre varchar(30) default '',
  total integer default 0,
  fecha date default '1900-01-01',
  estatus varchar(20) default 0,
  primary key(folioventa)
 );
