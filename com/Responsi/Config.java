/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Responsi;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */
public class Config {
    
    private static Connection conn;
    
    public static Connection configDB()throws SQLException{
        try{
            String url = "jdbc:mysql://localhost:3306/covid19";
            String user = "root";
            String pass = "";
            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            MysqlDataSource source = new MysqlDataSource();
              source.setUser(user);
              source.setPassword(pass);
              source.setURL(url);
              conn = source.getConnection();
        }catch(SQLException e){
            System.out.println("Database Connection Failed " + e.getMessage());
        }
        return conn;
    }
    
}
