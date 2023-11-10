/*
 * Frame de la App
 */
package vista;

import controlador.*;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import modelo.*;

/**
 *
 * @author Di Qi
 */
public class App extends javax.swing.JFrame {

    private final int PANEL_WIDTH = 500;
    private final int PANEL_HEIGHT = 500;
    
    private MyList lista;
    private PanelLista panelLista;
    private PanelUnoAUno panelUnoUno;

    /**
     * Creates new form App
     */
    public App() {
        initComponents();

        this.lista = new MyList();

        // Primeros 10 empleados
        for (int i = 0; i < 10; i++) {
            try {
                Empleado e = Funciones.generarEmpleadoAleatorio(Funciones.numeroRandom(1000, 2000));
                this.lista.add(e);
                this.lista.getLastNode().setIndex(e.getNumero());
            } catch (SueldoException ex) {
                System.err.println(ex.getMessage());
                JOptionPane.showMessageDialog(this, "No se ha podido crear un empleado.");
            }
        }

        // Crear paneles
        this.panelLista = new PanelLista(this, lista);
        this.panelUnoUno = new PanelUnoAUno(this, lista);
        
        // Establecer panel lista
        setPanelLista();
        
        
    }
    
    /**
     * Establece un la vista el panel de la lista
     */
    public void setPanelLista() {
        this.panel.removeAll();
        this.panelLista.setSize(PANEL_WIDTH, PANEL_HEIGHT);
        this.panel.add(this.panelLista, BorderLayout.CENTER);
        this.panel.revalidate();
        this.panel.repaint();
    }
    
    /**
     * Establece un la vista el panel de la vista uno a uno
     */
    public void setPanelUnoAUno() {
        this.panel.removeAll();
        this.panelUnoUno.setSize(PANEL_WIDTH, PANEL_HEIGHT);
        this.panel.add(this.panelUnoUno, BorderLayout.CENTER);
        this.panel.revalidate();
        this.panel.repaint();
    }

    public PanelLista getPanelLista() {
        return panelLista;
    }

    public PanelUnoAUno getPanelUnoUno() {
        return panelUnoUno;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Empleados");
        setResizable(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
