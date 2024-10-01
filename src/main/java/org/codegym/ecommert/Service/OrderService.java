package org.codegym.ecommert.Service;

import org.codegym.ecommert.Entity.Customer;
import org.codegym.ecommert.Entity.Order;
import org.codegym.ecommert.Model.OrderModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderService {
    private OrderModel orderModel;

    public OrderService() {
        orderModel = new OrderModel();
    }

    public void showPageListOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        ResultSet data = orderModel.getAllOrder();
        List<Order> listOrder = new ArrayList<Order>();

        // ORM
        while (data.next()){
            int orderId = data.getInt("order_id");
            String customerName = data.getString("customer_name");
            int customerId = data.getInt("customer_id");
            Date orderDate = data.getDate("order_date");
            double totalAmount = data.getDouble("total_amount");
            String email = data.getString("email");
            String phone = data.getString("phone");
            String address = data.getString("address");

            Customer customer = new Customer(customerName, email, phone, address);
            customer.setId(customerId);

            Order order = new Order(customer, orderDate, totalAmount);
            order.setId(orderId);

            listOrder.add(order);
        }

        request.setAttribute("listOrder", listOrder);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/orders/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
