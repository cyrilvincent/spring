package fr.aprr.formation.repositories;

import fr.aprr.formation.entities.Book;
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
public class BookSpringJdbcRepository implements IRepository<Book> {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private ApplicationContext context;

    @Override
    public List<Book> getAll() throws SQLException {
        return getBySql("select * from public.book");
    }

    @Override
    public Book getById(int id) throws SQLException {
        return getBySql("select * from public.book where id=" + id).get(0);
    }

    private List<Book> getBySql(String sql) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        RowMapper<Book> mapper = new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet resultSet, int i) throws SQLException {
                Book b = context.getBean("book", Book.class);
                b.setId(resultSet.getInt("id"));
                b.setTitle(resultSet.getString("title"));
                b.setPrice(resultSet.getDouble("price"));
                Integer nbPage = resultSet.getInt("nbpage");
                if(nbPage!=null) {
                    b.setNbPage(nbPage);
                }
                return b;
            }
        };
        List<Book> res = template.query(sql, mapper);
        return res;
    }
}
