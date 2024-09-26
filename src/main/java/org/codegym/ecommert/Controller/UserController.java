package org.codegym.ecommert.Controller;

import org.codegym.ecommert.Entity.User;
import org.codegym.ecommert.Service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserController", urlPatterns = {"/admin/users/*"})
public class UserController extends BaseController {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        if (url == null) {
            url = "/";
        }

        switch (url) {
            case "/":
                userService.showPageUserList(req, resp);
                break;
            case "/add":
                userService.showPageAddUser(req, resp);
                break;
            case "/delete":
                userService.deleteUser(req, resp);
                break;
            default:
                pageNotFound(req, resp);
        }
    }

}
