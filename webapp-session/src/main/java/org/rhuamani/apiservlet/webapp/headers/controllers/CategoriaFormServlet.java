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
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@WebServlet("/categorias/form")
public class CategoriaFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        CategoriaService service = new CategoriaServiceImpl(conn);
        long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (NumberFormatException e) {
            id = 0L;
        }
        Categoria categoria = new Categoria();

        if (id > 0) {
            Optional<Categoria> o = service.porId(id);
            if (o.isPresent()) {
                categoria = o.get();
            }
        }

        req.setAttribute("categoria", categoria);
        req.setAttribute("title", req.getAttribute("title") + ": Registro de categoria");

        getServletContext().getRequestDispatcher("/categorias/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        CategoriaService service = new CategoriaServiceImpl(conn);

        long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (NumberFormatException e) {
            id = 0L;
        }

        String nombre = req.getParameter("nombre");

        Map<String, String> errores = new HashMap<>();

        if (nombre == null || nombre.isBlank()) {
            errores.put("nombre", "el nombre es requerido!");
        }

        Categoria categoria = new Categoria();

        if (id > 0) {
            Optional<Categoria> o = service.porId(id);
            if (o.isPresent()) {
                categoria = o.get();
            }
        }

        categoria.setNombre(nombre);

        if (errores.isEmpty()) {
            service.guardar(categoria);
            resp.sendRedirect(req.getContextPath() + "/categorias");
        } else {
            req.setAttribute("errores", errores);
            req.setAttribute("categoria", categoria);
            req.setAttribute("title", req.getAttribute("title") + ": Formulario de categoria");
            getServletContext().getRequestDispatcher("/categorias/form.jsp").forward(req, resp);
        }
    }
}