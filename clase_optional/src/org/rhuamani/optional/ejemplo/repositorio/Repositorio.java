package org.rhuamani.optional.ejemplo.repositorio;

import org.rhuamani.optional.ejemplo.models.Computador;

import java.util.Optional;

public interface Repositorio<T> {
    Optional<Computador> filtrar(String nombre);
}
