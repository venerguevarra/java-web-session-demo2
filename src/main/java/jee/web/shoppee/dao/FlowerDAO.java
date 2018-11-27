package jee.web.shoppee.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zaxxer.hikari.HikariDataSource;

import jee.web.shoppee.exceptions.DataAccessException;
import jee.web.shoppee.model.Flower;

public class FlowerDAO {
    private final static String SELECT_ALL = "SELECT fid, fname, fdesc, fprice FROM flowersdetails";
    private HikariDataSource dataSource;

    public FlowerDAO(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public List<Flower> findAll() {
        final List<Flower> flowers = new ArrayList<>();
        try {
            final PreparedStatement statement = dataSource.getConnection().prepareStatement(SELECT_ALL);
            final ResultSet result = statement.executeQuery();
            while(result.next()) {
                flowers.add(this.toModel(result));
            }
        } catch (SQLException e) {
            throw new DataAccessException("Failed to retrieve list of flowers.", e);
        }
        return flowers;
    }

    private Flower toModel(ResultSet result) throws SQLException {
        Flower flower = new Flower();
        flower.setId(result.getString(1));
        flower.setName(result.getString(2));
        flower.setDescription(result.getString(3));
        flower.setPrice(result.getInt(4));
        return flower;
    }
}
