package org.codegym.ecommert.Service;

import org.codegym.ecommert.Entity.User;
import org.codegym.ecommert.Model.UserModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserService {

    private UserModel userModel;

    public UserService() {
        this.userModel = new UserModel();
    }

    public void showPageUserList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get all users from model
        List<User> users = userModel.getAllUser();
        // set data vao request de truyen xuong jsp
        request.setAttribute("data", users);

        // forward request to user.jsp
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/user.jsp");
        requestDispatcher.forward(request, response);
    }

    public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException{
        int id = Integer.parseInt(request.getParameter("id"));
        User useDelete = userModel.findUserById(id);
        userModel.deleteUser(useDelete);
    }

    public void showPageAddUser(HttpServletRequest request, HttpServletResponse response) {

    }
}
