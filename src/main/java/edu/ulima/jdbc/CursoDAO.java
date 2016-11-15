package edu.ulima.jdbc;

import edu.ulima.bean.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Esto es del SDK de heroku
import com.heroku.sdk.jdbc.DatabaseUrl;
import java.net.URISyntaxException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CursoDAO {
    
    public static  List<Curso> getAllCursos() {
        String sql = "SELECT * FROM TBCURSO ORDER BY NOMBRE";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection con = null;
        List<Curso> rpta = new ArrayList<>();
        
        try {
            con = DatabaseUrl.extract().getConnection();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while ( rs.next() ) {
                Curso c = new Curso( rs.getInt(1) , rs.getInt(2) , rs.getInt(3), rs.getString(4), rs.getInt(5));
                rpta.add(c);
                
            } // while
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        
        return rpta;
    }
    
    public static void createTables() {
        Connection connection = null;

        try {
            connection = DatabaseUrl.extract().getConnection();
            
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS TBCURSO (id  int, cred int, nivel int, nombre text, idfac  int)");

            stmt.executeUpdate("INSERT INTO ticks VALUES (1 ,3 , 1 , 'MATEMATICAS BASICAS I' , 1)");
            stmt.executeUpdate("INSERT INTO ticks VALUES (2 ,3 , 2 , 'MATEMATICAS BASICAS II' , 1)");
            stmt.executeUpdate("INSERT INTO ticks VALUES (3 ,3 , 2 , 'ALTA COCINA' , 1)");
            stmt.executeUpdate("INSERT INTO ticks VALUES (4 ,3 , 2 , 'ALGORITMOS Y CIENCIAS OCULTAS' , 1)");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (URISyntaxException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally  {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
            
                  
                  
    }
    
    
}
