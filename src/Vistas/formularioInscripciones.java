/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import AccesoADatos.AlumnoData;
import AccesoADatos.InscripcionData;
import Entidades.Alumno;
import Entidades.Inscripcion;
import Entidades.Materia;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 * a
 *
 * @author Usuario
 */
public class formularioInscripciones extends javax.swing.JInternalFrame {

    AlumnoData AG = new AlumnoData();
    List<Alumno> LA;
    ButtonGroup estados = new ButtonGroup();
    DefaultTableModel modelo = new DefaultTableModel();
    InscripcionData insdata = new InscripcionData();
    int idMateriaSelecionada = 0;

    public formularioInscripciones() {
        initComponents();
        estados.add(jrMI);
        estados.add(jrMNI);
        jrMI.setSelected(true);

        try {
            LA = new ArrayList<>(AG.listaralumnos());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de coneccion", "ERROR", HEIGHT);
            ex.printStackTrace();
        }
        CargarTabla();
        CargarAlumnos();
        

    }

    private void CargarAlumnos() {
        for (Alumno a : LA) {
            jcCombo.addItem(a);
        }
    }

    private void CargarTabla() {
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Año");

        jtTabla.setModel(modelo);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabla = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcCombo = new javax.swing.JComboBox<>();
        jrMI = new javax.swing.JRadioButton();
        jrMNI = new javax.swing.JRadioButton();
        jbInscribir = new javax.swing.JButton();
        jbAnular = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(500, 500));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Formulario de inscripcion");

        jtTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(jtTabla);

        jtTabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override

            public void valueChanged(ListSelectionEvent e) {
                // Este código se ejecutará cuando se seleccione una fila en la tabla
                if (!e.getValueIsAdjusting()) { // Evita que se ejecute dos veces por cada selección
                    int filaSeleccionada = jtTabla.getSelectedRow();
                    if (filaSeleccionada != -1) { // Verifica si se ha seleccionado una fila válida

                        for (int i = 0; i < 1; i++) {
                            idMateriaSelecionada =(Integer) modelo.getValueAt(filaSeleccionada, i);

                        }

                    }
                }
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Selecione un alumno:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Listado de Materia");

        jcCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcComboActionPerformed(evt);
            }
        });

        jrMI.setText("Materias incriptas");
        jrMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrMIActionPerformed(evt);
            }
        });

        jrMNI.setText("Materias no inscriptas");
        jrMNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrMNIActionPerformed(evt);
            }
        });

        jbInscribir.setText("inscribir");
        jbInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInscribirActionPerformed(evt);
            }
        });

        jbAnular.setText("Alular inscripcion");
        jbAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnularActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jcCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(jbInscribir)
                                .addGap(40, 40, 40)
                                .addComponent(jbAnular)
                                .addGap(48, 48, 48)
                                .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jrMI)
                .addGap(60, 60, 60)
                .addComponent(jrMNI)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrMNI)
                    .addComponent(jrMI))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAnular)
                    .addComponent(jbSalir)
                    .addComponent(jbInscribir))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jcComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcComboActionPerformed
        //combo
        borrar();

        List<Materia> matC = new ArrayList();
        List<Materia> matNC = new ArrayList();

        int id = ((Alumno) jcCombo.getSelectedItem()).getIdAlumno();
        if (jrMI.isSelected()) {
            jbAnular.setEnabled(true);
            jbInscribir.setEnabled(false);
            matC = insdata.obtenerMateriasCursadas(id);
            for (Materia m : matC) {
                modelo.addRow(new Object[]{
                    m.getIdMateria(), m.getNombre(), m.getAnno()
                });

            }

        } else {
            jbAnular.setEnabled(false);
            jbInscribir.setEnabled(true);
            matNC = insdata.obtenerMateriasNOCursadas(id);
            for (Materia m : matNC) {
                modelo.addRow(new Object[]{
                    m.getIdMateria(), m.getNombre(), m.getAnno()
                });

            }

        }


    }//GEN-LAST:event_jcComboActionPerformed

    private void jbInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInscribirActionPerformed
        // inscribir
        int id = ((Alumno) jcCombo.getSelectedItem()).getIdAlumno();
        int nota = 0;
        Alumno alu = null;
        Materia mat = null;
        Inscripcion ins = null;
        if (idMateriaSelecionada > 0) {
            ins = new Inscripcion();
            mat = new Materia();
            alu = new Alumno();
            mat.setIdMateria(idMateriaSelecionada);
            alu.setIdAlumno(id);

            ins.setNota(0);
            ins.setAlumno(alu);
            ins.setMateria(mat);
            insdata.guardarInscripcion(ins);
            idMateriaSelecionada = 0;
            //-----------
            refrescar();

        } else {
            JOptionPane.showMessageDialog(this, "Sin Materia Selecionada");
        }
