package org.rhuamani.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rhuamani.apiservlet.webapp.headers.models.Curso;
import org.rhuamani.apiservlet.webapp.headers.models.Usuario;
import org.rhuamani.apiservlet.webapp.headers.services.CursoService;
import org.rhuamani.apiservlet.webapp.headers.services.CursoServiceImpl;
import org.rhuamani.apiservlet.webapp.headers.services.UsuarioService;
import org.rhuamani.apiservlet.webapp.headers.services.UsuarioServiceImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/usuarios/buscar")
public class UsuarioBuscarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        UsuarioService service = new UsuarioServiceImpl(conn);
        String nombre = req.getParameter("nombre");

        List<Usuario> usuarios = service.porNombre(nombre);

        req.setAttribute("title", req.getAttribute("title") + ": Listado de usuarios");
        req.setAttribute("usuarios", usuarios);
        getServletContext().getRequestDispatcher("/usuarios/listar.jsp").forward(req, resp);
    }
}