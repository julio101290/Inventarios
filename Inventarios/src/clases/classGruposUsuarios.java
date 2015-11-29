/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import herramientas.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author julio
 */


public class classGruposUsuarios {
    private conexion con;
   
    PreparedStatement ps;
    ResultSet res;
    
    public String strDescripcion;
    public long lngIDGrupo;
    
    public classGruposUsuarios(){
    con = new conexion();
}
    public void leerGrupos(long intDesde ,long intCuantos,DefaultTableModel tablaClientes,String strBusqueda ){
        String strConsulta;
        String datos[]=new String [4];
      
        strConsulta="call PA_LeeGruposUsuarios("+intDesde+","+intCuantos+",'"+strBusqueda+"');";
      
        try{
         
         ps= con.conectado().prepareStatement(strConsulta);
         res = ps.executeQuery();
         
         while(res.next()){
              //System.out.println(res.getString("Nombres"));
              datos[0]=res.getString("IdGrupoUsuario");
              datos[1]=res.getString("Descripcion");
             
              tablaClientes.addRow(datos);
         }
            res.close();
            }catch(SQLException e){
         System.out.println(e);
        }
        
    
        
    }
    
    public void llenarCombo(JComboBox Combo){
        String strConsulta;
        String datos[]=new String [2];
        DecimalFormat formato = new DecimalFormat("0000");
        
        int intDesde=0;
        int intCuantos=1000;
        String strBusqueda="";
        strConsulta="call PA_LeeGruposUsuarios("+intDesde+","+intCuantos+",'"+strBusqueda+"');";
      
        try{
         
         ps= con.conectado().prepareStatement(strConsulta);
         res = ps.executeQuery();
         
         while(res.next()){
             
              datos[0]=formato.format( res.getDouble("IdGrupoUsuario")).toString();
              datos[1]=res.getString("Descripcion");
             
              
              Combo.addItem(datos[0] + " "+ datos[1]);
         }
            res.close();
            System.out.println(res.getWarnings());
            }catch(SQLException e){
         System.out.println(e);
        }
        
    }
    
    public long leerCuantos(String strBusqueda){
        String strConsulta;
        long cuantos = 0;
        strConsulta="call PA_CuantosGrupos('" +strBusqueda +"');";
      
        try{
         
         ps= con.conectado().prepareStatement(strConsulta);
         res = ps.executeQuery();
          System.out.println(strConsulta);
         while(res.next()){
              //System.out.println(res.getString("Nombres"));
              cuantos=Long.valueOf(res.getString("cuantos"));
       
              return cuantos;
              
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
         System.out.println(strConsulta);
         return cuantos;
          }
       System.out.println(strConsulta);
        return cuantos;
       
        }
    
        public boolean ingresarGrupo() throws SQLException
    {               
         String strConsulta="";
         String strRespuesta="";
         
         strConsulta=strConsulta +"call InsertaGrupoUsuario ('"+this.strDescripcion+"');";
         ps= con.conectado().prepareStatement(strConsulta);
         
         strRespuesta= herramientas.globales.strPreguntaSiNo("Desea agregar el grupo " + this.strDescripcion);
         if (strRespuesta=="SI"){
            res = ps.executeQuery();
         }
         
         System.out.println(strConsulta);
         return true;
    }
        
    public boolean eliminarGrupo() throws SQLException
    {               
         String strConsulta="";
         String strRespuesta="";
         
         strConsulta=strConsulta +"call PA_EliminarGrupo  ('"+this.lngIDGrupo+"');";
         ps= con.conectado().prepareStatement(strConsulta);
         
         strRespuesta= herramientas.globales.strPreguntaSiNo("Desea eliminar el grupo con ID " + this.lngIDGrupo);
         if (strRespuesta=="SI"){
            res = ps.executeQuery();
         }
         
         System.out.println(strConsulta);
         return true;
    }
    
       public boolean actualizarGrupo() throws SQLException
    {               
         String strConsulta="";
         String strRespuesta="";
         
         strConsulta=strConsulta +"call PA_ActualizarGrupo  ("+this.lngIDGrupo+",'"+ strDescripcion +"');";
         ps= con.conectado().prepareStatement(strConsulta);
         
         strRespuesta= herramientas.globales.strPreguntaSiNo("Desea actualizar el grupo con ID " + this.lngIDGrupo);
         if (strRespuesta=="SI"){
            res = ps.executeQuery();
         }
         
         System.out.println(strConsulta);
         return true;
    }
        
        public String[] leerGrupo(String strGrupo){
        String strConsulta;
        String datos[]=new String [12];
        
        strConsulta="call PA_LeerGrupoUsuario ("+strGrupo+");";
     
      
        try{
         
         ps= con.conectado().prepareStatement(strConsulta);
         res = ps.executeQuery();
         
         while(res.next()){
              //System.out.println(res.getString("Nombres"));
              datos[0]=res.getString("idGrupoUsuario");
              datos[1]=res.getString("Descripcion");
      
                      
              res.close();
              return datos;
              
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
 
         return datos;
          }
      
        return datos;
        }
}
