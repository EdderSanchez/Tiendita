/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ventas;

import Entidades.CAbonos;
import Entidades.CArticulo;
import Entidades.CCliente;
import Entidades.CMostrarArticulo;
import Entidades.CTotales;
import Entidades.CVentas;
import Entidades.WebResponse;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author Dell Inspiron EPF
 */
@Path("Ventas")
public class VentasResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public VentasResource() {
    }

    /**
     * Retrieves representation of an instance of Ventas.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/xml")
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
    
    @GET
    @Path("ConsultarVentas")
    @Produces("application/json")
    public ArrayList<CVentas> ConsultarVentas( @Context  HttpServletRequest request)
    {
        ArrayList<CVentas> lVentas = new ArrayList<>();
        
        try
        {
            return lVentas = new VentasBO.VentasBO().ConsultarVentas() ;
        }
        catch(Exception ex) 
        {
             return lVentas;
        } 
       
    }
    
    @GET
    @Path("ConsultarCliente")
    @Produces("application/json")
    public ArrayList<CCliente>  ConsultarCliente( @Context  HttpServletRequest request,
            @QueryParam("nombrecliente") String sNombreCliente ) throws Throwable
    {
        WebResponse wr = new WebResponse();
           ArrayList<CCliente> lCliente = new ArrayList<>();
        
        try
        {
            return lCliente =  new VentasBO.VentasBO().ConsultarCliente(sNombreCliente);
        }
        catch(Exception ex) 
        {
            return lCliente ;
        } 
    }
    
    @GET
    @Path("ConsultarArticulo")
    @Produces("application/json")
    public ArrayList<CArticulo> ConsultarArticulo( @Context  HttpServletRequest request,
            @QueryParam("nombrearticulo") String sNombreArticulo ) throws Throwable
    {
        WebResponse wr = new WebResponse();
        ArrayList<CArticulo> lArticulo = new ArrayList<>();
        
        try
        {
            return lArticulo = new VentasBO.VentasBO().ConsultarArticulo(sNombreArticulo);
        }
        catch(Exception ex) 
        {
            return lArticulo;
        } 
    }
    
    @GET
    @Path("ValidarExistencia")
    @Produces("application/json")
    public CArticulo ValidarExistencia( @Context  HttpServletRequest request,
            @QueryParam("descripcion") String sDescripcion,
            @QueryParam("modelo") String sModelo) throws Throwable
    {
        WebResponse wr = new WebResponse();
        CArticulo objArticulo = new CArticulo();
        
        try
        {
            return objArticulo = ( new VentasBO.VentasBO().ValidarExistencia(sDescripcion,sModelo));
        }
        catch(Exception ex) 
        {
            return objArticulo;
        } 
    }
    
     @GET
    @Path("ObtenerFolioVenta")
    @Produces("application/json")
    public int ObtenerFolioVenta( @Context  HttpServletRequest request) throws Throwable
    {
        WebResponse wr = new WebResponse();
        int iFolioVenta = 0;
        
        try
        {
            return iFolioVenta = ( new VentasBO.VentasBO().ObtenerFolioVenta()) ;
        }
        catch(Exception ex) 
        {
            return iFolioVenta;
        } 
    }
    
      @GET
    @Path("ObtenerFecha")
    @Produces("application/json")
    public Date ObtenerFecha( @Context  HttpServletRequest request) throws Throwable
    {
        WebResponse wr = new WebResponse();
        Date dFecha = new Date(0);
        
        try
        {
            return dFecha = ( new VentasBO.VentasBO().ObtenerFecha()) ;
        }
        catch(Exception ex) 
        {
            return dFecha;
        } 
    }
    
    @GET
    @Path("MostrarArticulo")
    @Produces("application/json")
    public ArrayList<CMostrarArticulo> MostrarArticulo( @Context  HttpServletRequest request,
            @QueryParam("descripcion") String sDescripcion,
            @QueryParam("cantidad") int iCantidad) throws Throwable
    {
        WebResponse wr = new WebResponse();
         ArrayList<CMostrarArticulo> lArticulos = new ArrayList<>();
        
        try
        {
            return lArticulos = ( new VentasBO.VentasBO().MostrarArticulo(sDescripcion,iCantidad) );
        }
        catch(Exception ex) 
        {
            return lArticulos;
        } 
    }
    
     @GET
    @Path("CalcularTotales")
    @Produces("application/json")
    public CTotales CalcularTotales( @Context  HttpServletRequest request,
            @QueryParam("importe") int iImporte) throws Throwable
    {
        WebResponse wr = new WebResponse();
        CTotales objTotales = new CTotales();
        
        try
        {
            return objTotales = ( new VentasBO.VentasBO().CalcularTotales(iImporte) );
        }
        catch(Exception ex) 
        {
            return objTotales;
        } 
    }
    
    @GET
    @Path("CalcularAbonos")
    @Produces("application/json")
    public ArrayList<CAbonos> CalcularAbonos( @Context  HttpServletRequest request,
            @QueryParam("totaladeudo") int iTotalAdeudo) throws Throwable
    {
        WebResponse wr = new WebResponse();
        ArrayList<CAbonos> lAbonos = new ArrayList<>();
        
        try
        {
            return lAbonos = ( new VentasBO.VentasBO().CalcularAbonos(iTotalAdeudo) );
        }
        catch(Exception ex) 
        {
            return lAbonos;
        } 
    }
    
     @GET
    @Path("GrabarVenta")
    @Produces("application/json")
    public int GrabarVenta( @Context  HttpServletRequest request,
            @QueryParam("folioventa") int iFolioVenta,
            @QueryParam("clave") int iClave,
            @QueryParam("nombre") String sNombre,
            @QueryParam("total") int iTotal,
            @QueryParam("fecha") String sFecha,
            @QueryParam("estatus") String sEstatus) throws Throwable
    {
        WebResponse wr = new WebResponse();
        int iEjecuto = 0;
        
        try
        {
            return iEjecuto = ( new VentasBO.VentasBO().GrabarVenta(iFolioVenta,iClave,sNombre,iTotal,sFecha,sEstatus));
        }
        catch(Exception ex) 
        {
            return iEjecuto;
        } 
    }
}
