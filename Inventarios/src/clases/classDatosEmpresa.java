/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import herramientas.conexion;
import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author julioc
 */
public class classDatosEmpresa {
   
    private conexion con;
    PreparedStatement ps;
    ResultSet res;
    
    public String strCiudad;
    public String Direccion;
    public String Estado;
    public File Logo;
    public FileInputStream fLogo;
    public String Nombre;
    public String Pais;
    public String RazonSocial;
    public String RFC;
    public String Telefono;
    
    private Sentencias_sql sql; 
    public classDatosEmpresa() {
    sql = new Sentencias_sql();
    con = new conexion();
    
}
        public boolean ingresarDatosEmpresa() throws SQLException
    {               
         
           
        
         String strConsulta="";
       
         
         String strRespuesta="";
         
         strConsulta="call PA_DATOSEMPRESA ('"
                 + this.Direccion + "'"
                 + ",'" + this.Estado + "'"
                 + ",'" + this.Nombre + "'"
                 + ",'" + this.Pais + "'"
                 + ",'" + this.RazonSocial + "'"
                 + ",'" + this.RFC + "'"
                 + ",'" + this.Telefono + "'" 
                 + ",'" + this.strCiudad + "'"
                 + ");";

         ps= con.conectado().prepareStatement(strConsulta);
         
         strRespuesta= herramientas.globales.strPreguntaSiNo("Desea agregar la empresa " + this.Nombre);
         if (strRespuesta=="SI"){
            res = ps.executeQuery();
         }
         
         System.out.println(strConsulta);
         return true;
    }
        
     public boolean EliminarEmpresa() throws SQLException
    {               
         
           
        
         String strConsulta="";
       
         
         String strRespuesta="";
         
         strConsulta="call PA_ELIMINADATOSEMPRESA;";

         ps= con.conectado().prepareStatement(strConsulta);
         
        try{ 
            res = ps.executeQuery();
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR " + ex.toString());
        } 
         
         System.out.println(strConsulta);
         return true;
    }
     
     
     public void leerEmpresa(){
        String strConsulta;
        String datos[]=new String [4];
      
        strConsulta="CALL PA_LEEDATOSEMPRESA();";
      
        try{
         
         ps= con.conectado().prepareStatement(strConsulta);
         res = ps.executeQuery();
         
         while(res.next()){
              this.strCiudad=res.getString("Ciudad");
              this.Direccion=res.getString("Direccion");
              this.Estado=res.getString("Estado");
              this.Nombre=res.getString("Nombre");
              this.Pais=res.getString("Pais");
              this.RazonSocial=res.getString("RazonSocial");
              this.RFC=res.getString("RFC");
              this.Telefono=res.getString("Telefono");
        
         }
            res.close();
            }catch(SQLException e){
         JOptionPane.showMessageDialog(null, "ERROR AL LEER LA EMPRESA " + e.toString());
        }
     }

}
    

