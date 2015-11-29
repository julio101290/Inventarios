/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import herramientas.conexion;
import java.sql.*;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

    
  
/**
 *
 * @author ANDRES
 */
public class classUsuario  {
private Sentencias_sql sql; 
public Long lngIDUsuario;
public String strUsuario;
public String strNombre;
public String strContraseña;
public String strContraseña2;
public String strGrupoUsuario;


private conexion con;
PreparedStatement ps;
ResultSet res;
       

    public classUsuario() {
        
        sql = new Sentencias_sql();
        con = new conexion();
    }   
    
    
   
    public boolean ingresar_usuario()
    {               
         String strSQL="";
         strSQL=strSQL +"call PA_InsertaUsuario  ('"+this.strNombre+"'"
                 + ",'"+this.strContraseña+"',"+this.strGrupoUsuario+",'"
                 + this.strNombre + "');";
         System.out.println(strSQL);
         sql.ejecutarQuery(strSQL);
         System.out.println(strSQL);
         return true;
    }
    
        public boolean actualizar_usuario()
    {               
         String strSQL="";
         strSQL=strSQL +"CALL PA_ActualizarUsuario('"+this.strUsuario+"','" +this.strContraseña+"'"
                 + ","+this.strGrupoUsuario+",'"+this.strNombre+"');";
         System.out.println(strSQL);
         sql.ejecutarQuery(strSQL);
         System.out.println(strSQL);
         return true;
    }
        
        
    public boolean eliminar_usuario()
    {               
         String strSQL="";
         strSQL=strSQL +"CALL `PA_EliminarUsuario`('"+this.strUsuario+"');";
         System.out.println(strSQL);
         sql.ejecutarQuery(strSQL);
         System.out.println(strSQL);
         return true;
    }
    
  
     
    public void leerUsuarios(long intDesde ,long intCuantos,DefaultTableModel tablaClientes,String strBusqueda ){
        String strConsulta;
        String datos[]=new String [6];
        DecimalFormat formato = new DecimalFormat("0000");
        strConsulta="call PA_LeeUsuarios("+intDesde+","+intCuantos+",'"+strBusqueda+"');";
      
        try{
         
         ps= con.conectado().prepareStatement(strConsulta);
         res = ps.executeQuery();
         
         while(res.next()){
              //System.out.println(res.getString("Nombres"));
              datos[0]=res.getString("IdUsuario");
              datos[1]=res.getString("Usuario");
              datos[2]=res.getString("Contra");
              datos[3]=formato.format(res.getBigDecimal("idGrupo")) +" "+ res.getString("grupo");
              datos[4]=res.getString("Nombre");
              
              tablaClientes.addRow(datos);
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
        
    }
        
}
    
    public String[] leerUsuario(String strUsuario){
        String strConsulta;
        String datos[]=new String [6];
        DecimalFormat formato = new DecimalFormat("0000");
        
        strConsulta="call PA_LeeUsuario('"+strUsuario+"');";
     
      
        try{
         
         ps= con.conectado().prepareStatement(strConsulta);
         res = ps.executeQuery();
         
         while(res.next()){
              //System.out.println(res.getString("Nombres"));
              datos[0]=res.getString("IdUsuario");
              datos[1]=res.getString("Usuario");
              datos[2]=res.getString("Contra");
              datos[3]=formato.format(res.getBigDecimal("idGrupo"))+" "+res.getString("Grupo");
              datos[4]=res.getString("Nombre");
              datos[5]=res.getString("idGrupo");
           
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
        strConsulta="call PA_CuantosUsuarios('" +strBusqueda +"');";
      
        try{
         
         ps= con.conectado().prepareStatement(strConsulta);
         res = ps.executeQuery();
          System.out.println(strConsulta);
         while(res.next()){
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


  public boolean blnChecaUsuarioContra( String sql){
        boolean data =false;
        String idUsuarios="IdUsuarios";
        
      try{
         
         ps= con.conectado().prepareStatement(sql);
         res = ps.executeQuery();
         
         while(res.next()){
              //System.out.println(res.getNString(idUsuarios));
              data=true;
              System.out.println(res.getWarnings());
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
        
    }
       
        return data;
        
    }
    
}


    


    
    
    
    
