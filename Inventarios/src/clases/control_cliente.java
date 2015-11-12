/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import herramientas.conexion;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

    
  
/**
 *
 * @author ANDRES
 */
public class control_cliente  {
private Sentencias_sql sql; 
public String strCliente;
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
public java.util.Date Fecha = new java.util.Date();

private conexion con;
PreparedStatement ps;
ResultSet res;
       

    public control_cliente() {
        
        sql = new Sentencias_sql();
        con = new conexion();
    }   
    
        
   
    public boolean ingresar_cliente()
    {               
         String strSQL="";
         strSQL=strSQL +"call sp_InsertaCliente ('"+this.strNombre+"'"
                 + ",'"+strApellido+"','"+strDomicilio+"','"+strCiudad+"','" +strTelefono+"',"
                 + "'"+strRFC+"','"+strFechaNacimiento+"','"+strEstado+"','"
                 +strMunicipio+"','"+strCodigoPostal+"','"+this.strLugarNacimiento+"');";
         System.out.println(strSQL);
         sql.ejecutarQuery(strSQL);
         System.out.println(strSQL);
         return true;
    }
    
        public boolean actualizar_cliente()
    {               
         String strSQL="";
         strSQL=strSQL +"CALL `PA_ActualizaCliente`('"+this.strCliente+"','" +this.strNombre+"'"
                 + ",'"+strApellido+"','"+strCiudad+"','" +strTelefono+"',"
                 + "'"+strRFC+"','"+strFechaNacimiento+"','"+strEstado+"','"
                 +strMunicipio+"','"+strCodigoPostal+"','"+this.strLugarNacimiento+"','"+strDomicilio+"');";
         System.out.println(strSQL);
         sql.ejecutarQuery(strSQL);
         System.out.println(strSQL);
         return true;
    }
        
        
    public boolean eliminar_cliente()
    {               
         String strSQL="";
         strSQL=strSQL +"CALL `PA_EliminarCliente`('"+this.strCliente+"');";
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
     
    public void leerClientes(long intDesde ,long intCuantos,DefaultTableModel tablaClientes,String strBusqueda ){
        String strConsulta;
        String datos[]=new String [4];
       // strConsulta="call PA_LeeClientes(" + intDesde +"," +","+ intCuantos+")";
        strConsulta="call PA_LeeClientes("+intDesde+","+intCuantos+",'"+strBusqueda+"');";
      
        try{
         
         ps= con.conectado().prepareStatement(strConsulta);
         res = ps.executeQuery();
         
         while(res.next()){
              //System.out.println(res.getString("Nombres"));
              datos[0]=res.getString("IdCliente");
              datos[1]=res.getString("Nombres");
              datos[2]=res.getString("Apellidos");
              datos[3]=res.getString("RFC");
              
              tablaClientes.addRow(datos);
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
        
    }
        
}
    
    public String[] leerCliente(String strCliente){
        String strConsulta;
        String datos[]=new String [12];
        
        strConsulta="call PA_LeeCliente("+strCliente+");";
     
      
        try{
         
         ps= con.conectado().prepareStatement(strConsulta);
         res = ps.executeQuery();
         
         while(res.next()){
              //System.out.println(res.getString("Nombres"));
              datos[0]=res.getString("IdCliente");
              datos[1]=res.getString("Nombres");
              datos[2]=res.getString("Apellidos");
              datos[3]=res.getString("Direccion");
              datos[4]=res.getString("Ciudad");
              
              datos[5]=res.getString("Telefono");
              datos[6]=res.getString("RFC");
              //datos[7]=res.getString("FechaNacimiento");
               Fecha =        res.getDate("FechaNacimiento");
              datos[8]=res.getString("Estado");
              datos[9]=res.getString("Municipio");
             
              datos[10]=res.getString("CodigoPostal");
              datos[11]=res.getString("LugarNacimiento");
                      
              res.close();
              return datos;
              
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
 
         return datos;
          }
      
        return datos;
        }
    
    
public long leerCuantos(String strBusqueda){
        String strConsulta;
        long cuantos = 0;
        strConsulta="call PA_CuantosClientes('" +strBusqueda +"');";
      
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


    
    
    
    
