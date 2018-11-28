package jee.web.shoppee.service;

import java.util.List;

import jee.web.shoppee.dao.BookDAO;
import jee.web.shoppee.dao.FlowerDAO;
import jee.web.shoppee.dao.ToyDAO;
import jee.web.shoppee.exceptions.DataAccessException;
import jee.web.shoppee.exceptions.ServiceException;
import jee.web.shoppee.model.Book;
import jee.web.shoppee.model.Flower;
import jee.web.shoppee.model.Toy;

public class CatalogService {
    private BookDAO bookDAO;
    private FlowerDAO flowerDAO;
    private ToyDAO toyDAO;

    public CatalogService(BookDAO bookDAO, FlowerDAO flowerDAO, ToyDAO toyDAO) {
        this.bookDAO = bookDAO;
        this.flowerDAO = flowerDAO;
        this.toyDAO = toyDAO;
    }

    public List<Book> getBookCatalog() {
        try {
            return bookDAO.findAll();
        } catch (DataAccessException e) {
            throw new ServiceException("Failed to create book catalog", e);
        }
    }

    public List<Flower> getFlowerCatalog() {
        try {
            return flowerDAO.findAll();
        } catch (DataAccessException e) {
            throw new ServiceException("Failed to create flower catalog", e);
        }
    }

    public List<Toy> getToyCatalog() {
        try {
            return toyDAO.findAll();
        } catch (DataAccessException e) {
            throw new ServiceException("Failed to create toy catalog", e);
        }
    }

    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public void setFlowerDAO(FlowerDAO flowerDAO) {
        this.flowerDAO = flowerDAO;
    }

    public void setToyDAO(ToyDAO toyDAO) {
        this.toyDAO = toyDAO;
    }
}
