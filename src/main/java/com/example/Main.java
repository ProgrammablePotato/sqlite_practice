package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//create database test01;
//grant all PRIVILEGES on test01.* to test01@localhost identified by 'titok';
//insert into jarmuvek values("aaa","Smart"),("bbb","Subaru"),("ccc","Supra");
public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:sqlite:database.sqlite";
        String user = "test01";
        String pass = "titok";
        Connection conn = DriverManager.getConnection(url, user, pass);
        System.out.println("oksikaaaa");
        String sql = "select * from jarmuvek";
        Statement kiskutya = conn.createStatement();
        ResultSet rs = kiskutya.executeQuery(sql);
        while(rs.next()) {
            System.out.println(rs.getString("rendszam"));
        }
    }
}

//task failed successfully