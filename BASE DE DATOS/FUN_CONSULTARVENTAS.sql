-- Function: FUNCTION FUN_CONSULTARVENTAS()

-- DROP FUNCTION FUN_CONSULTARVENTAS()
--SELECT ifolioventa as folioventa,iclave as clave,cnombre as nombre,itotal as total,dfecha as fecha,cestatus as estatus from FUN_CONSULTARVENTAS()


CREATE OR REPLACE FUNCTION FUN_CONSULTARVENTAS()
   RETURNS TABLE(ifolioventa integer,iclave  integer ,cnombre varchar(30),itotal integer, dfecha date ,  cestatus varchar(20)) as
$BODY$
BEGIN

	RETURN QUERY SELECT folioventa,clave,nombre,total,fecha,estatus FROM cat_ventas;
	
	
END;
$BODY$
LANGUAGE 'plpgsql' VOLATILE SECURITY DEFINER