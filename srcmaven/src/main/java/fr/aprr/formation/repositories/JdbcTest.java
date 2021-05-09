package fr.aprr.formation.repositories;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class JdbcTest {

    public static void test() {
        String driver = "org.postgresql.Driver";
        String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url,"postgres","sa");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from public.customer");
            while(rs.next()) {
                String lname = rs.getString("lname");
                log.info(lname);
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
