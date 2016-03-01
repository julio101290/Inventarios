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
         
         strConsulta=","
                 + "'"  + strConsulta +"call PA_InsertaEstado ('"
                 + ""+this.strCiudad+"'"
                 + ",'" + this.Direccion + "'"
                 + ",'" + this.Estado + "',?," 
            
                 + ",'" + this.Nombre + "'"
                 + ",'" + this.Pais + "'s"
                 + ",'" + this.RazonSocial + "'"
                 + ",'" + this.RFC + "'"
                 + ",'" + this.Telefono + "'"
                 
                 + ");";
         ps.setBinaryStream(5, fLogo);
         ps= con.conectado().prepareStatement(strConsulta);
         
         strRespuesta= herramientas.globales.strPreguntaSiNo("Desea agregar la empresa " + this.Nombre);
         if (strRespuesta=="SI"){
            res = ps.executeQuery();
         }
         
         System.out.println(strConsulta);
         return true;
    }

}
    

