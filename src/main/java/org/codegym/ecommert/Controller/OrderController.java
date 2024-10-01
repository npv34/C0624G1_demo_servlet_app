package org.codegym.ecommert.Controller;

import org.codegym.ecommert.Service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "OrderController", urlPatterns = {"/admin/orders/*"})
public class OrderController extends BaseController{
    private OrderService orderService;
    @Override
    public void init() throws ServletException {
        orderService = new OrderService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String url = req.getPathInfo();
         if (url == null) {
             url = "/";
         }

         switch (url) {
             case "/":
                 try {
                     orderService.showPageListOrder(req, resp);
                 } catch (SQLException e) {
                     throw new RuntimeException(e);
                 }
                 break;

             default:
                 pageNotFound(req, resp);
                 break;
         }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
