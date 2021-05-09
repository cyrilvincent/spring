package fr.aprr.formation.repositories;

import fr.aprr.formation.entities.Book;
import fr.aprr.formation.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookJdbcRepository implements IRepository<Book> {

    private String driver = "org.postgresql.Driver";
    private String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
    @Autowired
    private ApplicationContext context;

    public BookJdbcRepository() throws ClassNotFoundException {
        Class.forName(driver);
    }

    @Override
    public List<Book> getAll() throws SQLException {
        return getBySql("select * from public.book");
    }

    @Override
    public Book getById(int id) throws SQLException {
        return getBySql("select * from public.book where id=" + id).get(0);
    }

    private List<Book> getBySql(String sql) throws SQLException {
        Connection connection = DriverManager.getConnection(url,"postgres","sa");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        List<Book> res = new ArrayList<>();
        while(rs.next()) {
            Book b = context.getBean("book", Book.class);
            b.setId(rs.getInt("id"));
            b.setTitle(rs.getString("title"));
            b.setPrice(rs.getDouble("price"));
            Integer nbPage = rs.getInt("nbpage");
            if(nbPage!=null) {
                b.setNbPage(nbPage);
            }
            res.add(b);
        }
        return res;
    }
}
