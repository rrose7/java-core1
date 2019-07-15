package com.vastika.training.java.jdbc1.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    public static Connection getConnection() {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cns?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

            return con;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }finally {
            System.out.println("DB connection done");
        }


        return null;
    }

    }

