package simple.kasir;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author baguswidyapratama
 */
public class DatabaseMinikasir {

    private String dbuser = "root";
    private String dbpassword = "sukses78";
    private Statement stmt = null;
    private Connection con = null;
    private ResultSet rs = null;
    boolean ismasuk = false;

    public DatabaseMinikasir() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "JDBC Driver Error", JOptionPane.WARNING_MESSAGE);
        }

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/minikasir", dbuser, dbpassword);
            stmt = (Statement) con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "JDBC Driver Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public ResultSet getData(String SQLString) {
        try {
            rs = stmt.executeQuery(SQLString);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "JDBC Driver Error", JOptionPane.WARNING_MESSAGE);
        }
        return rs;

    }

    public void query(String SQLString) {
        try {
            stmt.executeUpdate(SQLString);
            this.ismasuk = true;
        } catch (Exception e) {
            this.ismasuk = false;
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "JDBC Driver Error", JOptionPane.WARNING_MESSAGE);
        }
    }
}