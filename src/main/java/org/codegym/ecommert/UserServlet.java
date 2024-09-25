package org.codegym.ecommert;

import org.codegym.ecommert.Entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = {"/admin/users/*"})
public class UserServlet extends BaseServlet {
    private List<User> userList;

    @Override
    public void init() throws ServletException {
        userList = new ArrayList<>();
        // Initialize user list
        userList.add(new User(1, "John Doe", "johndoe@example.com"));
        userList.add(new User(2, "Jane Smith", "janesmith@example.com"));

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        if (url == null) {
            url = "/";
        }

        switch (url) {
            case "/":
                showUserList(req, resp);
                break;
            case "/add":
                addUser(req, resp);
                break;
            case "/delete":
                deleteUser(req, resp);
                break;
            default:
                pageNotFound(req, resp);
        }
    }

    public void showUserList(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("data", userList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/user.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public void addUser(HttpServletRequest request, HttpServletResponse response) {

    }

    public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User userDelete = null;
        for (User user : userList) {
            if (user.getId() == id) {
                userDelete = user;
                break;
            }
        }

        if (userDelete!= null) {
            userList.remove(userDelete);
            // set lai location trong response
            response.sendRedirect("/admin/users");
        }
    }
}
