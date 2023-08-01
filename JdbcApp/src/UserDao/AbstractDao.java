/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserDao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author HP
 */
public abstract class AbstractDao {
     public Connection connect() throws Exception {

        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "123456";
        Connection c = DriverManager.getConnection(url, username, password);
        return c;
    }
}
