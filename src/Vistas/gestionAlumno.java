/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import AccesoADatos.AlumnoData;
import Entidades.Alumno;
import AccesoADatos.Conexion;
import java.time.LocalDate;
import java.time.ZoneId;
import java.sql.Date;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class gestionAlumno extends javax.swing.JInternalFrame {

    AlumnoData alum = new AlumnoData();
    ButtonGroup estados = new ButtonGroup();
    private Alumno alumG = null;

    public gestionAlumno() {
        initComponents();
        estados.add(jrBotonActivo);
        estados.add(jrBotonInactivo);
        jrBotonActivo.setSelected(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jbNuevo = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();
        jtDocumento = new javax.swing.JTextField();
        jtApellido = new javax.swing.JTextField();
        jtNombre = new javax.swing.JTextField();
        jdFecha = new com.toedter.calendar.JDateChooser();
        jrBotonActivo = new javax.swing.JRadioButton();
        jrBotonInactivo = new javax.swing.JRadioButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Alumnos");
        setPreferredSize(new java.awt.Dimension(500, 400));

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Alumno");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(174, 12, 111, 38);

        jLabel2.setText("Fecha de Naciomiento");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(47, 252, 125, 16);

        jLabel3.setText("Apellido");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(47, 122, 45, 16);

        jLabel4.setText("Documento");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(47, 76, 65, 16);

        jLabel5.setText("Nombre");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(47, 164, 45, 16);

        jLabel6.setText("Estado");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(47, 202, 39, 16);

        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(jbNuevo);
        jbNuevo.setBounds(37, 286, 70, 32);

        jbEliminar.setText("Eliminar");
        jbEliminar.setEnabled(false);
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jbEliminar);
        jbEliminar.setBounds(116, 286, 80, 32);

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });
        jPanel1.add(jbSalir);
        jbSalir.setBounds(318, 286, 56, 32);

        jbModificar.setText("Modificar");
        jbModificar.setEnabled(false);
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });
        jPanel1.add(jbModificar);
        jbModificar.setBounds(210, 286, 90, 32);

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(jbBuscar);
        jbBuscar.setBounds(332, 68, 71, 32);
        jPanel1.add(jtDocumento);
        jtDocumento.setBounds(155, 72, 159, 24);
        jPanel1.add(jtApellido);
        jtApellido.setBounds(155, 118, 159, 24);
        jPanel1.add(jtNombre);
        jtNombre.setBounds(155, 160, 159, 24);
        jPanel1.add(jdFecha);
        jdFecha.setBounds(185, 239, 118, 29);

        jrBotonActivo.setText("Activo");
        jrBotonActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrBotonActivoActionPerformed(evt);
            }
        });
        jPanel1.add(jrBotonActivo);
        jrBotonActivo.setBounds(160, 200, 111, 28);

        jrBotonInactivo.setText("Inactivo");
        jrBotonInactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrBotonInactivoActionPerformed(evt);
            }
        });
        jPanel1.add(jrBotonInactivo);
        jrBotonInactivo.setBounds(270, 200, 76, 28);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        //boton modificar
        String nombre = jtNombre.getText();
        String apellido = jtApellido.getText();
        int dni = (int) Integer.parseInt(jtDocumento.getText());
        boolean estado = false;
        if (jrBotonActivo.isSelected()) {
            estado = true;
        } else {
            estado = false;
        }

        LocalDate fecha = jdFecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Alumno alum2 = new Alumno(dni, apellido, nombre, fecha, estado);
        alum.guardarAlumno(alum2);
        JOptionPane.showMessageDialog(null, "Alumno Guardado :)");


    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        // Boton buscar
        int dni = Integer.parseInt(jtDocumento.getText());

        alumG = alum.buscarAlumnoDNI(dni);
        if (alumG != null) {

            jbEliminar.setEnabled(true);
            jbModificar.setEnabled(true);
            jtApellido.setText(alumG.getApellido());
            jtNombre.setText(alumG.getNombre());
            jdFecha.setDate(Date.valueOf(alumG.getFechaDeNacimiento()));
             JOptionPane.showMessageDialog(null, "Alumno Guardado :V");

            if (alumG.isEstado()) {
                jrBotonActivo.setSelected(true);
                jrBotonInactivo.setSelected(false);
            } else {
                jrBotonActivo.setSelected(false);
                jrBotonInactivo.setSelected(true);
            }

        }else{
         JOptionPane.showMessageDialog(null, "Alumno no encontrado");
        }


    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jrBotonActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrBotonActivoActionPerformed

        if (jrBotonActivo.isSelected()) {
            jrBotonInactivo.setSelected(false);
        }


    }//GEN-LAST:event_jrBotonActivoActionPerformed

    private void jrBotonInactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrBotonInactivoActionPerformed
        //radiobotton

        if (jrBotonInactivo.isSelected()) {
            jrBotonActivo.setSelected(false);
        }
    }//GEN-LAST:event_jrBotonInactivoActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        // boton Eliminar

        alum.eliminarAlumno(alumG.getIdAlumno());
        alum.removeralumno();
        alumG = null;
        jtDocumento.setText("");
        jtApellido.setText("");
        jtNombre.setText("");
        jdFecha.setDate(null);
        jbEliminar.setEnabled(false);
        


    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // boton salir
        this.dispose();


    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        //boton modificar
        Alumno al = new Alumno();
        int dni = Integer.parseInt(jtDocumento.getText());
        LocalDate fecha = jdFecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        boolean estado = false;
        if (jrBotonActivo.isSelected()) {
            estado = true;
        } else {
            estado = false;
        }
        al.setIdAlumno(alum.buscarAlumnoDNI(dni).getIdAlumno());
        al.setDni(dni);
        al.setApellido(jtApellido.getText());
        al.setNombre(jtNombre.getText());
        al.setEstado(estado);
        al.setFechaDeNacimiento(fecha);

        alum.modificarAlumno(al);


    }//GEN-LAST:event_jbModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbSalir;
    private com.toedter.calendar.JDateChooser jdFecha;
    private javax.swing.JRadioButton jrBotonActivo;
    private javax.swing.JRadioButton jrBotonInactivo;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JTextField jtDocumento;
    private javax.swing.JTextField jtNombre;
    // End of variables declaration//GEN-END:variables
}
