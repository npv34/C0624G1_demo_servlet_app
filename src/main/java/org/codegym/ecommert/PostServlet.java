package org.codegym.ecommert;

import org.codegym.ecommert.Controller.BaseController;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "PostServlet", urlPatterns = {"/admin/posts/*"})

public class PostServlet extends BaseController {
}
