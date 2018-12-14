/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package VentasDAL;

import Conexiones.clases.Conexion;
import Conexiones.clases.DatosConexion;
import Entidades.CAbonos;
import Entidades.CArticulo;
import Entidades.CCliente;
import Entidades.CMostrarArticulo;
import Entidades.CTotales;
import Entidades.CVentas;
import Entidades.WebResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author Dell Inspiron EPF
 */
public class VentasDAL 
{
    
       public ArrayList<CVentas> ConsultarVentas( )
    {
        String sSql = new String();
        CVentas objVenta = new CVentas();
        WebResponse wr = new WebResponse();
        ArrayList<CVentas> lVentas = new ArrayList<>();
        
        ResultSet objResult = null;
        PreparedStatement objPstmt = null;
        Connection objConnTiendita = null;
                
        try
        {
            objConnTiendita = (Connection)AbrirConexionTiendita();
            
            sSql = "SELECT ifolioventa as folioventa,iclave as clave,cnombre as nombre,itotal as total,dfecha as fecha,cestatus as estatus from FUN_CONSULTARVENTAS()";
            
            objPstmt = objConnTiendita.prepareStatement(sSql); 
            objResult = objPstmt.executeQuery();
            
            while( objResult.next())
            {
               objVenta = new CVentas();
               objVenta.setFolio(objResult.getInt("folioventa"));
               objVenta.setClave(objResult.getInt("clave"));
               objVenta.setNombre(objResult.getString("nombre"));
               objVenta.setTotal(objResult.getInt("total"));
               objVenta.setFecha(objResult.getString("fecha"));
               objVenta.setEstatus(objResult.getString("estatus"));
               lVentas.add(objVenta);
            }
            
            wr.setData(lVentas);

        }
        catch(Exception ex)
        {
            
        }
       /* finally{
            objConnTiendita.close();
            objPstmt.close();
            objResult.close();
        }
        */
        return lVentas;
    }
   
        public ArrayList<CCliente> ConsultarCliente(String sNombreCliente ) throws Throwable
    {
        String sSql = new String();
        CCliente objCliente = new CCliente();
        WebResponse wr = new WebResponse();
        ArrayList<CCliente> lCliente = new ArrayList<>();
        
    ResultSet objResult = null;
    PreparedStatement objPstmt = null;
    Connection objConnTiendita = null;
                
        try
        {
            objConnTiendita = (Connection)AbrirConexionTiendita();
            
            sSql = "SELECT cnombre as nombre ,iclave as clave,irfc as rfc from FUN_CONSULTARNOMBRE(?)";
            
            objPstmt = objConnTiendita.prepareStatement(sSql); 
            objPstmt.setString(1, sNombreCliente);
            objResult = objPstmt.executeQuery();
            
            while( objResult.next())
            {
               objCliente = new CCliente();
               objCliente.setNombre(objResult.getString("nombre"));
               objCliente.setClave(objResult.getInt("clave"));
               objCliente.setRFC(objResult.getString("rfc"));
               lCliente.add(objCliente);
            }
            
            
        }
        catch(Exception ex)
        {
            
        }
        finally{
            objConnTiendita.close();
            objPstmt.close();
            objResult.close();
        }
        
        return lCliente;
    }
        
