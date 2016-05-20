/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author julioc
 */
import herramientas.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class classTiposFlujo {
    
    private conexion con;
    PreparedStatement ps;
    ResultSet res;
    private Sentencias_sql sql; 
    
    public long lngIdTipoFlujo;
    public String strDescripcion;
    public String strEntradaSalida;
    
    public classTiposFlujo(){
        sql = new Sentencias_sql();
        con = new conexion();
    }
    
    public void leerTipoFlujo(String strTipoFlujo){
        String strConsulta;
        String datos[]=new String [12];
        
        strConsulta="call PA_LeeTipoFlujo ("+strTipoFlujo
                + ");";
     
      
        try{
         
         ps= con.conectado().prepareStatement(strConsulta);
         res = ps.executeQuery();
         
         while(res.next()){
              this.lngIdTipoFlujo=Long.valueOf(res.getString("idTipoFlujo"));
              this.strDescripcion=res.getString("Descripcion");
              this.strEntradaSalida=res.getString("EntradaSalida");
              
                      
              res.close();
              
              
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
 
     
          }
        }
    
     public void leerTiposFlujos(long intDesde ,long intCuantos,DefaultTableModel tablaArticulos,String strBusqueda ){
        String strConsulta;
        String datos[]=new String [7];
      
        strConsulta="CALL PA_LeeTiposFlujos ("+intDesde+","+intCuantos+",'"+strBusqueda+"');";
      
        try{
         
         ps= con.conectado().prepareStatement(strConsulta);
         res = ps.executeQuery();
         
         while(res.next()){
              //System.out.println(res.getString("Nombres"));
              
              datos[0]=res.getString("idTipoFlujo");
              datos[1]=res.getString("Descripcion");
              datos[2]=res.getString("EntradaSalida");
          
             
              tablaArticulos.addRow(datos);
         }
            res.close();
            }catch(SQLException e){
        
          JOptionPane.showInternalMessageDialog(null,"ERROR" + e.toString());
        }
        
    
        
    }
     
     public boolean ingresarTipoFlujo() throws SQLException
    {               
         String strConsulta="";
         String strRespuesta="";
         
         strConsulta=strConsulta +"call PA_InsertaTipoFlujo('"+this.strDescripcion+"'"
                 + ",'" + this.strEntradaSalida  + "'"
        
                 + ");";
         ps= con.conectado().prepareStatement(strConsulta);
         
         strRespuesta= herramientas.globales.strPreguntaSiNo("Desea agregar el tipo flujo " + this.strDescripcion);
         if (strRespuesta=="SI"){
            res = ps.executeQuery();
         }
         
         System.out.println(strConsulta);
         return true;
    }
    
      public boolean actualizarTipoFlujo() throws SQLException
    {               
         String strConsulta="";
         String strRespuesta="";
         
         strConsulta=strConsulta +"call PA_ActualizaTipoFlujo  ("+this.lngIdTipoFlujo+",'"
                 + this.strDescripcion + "'" 
                 + ",'" + this.strEntradaSalida + "'"

                 + ");";

       ps= con.conectado().prepareStatement(strConsulta);
         
         strRespuesta= herramientas.globales.strPreguntaSiNo("Desea actualizar el tipo flujo de inventario " + this.strDescripcion);
         if (strRespuesta=="SI"){
            res = ps.executeQuery();
         }
         
         System.out.println(strConsulta);
         return true;
    }

public boolean eliminarTipoFlujo() throws SQLException
    {               
         String strConsulta="";
         String strRespuesta="";
         
         strConsulta=strConsulta +"call PA_EliminarTipoFlujo  ('"+this.lngIdTipoFlujo+"');";
         ps= con.conectado().prepareStatement(strConsulta);
         
         strRespuesta= herramientas.globales.strPreguntaSiNo("Desea eliminar el tipo flujo de inventario " + this.strDescripcion);
         if (strRespuesta=="SI"){
            res = ps.executeQuery();
         }
         
         System.out.println(strConsulta);
         return true;
    }
       
    
    public long leerCuantos(String strBusqueda){
        String strConsulta;
        long cuantos = 0;
        strConsulta="call PA_LeeCuantosTiposFlujos('" +strBusqueda +"');";
      
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


