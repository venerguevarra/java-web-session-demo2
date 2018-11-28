package jee.web.shoppee.factory;

import com.zaxxer.hikari.HikariDataSource;

import jee.web.shoppee.dao.BookDAO;
import jee.web.shoppee.dao.FlowerDAO;
import jee.web.shoppee.dao.ToyDAO;
import jee.web.shoppee.db.ConnectionPool;
import jee.web.shoppee.service.CatalogService;

public class ApplicationFactory {
    private static ApplicationFactory applicationFactory;
    private CatalogService catalogService;
    private FlowerDAO flowerDAO;
    private BookDAO bookDAO;
    private ToyDAO toyDAO;

    private ApplicationFactory() {
        init();
    }

    private void init() {
        final HikariDataSource dataSource = ConnectionPool.getInstance().getDataSource();
        this.flowerDAO = new FlowerDAO(dataSource);
        this.toyDAO = new ToyDAO(dataSource);
        this.bookDAO = new BookDAO(dataSource);

        this.catalogService = new CatalogService(bookDAO, flowerDAO, toyDAO);
    }

    public static void instantiate() {
        if (applicationFactory == null) {
            applicationFactory = new ApplicationFactory();
        }
    }

    public static ApplicationFactory getInstance() {
        return applicationFactory;
    }

    public FlowerDAO getFlowerDAO() {
        return flowerDAO;
    }

    public ToyDAO getToyDAO() {
        return toyDAO;
    }

    public BookDAO getBookDAO() {
        return bookDAO;
    }

    public CatalogService getCatalogService() {
        return catalogService;
    }
}
