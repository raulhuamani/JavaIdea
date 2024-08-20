package org.rhuamani.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rhuamani.apiservlet.webapp.headers.models.Categoria;
import org.rhuamani.apiservlet.webapp.headers.services.LoginService;
import org.rhuamani.apiservlet.webapp.headers.services.LoginServiceSessionImpl;
import org.rhuamani.apiservlet.webapp.headers.services.CategoriaService;
import org.rhuamani.apiservlet.webapp.headers.services.CategoriaServiceImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

@WebServlet("/categorias")
public class CategoriaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        CategoriaService service = new CategoriaServiceImpl(conn);
        List<Categoria> categorias = service.listar();

        LoginService auth = new LoginServiceSessionImpl();
        Optional<String> usernameOptional = auth.getUsername(req);

        req.setAttribute("categorias", categorias);
        req.setAttribute("username", usernameOptional);

        req.setAttribute("title", req.getAttribute("title") + ": Listado de categorias");
        getServletContext().getRequestDispatcher("/categorias/listar.jsp").forward(req, resp);
    }
}