package GUI;


import com.sun.glass.ui.Cursor;
import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import BackgroundWork.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dimas Adiyaksa
 */
public class Login extends javax.swing.JFrame {

    private String Username;
    private String Password;
    private boolean Admin;
    private int A,B,hasil;
    /**
     * Creates new form Login
     */
    public Login(boolean admin) {
        initComponents();
        this.toFront();
        setLocationRelativeTo(null);
        inisiasi();
        captchaField();
        this.Admin = admin;
    }

    Login() {
        initComponents();
        this.toFront();
        setLocationRelativeTo(null);
        inisiasi();
        captchaField();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginLabel = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        captchaLabel = new javax.swing.JLabel();
        capctha = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        Masuk = new javax.swing.JButton();
        batal = new javax.swing.JButton();
        usernameSalah = new javax.swing.JLabel();
        passwordSalah = new javax.swing.JLabel();
        captchaSalah = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        loginLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        loginLabel.setText("LOGIN");

        username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernameFocusLost(evt);
            }
        });
        username.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usernameMouseClicked(evt);
            }
        });
        username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usernameKeyTyped(evt);
            }
        });

        captchaLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        captchaLabel.setText("3 -7 =");

        password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFocusLost(evt);
            }
        });
        password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passwordMouseClicked(evt);
            }
        });
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordKeyTyped(evt);
            }
        });

        Masuk.setText("Masuk");
        Masuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MasukMouseClicked(evt);
            }
        });

        batal.setText("Batal");
        batal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                batalMouseClicked(evt);
            }
        });

        usernameSalah.setForeground(new java.awt.Color(255, 0, 0));
        usernameSalah.setText("Username Salah");

        passwordSalah.setForeground(new java.awt.Color(255, 0, 51));
        passwordSalah.setText("Password Salah");

        captchaSalah.setForeground(new java.awt.Color(255, 0, 51));
        captchaSalah.setText("Captcha Salah");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginLabel)
                    .addComponent(usernameSalah, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordSalah)
                    .addComponent(captchaSalah)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Masuk, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(batal, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(captchaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(capctha, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(loginLabel)
                .addGap(17, 17, 17)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(usernameSalah)
                .addGap(1, 1, 1)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(passwordSalah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(captchaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(capctha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(captchaSalah)
                .addGap(9, 9, 9)
                .addComponent(Masuk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(batal)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inisiasi(){
        username.setText("Username");
        username.setForeground(Color.GRAY);
    
        password.setText("Password");
        password.setEchoChar((char)0);
        password.setForeground(Color.GRAY);
        
        passwordSalah.setText("");
        usernameSalah.setText("");
        captchaSalah.setText("");
    }
    
    public void captchaField(){
        int indeks;
        char[] operand = new char[3];
        operand[0] = '+';
        operand[1] = '-';
        operand[2] = 'x';
        char getOperand;
        Random random = new Random();
        A = random.nextInt(100)%10;
        B = (random.nextInt(255)%10)+1;
        indeks = random.nextInt(10)%3;
        getOperand = operand[indeks];
        
        
        switch (indeks) {
            case 0:
                hasil = A+B;
                break;
            case 1:
                hasil = A-B;
                break;
            default:
                hasil = A*B;
                break;
        }
        
        captchaLabel.setText(A+" "+getOperand+" "+B+" = ");
        
        //return hasil;
    }
    
    private void usernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameMouseClicked
        // TODO add your handling code here:
        String user;
        user = username.getText();
        if(user.equals("Username")){
            username.setForeground(Color.BLACK);
            username.setText("");
        }else{
             username.setForeground(Color.BLACK);
             username.setText(user);
             
        }
        
    }//GEN-LAST:event_usernameMouseClicked

    private void usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFocusLost
        // TODO add your handling code here:
        String user;
        user = username.getText();
        if(user.equals("Username")||user.equals("")){
            username.setText("Username");
            username.setForeground(Color.GRAY);
        }else{
             username.setText(user);
             username.setForeground(Color.BLACK);
        }
       
    
    }//GEN-LAST:event_usernameFocusLost

    private void usernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameKeyTyped
        // TODO add your handling code here:
        String user;
        user = username.getText();
        if(user.equals("Username")||user.equals("")){
            username.setForeground(Color.BLACK);
            username.setText("");
        }else{
             username.setForeground(Color.BLACK);
             username.setText(user);
             
        }
    }//GEN-LAST:event_usernameKeyTyped

    private void passwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyTyped
        // TODO add your handling code here:
        String Pass;
        Pass = password.getText();
        if(Pass.equals("Password")||Pass.equals("")){
            password.setForeground(Color.BLACK);
            password.setText("");
            password.setEchoChar((char)0);
        }else{
             password.setEchoChar('*');
             password.setForeground(Color.BLACK);
             password.setText(Pass);
             
        }
    }//GEN-LAST:event_passwordKeyTyped

    private void passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusLost
        // TODO add your handling code here:
        String Pass;
        Pass = password.getText();
        if(Pass.equals("Password")||Pass.equals("")){
            password.setForeground(Color.GRAY);
            password.setText("Password");
        }else{
             password.setForeground(Color.BLACK);
             password.setText(Pass);
             
        }
    }//GEN-LAST:event_passwordFocusLost

    private void passwordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordMouseClicked
        // TODO add your handling code here:
         String Pass;
        Pass = password.getText();
        if(Pass.equals("Password")){
            password.setForeground(Color.BLACK);
            password.setText("");
            
        }else{
            password.setForeground(Color.BLACK);
            password.setText(Pass);
        }
    }//GEN-LAST:event_passwordMouseClicked

    private void MasukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MasukMouseClicked
        if(login(username.getText(),password.getText())) {
            if (Integer.parseInt(capctha.getText())==hasil) {
                JOptionPane.showMessageDialog(null, "Login Berhasil!");
                this.Admin = true;
                dispose();
               
                Utama.IsAdmin = true;
                                
            }else{
                captchaSalah.setText("Captcha Salah!");
                JOptionPane.showMessageDialog(null, Integer.parseInt(capctha.getText()));
            }
        }else{
            JOptionPane.showMessageDialog(null,"Login Gagal!");
        }
    }//GEN-LAST:event_MasukMouseClicked

    private void batalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_batalMouseClicked
        // TODO add your handling code here:
        this.dispose();
        
    }//GEN-LAST:event_batalMouseClicked
    
    public boolean login(String username,String Password){
        String[] user = new String[5];
        String[] pass = new String[5];
        int i = 0;
        int CpcRes;
        ResultSet rs = null;
        
        try {
            koneksi kon = new koneksi();
            rs = kon.koneksikan("SELECT * FROM logindata");
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            while(rs.next()){
                try {
                    user[i] = rs.getString("Username");
                    pass[i] = rs.getString("Password");
                    i++;
                } catch (Exception ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null,ex);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,ex);
        }
        
        for(i = 0;i<user.length;i++){
            if(username.equals(user[i])&&i<=user.length){
                if(Password.equals(pass[i])){
                    return true;
                }
            }
        }        
         passwordSalah.setText("Password Salah!");
                       
        return false;
        
    }
    
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Masuk;
    private javax.swing.JButton batal;
    private javax.swing.JTextField capctha;
    private javax.swing.JLabel captchaLabel;
    private javax.swing.JLabel captchaSalah;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel passwordSalah;
    private javax.swing.JTextField username;
    private javax.swing.JLabel usernameSalah;
    // End of variables declaration//GEN-END:variables
}
