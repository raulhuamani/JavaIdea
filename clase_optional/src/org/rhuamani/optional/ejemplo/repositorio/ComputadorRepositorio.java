package org.rhuamani.optional.ejemplo.repositorio;

import org.rhuamani.optional.ejemplo.models.Computador;
import org.rhuamani.optional.ejemplo.models.Fabricante;
import org.rhuamani.optional.ejemplo.models.Procesador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComputadorRepositorio implements Repositorio {
    private List<Computador> dataSource;

    public ComputadorRepositorio() {
        dataSource = new ArrayList<>();
        Procesador proc = new Procesador("I9-9880H", new Fabricante("Intel"));
        Computador asus = new Computador("Asus ROG", "Strix G512");
        asus.setProcesador(proc);
        dataSource.add(asus);
        dataSource.add(new Computador("MacBook Pro", "MVVK2CI"));
    }

    @Override
    public Optional<Computador> filtrar(String nombre) {
        return dataSource.stream()
                .filter( c -> c.getNombre().toUpperCase().contains(nombre.toUpperCase()))
                .findFirst();
        /*for (Computador c: dataSource){
            if (c.getNombre().equalsIgnoreCase(nombre)){
                return Optional.of(c);
            }
        }
        return Optional.empty();*/
    }
}
