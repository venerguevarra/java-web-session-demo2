package jee.web.shoppee.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public abstract class AbstractController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RequestDispatcher getDispatcher(final HttpServletRequest request, final String path) {
        final RequestDispatcher dispatcher = request.getRequestDispatcher(path);
        return dispatcher;
    }
}
