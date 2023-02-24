package org.rhuamani.poointerfaces.repositorio;

import org.rhuamani.poointerfaces.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio<T> {
    List<T> listar(int desde, int hasta);
}
