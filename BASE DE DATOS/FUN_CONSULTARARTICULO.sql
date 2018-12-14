-- Function: FUNCTION FUN_CONSULTARARTICULO(CHARACTER)

-- DROP FUNCTION FUN_CONSULTARARTICULO(CHARACTER)
--SELECT cdescripcion as descripcion ,cmodelo as modelo,iexistencia as existencia,iprecio as precio from FUN_CONSULTARARTICULO('C')


CREATE OR REPLACE FUNCTION FUN_CONSULTARARTICULO(CHARACTER)
   RETURNS TABLE(cdescripcion varchar(30) ,cmodelo varchar(30),iexistencia integer,iprecio integer) as
$BODY$
DECLARE
	cDescripcionArticulo ALIAS FOR $1;
BEGIN

	RETURN QUERY SELECT descripcion,modelo,existencia,precio FROM cat_articulos  WHERE  descripcion like '%'||cDescripcionArticulo||'%';
	
	
END;
$BODY$
LANGUAGE 'plpgsql' VOLATILE SECURITY DEFINER;