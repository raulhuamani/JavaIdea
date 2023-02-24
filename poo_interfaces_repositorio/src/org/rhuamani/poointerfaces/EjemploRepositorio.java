package org.rhuamani.poointerfaces;

import org.rhuamani.poointerfaces.modelo.Cliente;
import org.rhuamani.poointerfaces.repositorio.*;
import org.rhuamani.poointerfaces.repositorio.excepciones.*;
import org.rhuamani.poointerfaces.repositorio.lista.ClienteListRepositorio;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {
        try {
            //CrudRepositorio repo =  new ClienteListRepositorio();     // comentado por Herencia multiple entre interfaces (Video 220)
            OrdenablePaginableCrudRepositorio<Cliente> repo = new ClienteListRepositorio();
            repo.crear(new Cliente("Raul", "Huamani"));
            repo.crear(new Cliente("Yuri", "Huaman"));
            repo.crear(new Cliente("Luciana", "Huamani"));
            Cliente andres = new Cliente("Andres", "Guzman");
            repo.crear(andres);
            //repo.crear(andres);

            //repo.crear(null);
            System.out.println("====== Listar ======");
            List<Cliente> clientes = repo.listar();
            clientes.forEach(System.out::println);
            System.out.println("====== Paginable ======");
            //List<Cliente> paginable = ((PaginableRepositorio) repo).listar(0,3);      //evitamos castear - Herencia multiple de interfases
            List<Cliente> paginable = repo.listar(0,3);
            paginable.forEach(System.out::println);
            System.out.println("====== Ordenar ======");
            List<Cliente> clientesOrdenAsc = repo.listar("apellido", Direccion.DESC);
            for (Cliente c : clientesOrdenAsc){
                System.out.println(c);
            }
            System.out.println("====== Editar ======");
            Cliente andresActualizar = new Cliente("Andrew", "Perez");
            andresActualizar.setId(4);
            repo.editar(andresActualizar);
            Cliente obj = repo.porId(4);
            System.out.println("Actualizado : " + obj);
            System.out.println("================================");
            //((OrdenableRepositorio) repo).listar("nombre", Direccion.ASC).forEach(System.out::println);
            repo.listar("nombre", Direccion.ASC).forEach(System.out::println);
            System.out.println("====== Eliminar ======");
            repo.eliminar(4);
            repo.listar().forEach(System.out::println);
            System.out.println("====== Total ======");
            System.out.println("Total de Registros: " + repo.total());
        } catch (RegistroDuplicadoAccesoDatoException e){
            System.out.println("RegistroDuplicado: " + e.getMessage());
            e.printStackTrace();
        } catch (LecturaAccesoDatoException e){
            System.out.println("Lectura: " + e.getMessage());
            e.printStackTrace();
        } catch (EscrituraAccesoDatoException e){
            System.out.println("Escritura: " + e.getMessage());
            e.printStackTrace();
        } catch (AccesoDatoException e){
            System.out.println("Genérica: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
