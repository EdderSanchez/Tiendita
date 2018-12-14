-- Function: FUNCTION FUN_VALIDAREXISTENCIA(CHARACTER)

-- DROP FUNCTION FUN_VALIDAREXISTENCIA(CHARACTER)
--SELECT cdescripcion as descripcion ,cmodelo as modelo,iexistencia as existencia,iprecio as precio from FUN_VALIDAREXISTENCIA('REFRIGERADOR','MABE')


CREATE OR REPLACE FUNCTION FUN_VALIDAREXISTENCIA(CHARACTER,CHARACTER)
   RETURNS TABLE(cdescripcion varchar(30) ,cmodelo varchar(30),iexistencia integer,iprecio integer) as
$BODY$
DECLARE
	cDescripcionArticulo ALIAS FOR $1;
	cModeloArticulo ALIAS FOR $2;
BEGIN

	RETURN QUERY SELECT descripcion,modelo,existencia,precio FROM cat_articulos  WHERE  descripcion = cDescripcionArticulo AND modelo = cModeloArticulo;
	
	
END;
$BODY$
LANGUAGE 'plpgsql' VOLATILE SECURITY DEFINER;
