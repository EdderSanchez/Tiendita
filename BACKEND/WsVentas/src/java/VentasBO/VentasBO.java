/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package VentasBO;

import Entidades.CAbonos;
import Entidades.CArticulo;
import Entidades.CCliente;
import Entidades.CMostrarArticulo;
import Entidades.CTotales;
import Entidades.CVentas;
import Entidades.WebResponse;
import VentasDAL.VentasDAL;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Dell Inspiron EPF
 */
public class VentasBO {
    
    public ArrayList<CVentas> ConsultarVentas()
    {
        WebResponse wr = new WebResponse();
        VentasDAL objVentasDal = new VentasDAL();
        ArrayList<CVentas> lVentas = new ArrayList<>();
        
        lVentas = objVentasDal.ConsultarVentas();
        
        return lVentas;
    }
    
     public ArrayList<CCliente> ConsultarCliente(String sNombreCliente) throws Throwable
    {
        WebResponse wr = new WebResponse();
        VentasDAL objVentasDal = new VentasDAL();
          ArrayList<CCliente> lCliente = new ArrayList<>();
        
        lCliente = objVentasDal.ConsultarCliente(sNombreCliente);
        
        return lCliente;
    }
     
    public ArrayList<CArticulo> ConsultarArticulo(String sNombreArticulo) throws Throwable
    {
        WebResponse wr = new WebResponse();
        VentasDAL objVentasDal = new VentasDAL();
        ArrayList<CArticulo> lArticulo = new ArrayList<>();
        
        lArticulo = objVentasDal.ConsultarArticulo(sNombreArticulo);
        
        return lArticulo;
    }
   
    public CArticulo ValidarExistencia(String sDescripcion,String sModelo) throws Throwable
    {
        WebResponse wr = new WebResponse();
        VentasDAL objVentasDal = new VentasDAL();
        CArticulo objArticulo = new CArticulo();
        
        objArticulo = objVentasDal.ValidarExistencia(sDescripcion,sModelo);
        
        return objArticulo;
    }
    
    public int ObtenerFolioVenta() throws Throwable
    {
        WebResponse wr = new WebResponse();
        VentasDAL objVentasDal = new VentasDAL();
        int iFolioVenta = 0;
        
        iFolioVenta = objVentasDal.ObtenerFolioVenta();
        
        return iFolioVenta;
    }
    
    public Date ObtenerFecha() throws Throwable
    {
        WebResponse wr = new WebResponse();
        VentasDAL objVentasDal = new VentasDAL();
        Date dFecha;
        
        dFecha = objVentasDal.ObtenerFecha();
        
        return dFecha;
    }
    
    
    public ArrayList<CMostrarArticulo> MostrarArticulo(String sDescripcion,int iCantidad) throws Throwable
    {
        WebResponse wr = new WebResponse();
        VentasDAL objVentasDal = new VentasDAL();
        ArrayList<CMostrarArticulo> lArticulos = new ArrayList<>();
        
        lArticulos = objVentasDal.MostrarArticulo(sDescripcion,iCantidad);
        
        return lArticulos;
    }
    
     public CTotales CalcularTotales(int iImporte) throws Throwable
    {
        WebResponse wr = new WebResponse();
        VentasDAL objVentasDal = new VentasDAL();
        CTotales objTotales = new CTotales();
        
        objTotales = objVentasDal.CalcularTotales(iImporte);
        
        return objTotales;
    }
     
    public ArrayList<CAbonos> CalcularAbonos(int iTotalAdeudo) throws Throwable
    {
        WebResponse wr = new WebResponse();
        VentasDAL objVentasDal = new VentasDAL();
         ArrayList<CAbonos> lAbonos = new ArrayList<>();
        
        lAbonos = objVentasDal.CalcularAbonos(iTotalAdeudo);
        
        return lAbonos;
    }
    
     public int GrabarVenta(int iFolioVenta,int iClave,String sNombre,int iTotal,String sFecha,String sEstatus) throws Throwable
    {
        WebResponse wr = new WebResponse();
        VentasDAL objVentasDal = new VentasDAL();
        int iEjecuto = 0;
        
        iEjecuto = objVentasDal.GrabarVenta(iFolioVenta,iClave,sNombre,iTotal,sFecha,sEstatus);
        
        return iEjecuto;
    }


}
