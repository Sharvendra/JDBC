package controller;

import dao.UserDao;
import model.User;

import java.sql.SQLException;
import java.util.List;

public class App {
    public static void main(String[] args) {
        try {
            // read
//            List<User> users = UserDao.getAllUsers();
//            for (User u: users){
//                System.out.println(u.getId()+ "\t"+u.getName());
//            }
//            User u = UserDao.getUserById(20);
//            System.out.println(u == null ? "Not found" : u);
            //insert / create
//            User user = new User(0, "sab", "sab@gmail.com");
//            boolean ans = UserDao.saveUser(user);
//            System.out.println(ans ? "inserted" : "gadbad ho gyi");
            // delete
//            boolean ans = UserDao.deleteUser(1);
//            System.out.println(ans);
            //update
            User user = new User(5, "sab m","m@gmail.com");
            boolean ans = UserDao.updateUser(user);
            System.out.println(ans);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
