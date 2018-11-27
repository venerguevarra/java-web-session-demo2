package jee.web.shoppee.db;

import java.util.ResourceBundle;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionPool {
    private final static ResourceBundle BUNDLE = ResourceBundle.getBundle("database");

    private HikariDataSource dataSource;

    private ConnectionPool() {
        this.init();
    }

    private void init() {
        if (dataSource == null) {
            HikariConfig jdbcConfig = new HikariConfig();
            jdbcConfig.setPoolName(BUNDLE.getString("db.poolName"));
            jdbcConfig.setMaximumPoolSize(Integer.parseInt(BUNDLE.getString("db.maximumPoolSize")));
            jdbcConfig.setMinimumIdle(Integer.parseInt(BUNDLE.getString("db.minimumIdle")));
            jdbcConfig.setJdbcUrl(BUNDLE.getString("db.url"));
            jdbcConfig.setUsername(BUNDLE.getString("db.username"));
            jdbcConfig.setPassword(BUNDLE.getString("db.password"));
            jdbcConfig.setDriverClassName(BUNDLE.getString("db.driver"));

            jdbcConfig.addDataSourceProperty("cachePrepStmts", BUNDLE.getString("db.cachePrepStmts"));
            jdbcConfig.addDataSourceProperty("prepStmtCacheSize", BUNDLE.getString("db.prepStmtCacheSize"));
            jdbcConfig.addDataSourceProperty("prepStmtCacheSqlLimit", BUNDLE.getString("db.prepStmtCacheSqlLimit"));
            jdbcConfig.addDataSourceProperty("useServerPrepStmts", BUNDLE.getString("db.useServerPrepStmts"));

            this.dataSource = new HikariDataSource(jdbcConfig);
        }
    }

    private static ConnectionPool connectionPool;
    public static ConnectionPool getInstance() {
        if (connectionPool == null) {
            connectionPool = new ConnectionPool();
        }
        return connectionPool;
    }

    public HikariDataSource getDataSource() {
        return dataSource;
    }
}
