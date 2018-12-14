-- Function: FUNCTION FUN_CALCULARABONOS(INTEGER)

-- DROP FUNCTION FUN_CALCULARABONOS(INTEGER)
--SELECT imeses as meses,itotalpagar as totalpagar,iimporteabono as importeabono,iimporteahorra as importeahorra from FUN_CALCULARABONOS(5000)


CREATE OR REPLACE FUNCTION FUN_CALCULARABONOS(INTEGER)
   RETURNS TABLE(imeses integer,itotalpagar integer,iimporteabono integer,iimporteahorra integer) as
   
$BODY$
DECLARE
	iTotalAdeudo ALIAS FOR $1;

	iPorcentajeEnganche integer default 0;
	iTasaFinanciamiento integer default 0;
	iPlazoMaximo integer default 0;
	iPrecioContado float default 0;

	reg RECORD;
	
BEGIN
	SELECT porcentajeenganche,tasainteres,plazomaximo INTO iPorcentajeEnganche,iTasaFinanciamiento,iPlazoMaximo FROM cat_configuracion ;

	iPrecioContado = (iTotalAdeudo / (1 +((iTasaFinanciamiento * iPlazoMaximo)/100::float)));

	-- PLAZO MAXIMO
	--iTotalPagar = iPrecioContado * (1 + (iTasaFinanciamiento * iPlazoMaximo)/100::float);

	/****************************************** PLAZOS *********************************************/

	-- 3 MESES
	iMeses = 3;
	iTotalPagar = iPrecioContado * (1 + (iTasaFinanciamiento * 3)/100::float);
	iImporteAbono = iTotalPagar / 3;
	iImporteAhorra = iTotalAdeudo - iTotalPagar;
	RETURN NEXT;

	-- 6 MESES
	iMeses = 6;
	iTotalPagar  = iPrecioContado * (1 + (iTasaFinanciamiento * 6)/100::float);
	iImporteAbono = iTotalPagar / 6;
	iImporteAhorra = iTotalAdeudo - iTotalPagar;
	RETURN NEXT;
	

	-- 9 MESES
	iMeses = 9;
	iTotalPagar  = iPrecioContado * (1 + (iTasaFinanciamiento * 9)/100::float);
	iImporteAbono = iTotalPagar / 9;
	iImporteAhorra = iTotalAdeudo - iTotalPagar;
	RETURN NEXT;

	-- 12 MESES
	iMeses = 12;
	iTotalPagar  = iPrecioContado * (1 + (iTasaFinanciamiento * 12)/100::float);
	iImporteAbono = iTotalPagar / 12;
	iImporteAhorra = iTotalAdeudo - iTotalPagar;
	RETURN NEXT;

	raise notice '1 %' ,iPrecioContado;	
	
	RETURN;
	
END;
$BODY$
LANGUAGE 'plpgsql' VOLATILE SECURITY DEFINER;
