package org.rhuamani.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rhuamani.apiservlet.webapp.headers.models.Categoria;
import org.rhuamani.apiservlet.webapp.headers.services.CategoriaService;
import org.rhuamani.apiservlet.webapp.headers.services.CategoriaServiceImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/categorias/buscar")
public class CategoriaBuscarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        CategoriaService service = new CategoriaServiceImpl(conn);
        String nombre = req.getParameter("nombre");

        List<Categoria> categorias = service.porNombre(nombre);

        req.setAttribute("title", req.getAttribute("title") + ": Listado de categorias");
        req.setAttribute("categorias", categorias);
        getServletContext().getRequestDispatcher("/categorias/listar.jsp").forward(req, resp);
    }
}