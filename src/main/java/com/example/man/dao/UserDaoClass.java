package com.example.man.dao;
import com.example.man.model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
public class UserDaoClass implements UserDao{

    List<User> users=new ArrayList<User>();
    Connection con;

    {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database2", "Nandhini", "Nandhini@4");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public List<User> getAll() throws SQLException {
        Statement st= con.createStatement();
        ResultSet rs=st.executeQuery("select * from user");
        while(rs.next())
        {
            User us=new User();
            us.setId(rs.getInt("id"));
            us.setName(rs.getString("name"));
            users.add(us);
        }
        return users;
    }
    public List<User> getOne(int id) throws SQLException {
        PreparedStatement stat = con.prepareStatement("select * from user where id= ?");
        stat.setInt(1, id);
        ResultSet res = stat.executeQuery();
        while (res.next()) {
            User user = new User();
            user.setId(res.getInt("id"));
            user.setName(res.getString("name"));
            users.add(user);
        }

        return users;
    }
    public void create(User user) throws SQLException {

        PreparedStatement stat = con.prepareStatement("insert into user (id,name) values(?,?)");
        stat.setInt(1, user.getId());
        stat.setString(2,user.getName());
        stat.executeUpdate();
    }
    public void update(User user, String id) throws SQLException {

        PreparedStatement stat = con.prepareStatement(" UPDATE user SET name = ? WHERE id = ?;");
        stat.setString(1,user.getName());
        stat.setInt(2, Integer.parseInt(id));
        stat.executeUpdate();

    }
    public int delete(int id) throws SQLException {

        PreparedStatement stat = con.prepareStatement("delete from user where id= ?;");
        stat.setInt(1, id);
        int res=stat.executeUpdate();
        return 0;

    }
}
