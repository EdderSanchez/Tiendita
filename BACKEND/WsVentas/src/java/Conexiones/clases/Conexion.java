/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Conexiones.clases;

import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author ycalderonn
 */
public class Conexion 
{
    Connection Conexion;
    boolean Ejecucion;
    String Mensaje;
    
    public Conexion()
    {
        Conexion = null;
        Ejecucion = false;
        Mensaje = "";
    }
    
    public Connection getConexion() 
    {
        return Conexion;
    }

    public void setConexion(Connection Conexion) 
    {
        this.Conexion = Conexion;
    }

    public boolean isEjecucion() 
    {
        return Ejecucion;
    }

    public void setEjecucion(boolean Ejecucion)
    {
        this.Ejecucion = Ejecucion;
    }

    public String getMensaje() 
    {
        return Mensaje;
    }

    public void setMensaje(String Mensaje)
    {
        this.Mensaje = Mensaje;
    }
}
