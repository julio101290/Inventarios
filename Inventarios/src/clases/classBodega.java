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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author julioc
 */
public class classBodega {
private conexion con;
    PreparedStatement ps;
    ResultSet res;
    private Sentencias_sql sql; 
    
    public long lngIdBodega;
    public String strDescripcion;

    
    public classBodega(){
        sql = new Sentencias_sql();
        con = new conexion();
    }
    
      public void leerBodega(String strBodega){
        String strConsulta;
        String datos[]=new String [12];
        
        strConsulta="call PA_Leebodega ("+strBodega
                + ");";
     
      
        try{
         
         ps= con.conectado().prepareStatement(strConsulta);
         res = ps.executeQuery();
         
         while(res.next()){
              this.lngIdBodega=Long.valueOf(res.getString("idBodega"));
              this.strDescripcion=res.getString("Descripcion");
              datos[0]=res.getString("idBodega");
              datos[1]=res.getString("Descripcion");
                      
              res.close();
              
              
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
 
     
          }
        }
    public boolean ingresarBodega() throws SQLException
    {               
         String strConsulta="";
         String strRespuesta="";
         
         strConsulta=strConsulta +"call PA_InsertaBodega('"+this.strDescripcion+"'"
                 + ");";
         ps= con.conectado().prepareStatement(strConsulta);
         
         strRespuesta= herramientas.globales.strPreguntaSiNo("Desea agregar la bodega " + this.strDescripcion);
         if (strRespuesta=="SI"){
            res = ps.executeQuery();
         }
         
         System.out.println(strConsulta);
         return true;
    }
    
    public boolean actualizarBodega() throws SQLException
    {               
         String strConsulta="";
         String strRespuesta="";
         
         strConsulta=strConsulta +"call PA_ActualizaBodega  ("+this.lngIdBodega+",'"
                 + this.strDescripcion + "'" 
                 + ");";

       ps= con.conectado().prepareStatement(strConsulta);
         
         strRespuesta= herramientas.globales.strPreguntaSiNo("Desea actualizar la bodega " + this.strDescripcion);
         if (strRespuesta=="SI"){
            res = ps.executeQuery();
         }
         
         System.out.println(strConsulta);
         return true;
    }
    
    public boolean eliminarBodega() throws SQLException
    {               
         String strConsulta="";
         String strRespuesta="";
         
         strConsulta=strConsulta +"call PA_EliminarBodega  ('"+this.lngIdBodega+"');";
         ps= con.conectado().prepareStatement(strConsulta);
         
         strRespuesta= herramientas.globales.strPreguntaSiNo("Desea eliminar la bodega " + this.strDescripcion);
         if (strRespuesta=="SI"){
            res = ps.executeQuery();
         }
         
         System.out.println(strConsulta);
         return true;
    }
    
    public void leerBodegas(long intDesde ,long intCuantos,DefaultTableModel tablaBodegas,String strBusqueda ){
        String strConsulta;
        String datos[]=new String [3];
      
        strConsulta="CALL PA_LeeBodegas ("+intDesde+","+intCuantos+",'"+strBusqueda+"');";
      
        try{
         
         ps= con.conectado().prepareStatement(strConsulta);
         res = ps.executeQuery();
         
         while(res.next()){
              //System.out.println(res.getString("Nombres"));
              
              datos[0]=res.getString("idBodega");
              datos[1]=res.getString("Descripcion");
          
             
              tablaBodegas.addRow(datos);
         }
            res.close();
            }catch(SQLException e){
        
          JOptionPane.showInternalMessageDialog(null,"ERROR" + e.toString());
        }
        
    
        
    }
    
    public long leerCuantos(String strBusqueda){
        String strConsulta;
        long cuantos = 0;
        strConsulta="call PA_LeeCuantosBodegas('" +strBusqueda +"');";
      
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
       
     
}
