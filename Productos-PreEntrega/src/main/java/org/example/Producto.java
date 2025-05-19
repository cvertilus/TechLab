package org.example;

public class Producto {
    private String nombre;
    private Double precio;
    private int CantidadEnStock;
    private int id;

    public Producto() {
    }

    public Producto(String nombre, Double precio, int cantidadEnStock ) {
        this.nombre = nombre;
        this.precio = precio;
        this.CantidadEnStock = cantidadEnStock;
    }

    public Producto(String nombre, int id, int cantidadEnStock, Double precio) {
        this.nombre = nombre;
        this.id = id;
        CantidadEnStock = cantidadEnStock;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public int getCantidadEnStock() {
        return CantidadEnStock;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        CantidadEnStock = cantidadEnStock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return " ---------------------------------------------------------------------" +
                "\n Producto Id es: " + id +
                "\n Producto nombre es: " + nombre +
                "\n Producto precio es: " + precio +
                "\n Producto Stock es: " + CantidadEnStock +
                "\n ---------------------------------------------------------------- \n";
    }
}
