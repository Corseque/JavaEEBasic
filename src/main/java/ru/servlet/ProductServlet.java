package ru.servlet;

import model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(BasicServlet.class);
    private final List<Product> products = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New Products GET request");
        products.clear();
        for (int i = 0; i < 3; i++) {
            String title = req.getParameter("p" + (i + 1));
            if (title != null) {
                logger.info("New Product: " + req.getParameter("p" + (i + 1)));
                products.add(createProduct((i + 1), req.getParameter("p" + (i + 1))));
            }
        }
        resp.setHeader("Content-type", "text/html; charset=utf-8");
        resp.getWriter().println("<h1>New Products GET request</h1> ");
        for (Product product : products) {
            resp.getWriter().print("<br>");
            resp.getWriter().printf("id = %s product = %s cost = %s", product.getId(), product.getTitle(), product.getCost());
        }
    }

    private Product createProduct(int id, String p1) {
        Random random = new Random();
        return Product.builder()
                .id(id)
                .title(p1)
                .cost(random.nextInt(10) + 1)
                .build();
    }
}
