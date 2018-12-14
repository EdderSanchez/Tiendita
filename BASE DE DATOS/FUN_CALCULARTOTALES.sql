-- Function: FUNCTION FUN_CALCULARTOTALES(INTEGER)

-- DROP FUNCTION FUN_CALCULARTOTALES(INTEGER)
--SELECT ienganche as enganche ,ibonificacionenganche as bonificacionenganche,itotaladeudo as totaladeudo from FUN_CALCULARTOTALES(2040)


CREATE OR REPLACE FUNCTION FUN_CALCULARTOTALES(INTEGER)
   RETURNS TABLE(ienganche integer ,ibonificacionenganche integer,itotaladeudo integer) as
$BODY$
DECLARE
	iImporte ALIAS FOR $1;

	iPorcentajeEnganche integer default 0;
	iTasaFinanciamiento integer default 0;
	iPlazoMaximo integer default 0;
	
BEGIN
	SELECT porcentajeenganche,tasainteres,plazomaximo INTO iPorcentajeEnganche,iTasaFinanciamiento,iPlazoMaximo FROM cat_configuracion ;

	iEnganche = ((iPorcentajeEnganche / 100::float) * iImporte);
	iBonificacionEnganche = iEnganche * ((iTasaFinanciamiento * iPlazoMaximo)/100::float);
	iTotalAdeudo = iImporte - iEnganche - iBonificacionEnganche;


	RETURN NEXT;
	
END;
$BODY$
LANGUAGE 'plpgsql' VOLATILE SECURITY DEFINER;
