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
public class classArticulos {
    private conexion con;
    PreparedStatement ps;
    ResultSet res;
    private Sentencias_sql sql; 
    
    public long lngIdArticulo;
    public String strDescripcion;
    public String strTipo;
    public double dblIVA ;
    public double dblIEPS;
    public double dblPrecioCosto;
    public double dblPrecioVenta;
    
    
    public classArticulos(){
        sql = new Sentencias_sql();
        con = new conexion();
    }
    
     public void leerArticulo(String strArticulo){
        String strConsulta;
        String datos[]=new String [12];
        
        strConsulta="call PA_LeeArticulo ("+strArticulo
                + ");";
     
      
        try{
         
         ps= con.conectado().prepareStatement(strConsulta);
         res = ps.executeQuery();
         
         while(res.next()){
              this.lngIdArticulo=Long.valueOf(res.getString("idArticulo"));
              this.strDescripcion=res.getString("Descripcion");
              this.strTipo=res.getString("Tipo");
              this.dblIVA=res.getDouble("IVA");
              this.dblIEPS=res.getDouble("IEPS");
              this.dblPrecioCosto=res.getDouble("PrecioCosto");
              this.dblPrecioVenta=res.getDouble("PrecioVenta");
                      
              res.close();
              
              
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
 
     
          }
        }
    
     public void leerArticulos(long intDesde ,long intCuantos,DefaultTableModel tablaArticulos,String strBusqueda ){
        String strConsulta;
        String datos[]=new String [7];
      
        strConsulta="CALL PA_LeeArticulos ("+intDesde+","+intCuantos+",'"+strBusqueda+"');";
      
        try{
         
         ps= con.conectado().prepareStatement(strConsulta);
         res = ps.executeQuery();
         
         while(res.next()){
              //System.out.println(res.getString("Nombres"));
              
              datos[0]=res.getString("idArticulo");
              datos[1]=res.getString("Descripcion");
              datos[2]=res.getString("Tipo");
              datos[3]=res.getString("IEPS");
              datos[4]=res.getString("IVA");
              datos[5]=res.getString("PrecioCosto");
              datos[6]=res.getString("PrecioVenta");
             
              tablaArticulos.addRow(datos);
         }
            res.close();
            }catch(SQLException e){
        
          JOptionPane.showInternalMessageDialog(null,"ERROR" + e.toString());
        }
        
    
        
    }
    public boolean ingresarArticulo() throws SQLException
    {               
         String strConsulta="";
         String strRespuesta="";
         
         strConsulta=strConsulta +"call PA_InsertaArticulo('"+this.strDescripcion+"'"
                 + ",'" + this.strTipo + "'"
                 + ",'" + this.dblIEPS + "'"
                 + ",'" + this.dblIVA + "'"
                 + ",'" + this.dblPrecioCosto + "'"
                 + ",'" + this.dblPrecioVenta + "'"
                 + ");";
         ps= con.conectado().prepareStatement(strConsulta);
         
         strRespuesta= herramientas.globales.strPreguntaSiNo("Desea agregar el articulo " + this.strDescripcion);
         if (strRespuesta=="SI"){
            res = ps.executeQuery();
         }
         
         System.out.println(strConsulta);
         return true;
    }
    
     public boolean actualizarArticulo() throws SQLException
    {               
         String strConsulta="";
         String strRespuesta="";
         
         strConsulta=strConsulta +"call PA_ActualizaArticulo  ("+this.lngIdArticulo+",'"
                 + this.strDescripcion + "'" 
                 + ",'" + this.strTipo + "'"
                 + ",'" + this.dblIEPS + "'"
                 + ",'" + this.dblIVA + "'"
                 + ",'" + this.dblPrecioCosto + "'"
                 + ",'" + this.dblPrecioVenta + "'"
                 + ");";

       ps= con.conectado().prepareStatement(strConsulta);
         
         strRespuesta= herramientas.globales.strPreguntaSiNo("Desea actualizar el pais con ID " + this.lngIdArticulo);
         if (strRespuesta=="SI"){
            res = ps.executeQuery();
         }
         
         System.out.println(strConsulta);
         return true;
    }
     
       public boolean eliminarArticulo() throws SQLException
    {               
         String strConsulta="";
         String strRespuesta="";
         
         strConsulta=strConsulta +"call PA_EliminarArticulo  ('"+this.lngIdArticulo+"');";
         ps= con.conectado().prepareStatement(strConsulta);
         
         strRespuesta= herramientas.globales.strPreguntaSiNo("Desea eliminar el articulo " + this.strDescripcion);
         if (strRespuesta=="SI"){
            res = ps.executeQuery();
         }
         
         System.out.println(strConsulta);
         return true;
    }
       
    
    public long leerCuantos(String strBusqueda){
        String strConsulta;
        long cuantos = 0;
        strConsulta="call PA_LeeCuantosArticulos('" +strBusqueda +"');";
      
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
