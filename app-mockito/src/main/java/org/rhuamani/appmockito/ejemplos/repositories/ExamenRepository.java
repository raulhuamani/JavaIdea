package org.rhuamani.appmockito.ejemplos.repositories;

import org.rhuamani.appmockito.ejemplos.models.Examen;

import java.util.List;

public interface ExamenRepository {
    Examen guardar(Examen examen);
    List<Examen> findAll();
}