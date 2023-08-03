/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserDaoImpl;

import UserDao.AbstractDao;
import UserDao.UserDaoInter;
import bean.Nationality;
import bean.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class UserDao extends AbstractDao implements UserDaoInter {

    
    private User getUser(ResultSet rs) throws Exception{
        int id = rs.getInt("id");
                String names = rs.getString("name");
                String surnames = rs.getString("surname");
                String phones = rs.getString("phone");
                String mails = rs.getString("email");
                int ages = rs.getInt("age");
                Date birthDate=rs.getDate("birthdate");
                int nationalityId=rs.getInt("nationality_id");
                int birthplaceId=rs.getInt("birthplace_id");
                String nationalityStr=rs.getString("nationality");
                String birthPlaceStr=rs.getString("birthplace");
                Nationality nationality=new Nationality(nationalityId, nationalityStr, null);
                Nationality birthPlace=new Nationality(birthplaceId, birthPlaceStr, null);

                return (new User(id, names, surnames,phones,mails, ages, birthDate, nationality, birthPlace));
            
    }
    
    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("SELECT "
                    + " u.*, "
                    + " n.country_name as nationality, "
                    + " c.country_name as birthplace from workers u "
                    + " left join nationality n on u.nationality_id = n.id "
                    + " left join nationality c on u.birthplace_id = c.id");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                User u= getUser(rs);
                result.add(u);
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
            return stmt.execute("delete from workers where id= " + id);

        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public User getById(int id) {
        User result=null;
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("SELECT "
                    + " u.*, "
                    + " n.country_name as nationality, "
                    + " c.country_name as birthplace from workers u "
                    + " left join nationality n on u.nationality_id = n.id "
                    + " left join nationality c on u.birthplace_id = c.id where u.id="+id);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result=getUser(rs);
                
                }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }


  

    @Override
    public boolean addUser(User u) {
      try(Connection c= connect()){
            PreparedStatement stmt=c.prepareStatement(  "insert into workers(name,surname,age,phone,email) values(?,?,?,?,?) ");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(4, u.getPhone());
            stmt.setString(5, u.getEmail());
            stmt.setInt(3, u.getAge());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
                    return false; 

        }
    }

    

}
