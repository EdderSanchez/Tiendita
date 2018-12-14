-- Function: FUNCTION FUN_CONSULTARNOMBRE(CHARACTER)

-- DROP FUNCTION FUN_CONSULTARNOMBRE(CHARACTER)
--SELECT cnombre as nombre ,iclave as clave,irfc as rfc from FUN_CONSULTARNOMBRE('C')


CREATE OR REPLACE FUNCTION FUN_CONSULTARNOMBRE(CHARACTER)
   RETURNS TABLE(cnombre varchar(30) ,iclave integer,irfc varchar) as
$BODY$
DECLARE
	cNombreCliente ALIAS FOR $1;
BEGIN

	RETURN QUERY SELECT nombre,clave,rfc FROM cat_cliente WHERE  nombre like '%'||cNombreCliente||'%';
	
	
END;
$BODY$
LANGUAGE 'plpgsql' VOLATILE SECURITY DEFINER;
