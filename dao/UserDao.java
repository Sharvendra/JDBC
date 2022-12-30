package dao;

import db.MyConnection;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    //read
    public static User getUserById(int id) throws SQLException {
       User user = null;
        Connection conn = MyConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from user where id = ?");
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
             id = rs.getInt(1);
            String name = rs.getString(2);
            String email = rs.getString(3);
             user = new User(id,name,email);

        }
        return user;
    }
    //insert/create
    public static boolean saveUser(User user) throws SQLException {
        Connection conn = MyConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into user values(default, ?,? )");
        ps.setString(1, user.getName());
        ps.setString(2, user.getEmail());
        int ans = ps.executeUpdate();
        return ans == 1 ;
    }
    //update
    public static boolean updateUser(User user) throws SQLException {
        Connection conn = MyConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(" update user set name = ? , email = ? where id= ?");
        ps.setString(1, user.getName());
        ps.setString(2, user.getEmail());
        ps.setInt(3,user.getId());
        int ans = ps.executeUpdate();
        return ans == 1 ;
    }
    //delete
    public static boolean deleteUser(int id) throws SQLException {
        Connection conn = MyConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("delete from user where id = ?");
        ps.setInt(1,id);
        int ans = ps.executeUpdate();
        return ans == 1 ;
    }

}
