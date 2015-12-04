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
    
    public Long     lngIdPais;
    public String   strPais;
    
    public void leerPais(String strGrupo){
        String strConsulta;
        String datos[]=new String [12];
        
        strConsulta="call PA_LeerPais ("+strGrupo
                + ");";
     
      
        try{
         
         ps= con.conectado().prepareStatement(strConsulta);
         res = ps.executeQuery();
         
         while(res.next()){
              this.lngIdPais=res.getLong("idPais");
              this.strPais=res.getNString("NombrePais");

                      
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
      
        strConsulta="call PA_LeeGruposUsuarios("+intDesde+","+intCuantos+",'"+strBusqueda+"');";
      
        try{
         
         ps= con.conectado().prepareStatement(strConsulta);
         res = ps.executeQuery();
         
         while(res.next()){
              //System.out.println(res.getString("Nombres"));
              datos[0]=res.getString("idPais");
              datos[1]=res.getString("nombrePais");
             
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
        strConsulta="call PA_CuantosPaises('" +strBusqueda +"');";
      
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
    
    public boolean actualizarGrupo() throws SQLException
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
    
    
    public boolean ingresarGrupo() throws SQLException
    {               
         String strConsulta="";
         String strRespuesta="";
         
         strConsulta=strConsulta +"call PA_InsertaPais ('"+this.strPais+"'"
                 + ");";
         ps= con.conectado().prepareStatement(strConsulta);
         
         strRespuesta= herramientas.globales.strPreguntaSiNo("Desea agregar el grupo " + this.strPais);
         if (strRespuesta=="SI"){
            res = ps.executeQuery();
         }
         
         System.out.println(strConsulta);
         return true;
    }
}

    

