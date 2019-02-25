package BackgroundWork;


import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class koneksi {
    Connection kon;
    Statement st;
    ResultSet rs;
    private String hasil;
    private String db = "rumah_sakit";
    private String username = "root";
    private String password = "";
    private String url = "localhost";
    
    public ResultSet koneksikan(String sql) throws SQLException{
        kon = DriverManager.getConnection("jdbc:mysql://"+url+"/"+db,username,password);
        st = kon.createStatement();
        rs = st.executeQuery(sql);
        //kon.close();
        return rs;
    }
     
    public void insert(String sql){
        try {
            kon = DriverManager.getConnection("jdbc:mysql://"+url+"/"+db,username,password);
            st = kon.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
           // Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    public void Sett(String url,String username,String password,String db){
        this.url = url;
        this.username = username;
        this.password = password;
        this.db = db;        
    }
  
    

}
