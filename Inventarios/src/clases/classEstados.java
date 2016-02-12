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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author julio
 */

public class classEstados {
    
    private conexion con;
    PreparedStatement ps;
    ResultSet res;
    private Sentencias_sql sql; 
    
    public Long     lngIdEstado;
    public String   StrPais;
    public String   strEstado;
    

    
    public classEstados(){
        sql = new Sentencias_sql();
        con = new conexion();
}
    public void leerEstado(String strEstado,String strPais){
        String strConsulta;
        String datos[]=new String [5];
        DecimalFormat formato = new DecimalFormat("0000");
        strConsulta="call PA_LeeEstado ("+strPais
                + ","+strEstado+");";
      
      
        try{
         
         ps= con.conectado().prepareStatement(strConsulta);
         res = ps.executeQuery();
         
         while(res.next()){
              this.lngIdEstado=Long.valueOf(res.getString("idEstado"));
              this.strEstado=res.getString("Descripcion");
              this.StrPais=formato.format(res.getBigDecimal("idPais"))+" "+res.getString("NombrePais");
                      
              res.close();
              
              
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
 
     
          }
        }
    
    public void leerEstados(long intDesde ,long intCuantos,DefaultTableModel tablaEstadoes,String strBusqueda,long lngPais ){
        String strConsulta;
        String datos[]=new String [4];
      
        strConsulta="call PA_LeeEstados ("+intDesde+","+intCuantos+",'"+strBusqueda+"',"+lngPais+");";
      
        try{
         
         ps= con.conectado().prepareStatement(strConsulta);
         res = ps.executeQuery();
         
         while(res.next()){
              //System.out.println(res.getString("Nombres"));
              datos[0]=res.getString("idPais");
              datos[1]=res.getString("idEstado");
              datos[2]=res.getString("Descripcion");
             
              tablaEstadoes.addRow(datos);
         }
            res.close();
            }catch(SQLException e){
         System.out.println(e);
        }
        
    
        
    }
    
    public long leerCuantos(String strBusqueda,String strPais){
        String strConsulta;
        long cuantos = 0;
        strConsulta="call PA_LeeCuantosEstados('" +strBusqueda +"'"
                + ",'"+ strPais + "');";
      
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
    
    public boolean eliminarEstado() throws SQLException
    {               
         String strConsulta="";
         String strRespuesta="";
         
         strConsulta=strConsulta +"call PA_EliminaEstado   ('"+this.lngIdEstado+"','"+Long.valueOf(this.StrPais)+"');";
         ps= con.conectado().prepareStatement(strConsulta);
         
         strRespuesta= herramientas.globales.strPreguntaSiNo("Desea eliminar el estado con ID " + this.lngIdEstado);
         if (strRespuesta=="SI"){
            res = ps.executeQuery();
         }
         
         System.out.println(strConsulta);
         return true;
    }
    
    public boolean actualizarEstado() throws SQLException
    {               
         String strConsulta="";
         String strRespuesta="";
         
         strConsulta=strConsulta +"call PA_ActualizaEstado  ("+this.lngIdEstado+",'"+ this.StrPais 
                 + "','" + this.strEstado
                 + "');";
      
        
       ps= con.conectado().prepareStatement(strConsulta);
         
         strRespuesta= herramientas.globales.strPreguntaSiNo("Desea actualizar el estado con ID " + this.lngIdEstado);
         if (strRespuesta=="SI"){
            res = ps.executeQuery();
            return true;
         }
         else{
         return false;
         }
         //System.out.println(strConsulta);
    }
    
    
    public boolean ingresarEstado() throws SQLException
    {               
         String strConsulta="";
         String strRespuesta="";
         
         strConsulta=strConsulta +"call PA_InsertaEstado ('"+this.strEstado+"'"
                 + ",'" + this.StrPais + "'"
                 
                 + ");";
         ps= con.conectado().prepareStatement(strConsulta);
         
         strRespuesta= herramientas.globales.strPreguntaSiNo("Desea agregar el estado " + this.strEstado);
         if (strRespuesta=="SI"){
            res = ps.executeQuery();
         }
         
         System.out.println(strConsulta);
         return true;
    }
}

    

