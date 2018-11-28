package jee.web.shoppee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jee.web.shoppee.model.CartItem;
import jee.web.shoppee.model.ShoppingCart;

@WebServlet(urlPatterns = "/shopping-cart")
public class ShoppingCartController extends AbstractController {
    private static final long serialVersionUID = 7919391415762386219L;
    private static final String ADD_ACTION = "add";
    private static final String REMOVE_ACTION = "remove";
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	final HttpSession session = request.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");

        final String action = request.getParameter("action");
        if(ADD_ACTION.equals(action)) {
            add(shoppingCart, request);
    	} else if(REMOVE_ACTION.equals(action)) {
    		remove(shoppingCart, request);
    	}

        session.setAttribute("shoppingCart", shoppingCart);
        getDispatcher(request, "/shoppingCart.jsp").forward(request, response);;
    }

    private void add(ShoppingCart shoppingCart, HttpServletRequest request) {
    	if(shoppingCart == null) {
            shoppingCart = new ShoppingCart();
        }
        final CartItem item = toModel(request);
        shoppingCart.add(item);
    }

    private void remove(ShoppingCart shoppingCart, HttpServletRequest request) {
    	final String cartItemId = request.getParameter("cartItemId");
		shoppingCart.remove(cartItemId);
    }

    private CartItem toModel(HttpServletRequest request) {
        CartItem cartItem = new CartItem();
        cartItem.setId(request.getParameter("id"));
        cartItem.setDescription(request.getParameter("description"));
        cartItem.setName(request.getParameter("name"));
        cartItem.setPrice(Integer.parseInt(request.getParameter("price")));
        cartItem.setQuantity(1);
        return cartItem;
    }
}