    public ArrayList<CArticulo> ConsultarArticulo(String sNombreArticulo ) throws Throwable
    {
        String sSql = new String();
        CArticulo objArticulo = new CArticulo();
        WebResponse wr = new WebResponse();
        ArrayList<CArticulo> lArticulo = new ArrayList<>();
        
    ResultSet objResult = null;
    PreparedStatement objPstmt = null;
    Connection objConnTiendita = null;
                
        try
        {
            objConnTiendita = (Connection)AbrirConexionTiendita();
            
            sSql = "SELECT cdescripcion as descripcion ,cmodelo as modelo,iexistencia as existencia,iprecio as precio from FUN_CONSULTARARTICULO(?)";
            
            objPstmt = objConnTiendita.prepareStatement(sSql); 
            objPstmt.setString(1, sNombreArticulo);
            objResult = objPstmt.executeQuery();
            
            while( objResult.next())
            {
               objArticulo = new CArticulo();
               objArticulo.setDescripcion(objResult.getString("descripcion"));
               objArticulo.setModelo(objResult.getString("modelo"));
               objArticulo.setExistencia(objResult.getInt("existencia"));
               objArticulo.setPrecio(objResult.getInt("precio"));
               lArticulo.add(objArticulo);
            }
          
        }
        catch(Exception ex)
        {
            
        }
        finally{
            objConnTiendita.close();
            objPstmt.close();
            objResult.close();
        }
        
        return lArticulo;
    }    
        
    public  CArticulo ValidarExistencia(String sDescripcion , String sModelo ) throws Throwable
    {
        String sSql = new String();
        CArticulo objArticulo = new CArticulo();
        WebResponse wr = new WebResponse();
        
        ResultSet objResult = null;
        PreparedStatement objPstmt = null;
        Connection objConnTiendita = null;
                
        try
        {
            objConnTiendita = (Connection)AbrirConexionTiendita();
            
            sSql = "SELECT cdescripcion as descripcion ,cmodelo as modelo,iexistencia as existencia,iprecio as precio from FUN_VALIDAREXISTENCIA(?,?)";
            
            objPstmt = objConnTiendita.prepareStatement(sSql); 
            objPstmt.setString(1, sDescripcion);
            objPstmt.setString(2, sModelo);
            objResult = objPstmt.executeQuery();
            
            if( objResult.next())
            {
               objArticulo.setDescripcion(objResult.getString("descripcion"));
               objArticulo.setModelo(objResult.getString("modelo"));
               objArticulo.setExistencia(objResult.getInt("existencia"));
               objArticulo.setPrecio(objResult.getInt("precio"));
            }
            
        }
        catch(Exception ex)
        {
            
        }
        finally{
            objConnTiendita.close();
            objPstmt.close();
            objResult.close();
        }
        
        return objArticulo;
    }  
    
    public int ObtenerFolioVenta() throws Throwable
    {
        String sSql = new String();
        WebResponse wr = new WebResponse();
        int iFolioVenta = 0;
        
        ResultSet objResult = null;
        PreparedStatement objPstmt = null;
        Connection objConnTiendita = null;
                
        try
        {
            objConnTiendita = (Connection)AbrirConexionTiendita();
            
            sSql = "SELECT ifolioventa as folioventa from FUN_CONSULTARFOLIOVENTA()";
            
            objPstmt = objConnTiendita.prepareStatement(sSql); 
            objResult = objPstmt.executeQuery();
            
            if( objResult.next())
            {
               iFolioVenta = objResult.getInt("folioventa");
            }
            
        }
        catch(Exception ex)
        {
            
        }
        finally{
            objConnTiendita.close();
            objPstmt.close();
            objResult.close();
        }
        
        return iFolioVenta;
    } 
    
