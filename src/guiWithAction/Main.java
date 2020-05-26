package guiWithAction;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JSlider;
import javax.swing.BorderFactory;

/**
 *
 * @author tadaki
 */
public class Main extends javax.swing.JFrame {

    public enum Colors {//色を列挙型として定義
        ORANGE(Color.ORANGE), YELLOW(Color.YELLOW), GREEN(Color.GREEN);
        private final Color color;

        Colors(Color color) {
            this.color = color;
        }

        public Color getColor() {
            return color;
        }
    }
    private final JLabel label;
    private final JSlider slider;
    private final Font font;

    /**
     * Creates new form MainWithJMenu
     */
    public Main() {
        initComponents();
        font = new Font("MS UI Gothic", 0, 24);

        for (Colors m : Colors.values()) {
            JMenuItem item = new JMenuItem(m.toString());
            item.setFont(font);
            item.addActionListener(e -> colorItemPerformed(m));
            selectColors.add(item);
        }

        //スライダーの生成
        slider = new JSlider();
        slider.setFont(font);
        slider.setPaintTicks(true);
        slider.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        slider.setBackground(Color.white);
        //動作の定義
        slider.addChangeListener(e -> sliderStateChanged(e));
        menuBar.add(slider);//メニューバーへの追加

        //ラベルの生成
        label = new JLabel();
        label.setFont(font);
        menuBar.add(label);//メニューバーへの追加

        int v = slider.getValue();
        label.setText(String.valueOf(v));
        pack();
    }

    /**
     * 色を選択した際の動作
     *
     * @param c
     */
    private void colorItemPerformed(Colors c) {
        System.out.println(c.toString());
        panel.setBackground(c.getColor());
    }

    /**
     * スライダーを操作した際の動作
     *
     * @param evt
     */
    private void sliderStateChanged(javax.swing.event.ChangeEvent evt) {
        int v = slider.getValue();
        System.out.println("sliderの値が"
                + String.valueOf(v) + "になりました。");
        label.setText(String.valueOf(v));
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
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exit = new javax.swing.JMenuItem();
        selectColors = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 200));
        setPreferredSize(new java.awt.Dimension(400, 200));

        panel.setMinimumSize(new java.awt.Dimension(100, 100));
        getContentPane().add(panel, java.awt.BorderLayout.CENTER);

        fileMenu.setText("File");
        fileMenu.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N

        exit.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        exit.setText("exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        fileMenu.add(exit);

        menuBar.add(fileMenu);

        selectColors.setText("Colors");
        selectColors.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        menuBar.add(selectColors);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        dispose();
    }//GEN-LAST:event_exitActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel panel;
    private javax.swing.JMenu selectColors;
    // End of variables declaration//GEN-END:variables
}
