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
public class classMovimientosInventario {
    private conexion con;
    PreparedStatement ps;
    ResultSet res;
    private Sentencias_sql sql; 
    
    String strTipoMovimiento;
    long lngTipoFlujo;
    
    
    public classMovimientosInventario(){
        sql = new Sentencias_sql();
        con = new conexion();
    }
    
    public long lngUltimoFolio (String strTipoMovimiento,String strTipoFlujo,String strFolio){
        String strConsulta;
        String datos[]=new String [5];
        DecimalFormat formato = new DecimalFormat("0000");
        
        strConsulta="call PAL_UltimoFolioInventario ("+strTipoMovimiento
                 + ",'" + strTipoFlujo + "'"
                 + ",'" + strFolio + "'"
          
                 + ");";
             
        try{
         
         ps= con.conectado().prepareStatement(strConsulta);
         res = ps.executeQuery();
         
         while(res.next()){
              return  Long.valueOf(res.getString("idEstado"));              
         }
         res.close();
          }catch(SQLException e){
                System.out.println(e);
 
     
          }
        return 1;
    }   
}