    public Date ObtenerFecha() throws Throwable
    {
        String sSql = new String();
        WebResponse wr = new WebResponse();
        Date dFecha =new Date(0);
        
        ResultSet objResult = null;
        PreparedStatement objPstmt = null;
        Connection objConnTiendita = null;
                
        try
        {
            objConnTiendita = (Connection)AbrirConexionTiendita();
            
            sSql = "SELECT cfecha as fecha from FUN_CONSULTARFECHA()";
            
            objPstmt = objConnTiendita.prepareStatement(sSql); 
            objResult = objPstmt.executeQuery();
            
            if( objResult.next())
            {
               dFecha = objResult.getDate("fecha");
            }
            
        }
        catch(Exception ex)
        {
            
        }
        finally{
            objConnTiendita.close();
            objPstmt.close();
            objResult.close();
        }
        
        return dFecha;
    } 
    
    
     public ArrayList<CMostrarArticulo>  MostrarArticulo(String sDescripcion  ,int iCantidad ) throws Throwable
    {
        String sSql = new String();
        CMostrarArticulo objArticulo = new CMostrarArticulo();
       ArrayList<CMostrarArticulo> lArticulos = new ArrayList<>();
        WebResponse wr = new WebResponse();
        
        ResultSet objResult = null;
        PreparedStatement objPstmt = null;
        Connection objConnTiendita = null;
                
        try
        {
            objConnTiendita = (Connection)AbrirConexionTiendita();
            
            sSql = "SELECT cdescripcion as descripcion ,cmodelo as modelo,iprecioarticulo as precio,iimporte as importe from FUN_MOSTRARARTICULO(?,?)";
            
            objPstmt = objConnTiendita.prepareStatement(sSql); 
            objPstmt.setString(1, sDescripcion);
            objPstmt.setInt(2, iCantidad);
            objResult = objPstmt.executeQuery();
            
            if( objResult.next())
            {
               objArticulo = new CMostrarArticulo();
               objArticulo.setDescripcion(objResult.getString("descripcion"));
               objArticulo.setModelo(objResult.getString("modelo"));
               objArticulo.setCantidad(iCantidad);
               objArticulo.setImporte(objResult.getInt("importe"));
               objArticulo.setPrecio(objResult.getFloat("precio"));
               lArticulos.add(objArticulo);
            }
            
            
        }
        catch(Exception ex)
        {
            
        }
        finally{
            objConnTiendita.close();
            objPstmt.close();
            objResult.close();
        }
        
        return lArticulos;
    }  
     
      public CTotales CalcularTotales(int iImporte ) throws Throwable
    {
        String sSql = new String();
        CTotales objTotales = new CTotales();
        WebResponse wr = new WebResponse();
        
        ResultSet objResult = null;
        PreparedStatement objPstmt = null;
        Connection objConnTiendita = null;
                
        try
        {
            objConnTiendita = (Connection)AbrirConexionTiendita();
            
            sSql = "SELECT ienganche as enganche ,ibonificacionenganche as bonificacionenganche,itotaladeudo as totaladeudo from FUN_CALCULARTOTALES(?)";
            
            objPstmt = objConnTiendita.prepareStatement(sSql); 
            objPstmt.setInt(1, iImporte);
            objResult = objPstmt.executeQuery();
            
            if( objResult.next())
            {
               objTotales.setEnganche(objResult.getFloat("enganche"));
               objTotales.setBonificacionEnganche(objResult.getFloat("bonificacionenganche"));
               objTotales.setTotalAdeudo(objResult.getFloat("totaladeudo"));
            }
            
            
        }
        catch(Exception ex)
        {
            
        }
        finally{
            objConnTiendita.close();
            objPstmt.close();
            objResult.close();
        }
        
        return objTotales;
    }  
       
    public ArrayList<CAbonos> CalcularAbonos(int iTotalAdeudo ) throws Throwable
    {
        String sSql = new String();
        CAbonos objAbonos = new CAbonos();
        ArrayList<CAbonos> lAbonos = new ArrayList<>();
        WebResponse wr = new WebResponse();
        
        ResultSet objResult = null;
        PreparedStatement objPstmt = null;
        Connection objConnTiendita = null;
                
        try
        {
            objConnTiendita = (Connection)AbrirConexionTiendita();
            
            sSql = "SELECT imeses as meses,itotalpagar as totalpagar ,iimporteabono as importeabono,iimporteahorra as importeahorra"
                    + " from FUN_CALCULARABONOS(?)";
            
            objPstmt = objConnTiendita.prepareStatement(sSql); 
            objPstmt.setInt(1, iTotalAdeudo);
            objResult = objPstmt.executeQuery();
            
            while( objResult.next())
            {
               objAbonos = new CAbonos();
               objAbonos.setMeses(objResult.getInt("meses"));
               objAbonos.setTotalpagar(objResult.getFloat("totalpagar"));
               objAbonos.setImporteabono(objResult.getFloat("importeabono"));
               objAbonos.setImporteahorra(objResult.getFloat("importeahorra"));
               lAbonos.add(objAbonos);
            }
            
           
          
        }
        catch(Exception ex)
        {
            
        }
        finally{
            objConnTiendita.close();
            objPstmt.close();
            objResult.close();
        }
        
        return lAbonos;
    }  
    
