package org.rhuamani.appfacturas.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {

    private int numFatura;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private Detalle[] items;
    private int indiceItems;
    public static final int MAX_ITEMS = 10;
    private static int ultimaFactura;

    public Factura(String descripcion, Cliente cliente) {
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.items = new Detalle[MAX_ITEMS];
        this.numFatura = ++ultimaFactura;
        this.fecha = new Date();
    }

    public int getNumFatura() {
        return numFatura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Detalle[] getItems() {
        return items;
    }

    public void addItemFactura(Detalle item){
        if(indiceItems < MAX_ITEMS) {
            this.items[indiceItems++] = item;
        }
    }

    public float calcularTotal(){
        float total = 0.0f;
        for (int i=0; i < indiceItems; i++) {
            /*if(item == null){
                continue;
            }*/
            total += this.items[i].calcularImporte();
        }
        return total;
    }

    public String generarDetalle(){
        StringBuilder sb = new StringBuilder("Factura N°: ");
        sb.append(numFatura)
                .append("\nCliente: ")
                .append(this.cliente.getNombre())
                .append("\t RUC: ")
                .append(cliente.getRuc())
                .append("\nDescripcion: ")
                .append(this.descripcion)
                .append("\n");

        SimpleDateFormat df = new SimpleDateFormat("dd 'de ' MMMM, yyyy");
        sb.append("Fecha Emisión: ")
                .append(df.format(this.fecha))
                .append("\n")
                .append("\n#\tNombre\t$\tCant.\tTotal\n");

        for (int i=0; i < indiceItems; i++) {
            /*Detalle item = this.items[i];
            if (item == null){
                continue;
            }
            sb.append(item.getProducto().getCodigo())
                    .append("\t")
                    .append(item.getProducto().getNombre())
                    .append("\t")
                    .append(item.getProducto().getPrecio())
                    .append("\t")
                    .append(item.getCantidad())
                    .append("\t")
                    .append(item.calcularImporte())*/
            sb.append(this.items[i].toString())
                    .append("\n");
        }
        sb.append("\nGran Total: ")
                .append(calcularTotal());

        return sb.toString();
    }

    @Override
    public String toString() {
        return generarDetalle();
    }
}
