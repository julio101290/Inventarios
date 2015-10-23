/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.SQLException;
import herramientas.conexion.*;
import com.sun.crypto.provider.RSACipher;
import herramientas.conexion;
import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author julio
 */
public class classUsuarios {
    
    private conexion con;
    PreparedStatement ps;
    ResultSet res;

    public classUsuarios() {
        con = new conexion();
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
