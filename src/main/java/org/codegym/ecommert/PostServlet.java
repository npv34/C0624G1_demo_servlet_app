package org.codegym.ecommert;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "PostServlet", urlPatterns = {"/admin/posts/*"})

public class PostServlet extends BaseServlet {
}
