/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AplikasiPenjualan;


import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author Lenovo
 */
public class ConnectionDb {
  static final String jdbc_driver = "com.mysql.cj.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost:3306/penjualan";
    static final String user = "root";
    static final String pass = "";
    static Connection conn;
    static Statement stat;
    static ResultSet rs;
    
    public static Connection connectDatabase() {
        try {
            // Load driver JDBC
            Class.forName(jdbc_driver);
        } catch (ClassNotFoundException cnf) {
            JOptionPane.showMessageDialog(null, "Driver JDBC tidak ditemukan", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        try {
            // Buat koneksi
            conn = DriverManager.getConnection(url, user, pass);
            JOptionPane.showMessageDialog(null, "Koneksi Database Berhasil", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi Database Gagal: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            conn = null;  // Pastikan null jika koneksi gagal
        }
        
        return conn;  // Return the connection object
    }
}
