/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class main {
    
    public static void main(String[] args) throws Exception {
        String url="jdbc:mysql://localhost:3306/mydb";
        String username="root";
        String pass="123456";
        
        Connection c=DriverManager.getConnection(url,username,pass);
        
        Statement stmt=c.createStatement();
        stmt.execute("select name,surname,age from workers");
        
        ResultSet rs=stmt.getResultSet();
        
        while(rs.next()){
        
        String name=rs.getString("name");
        String surname=rs.getString("surname");
        int age=rs.getInt("age");
        
            System.out.println("name: "+name+"\nsurname: "+surname+"\nage: "+age+"\n----------------");
        
        }
        
    }
    
}