     public int GrabarVenta(int iFolioVenta,int iClave,String sNombre,int iTotal,String sFecha,String sEstatus) throws Throwable
    {
        String sSql = new String();
        CTotales objTotales = new CTotales();
        WebResponse wr = new WebResponse();
        int iEjecuto = 0;
        
        ResultSet objResult = null;
        PreparedStatement objPstmt = null;
        Connection objConnTiendita = null;
                
        try
        {
            objConnTiendita = (Connection)AbrirConexionTiendita();
            
            sSql = "SELECT FUN_GRABARVENTA  FROM FUN_GRABARVENTA(?,?,?,?,?,?)";
            
            objPstmt = objConnTiendita.prepareStatement(sSql); 
            objPstmt.setInt(1, iFolioVenta);
            objPstmt.setInt(2, iClave);
            objPstmt.setString(3, sNombre);
            objPstmt.setInt(4, iTotal);
            objPstmt.setString(5, sFecha);
            objPstmt.setString(6, sEstatus);
            
            objResult = objPstmt.executeQuery();
            
            if( objResult.next())
            {
                iEjecuto = objResult.getShort("FUN_GRABARVENTA");
            }
            
         
            
        }
        catch(Exception ex)
        {
            
        }
        finally{
            objConnTiendita.close();
            objPstmt.close();
            objResult.close();
        }
        
        return iEjecuto;
    }  
        
     public static String getCharacterDataFromElement(Element e)
    {
        Node child = e.getFirstChild();
        if (child instanceof CharacterData)
        {
            CharacterData cd = (CharacterData) child;
            return cd.getData();
        }
        return "?";
    }
     
     
    
    public void cerrarConexion( Connection Conexion ) throws SQLException
    {
        
        if( Conexion != null )
        {
            Conexion.close();
        }
    }
    
    public boolean procesarTransaccion( Connection objConexion, int iTipoTransaccion ) throws SQLException
    {
        boolean bContinuar = false;
        switch( iTipoTransaccion )
        {
            case 1:
            {
                if( objConexion != null ) // Begin
                {
                    objConexion.setAutoCommit( false );
                    bContinuar = true;
                }
            }
            break;
            case 2:
            {
                if( objConexion != null )// Commit
                {
                    objConexion.commit();
                    bContinuar = true;
                }
            }
            break;
            case 3:
            {
                if( objConexion != null ) // Rollback
                {
                    objConexion.rollback();
                    bContinuar = true;
                }
            }
            break;
        }
        return bContinuar;
    }
    
