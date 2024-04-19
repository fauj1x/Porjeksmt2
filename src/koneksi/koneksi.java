/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package koneksi;

import java.sql.*;
import javax.swing.JOptionPane;
public class koneksi {
            public static Connection koneksi;
                        public static Connection GetConnection(){
                                    
                                    try {
                                        String url = "jdbc:mysql://localhost:3306/manajemenprod";
                                        String user = "root";
                                        String password = "";


                                        koneksi= DriverManager.getConnection(url, user, password);
                                    } catch (SQLException e) {
                                        JOptionPane.showMessageDialog(null, "Koneksi gagal: " + e.getMessage());
                                    }
                                    return koneksi;


                        }

    public PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
            }

    

