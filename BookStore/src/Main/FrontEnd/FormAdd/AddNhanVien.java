/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main.FrontEnd.FormAdd;

/**
 *
 * @author DELL
 */
public class AddNhanVien extends javax.swing.JFrame {

    /**
     * Creates new form AddNhanVien
     */
    public AddNhanVien() {
        setUndecorated(true);
        setAlwaysOnTop(true);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelAdd = new javax.swing.JPanel();
        mid = new javax.swing.JPanel();
        MaNV = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        dchi = new javax.swing.JTextField();
        mail = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        bot = new javax.swing.JPanel();
        submitbtn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelAdd.setLayout(new java.awt.BorderLayout());

        mid.setBackground(new java.awt.Color(51, 255, 255));

        MaNV.setEditable(false);
        MaNV.setBackground(new java.awt.Color(204, 255, 204));
        MaNV.setForeground(new java.awt.Color(0, 0, 0));
        MaNV.setText("NV1");
        MaNV.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mã Nhân Viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 51, 51))); // NOI18N
        MaNV.setFocusable(false);

        name.setBackground(new java.awt.Color(204, 255, 204));
        name.setForeground(new java.awt.Color(0, 0, 0));
        name.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Họ và Tên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 51, 51))); // NOI18N

        dchi.setBackground(new java.awt.Color(204, 255, 204));
        dchi.setForeground(new java.awt.Color(0, 0, 0));
        dchi.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Địa Chỉ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 51, 51))); // NOI18N

        mail.setBackground(new java.awt.Color(204, 255, 204));
        mail.setForeground(new java.awt.Color(0, 0, 0));
        mail.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 51, 51))); // NOI18N

        phone.setBackground(new java.awt.Color(204, 255, 204));
        phone.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Số Điện Thoại", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 51, 51))); // NOI18N

        javax.swing.GroupLayout midLayout = new javax.swing.GroupLayout(mid);
        mid.setLayout(midLayout);
        midLayout.setHorizontalGroup(
            midLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(midLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(midLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(dchi)
                    .addComponent(MaNV, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mail)
                    .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        midLayout.setVerticalGroup(
            midLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(midLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(dchi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        PanelAdd.add(mid, java.awt.BorderLayout.CENTER);

        submitbtn.setBackground(new java.awt.Color(255, 255, 255));
        submitbtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        submitbtn.setForeground(new java.awt.Color(0, 51, 51));
        submitbtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        submitbtn.setText("Xác Nhận");
        submitbtn.setOpaque(true);
        submitbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitbtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout botLayout = new javax.swing.GroupLayout(bot);
        bot.setLayout(botLayout);
        botLayout.setHorizontalGroup(
            botLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(submitbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        botLayout.setVerticalGroup(
            botLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(submitbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        PanelAdd.add(bot, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(PanelAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(PanelAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitbtnMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_submitbtnMouseClicked

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
            java.util.logging.Logger.getLogger(AddNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField MaNV;
    private javax.swing.JPanel PanelAdd;
    private javax.swing.JPanel bot;
    private javax.swing.JTextField dchi;
    private javax.swing.JTextField mail;
    private javax.swing.JPanel mid;
    private javax.swing.JTextField name;
    private javax.swing.JTextField phone;
    private javax.swing.JLabel submitbtn;
    // End of variables declaration//GEN-END:variables
}
