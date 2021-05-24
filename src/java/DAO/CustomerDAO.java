/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import bean.Customers;
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
public class CustomerDAO extends DAO<Customers> {

    @Override
    public Customers checkLogin(Customers t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Customers> getAllCustomer() {
        try {
            ArrayList<Customers> result = new ArrayList<>();
            String sql = "select * from customers";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(toCus(rs));
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Customers toCus(ResultSet rs) throws SQLException {
        return new Customers(rs.getString("idcustomer"), rs.getString("fullname"),
                rs.getString("firstname"), rs.getString("middlename"),
                rs.getString("lastname"), rs.getString("address"),
                rs.getString("phonenumber"), rs.getString("email"),
                rs.getString("fromto"));
    }

    @Override
    public boolean addCustomer(Customers t) {
        try {
            String sql = "insert into customers(fullname, firstname, "
                    + "middlename, lastname, address, phonenumber, email, fromto) "
                    + "values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, t.getFullname());
            ps.setString(2, t.getFirstname());
            ps.setString(3, t.getMiddlename());
            ps.setString(4, t.getLastname());
            ps.setString(5, t.getAddress());
            ps.setString(6, t.getPhonenumber());
            ps.setString(7, t.getEmail());
            ps.setString(8, t.getFromto());
            int check = ps.executeUpdate();
            return check == 1;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Customers getCustomer(Customers t) {
        try {
            String sql = "select * from customers where idcustomer=?";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, t.getIdcustomer());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return (toCus(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean editCustomer(Customers t) {
        try {
            String sql = "update Customers set fullname=`?`, firstname=`?`, "
                    + "middlename=`?`, lastname=`?`, address=`?`, phonenumber=`?`"
                    + ", email=`?`, fromto=`?` where idcustomer=?";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, t.getFullname());
            ps.setString(2, t.getFirstname());
            ps.setString(3, t.getMiddlename());
            ps.setString(4, t.getLastname());
            ps.setString(5, t.getAddress());
            ps.setString(6, t.getPhonenumber());
            ps.setString(7, t.getEmail());
            ps.setString(8, t.getFromto());
            int check = ps.executeUpdate();
            return check == 1;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
