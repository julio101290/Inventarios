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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author julio
 */

public class classPaises {
    
    private conexion con;
    PreparedStatement ps;
    ResultSet res;
    private Sentencias_sql sql; 
    
    public Long     lngIdPais;
    public String   strPais;
    

    
    public classPaises(){
        sql = new Sentencias_sql();
        con = new conexion();
}
    public void leerPais(String strPais){
        String strConsulta;
        String datos[]=new String [12];
        
        strConsulta="call PA_LeerPais ("+strPais
                + ");";
     
      
        try{
         
         ps= con.conectado().prepareStatement(strConsulta);
         res = ps.executeQuery();
         
         while(res.next()){
              this.lngIdPais=Long.valueOf(res.getString("idPais"));
              this.strPais=res.getString("Descripcion");

                      
              res.close();
              
              
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
 
     
          }
        }
    
    public void leerPaises(long intDesde ,long intCuantos,DefaultTableModel tablaPaises,String strBusqueda ){
        String strConsulta;
        String datos[]=new String [4];
      
        strConsulta="call PA_LeePaises ("+intDesde+","+intCuantos+",'"+strBusqueda+"');";
      
        try{
         
         ps= con.conectado().prepareStatement(strConsulta);
         res = ps.executeQuery();
         
         while(res.next()){
              //System.out.println(res.getString("Nombres"));
              datos[0]=res.getString("idPais");
              datos[1]=res.getString("Descripcion");
             
              tablaPaises.addRow(datos);
         }
            res.close();
            }catch(SQLException e){
         System.out.println(e);
        }
        
    
        
    }
    
    public long leerCuantos(String strBusqueda){
        String strConsulta;
        long cuantos = 0;
        strConsulta="call PA_LeeCuantosPaises('" +strBusqueda +"');";
      
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
    
    public boolean eliminarPais() throws SQLException
    {               
         String strConsulta="";
         String strRespuesta="";
         
         strConsulta=strConsulta +"call PA_EliminarPais  ('"+this.lngIdPais+"');";
         ps= con.conectado().prepareStatement(strConsulta);
         
         strRespuesta= herramientas.globales.strPreguntaSiNo("Desea eliminar el pais con ID " + this.strPais);
         if (strRespuesta=="SI"){
            res = ps.executeQuery();
         }
         
         System.out.println(strConsulta);
         return true;
    }
    
    public boolean actualizarPais() throws SQLException
    {               
         String strConsulta="";
         String strRespuesta="";
         
         strConsulta=strConsulta +"call PA_ActualizarPais  ("+this.lngIdPais+",'"+ this.strPais 
    
                 + "');";
      
        
       ps= con.conectado().prepareStatement(strConsulta);
         
         strRespuesta= herramientas.globales.strPreguntaSiNo("Desea actualizar el pais con ID " + this.lngIdPais);
         if (strRespuesta=="SI"){
            res = ps.executeQuery();
         }
         
         System.out.println(strConsulta);
         return true;
    }
    
    
    public boolean ingresarPais() throws SQLException
    {               
         String strConsulta="";
         String strRespuesta="";
         
         strConsulta=strConsulta +"call PA_InsertaPais ('"+this.strPais+"'"
                 + ");";
         ps= con.conectado().prepareStatement(strConsulta);
         
         strRespuesta= herramientas.globales.strPreguntaSiNo("Desea agregar el pais " + this.strPais);
         if (strRespuesta=="SI"){
            res = ps.executeQuery();
         }
         
         System.out.println(strConsulta);
         return true;
    }
}

    

