/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-d       @Override
       public void tableChanged(TableModelEvent e) {
           throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       }
efault.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import AccesoADatos.AlumnoData;
import AccesoADatos.InscripcionData;
import Entidades.Alumno;
import Entidades.Inscripcion;
import static java.awt.image.ImageObserver.HEIGHT;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class actualizarNotas extends javax.swing.JInternalFrame {

    AlumnoData alumnoData = new AlumnoData();
    List<Alumno> listaAlumnos;
    DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            // solamente la columna 2 sera editable
            return column == 2;
        }
    };
    InscripcionData insdata = new InscripcionData();
    private double notaNueva = 0.0;
    private double notaAnterior = 0.0;

    public actualizarNotas() {
        initComponents();
        CargarTabla();

        try {
            listaAlumnos = new ArrayList<>(alumnoData.listaralumnos());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de conexion", "ERROR", HEIGHT);
            ex.printStackTrace();
        }
        CargarAlumnos();
        borrar();
        jbModifica.setEnabled(false);
        jtTabla.setVisible(true);
        jtTabla.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                //notaAnterior=Double.parseDouble((String)jtTabla.getValueAt(jtTabla.getSelectedRow(),2));

                if (e.getType() == TableModelEvent.UPDATE) {
                    jbModifica.setEnabled(false);
                    int fila = e.getFirstRow();
                    int columna = e.getColumn();
                    Object celdaMOdificada = jtTabla.getValueAt(fila, columna);
                    try {
                        System.out.println("evento ejecutado");
                        if (columna == 2) {
                            jbModifica.setEnabled(true);
                            System.out.println("Celda modificada en fila " + fila + ", columna " + columna + ": " + celdaMOdificada);
                            notaNueva = Double.parseDouble((String) celdaMOdificada);
                            System.out.println("la nota nueva es " + notaNueva);
                            System.out.println("nota anterior " + notaAnterior);
                            if (!(notaNueva >= 0 && notaNueva <= 10)) {
                                throw new ArithmeticException("la nota " + notaNueva + "debe estar entre 0 y 10");
                            }
                        }
                    } catch (NumberFormatException err) {
                        JOptionPane.showMessageDialog(null, "No ha introducido un numero", "Erorr no es un numero", JOptionPane.WARNING_MESSAGE);
                        notaNueva = notaAnterior;
                        refrecarTabla();
                        jbModifica.setEnabled(false);
                        //err.printStackTrace();
                    } catch (ArithmeticException err) {
                        JOptionPane.showMessageDialog(null, err.getMessage(), "Nota no permitida", JOptionPane.WARNING_MESSAGE);
                        notaNueva = notaAnterior;
                        refrecarTabla();
                        jbModifica.setEnabled(false);

                    } catch (Exception err) {
                        JOptionPane.showMessageDialog(null, "Ups a ocurrido un error inesperado contacte un administrador " + err.getMessage(), "Error inesperado", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        jtTabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int fila = jtTabla.getSelectedRow();
                    if (fila != -1) {
                        try {
                            Object objCelda = jtTabla.getValueAt(fila, 2);
                            if (objCelda instanceof Double) {
                                System.out.println("la nota anterior es" + notaAnterior);
                                notaAnterior = (Double) objCelda;
                                System.out.println(notaAnterior);
                            } else {
                                getToolkit().beep();
                                notaAnterior = 0.0;
                                refrecarTabla();
                                jbModifica.setEnabled(false);

                            }
                        } catch (ClassCastException err) {
                            JOptionPane.showMessageDialog(null, "Error de casteo" + err.getMessage(), "Error casteo", JOptionPane.ERROR_MESSAGE);

                        } catch (Exception err) {
                            JOptionPane.showMessageDialog(null, "Ups a ocurrido un error inesperado contacte un administrador " + err.getMessage(), "Error inesperado", JOptionPane.ERROR_MESSAGE);

                        }

                    }

                }
            }
        });

    }

    private void CargarAlumnos() {
        for (Alumno a : listaAlumnos) {
            jcCombo.addItem(a);
        }
    }

    private void CargarTabla() {
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Nota");
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

        jpanelCargarNotas = new javax.swing.JPanel();
        jbModifica = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcCombo = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(500, 500));

        jpanelCargarNotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpanelCargarNotasMouseClicked(evt);
            }
        });

        jbModifica.setText("Guardar / Modificar");
        jbModifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificaActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

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
        jtTabla.setCellSelectionEnabled(true);
        jtTabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jtTabla);
        jtTabla.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Cargar Notas");

        jLabel2.setText("Seleccione un Alumno :");

        jcCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpanelCargarNotasLayout = new javax.swing.GroupLayout(jpanelCargarNotas);
        jpanelCargarNotas.setLayout(jpanelCargarNotasLayout);
        jpanelCargarNotasLayout.setHorizontalGroup(
            jpanelCargarNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelCargarNotasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelCargarNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jpanelCargarNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jcCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jpanelCargarNotasLayout.createSequentialGroup()
                            .addComponent(jbModifica)
                            .addGap(18, 18, 18)
                            .addComponent(jButton2))))
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(jpanelCargarNotasLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpanelCargarNotasLayout.setVerticalGroup(
            jpanelCargarNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelCargarNotasLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpanelCargarNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpanelCargarNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jbModifica))
                .addContainerGap(126, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanelCargarNotas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanelCargarNotas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcComboActionPerformed
        // TODO add your handling code here:
        refrecarTabla();
    }//GEN-LAST:event_jcComboActionPerformed


    private void jbModificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificaActionPerformed
        // guardar
        int filaMateria = jtTabla.getSelectedRow();
        int idALumno = ((Alumno) jcCombo.getSelectedItem()).getIdAlumno();
        if (filaMateria != -1) {
            int idMateria = (Integer) jtTabla.getValueAt(filaMateria, 0);
            System.out.println(idMateria);
            insdata.actualizarNota(idALumno, idMateria, notaNueva);
            refrecarTabla();
            jbModifica.setEnabled(false);
            jtTabla.clearSelection();

        }

        /*Object getSource() (in java.util.EventObject)	Return the object that fired the event.
         int getFirstRow (Return the index of the first row that changed. TableModelEvent.HEADER_ROW specifies the table header.
         int getLastRow() The last row that changed. Again, HEADER_ROW is a possible value.
         int getColumn() Return the index of the column that changed. The constant TableModelEvent.ALL_COLUMNS specifies that all the columns might have changed.
         int getType() What happened to the changed cells. The returned value is one of the following: TableModelEvent.INSERT, TableModelEvent.DELETE, or TableModelEvent.UPDATE*/

    }//GEN-LAST:event_jbModificaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // salir
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jpanelCargarNotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpanelCargarNotasMouseClicked
        // TODO add your handling code here:
        if (evt.getSource() == jpanelCargarNotas) {
            jtTabla.clearSelection();
            jbModifica.setEnabled(false);
            notaNueva = notaAnterior;
            refrecarTabla();
            System.out.println("deseleccionado !");
        }
    }//GEN-LAST:event_jpanelCargarNotasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbModifica;
    private javax.swing.JComboBox<Alumno> jcCombo;
    private javax.swing.JPanel jpanelCargarNotas;
    private javax.swing.JTable jtTabla;
    // End of variables declaration//GEN-END:variables
private void borrar() {
        int filas = modelo.getRowCount() - 1;
        for (int i = filas; i >= 0; i--) {
            modelo.removeRow(i);

        }

    }

    private void refrecarTabla() {
        borrar();
        Alumno alu = (Alumno) jcCombo.getSelectedItem();
        ArrayList<Inscripcion> listains = new ArrayList<Inscripcion>();
        listains = (ArrayList) insdata.obtenerInscripcionesPorAlumno(alu.getIdAlumno());

        for (Inscripcion mat : listains) {
            modelo.addRow(new Object[]{mat.getMateria().getIdMateria(), mat.getMateria().getNombre(), mat.getNota()
            });
        }
    }

}
