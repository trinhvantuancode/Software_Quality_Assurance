/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kakashi
 * @param <T>
 */
public abstract class DAO<T> {
    
    private static Connection conn;

    public DAO() {
        if(conn == null) {
            String user = "root";
            String pass = "Tuan@28121999";
            String dbname = "qlch";
            String dbclass = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/" + dbname +
                    "?useUnicode=true&default-character-set=utf8mb4";
            //characterEncoding=utf-8&useSSL=false
            try {
                Class.forName(dbclass);
                conn = DriverManager.getConnection(url, user, pass);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public abstract T checkLogin(T t);
    
    public abstract ArrayList<T> getAllCustomer();
    
    public abstract boolean addCustomer(T t);
    
    public abstract T getCustomer(T t);
    
    public abstract boolean editCustomer(T t);
    
    public Connection getConnection() {
        return conn;
    }
    
    public void closeConnection() {
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
