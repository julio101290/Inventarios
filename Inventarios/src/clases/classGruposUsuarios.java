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

public class classGruposUsuarios {
    private conexion con;
    PreparedStatement ps;
    ResultSet res;
    
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
    
}
