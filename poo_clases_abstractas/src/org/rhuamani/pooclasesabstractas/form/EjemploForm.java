package org.rhuamani.pooclasesabstractas.form;

import org.rhuamani.pooclasesabstractas.form.elementos.*;
import org.rhuamani.pooclasesabstractas.form.elementos.select.Opcion;
import org.rhuamani.pooclasesabstractas.form.validador.*;

import java.util.Arrays;
import java.util.List;

public class EjemploForm {
    public static void main(String[] args) {

        InputForm username = new InputForm("username");
        username.addValidador(new RequeridoValidador());

        InputForm passowrd = new InputForm("clave", "password");
        passowrd.addValidador(new RequeridoValidador())
                .addValidador(new LargoValidador(6, 12));

        InputForm email = new InputForm("email", "email");
        email.addValidador(new RequeridoValidador())
                .addValidador(new EmailValidador());

        InputForm edad = new InputForm("edad", "number");
        edad.addValidador(new NumeroValidador());

        TextareaForm experiencia = new TextareaForm("exp", 5 , 9);

        SelectForm lenguaje = new SelectForm("lenguaje");
        lenguaje.addValidador(new NoNuloValidador());

        lenguaje.addOpcion(new Opcion("1", "Java"))
        .addOpcion(new Opcion("2", "Python"))
        .addOpcion(new Opcion("3", "JavaScript"))
        .addOpcion(new Opcion("4","TypeScript").setSelected())
        .addOpcion(new Opcion("5", "PHP"));

        ElementoForm saludar = new ElementoForm("saludo") {
            @Override
            public String dibujarHtml() {
                return "<input disabled name = '" + this.nombre + "' value = \"" + this.valor + "\">";
            }
        };

        saludar.setValor("Hola que tal este campo está deshabilitado");
        username.setValor("");
        passowrd.setValor("jj");
        email.setValor("rhuamanigmail.com");
        edad.setValor("36d");
        experiencia.setValor("... mas de 10 años de experiencia ...");
        //java.setSelected(true);

        /*List<ElementoForm> elementos = new ArrayList<>();
        elementos.add(username);
        elementos.add(passowrd);
        elementos.add(email);
        elementos.add(edad);
        elementos.add(experiencia);
        elementos.add(lenguaje);*/

        List<ElementoForm> elementos = Arrays.asList(username,
                passowrd,
                email,
                edad,
                experiencia,
                lenguaje,
                saludar);

        /*for (ElementoForm e: elementos){
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        }*/
        elementos.forEach(e -> {
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        });

        elementos.forEach(e -> {
            if(!e.esValido()){
                //e.getErrores().forEach(err -> System.out.println(e.getNombre() + ": " + err));
                e.getErrores().forEach(System.out::println);    // aplicando atajo x misma variable(err)
            }
        });
    }
}
