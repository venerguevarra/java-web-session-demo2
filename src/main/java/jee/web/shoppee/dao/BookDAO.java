package jee.web.shoppee.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zaxxer.hikari.HikariDataSource;

import jee.web.shoppee.exceptions.DataAccessException;
import jee.web.shoppee.model.Book;

public class BookDAO {
    private final static String SELECT_ALL = "SELECT bid, title, bookdesc, bookprice, aid FROM booksdetails";
    private HikariDataSource dataSource;

    public BookDAO(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public List<Book> findAll() {
        final List<Book> books = new ArrayList<>();
        try {
            final PreparedStatement statement = dataSource.getConnection().prepareStatement(SELECT_ALL);
            final ResultSet result = statement.executeQuery();
            while(result.next()) {
                books.add(this.toModel(result));
            }
        } catch (SQLException e) {
            throw new DataAccessException("Failed to retrieve list of books.", e);
        }
        return books;
    }

    private Book toModel(ResultSet result) throws SQLException {
        Book book = new Book();
        book.setId(result.getString(1));
        book.setName(result.getString(2));
        book.setDescription(result.getString(3));
        book.setPrice(result.getInt(4));
        book.setAuthorId(result.getString(5));
        return book;
    }
}
