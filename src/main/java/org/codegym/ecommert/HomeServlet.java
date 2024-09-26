package org.codegym.ecommert;

import org.codegym.ecommert.Controller.BaseController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HomeServlet", urlPatterns = {"/admin/home/*"})
public class HomeServlet extends BaseController {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        if (url == null) {
            url = "/";
        }

        if (url.equals("/")) {
            showHomePage(req, resp);
        } else {
            pageNotFound(req, resp);
        }
    }

    private void showHomePage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        writer.println("<h1>Home Page</h1>");
    }




    @Override
    public void destroy() {
        super.destroy();
    }
}
