package fr.aprr.formation.repositories;

import fr.aprr.formation.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerJdbcRepository implements IRepository<Customer> {

    private String driver = "org.postgresql.Driver";
    private String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
    @Autowired
    private ApplicationContext context;

    public CustomerJdbcRepository() throws ClassNotFoundException {
        Class.forName(driver);
    }

    @Override
    public List<Customer> getAll() throws SQLException {
        return getBySql("select * from public.customer");
    }

    @Override
    public Customer getById(int id) throws SQLException {
        return getBySql("select * from public.customer where id=" + id).get(0);
    }

    private List<Customer> getBySql(String sql) throws SQLException {
        Connection connection = DriverManager.getConnection(url,"postgres","sa");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        List<Customer> res = new ArrayList<>();
        while(rs.next()) {
            Customer c = context.getBean("customer", Customer.class);
            c.setId(rs.getInt("id"));
            c.setLname(rs.getString("lname"));
            c.setFname(rs.getString("fname"));
            String comment = rs.getString("comment");
            if(comment!=null) {
                c.setComment(comment);
            }
            res.add(c);
        }
        return res;
    }
}
