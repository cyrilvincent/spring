package fr.aprr.formation.repositories;

import fr.aprr.formation.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerSpringJdbcRepository implements IRepository<Customer> {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private ApplicationContext context;

    @Override
    public List<Customer> getAll() throws SQLException {
        return getBySql("select * from public.customer");
    }

    @Override
    public Customer getById(int id) throws SQLException {
        return getBySql("select * from public.customer where id=" + id).get(0);
    }

    private List<Customer> getBySql(String sql) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        RowMapper<Customer> mapper = new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
                Customer c = context.getBean("customer", Customer.class);
                c.setId(resultSet.getInt("id"));
                c.setLname(resultSet.getString("lname"));
                c.setFname(resultSet.getString("fname"));
                String comment = resultSet.getString("comment");
                if(comment!=null) {
                    c.setComment(comment);
                }
                return c;
            }
        };
        List<Customer> res = template.query(sql, mapper);
        return res;
    }
}
