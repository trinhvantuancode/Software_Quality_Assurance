/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import bean.Users;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Kakashi
 */
public class UserDAO extends DAO<Users>{

    public UserDAO() {
        super();
    }

    @Override
    public Users checkLogin(Users user) {
        try {
            String sql = "select * from users where username = ? AND password = ?";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return (toUser(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Users toUser(ResultSet rs) throws SQLException {
        return new Users(rs.getInt("idusers"), rs.getString("username"), rs.getString("password"), 
                        rs.getString("fullname"), rs.getString("address"), rs.getString("phonenumber"), 
                        rs.getString("email"), rs.getString("fisrtname"), rs.getString("middlename"), 
                        rs.getString("lastname"), rs.getDate("dateofbirth"), rs.getString("position"));
    }

    @Override
    public ArrayList<Users> getAllCustomer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addCustomer(Users t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Users getCustomer(Users t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editCustomer(Users t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
