package jee.web.shoppee.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jee.web.shoppee.factory.ApplicationFactory;
import jee.web.shoppee.model.Book;
import jee.web.shoppee.service.CatalogService;

@WebServlet(urlPatterns = "/book-catalog", loadOnStartup = 1)
public class BookCatalogController extends AbstractController {
    private static final long serialVersionUID = 7919391415762386219L;

    private CatalogService catalogService;

    @Override
    public void init() throws ServletException {
        this.catalogService = ApplicationFactory.getInstance().getCatalogService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final List<Book> books = this.catalogService.getBookCatalog();
        request.setAttribute("bookCatalog", books);
        getDispatcher(request, "/bookCatalog.jsp").forward(request, response);
    }

}
