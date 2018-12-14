/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Conexiones.clases;

/**
 *
 * @author ycalderonn
 */
public class DatosConexion 
{
    String Usuario, Password, BaseDatos, Contrasena, Mensaje, Servidor;
    boolean EstadoEjecucion;
    public DatosConexion()
    {
        
        Usuario = "";
        Password = "";
        BaseDatos = "";
        Contrasena = "";
        Mensaje = "";
        Servidor = "";
        EstadoEjecucion = false;
        
    }

    public String getServidor() 
    {
        return Servidor;
    }

    public void setServidor(String Servidor) 
    {
        this.Servidor = Servidor;
    }

    public String getMensaje() 
    {
        return Mensaje;
    }

    public void setMensaje(String Mensaje)
    {
        this.Mensaje = Mensaje;
    }

    public boolean isEstadoEjecucion() 
    {
        return EstadoEjecucion;
    }

    public void setEstadoEjecucion(boolean EstadoEjecucion) 
    {
        this.EstadoEjecucion = EstadoEjecucion;
    }
    
    public String getUsuario() 
    {
        return Usuario;
    }

    public void setUsuario(String Usuario)
    {
        this.Usuario = Usuario;
    }

    public String getPassword()
    {
        return Password;
    }

    public void setPassword(String Password)
    {
        this.Password = Password;
    }

    public String getBaseDatos() 
    {
        return BaseDatos;
    }

    public void setBaseDatos(String BaseDatos)
    {
        this.BaseDatos = BaseDatos;
    }

    public String getContrasena()
    {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) 
    {
        this.Contrasena = Contrasena;
    }    
}
