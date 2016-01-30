/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import clases.classGruposUsuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JComboBox;
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
    
    private static conexion con;
    private static PreparedStatement ps;
    private static ResultSet res;
    
            

    
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
    
    public static void llenarComboGlobal(JComboBox Combo,String strConsulta){
     
            
        con = new conexion();
        String datos[]=new String [2];
        DecimalFormat formato = new DecimalFormat("0000");
        
        int intDesde=0;
        int intCuantos=1000;
        String strBusqueda="";
        
      
        try{
         
         ps= con.conectado().prepareStatement(strConsulta);
         res = ps.executeQuery();
         
         while(res.next()){
             
              datos[0]=formato.format( res.getDouble(1));
              datos[1]=res.getString(2) ;
             
              
              Combo.addItem(datos[0] + " "+ datos[1]);
         }
            res.close();
            System.out.println(res.getWarnings());
            }catch(SQLException e){
         System.out.println(e);
        }
        
    }

}
