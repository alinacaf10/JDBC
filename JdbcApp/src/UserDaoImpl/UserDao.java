/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserDaoImpl;

import UserDao.AbstractDao;
import UserDao.UserDaoInter;
import bean.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class UserDao extends AbstractDao implements UserDaoInter {

    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select * from workers");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String names = rs.getString("name");
                String surnames = rs.getString("surname");
                int ages = rs.getInt("age");

                result.add(new User(id, names, surnames, ages));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateUser(User u) {

               try (Connection c = connect()) {

            Statement stmt = c.createStatement();
            return stmt.execute(" update workers set name ='ALI' where id= 1 ");

        } catch (Exception ex) {
            return false;
        }

    }

    @Override
    public boolean removeUser(int id) {
             try (Connection c = connect()) {

            Statement stmt = c.createStatement();
            return stmt.execute(" delete from workers where id= 1 ");

        } catch (Exception ex) {
            return false;
        }
    }

   

}
