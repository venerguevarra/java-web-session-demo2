package jee.web.shoppee.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zaxxer.hikari.HikariDataSource;

import jee.web.shoppee.exceptions.DataAccessException;
import jee.web.shoppee.model.Toy;

public class ToyDAO {
    private final static String SELECT_ALL = "SELECT tid, tname, tdesc, tprice FROM toysdetails";
    private HikariDataSource dataSource;

    public ToyDAO(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public List<Toy> findAll() {
        final List<Toy> toys = new ArrayList<>();
        try {
            final PreparedStatement statement = dataSource.getConnection().prepareStatement(SELECT_ALL);
            final ResultSet result = statement.executeQuery();
            while(result.next()) {
                toys.add(this.toModel(result));
            }
        } catch (SQLException e) {
            throw new DataAccessException("Failed to retrieve list of toys.", e);
        }
        return toys;
    }

    private Toy toModel(ResultSet result) throws SQLException {
        Toy toy = new Toy();
        toy.setId(result.getString(1));
        toy.setName(result.getString(2));
        toy.setDescription(result.getString(3));
        toy.setPrice(result.getInt(4));
        return toy;
    }
}