//
//        jtTabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//            @Override
//
//            public void valueChanged(ListSelectionEvent e) {
//                // Este código se ejecutará cuando se seleccione una fila en la tabla
//                if (!e.getValueIsAdjusting()) { // Evita que se ejecute dos veces por cada selección
//                    int filaSeleccionada = jtTabla.getSelectedRow();
//                    if (filaSeleccionada != -1) { // Verifica si se ha seleccionado una fila válida
//
//                        for (int i = 0; i < 1; i++) {
//                           int idMateriaSelecionada =(Integer) modelo.getValueAt(filaSeleccionada, i);
//                            
//
//                        }
//
//                    }
//                }
//            }
//        });


    }//GEN-LAST:event_jbInscribirActionPerformed

    private void jrMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrMIActionPerformed
        // jrboton
        borrar();

        List<Materia> matC = new ArrayList();
        List<Materia> matNC = new ArrayList();

        int id = ((Alumno) jcCombo.getSelectedItem()).getIdAlumno();
        if (jrMI.isSelected()) {
            jbAnular.setEnabled(true);
            jbInscribir.setEnabled(false);
            matC = insdata.obtenerMateriasCursadas(id);
            for (Materia m : matC) {
                modelo.addRow(new Object[]{
                    m.getIdMateria(), m.getNombre(), m.getAnno()
                });

            }

        } else {
            jbAnular.setEnabled(false);
            jbInscribir.setEnabled(true);
            matNC = insdata.obtenerMateriasNOCursadas(id);
            for (Materia m : matNC) {
                modelo.addRow(new Object[]{
                    m.getIdMateria(), m.getNombre(), m.getAnno()
                });

            }

        }


    }//GEN-LAST:event_jrMIActionPerformed

    private void jrMNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrMNIActionPerformed
        //jrboton2
        // jrboton
        borrar();

        List<Materia> matC = new ArrayList();
        List<Materia> matNC = new ArrayList();

        int id = ((Alumno) jcCombo.getSelectedItem()).getIdAlumno();
        if (jrMI.isSelected()) {
            jbAnular.setEnabled(true);
            jbInscribir.setEnabled(false);
            matC = insdata.obtenerMateriasCursadas(id);
            for (Materia m : matC) {
                modelo.addRow(new Object[]{
                    m.getIdMateria(), m.getNombre(), m.getAnno()
                });

            }

        } else {
            jbAnular.setEnabled(false);
            jbInscribir.setEnabled(true);
            matNC = insdata.obtenerMateriasNOCursadas(id);
            for (Materia m : matNC) {
                modelo.addRow(new Object[]{
                    m.getIdMateria(), m.getNombre(), m.getAnno()
                });

            }

        }


    }//GEN-LAST:event_jrMNIActionPerformed

    private void jbAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnularActionPerformed
        // anular

        int id = ((Alumno) jcCombo.getSelectedItem()).getIdAlumno();

        if (idMateriaSelecionada > 0) {

            insdata.borrarInscripcionMateriaAlumno(id, idMateriaSelecionada);
            idMateriaSelecionada = 0;
            //-----------
            refrescar();

        } else {
            JOptionPane.showMessageDialog(this, "Sin Materia Selecionada");
        }


    }//GEN-LAST:event_jbAnularActionPerformed

    private void borrar() {
        int filas = modelo.getRowCount() - 1;
        for (int i = filas; i >= 0; i--) {
            modelo.removeRow(i);

        }

    }

    private void refrescar() {
        ActionEvent eventoSimulado = new ActionEvent(jcCombo, ActionEvent.ACTION_PERFORMED, "");
        jcCombo.getActionListeners()[0].actionPerformed(eventoSimulado);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAnular;
    private javax.swing.JButton jbInscribir;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Alumno> jcCombo;
    private javax.swing.JRadioButton jrMI;
    private javax.swing.JRadioButton jrMNI;
    private javax.swing.JTable jtTabla;
    // End of variables declaration//GEN-END:variables

}
