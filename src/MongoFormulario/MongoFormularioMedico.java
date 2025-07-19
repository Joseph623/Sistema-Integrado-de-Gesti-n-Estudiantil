package MongoFormulario;

import Vista.Form;
import com.mongodb.client.*;
import org.bson.Document;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MongoFormularioMedico extends javax.swing.JFrame {

    MongoDatabase database;
    MongoCollection<Document> coleccion;

    public MongoFormularioMedico() {
        initComponents();
        conectarMongo();
        cargarEstudiantesDesdeMySQL();
        setLocationRelativeTo(null);
        mostrarDatos();
        tablaDatos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaDatos.setRowSelectionAllowed(true);
        tablaDatos.setColumnSelectionAllowed(false);

    }

    private void conectarMongo() {
        Conexion conexion = new Conexion();
        database = conexion.conectar();
        coleccion = database.getCollection("fichas_medicas");
    }

    private void cargarEstudiantesDesdeMySQL() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectobd?useSSL=false&serverTimezone=UTC", "root", "1234");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, nombre FROM estudiantes");
            cbEstudianteId.removeAllItems();
            while (rs.next()) {
                String item = rs.getString("id") + " - " + rs.getString("nombre");
                cbEstudianteId.addItem(item);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error MySQL: " + e.getMessage());
        }
    }

    private void limpiarCampos() {
        txtGrupo.setText("");
        txtAlergias.setText("");
        txtEstadoEmocional.setText("");
        txtObservaciones.setText("");
    }

    private void mostrarDatos() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Estudiante ID");
        modelo.addColumn("Grupo");
        modelo.addColumn("Alergias");
        modelo.addColumn("Estado emocional");
        modelo.addColumn("Observaciones");

        MongoCursor<Document> cursor = coleccion.find().iterator();
        while (cursor.hasNext()) {
            Document doc = cursor.next();
            String id = doc.getString("estudiante_id");
            Document salud = (Document) doc.get("salud");
            Document psicologia = (Document) doc.get("psicologia");
            modelo.addRow(new Object[]{
                id,
                salud.getString("grupo_sanguineo"),
                salud.getString("alergias"),
                psicologia.getString("estado_emocional"),
                psicologia.getString("observaciones")
            });
        }
        tablaDatos.setModel(modelo);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbEstudianteId = new javax.swing.JComboBox<>();
        txtObservaciones = new javax.swing.JTextField();
        txtAlergias = new javax.swing.JTextField();
        txtEstadoEmocional = new javax.swing.JTextField();
        txtGrupo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAgregar = new RSMaterialComponent.RSButtonMaterialIconDos();
        btnEliminar = new RSMaterialComponent.RSButtonMaterialIconDos();
        btnActualizar = new RSMaterialComponent.RSButtonMaterialIconDos();
        btnLimpiar = new RSMaterialComponent.RSButtonMaterialIconDos();
        btnRegresar = new RSMaterialComponent.RSButtonMaterialIconDos();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbEstudianteId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbEstudianteId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstudianteIdActionPerformed(evt);
            }
        });
        jPanel1.add(cbEstudianteId, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 160, 30));

        txtObservaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtObservacionesActionPerformed(evt);
            }
        });
        jPanel1.add(txtObservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 210, 30));

        txtAlergias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlergiasActionPerformed(evt);
            }
        });
        jPanel1.add(txtAlergias, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 210, 30));

        txtEstadoEmocional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstadoEmocionalActionPerformed(evt);
            }
        });
        jPanel1.add(txtEstadoEmocional, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 210, 30));

        txtGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGrupoActionPerformed(evt);
            }
        });
        jPanel1.add(txtGrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 210, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Nombre del estudiante:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Estado Emocional:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 140, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Alergias:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 100, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Observaciones:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 130, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Grupo Sanguineo:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 170, 30));

        btnAgregar.setBackground(new java.awt.Color(102, 204, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.setBackgroundHover(new java.awt.Color(225, 71, 97));
        btnAgregar.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        btnAgregar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MENU);
        btnAgregar.setInheritsPopupMenu(true);
        btnAgregar.setRound(25);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 140, 40));

        btnEliminar.setBackground(new java.awt.Color(102, 204, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.setBackgroundHover(new java.awt.Color(225, 71, 97));
        btnEliminar.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        btnEliminar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MENU);
        btnEliminar.setInheritsPopupMenu(true);
        btnEliminar.setRound(25);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 140, 40));

        btnActualizar.setBackground(new java.awt.Color(102, 204, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.setBackgroundHover(new java.awt.Color(225, 71, 97));
        btnActualizar.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        btnActualizar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MENU);
        btnActualizar.setInheritsPopupMenu(true);
        btnActualizar.setRound(25);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 140, 40));

        btnLimpiar.setBackground(new java.awt.Color(102, 204, 255));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBackgroundHover(new java.awt.Color(225, 71, 97));
        btnLimpiar.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        btnLimpiar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MENU);
        btnLimpiar.setInheritsPopupMenu(true);
        btnLimpiar.setRound(25);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 140, 40));

        btnRegresar.setBackground(new java.awt.Color(0, 153, 204));
        btnRegresar.setText("Regresar");
        btnRegresar.setBackgroundHover(new java.awt.Color(225, 71, 97));
        btnRegresar.setEffectButton(RSMaterialComponent.RSButtonMaterialIconDos.EFFECTBUTTON.RAISED);
        btnRegresar.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        btnRegresar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.HOME);
        btnRegresar.setRound(25);
        btnRegresar.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                btnRegresarAncestorMoved(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 430, 150, 50));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204), 4));

        tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Grupo Sanguineo", "Alergias", "Estado Emocional", "Observaciones"
            }
        ));
        tablaDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaDatos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 640, 180));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoInt.png"))); // NOI18N
        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 4, true));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbEstudianteIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEstudianteIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbEstudianteIdActionPerformed

    private void txtObservacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtObservacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtObservacionesActionPerformed

    private void txtGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGrupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGrupoActionPerformed

    private void txtAlergiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlergiasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlergiasActionPerformed

    private void txtEstadoEmocionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadoEmocionalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstadoEmocionalActionPerformed

    private void tablaDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDatosMouseClicked
        int fila = tablaDatos.getSelectedRow();
        if (fila >= 0) {
            cbEstudianteId.setSelectedItem(tablaDatos.getValueAt(fila, 0).toString()); 
            txtGrupo.setText(tablaDatos.getValueAt(fila, 1).toString());               
            txtAlergias.setText(tablaDatos.getValueAt(fila, 2).toString());            
            txtEstadoEmocional.setText(tablaDatos.getValueAt(fila, 3).toString());     
            txtObservaciones.setText(tablaDatos.getValueAt(fila, 4).toString());       
        }
    }//GEN-LAST:event_tablaDatosMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String id = cbEstudianteId.getSelectedItem().toString().split(" - ")[0];
        Document doc = new Document("estudiante_id", id)
                .append("salud", new Document("grupo_sanguineo", txtGrupo.getText())
                        .append("alergias", txtAlergias.getText()))
                .append("psicologia", new Document("estado_emocional", txtEstadoEmocional.getText())
                        .append("observaciones", txtObservaciones.getText()));

        coleccion.insertOne(doc);
        JOptionPane.showMessageDialog(this, "Ficha médica agregada");
        limpiarCampos();
        mostrarDatos();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String id = cbEstudianteId.getSelectedItem().toString().split(" - ")[0];
        coleccion.deleteOne(new Document("estudiante_id", id));
        JOptionPane.showMessageDialog(this, "Ficha médica eliminada");
        limpiarCampos();
        mostrarDatos();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        String id = cbEstudianteId.getSelectedItem().toString().split(" - ")[0];
        Document filtro = new Document("estudiante_id", id);
        Document nuevosValores = new Document("$set",
                new Document("salud", new Document("grupo_sanguineo", txtGrupo.getText())
                        .append("alergias", txtAlergias.getText()))
                        .append("psicologia", new Document("estado_emocional", txtEstadoEmocional.getText())
                                .append("observaciones", txtObservaciones.getText()))
        );
        coleccion.updateOne(filtro, nuevosValores);
        JOptionPane.showMessageDialog(this, "Ficha médica actualizada");
        limpiarCampos();
        mostrarDatos();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnRegresarAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_btnRegresarAncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresarAncestorMoved

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        Form fy = new Form();
        fy.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MongoFormularioMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MongoFormularioMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MongoFormularioMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MongoFormularioMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MongoFormularioMedico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconDos btnActualizar;
    private RSMaterialComponent.RSButtonMaterialIconDos btnAgregar;
    private RSMaterialComponent.RSButtonMaterialIconDos btnEliminar;
    private RSMaterialComponent.RSButtonMaterialIconDos btnLimpiar;
    private RSMaterialComponent.RSButtonMaterialIconDos btnRegresar;
    private javax.swing.JComboBox<String> cbEstudianteId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaDatos;
    private javax.swing.JTextField txtAlergias;
    private javax.swing.JTextField txtEstadoEmocional;
    private javax.swing.JTextField txtGrupo;
    private javax.swing.JTextField txtObservaciones;
    // End of variables declaration//GEN-END:variables
}
