package fileChooser;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * File chooser example. This class is a simple text editor with file chooser
 * 
 * @author tadaki
 */
public class FileChooserMain extends javax.swing.JFrame {

    private File dir;
    private String filename = null;
    private final String applicationName;

    /**
     * Creates new form FileChooseMain
     */
    public FileChooserMain() {
        initComponents();
        applicationName = FileChooserMain.class.getSimpleName();// Getting class name
        setTitle(applicationName);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textPane = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenu = new javax.swing.JMenuItem();
        saveText = new javax.swing.JMenuItem();
        quit = new javax.swing.JMenuItem();
        textMenu = new javax.swing.JMenu();
        clearText = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textArea.setColumns(80);
        textArea.setFont(new java.awt.Font("MS UI Gothic", 0, 24)); // NOI18N
        textArea.setRows(20);
        textPane.setViewportView(textArea);

        getContentPane().add(textPane, java.awt.BorderLayout.CENTER);

        fileMenu.setText("File");
        fileMenu.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N

        openMenu.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        openMenu.setText("Open");
        openMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuActionPerformed(evt);
            }
        });
        fileMenu.add(openMenu);

        saveText.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        saveText.setText("Save");
        saveText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveTextActionPerformed(evt);
            }
        });
        fileMenu.add(saveText);

        quit.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        quit.setText("Quit");
        quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitActionPerformed(evt);
            }
        });
        fileMenu.add(quit);

        menuBar.add(fileMenu);

        textMenu.setText("Text");
        textMenu.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N

        clearText.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        clearText.setText("Clear");
        clearText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearTextActionPerformed(evt);
            }
        });
        textMenu.add(clearText);

        menuBar.add(textMenu);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openMenuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_openMenuActionPerformed
        // Create file chooser and set filter for text files
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(dir);
        chooser.setFileFilter(
                new FileNameExtensionFilter("Text File", "txt"));

        int returnVal = chooser.showOpenDialog(this);// Show dialog
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();// Selected file
            // Show text in textArea
            textArea.setText(FileUtilGUI.openFile(file));
            textArea.setVisible(true);
            filename = file.getName();
            setTitle(applicationName + " " + filename);
            dir = file.getParentFile();
        }
    }// GEN-LAST:event_openMenuActionPerformed

    private void quitActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_quitActionPerformed
        dispose();
    }// GEN-LAST:event_quitActionPerformed

    private void clearTextActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_clearTextActionPerformed
        textArea.setText(null);
    }// GEN-LAST:event_clearTextActionPerformed

    private void saveTextActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_saveTextActionPerformed
        // Create file chooser and set filter for text files
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(dir);
        chooser.setFileFilter(new FileNameExtensionFilter("Text File", "txt"));

        int returnVal = chooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            FileUtilGUI.saveFile(file, textArea.getText());
            filename = file.getName();
            this.setTitle(applicationName + " " + filename);
            dir = file.getParentFile();
        }
    }// GEN-LAST:event_saveTextActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FileChooserMain.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FileChooserMain.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FileChooserMain.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FileChooserMain.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FileChooserMain().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem clearText;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenu;
    private javax.swing.JMenuItem quit;
    private javax.swing.JMenuItem saveText;
    private javax.swing.JTextArea textArea;
    private javax.swing.JMenu textMenu;
    private javax.swing.JScrollPane textPane;
    // End of variables declaration//GEN-END:variables
}
