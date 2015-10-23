/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import clases.classUsuarios;
import herramientas.conexion;
import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.jar.Attributes;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import javax.xml.*;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



/**
 *
 * @author julio
 */
public class frmLogueo extends javax.swing.JFrame {

    /**
     * Creates new form frmLogueo
     */
    public frmLogueo() {
        initComponents();
        leerConfiguracion();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        lblServidor = new javax.swing.JLabel();
        txtServer = new javax.swing.JTextField();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblContraseña = new javax.swing.JLabel();
        cmdAccesar = new javax.swing.JButton();
        pswContraseña = new javax.swing.JPasswordField();
        lblBase = new javax.swing.JLabel();
        txtBase = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocationByPlatform(true);
        setResizable(false);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/padlock.jpg"))); // NOI18N

        lblServidor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblServidor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblServidor.setText("SERVIDOR");
        lblServidor.setToolTipText("");

        lblUsuario.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsuario.setText("USUARIO");

        lblContraseña.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblContraseña.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblContraseña.setText("CONTRASEÑA");

        cmdAccesar.setText("ACCESO");
        cmdAccesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAccesarActionPerformed(evt);
            }
        });

        lblBase.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblBase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBase.setText("BASE DE DATOS");
        lblBase.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblServidor, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(pswContraseña)
                            .addComponent(txtServer, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(lblContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblBase, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(txtBase)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(123, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(140, 140, 140)
                    .addComponent(cmdAccesar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(156, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addComponent(lblServidor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblBase)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(lblUsuario)
                .addGap(12, 12, 12)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblContraseña)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pswContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(459, Short.MAX_VALUE)
                    .addComponent(cmdAccesar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdAccesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAccesarActionPerformed
        try {
            // TODO add your handling code here:
            
            
//            File archivoConexion = new File("Conexion.xml");
//            
//            if (archivoConexion.exists())
//                System.out.println("El fichero");
//            else
            crearXML2();
            
            conexion con = new conexion();
            con.strServidor=this.txtServer.getText();
            con.strPSWSQL="";
            con.strUsuarioSQL="root";
            con.strBaseDeDatos=this.txtBase.getText();
         
            con.conectado();
            leerConfiguracion();
            frmPrincipal principal= new frmPrincipal();
            classUsuarios usuarios = new classUsuarios();
            if (usuarios.blnChecaUsuarioContra("SELECT * FROM Usuarios where Usuario='"+this.txtUsuario.getText() +"' and Contra='"+this.pswContraseña.getText()+"'")==true){
                this.setVisible(false);
                principal.setVisible(true);
            }
            else
                JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA INCORRECTO"+this.pswContraseña.getText());
                  System.out.println("SELECT * FROM Usuarios where Usuario='"+this.txtUsuario.getText() +"' and Contra='"+this.pswContraseña.getText()+"'");
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(frmLogueo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(frmLogueo.class.getName()).log(Level.SEVERE, null, ex);
        }
       
                
    }//GEN-LAST:event_cmdAccesarActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(frmLogueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(frmLogueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(frmLogueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(frmLogueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new frmLogueo().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdAccesar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblBase;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblServidor;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField pswContraseña;
    private javax.swing.JTextField txtBase;
    private javax.swing.JTextField txtServer;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables


public void crearXML2() throws ParserConfigurationException, TransformerConfigurationException, TransformerException{
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    DOMImplementation implementation = builder.getDOMImplementation();
    
    Document document = implementation.createDocument(null, "Configuracion", null);
    document.setXmlVersion("1.0");
    
    Element raiz = document.getDocumentElement();
    
    Element nodoServidor = document.createElement("Servidor"); //creamos un nuevo elemento
    Text nodoValorServidor = document.createTextNode(this.txtServer.getText()); //Ingresamos la info				
    nodoServidor.appendChild(nodoValorServidor); 						
    raiz.appendChild(nodoServidor); //pegamos el elemento a la raiz "Documento"
    
    Element nododb = document.createElement("DB"); //creamos un nuevo elemento
    Text nodoValorDB = document.createTextNode(this.txtBase.getText()); //Ingresamos la info				
    nododb.appendChild(nodoValorDB); 						
    raiz.appendChild(nododb); //pegamos el elemento a la raiz "Documento"
    
    Element nodoUsuario = document.createElement("Usuario"); //creamos un nuevo elemento
    Text nodoValorUsuario = document.createTextNode(this.txtUsuario.getText()); //Ingresamos la info				
    nodoUsuario.appendChild(nodoValorUsuario); 						
    raiz.appendChild(nodoUsuario); //pegamos el elemento a la raiz "Documento"
    
    
    Source source = new DOMSource(document);
    StreamResult result = new StreamResult(new java.io.File("Conexion.xml"));//nombre del archivo
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    transformer.transform(source, result);
}
    
    public void leerConfiguracion(){
        try{
    File fXmlFile = new File("Conexion.xml");
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(fXmlFile);

    //optional, but recommended
    //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
    doc.getDocumentElement().normalize();

    System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

    NodeList nList = doc.getElementsByTagName("Configuracion");

    System.out.println("----------------------------");

    for (int temp = 0; temp < nList.getLength(); temp++) {

        Node nNode = nList.item(temp);

        System.out.println("\nCurrent Element :" + nNode.getNodeName());

        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

            Element eElement = (Element) nNode;
 
            this.txtServer.setText( eElement.getElementsByTagName("Servidor").item(0).getTextContent());
            this.txtBase.setText(eElement.getElementsByTagName("DB").item(0).getTextContent());
            this.txtUsuario.setText(eElement.getElementsByTagName("Usuario").item(0).getTextContent());
        }
    }
    } catch (Exception e) {
    e.printStackTrace();
    }
  }

}