    public DatosConexion ObtenerDatosConexionTiendita()
    {
        String sXmlRecords = "", sLinea = "", sMensajeLog = "";
        NodeList nodes = null;
        BufferedReader entrada = null;
        
        File objArchivoConfig = new File( "/usr/local/tomcat/webapps/ConfigTiendita/Tiendita.xml" );
        DatosConexion objRetorno = new DatosConexion();
        if( objArchivoConfig.exists() )
        {
            try 
            {
                entrada = new BufferedReader( new FileReader( objArchivoConfig ) );
                while( entrada.ready() )
                {
                    sLinea = entrada.readLine();
                    sXmlRecords += sLinea;
                }
                
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                InputSource is = new InputSource();
                is.setCharacterStream( new StringReader( sXmlRecords ) );
                Document doc = db.parse(is);
                nodes = doc.getElementsByTagName("config");
                Element info = null;
                Element element = (Element) nodes.item(0);
                NodeList dabase = element.getElementsByTagName("database");
                
                for (int i = 0; i < dabase.getLength(); i++)
                {
                    element = (Element) dabase.item(i);
                    NodeList ipservidor = element.getElementsByTagName("ipservidor");
                    info = ( Element ) ipservidor.item(0);
                    objRetorno.setServidor( getCharacterDataFromElement( info ).trim() );
                    
                    NodeList basedatos = element.getElementsByTagName("basedatos");
                    info = ( Element ) basedatos.item(0);
                    objRetorno.setBaseDatos( getCharacterDataFromElement( info ).trim() );
                   
                    NodeList usuario = element.getElementsByTagName("usuario");
                    info = ( Element ) usuario.item(0);
                    objRetorno.setUsuario( getCharacterDataFromElement( info ).trim() );
                    
                    NodeList password = element.getElementsByTagName("password");
                    info = ( Element ) password.item(0);
                    objRetorno.setContrasena( getCharacterDataFromElement( info ).trim() );
            
                }
                
                objRetorno.setEstadoEjecucion( true );
            } 
            catch ( IOException | ParserConfigurationException | SAXException ex )
            {
                objRetorno.setEstadoEjecucion( false );
                objRetorno.setMensaje( "Error: " + ex.getMessage() );
                
                
            }
            finally
            {
                try 
                {
                    entrada.close();
                } 
                catch (IOException ex) 
                {
                    objRetorno.setEstadoEjecucion( false );
                    objRetorno.setMensaje( "Error: " + ex.getMessage() );
                    
                }
            }
            
        }
        else
        {
            sMensajeLog = "No existe archivo de configuracion: ";
            
        }
        
        return objRetorno;
    }
    
    public Connection AbrirConexionTiendita()
    {
        String sDriver = "";
        Connection conexion = null;
        Conexion objConexion = new Conexion();
        DatosConexion objDatosConexion = null;
        
        
        try
        {
            objDatosConexion = ObtenerDatosConexionTiendita();
            
            if( objDatosConexion.isEstadoEjecucion() )
            {
                try
                {

                    sDriver = "postgresql://" + objDatosConexion.getServidor()+":5432"+"/"+objDatosConexion.getBaseDatos();
                    Class.forName("org.postgresql.Driver");	 
                    conexion = DriverManager.getConnection( "jdbc:" + sDriver, objDatosConexion.getUsuario(), objDatosConexion.getContrasena() );
                    objConexion.setConexion( conexion );
                    objConexion.setEjecucion( true );

                }
                catch( ClassNotFoundException | SQLException Ex )
                {
                    objConexion.setEjecucion( false );
                    objConexion.setMensaje( "Error:  "+ Ex.getMessage() );
                }

            }
            else
            {
                objConexion.setMensaje( objDatosConexion.getMensaje() );
                objConexion.setEjecucion( false );
            }
        }
        catch( Exception ex )
        {
            
        }
        
        return conexion;
        
    }
    
    
    public Connection EstablecerConexion( int iTipoManejador, DatosConexion objDatosConexion )
    {
        Connection conexion = null;
        String sDriver = "";
        
        try
        {
            switch( iTipoManejador )
            {
                case 1:
                {
                    sDriver = "postgresql://" + objDatosConexion.getServidor()+":5432"+"/"+objDatosConexion.getBaseDatos();
                    Class.forName("org.postgresql.Driver");	 
                    conexion = DriverManager.getConnection( "jdbc:" + sDriver, objDatosConexion.getUsuario(), objDatosConexion.getContrasena() );
                }
                break;
                case 2:
                {
                    sDriver = "sqlserver://" + objDatosConexion.getServidor()+":1433"+";databaseName="+objDatosConexion.getBaseDatos();
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    conexion = DriverManager.getConnection( "jdbc:" + sDriver, objDatosConexion.getUsuario(), objDatosConexion.getContrasena() );
                }
                break;
            }
        }
        catch( ClassNotFoundException | SQLException Ex)
        {
            
        }

        return conexion;
    }
    
}
