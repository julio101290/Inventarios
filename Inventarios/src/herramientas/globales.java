/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import clases.classGruposUsuarios;
import javax.swing.JOptionPane;

/**
 *
 * @author julio
 */
 public class globales {
    public static long     lngIDGrupo;
    public static long     lngIDUsuario;
    public static boolean  blnAccesoConfiguracion;
    public static boolean  blnAccesoGrupos;
    public static boolean  blnAccesoUsuarios;
    public static boolean  blnAccesoClientes;
    public static boolean  blnAccesoArticulos;
    public static boolean  blnAccesoInventarios;
            

    
    public static void obtenerDerechosGrupo(){
        classGruposUsuarios grupos = new classGruposUsuarios();
        grupos.leerGrupo(String.valueOf(lngIDGrupo));
        blnAccesoConfiguracion=grupos.blnAccesoConfiguracion;
        blnAccesoGrupos=grupos.blnAccesoGrupos;
        blnAccesoUsuarios=grupos.blnAccesoUsuarios;
        blnAccesoClientes=grupos.blnAccesoClientes;
        blnAccesoArticulos=grupos.blnAccesoArticulos;
        blnAccesoInventarios=grupos.blnAccesoInventarios;
        
        
    }
    
 
    public static String strPreguntaSiNo(String strMensaje){
        int seleccion = JOptionPane.showOptionDialog(
            null, // Componente padre
            strMensaje, //Mensaje
            "Seleccione una opción", // Título
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,    // null para icono por defecto.
            new Object[] { "Si", "No"},    // null para YES, NO y CANCEL
            "Si");
        
        if (seleccion != -1)
            {
                if((seleccion + 1)==1)
                    {
                    return "SI";
                    }
                else
                    {
                    return "NO";
                    }
            }
    return null;
    } 

}
