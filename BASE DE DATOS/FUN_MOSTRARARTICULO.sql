-- Function: FUNCTION FUN_MOSTRARARTICULO(CHARACTER,INTEGER)

-- DROP FUNCTION FUN_MOSTRARARTICULO(CHARACTER,INTEGER)
--SELECT cdescripcion as descripcion ,cmodelo as modelo,iprecioarticulo as precio,iimporte as importe from FUN_MOSTRARARTICULO('CAFETERA',2)

CREATE OR REPLACE FUNCTION FUN_MOSTRARARTICULO(CHARACTER,INTEGER)
   RETURNS TABLE(cdescripcion varchar(30) ,cmodelo varchar(30),iprecioarticulo float,iimporte integer) as
$BODY$
DECLARE
	cDescripcionArticulo ALIAS FOR $1;
	iCantidad ALIAS FOR $2;

	iPlazoMaximo integer default 0;
	iTasaFinaciamiento integer default 0;
	iPrecio integer default 0;
BEGIN
	SELECT plazomaximo,tasainteres INTO iPlazoMaximo,iTasaFinaciamiento FROM cat_configuracion ;

	SELECT descripcion,modelo,precio INTO cDescripcion,cModelo,iPrecio FROM cat_articulos  WHERE descripcion = cDescripcionArticulo LIMIT 1;
	
	iPrecioArticulo = (iPrecio::float * (1 +(iTasaFinaciamiento * iPlazoMaximo)/100::float));	
	iImporte = iPrecioArticulo * iCantidad;


	RETURN NEXT;
	
END;
$BODY$
LANGUAGE 'plpgsql' VOLATILE SECURITY DEFINER;
