package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

        String kismalac = """
                insert into jarmuvek
                (rendszam,marka)
                values
                (?,?);
                """;
        PreparedStatement ps = conn.prepareStatement(kismalac);
        ps.setString(1, "ribi-01");
        ps.setString(2, "Saang-Yong");
        ps.executeUpdate();

        String sql = "select * from jarmuvek";
        Statement kiskutya = conn.createStatement();
        ResultSet rs = kiskutya.executeQuery(sql);
        while(rs.next()) {
            System.out.println(rs.getString("rendszam"));
        }
        conn.close();
    }
}

//task failed successfully