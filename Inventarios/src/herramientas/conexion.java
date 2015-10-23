/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;
import java.sql.*;
import javax.swing.JOptionPane;

public class conexion {

   
   public static String strServidor= new String();
   public static String strBaseDeDatos=new String();
   public static String strUsuarioSQL=new String();
   public static String strPSWSQL=new String();
   Connection conexion= null;
        
 
  
    public Connection conectado(){
       try{  

         Class.forName("com.mysql.jdbc.Driver");
        
         conexion = DriverManager.getConnection("jdbc:mysql://"+ this.strServidor +"/" +this.strBaseDeDatos + "?user="+this.strUsuarioSQL + "&password="+ this.strPSWSQL);
         Statement stm = conexion.createStatement();
      }
         catch(SQLException e)
         {
         
             JOptionPane.showMessageDialog(null, "ERROR DE CONEXIÓN"+e);
            
         }
         catch(ClassNotFoundException e)
         {
          JOptionPane.showMessageDialog(null, e);
         }
        return conexion;
}

    public void desconectar(){
      conexion = null;
      System.out.println("conexion terminada");

    } 

    
}
