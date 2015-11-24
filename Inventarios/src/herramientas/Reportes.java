/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import java.io.File;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author julio
 */
public class Reportes {
    File theFile ;
   
    //http://www.javamexico.org/foros/java_standard_edition/como_llamar_un_reporte
    public static void lanzarReporte(String strConsulta ,String strReporte)
            {
                conexion con;
                con = new conexion();
                try
                {  

                    String fileName = System.getProperty("user.dir").concat("/src/reportes/"+strReporte+".jrxml");
                   

                    if (fileName == null)
                    {                
                        System.out.println("No encuentro el archivo del reporte.");
                        System.exit(2);
                    }

                   
                   
                File theFile = new File(fileName);
                JRDesignQuery newQuery = new JRDesignQuery();
                JasperDesign jasperDesign = JRXmlLoader.load(theFile);
                newQuery.setText(strConsulta);
                jasperDesign.setQuery(newQuery);
               
                 JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
                 JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, con.conectado());
                 JasperViewer jviewer = new JasperViewer(jasperPrint,false);
                 jviewer.setTitle("Sistema de gestión de Cartera");
                 jviewer.setVisible(true);
                   con.desconectar();
                }

                catch (Exception j)
                {
                    System.out.println("Mensaje de Error:"+j.getMessage());
                }
               
            }


              
               
            }
           
            


    

