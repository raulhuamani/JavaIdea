package org.rhuamani.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rhuamani.apiservlet.webapp.headers.models.Curso;
import org.rhuamani.apiservlet.webapp.headers.services.CursoService;
import org.rhuamani.apiservlet.webapp.headers.services.CursoServiceImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@WebServlet("/cursos/form")
public class CursoFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        CursoService service = new CursoServiceImpl(conn);
        long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (NumberFormatException e) {
            id = 0L;
        }
        Curso curso = new Curso();
        if (id > 0) {
            Optional<Curso> o = service.porId(id);
            if (o.isPresent()) {
                curso = o.get();
            }
        }
        req.setAttribute("curso", curso);
        req.setAttribute("titulo", id > 0 ? "Tarea 10: Editar curso" : "Tarea 10: Crear curso");
        getServletContext().getRequestDispatcher("/cursos/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        CursoService service = new CursoServiceImpl(conn);
        String nombre = req.getParameter("nombre");
        String descripcion = req.getParameter("descripcion");
        String instructor = req.getParameter("instructor");

        double duracion;
        try {
            duracion = Double.parseDouble(req.getParameter("duracion"));
        } catch (NumberFormatException e) {
            duracion = 0;
        }

        Map<String, String> errores = new HashMap<>();
        if (nombre == null || nombre.isBlank()) {
            errores.put("nombre", "el nombre es requerido!");
        }
        if (descripcion == null || descripcion.isBlank()) {
            errores.put("descripcion", "la descripcion es requerida!");
        }

        if (instructor == null || instructor.isBlank()) {
            errores.put("instructor", "el instructor es requerido");
        }
        if (duracion == 0) {
            errores.put("duracion", "la duracion es requerida!");
        }

        long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (NumberFormatException e) {
            id = 0L;
        }
        Curso curso = new Curso();
        curso.setId(id);
        curso.setNombre(nombre);
        curso.setDescripcion(descripcion);
        curso.setInstructor(instructor);
        curso.setDuracion(duracion);

        if (errores.isEmpty()) {
            service.guardar(curso);
            resp.sendRedirect(req.getContextPath() + "/cursos");
        } else {
            req.setAttribute("errores", errores);
            req.setAttribute("curso", curso);
            req.setAttribute("titulo", id > 0 ? "Tarea 10: Editar curso" : "Tarea 10: Crear curso");
            getServletContext().getRequestDispatcher("/cursos/form.jsp").forward(req, resp);
        }
    }
}