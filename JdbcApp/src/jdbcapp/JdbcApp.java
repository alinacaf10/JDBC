/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jdbcapp;

import UserDao.UserDaoInter;
import UserDaoImpl.UserDao;
import bean.User;
import java.util.List;

/**
 *
 * @author HP
 */
public class JdbcApp {

    
   

    public static void main(String[] args) throws Exception {
    
        UserDaoInter user=new UserDao();
        System.out.println(user.getAll());
    }
}    
    

