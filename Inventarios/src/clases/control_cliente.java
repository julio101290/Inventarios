/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

    
  
/**
 *
 * @author ANDRES
 */
public class control_cliente  {
private Sentencias_sql sql; 
public String strNombre;
public String strApellido;
public String strLugarNacimiento;
public String strCiudad;
public String strDomicilio;
public String strCodigoPostal;
public String strEstado;
public String strMunicipio;
public String strRFC;
public String strTelefono;
public String strFechaNacimiento;

       

    public control_cliente() {
        
        sql = new Sentencias_sql();
    }   
    
        
   
    public boolean ingresar_cliente()
    {               
         String strSQL="";
         strSQL=strSQL +"call sp_InsertaCliente ('"+this.strNombre+"'"
                 + ",'"+strApellido+"','"+strDomicilio+"','"+strCiudad+"','" +strTelefono+"',"
                 + "'"+strRFC+"','"+strFechaNacimiento+"','"+strEstado+"','"
                 +strMunicipio+"','"+strCodigoPostal+"');";
         System.out.println(strSQL);
         sql.ejecutarQuery(strSQL);
         System.out.println(strSQL);
         return true;
    }
    
    public Object[][] consulta_clientes(){
        String[] columnas={"IdCliente","Nombres","Apellidos","Direccion","Ciudad","Telefono","RFC"};
        Object[][] datos = sql.GetTabla(columnas, "Clientes", "select idCliente,Nombres,Apellidos,Direccion,Ciudad,Telefono, RFC from Clientes;");
        return datos;
    }
     
    
    
}