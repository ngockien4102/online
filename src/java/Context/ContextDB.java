/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSII
 */
public class ContextDB {
    public Connection connection;
    public ContextDB(){
       try {
            String url = "jdbc:mysql://localhost:3306/OnlineShop";
            String user = "root";
            String password = "1234";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ContextDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        ContextDB c = new ContextDB();
        System.out.println(c.connection.toString());
    }
}
