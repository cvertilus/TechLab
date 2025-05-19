package org.example;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private List<Producto> productos;

    public Pedido(int id, List<Producto> productos) {
        this.id = id;
        this.productos = productos;
    }

    public Pedido() {
        this.productos =  new ArrayList<>();
    }

    public double precioTotal() {
        Double precio = 0.0;
        for (Producto p : productos) {
            precio += p.getPrecio();
        }
        return precio;
    }

    public void agregarProducto(Producto p){
        productos.add(p);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    @Override
    public String toString(){
       productos.stream().forEach(producto -> System.out.println(producto));
       return  "el precio total es : " + precioTotal();

    }
}